## Description

1. The Develocity plugin is applied via the `gradle/configure-develocity.gradle.kts` init script.
2. PTS is configured on test tasks using the precompiled script plugin under `buildSrc/src/main/kotlin/predictive-test-selection-conventions.gradle.kts`.
3. The plugin won't be able to access the Develocity test task extension, as it is registered in a different classloader belonging to the init script.
4. To overcome this issue, we use [develocity-gradle-plugin-adapters](https://github.com/gradle/develocity-agent-adapters) that provide utilities to interact with Develocity extensions across class loader boundaries.
5. This is the pattern adopted by the Common Custom User Data Gradle plugin which also ensures that the Develocity core extension is configured regardless of the classloader in which the extension was registered.
