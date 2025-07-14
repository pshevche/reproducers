plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.testng)
    testRuntimeOnly("org.junit.support:testng-engine:1.0.6")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.13.3")
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "org.example.App"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    develocity {
        testDistribution {
            enabled = true
            maxRemoteExecutors = 0
        }
        testRetry {
            maxRetries = 1
        }
    }
}
