import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java-library`
    id("org.gradle.test-retry") version "1.6.2"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

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
    testLogging {
        events.add(TestLogEvent.FAILED)
    }
    retry {
        maxRetries = 2
    }
}
