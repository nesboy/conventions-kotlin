rootProject.name="conventions-kotlin"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("detekt-gradle", "dev.detekt:detekt-gradle-plugin:2.0.0-alpha.6")
            library("dokka-gradle", "org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
            library("kotlin-gradle", "org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.20")
            library("kover-gradle", "org.jetbrains.kotlinx:kover-gradle-plugin:0.9.9")
        }
    }
}
