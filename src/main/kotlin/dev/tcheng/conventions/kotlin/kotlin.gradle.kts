package dev.tcheng.conventions.kotlin

import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
