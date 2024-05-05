plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "dev.tcheng"
version = "0.0.1"

repositories {
    mavenLocal()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.detekt.gradle)
    implementation(libs.dokka.gradle)
    implementation(libs.kotlin.gradle)
    implementation(libs.kover.gradle)
}

tasks.named("build") { finalizedBy("publishToMavenLocal") }
