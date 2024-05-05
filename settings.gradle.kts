rootProject.name="conventions-kotlin"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("detekt-gradle", "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.6")
            library("dokka-gradle", "org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")
            library("kotlin-gradle", "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
            library("kover-gradle", "org.jetbrains.kotlinx:kover-gradle-plugin:0.7.6")
        }
    }
}
