package dev.tcheng.conventions.kotlin

import gradle.kotlin.dsl.accessors._6b44df4e710766fa51b9f600af186838.testing
import org.gradle.api.attributes.TestSuiteType
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.getting
import org.gradle.kotlin.dsl.`jvm-test-suite`
import org.gradle.kotlin.dsl.registering

plugins {
    `jvm-test-suite`
}

testing {
    suites {
        configureEach {
            if (this is JvmTestSuite) {
                useJUnitJupiter()
                targets {
                    all {
                        testTask.configure {
                            testLogging {
                                showStandardStreams = true
                                events = setOf(
                                    TestLogEvent.PASSED,
                                    TestLogEvent.FAILED,
                                    TestLogEvent.SKIPPED
                                )
                            }
                        }
                    }
                }
            }
        }

        val test by getting(JvmTestSuite::class)

        val integTest by registering(JvmTestSuite::class) {
            testType.set(TestSuiteType.INTEGRATION_TEST)

            dependencies {
                implementation(project())
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}

tasks.named("check") {
    dependsOn(testing.suites.named("integTest"))
}
