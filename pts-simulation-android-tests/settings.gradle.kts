pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

plugins {
    id("com.gradle.develocity") version "3.19.1"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

develocity.server = "https://ge-helm-cluster-unstable-release.grdev.net"

rootProject.name = "my-app"

include(":app")
