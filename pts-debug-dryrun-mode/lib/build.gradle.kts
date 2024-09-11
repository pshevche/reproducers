import com.gradle.develocity.agent.gradle.internal.test.PredictiveTestSelectionConfigurationInternal

plugins {
    `java-library`
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
    // either option works: we will fetch the prediction, output selected/non-selected tests, but will not run any tests
    dryRun = true
    //systemProperty("junit.platform.execution.dryRun.enabled", true)
    develocity.predictiveTestSelection {
        enabled = true
        this as PredictiveTestSelectionConfigurationInternal
        debug = true
    }
}
