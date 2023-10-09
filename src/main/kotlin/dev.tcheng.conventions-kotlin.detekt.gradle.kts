import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    id("io.gitlab.arturbosch.detekt")
}

val detektConfig by configurations.creating

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.1")
    detektConfig("dev.tcheng:detekt-config:0.0.1")
}


detekt {
//    config.setFrom("${projectDir}/src/main/resources/detekt-config.yml")
    config.from(resources.text.fromArchiveEntry(detektConfig, "detekt-config.yml"))
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
