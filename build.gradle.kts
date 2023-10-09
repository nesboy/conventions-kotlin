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
    val dokkaVersion: String by project
    val kotlinVersion: String by project

    compileOnly("dev.tcheng:detekt-config:0.0.1")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.1")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:$dokkaVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kover-gradle-plugin:0.7.3")
}

tasks.named("build") { finalizedBy("publishToMavenLocal") }
