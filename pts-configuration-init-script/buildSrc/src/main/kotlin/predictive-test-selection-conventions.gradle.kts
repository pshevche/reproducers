import com.gradle.develocity.agent.gradle.adapters.internal.ProxyFactory.createProxy
import com.gradle.develocity.agent.gradle.test.DevelocityTestConfiguration

tasks.named<Test>("test") {
    createProxy(extensions.getByName("develocity"), DevelocityTestConfiguration::class.java).apply {
        predictiveTestSelection {
            enabled = true
        }
    }
}
