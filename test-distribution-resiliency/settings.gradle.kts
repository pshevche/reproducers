pluginManagement {
    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://repo.grdev.net/artifactory/public")
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
//    id("com.gradle.develocity") version "3.19.2"
     id("com.gradle.develocity") version "4.0"
}

develocity.server = "https://dv-td-dogfooding.grdev.net"
rootProject.name = "test-distribution-resiliency"
include("lib")
