import dev.detekt.gradle.Detekt
import dev.detekt.gradle.DetektCreateBaselineTask
import dev.detekt.gradle.extensions.DetektExtension

plugins {
    id("dev.detekt")
}

dependencies {
    "detektPlugins"("dev.detekt:detekt-rules-ktlint-wrapper:2.0.0-alpha.6")
}

extensions.configure<DetektExtension> {
    parallel = true
    ignoreFailures = false
    autoCorrect = true
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
    jvmTarget.set("25")
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget.set("25")
}
