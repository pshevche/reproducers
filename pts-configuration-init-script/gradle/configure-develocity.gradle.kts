initscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.gradle:develocity-gradle-plugin:3.17.6")
    }
}

gradle.settingsEvaluated {
    pluginManager.apply(com.gradle.develocity.agent.gradle.DevelocityPlugin::class)

    develocity {
        server = "<<DEVELOCITY_SERVER>>"
    }
}
