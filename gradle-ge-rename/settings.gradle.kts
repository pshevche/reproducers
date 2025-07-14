pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("com.gradle.develocity") version "4.0"
    id("com.gradle.enterprise") version "3.16"
}

rootProject.name = "gradle-ge-rename"
include("lib")
