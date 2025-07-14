plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
    id("com.gradle.develocity") version "4.0.1"
}

develocity.server = "http://localhost:8180"
rootProject.name = "pts-metrics-migration"
include("lib")
