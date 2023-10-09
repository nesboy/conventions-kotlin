package dev.tcheng.conventions.kotlin

import gradle.kotlin.dsl.accessors._6b1cdd1e881959619ea23cf7941079a9.detekt
import gradle.kotlin.dsl.accessors._6b1cdd1e881959619ea23cf7941079a9.detektPlugins
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

plugins {
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.1")
}

detekt {
    config.setFrom("${rootDir}/buildSrc/src/main/resources/detekt-config.yml")
    parallel = true
    ignoreFailures = false
    autoCorrect = true
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
        txt.required.set(false)
        xml.required.set(false)
        sarif.required.set(false)
        md.required.set(false)
    }
    jvmTarget = "11"
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = "11"
}
