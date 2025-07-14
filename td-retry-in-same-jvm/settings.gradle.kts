plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
    id("com.gradle.develocity") version "4.0"
}

develocity.server = "https://dv-td-dogfooding.grdev.net"
rootProject.name = "td-retry-in-same-jvm"
include("lib")
