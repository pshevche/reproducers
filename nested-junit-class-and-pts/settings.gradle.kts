plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("com.gradle.develocity") version "3.19.1"
}

develocity.server = "http://localhost:5086"
rootProject.name = "nested-junit-class-and-pts"
include("lib")
