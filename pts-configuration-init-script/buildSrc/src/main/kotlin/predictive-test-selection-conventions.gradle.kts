import com.gradle.develocity.agent.gradle.adapters.internal.ProxyFactory.createProxy
import com.gradle.develocity.agent.gradle.test.DevelocityTestConfiguration

tasks.named<Test>("test") {
    develocity(this) {
        predictiveTestSelection {
            enabled = true
        }
    }
}

fun develocity(test: Test, config: DevelocityTestConfiguration.() -> Unit) {
    createProxy(test.extensions.getByName("develocity"), DevelocityTestConfiguration::class.java).apply(config)
}
