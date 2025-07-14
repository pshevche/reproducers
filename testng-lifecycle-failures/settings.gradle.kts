plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
    id("com.gradle.develocity") version "4.0.2"
}

develocity.server = "<DEVELOCITY_INSTANCE>"
rootProject.name = "testng-lifecycle-failures"
include("app")
