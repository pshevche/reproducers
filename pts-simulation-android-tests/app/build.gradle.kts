import com.android.build.gradle.internal.tasks.DeviceProviderInstrumentTestTask
import com.android.build.gradle.tasks.PackageApplication
import com.gradle.develocity.agent.gradle.test.ImportJUnitXmlReports
import com.gradle.develocity.agent.gradle.test.JUnitXmlDialect

plugins {
    id("com.android.application") version "8.8.0"
}

repositories {
    google()
    mavenCentral()
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "org.gradle.samples"
        namespace = "org.gradle.samples"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

// (1) standalone task with naive inputs
val syntheticImportOutput = layout.buildDirectory.file("outputs/importJUnitXml/output")
val importJUnitXml by tasks.registering(ImportJUnitXmlReports::class) {
    dialect = JUnitXmlDialect.ANDROID_CONNECTED
    inputs.dir("build/intermediates/javac/debug/compileDebugJavaWithJavac/classes")
        .withPropertyName("sources")
        .withNormalizer(ClasspathNormalizer::class)
    inputs.dir("build/intermediates/javac/debugAndroidTest/compileDebugAndroidTestJavaWithJavac/classes")
        .withPropertyName("testSources")
        .withNormalizer(ClasspathNormalizer::class)
    reports.from(fileTree("build/outputs/androidTest-results"))
    outputs.file(syntheticImportOutput)
    doLast {
        syntheticImportOutput.get().asFile.createNewFile()
    }
}

tasks.named("connectedCheck") {
    finalizedBy(importJUnitXml)
}

// (2) finalizer task for Android-native test task
//afterEvaluate {
//    val connectedDebugAndroidTest =
//        tasks.named("connectedDebugAndroidTest", DeviceProviderInstrumentTestTask::class)
//    ImportJUnitXmlReports.register(
//        tasks,
//        connectedDebugAndroidTest,
//        JUnitXmlDialect.ANDROID_CONNECTED
//    )
//}
