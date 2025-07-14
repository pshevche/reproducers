import java.time.Duration

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testImplementation("org.junit.platform:junit-platform-launcher")

    api(libs.commons.math3)

    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    develocity {
        testDistribution {
            enabled = true
            requirements.addAll("demo")
            remoteExecutionPreferred = true
            maxRecoverableFailures = 0
        }
    }
    testLogging {
        displayGranularity = 0
    }
}
