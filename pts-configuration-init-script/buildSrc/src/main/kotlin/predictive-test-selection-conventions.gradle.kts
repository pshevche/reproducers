import com.gradle.develocity.agent.gradle.adapters.internal.ProxyFactory.createProxy
import com.gradle.develocity.agent.gradle.test.DevelocityTestConfiguration
import com.gradle.develocity.agent.gradle.test.PredictiveTestSelectionMode
import com.gradle.develocity.agent.gradle.test.PredictiveTestSelectionProfile

tasks.named<Test>("test") {
    develocity(this) {
        predictiveTestSelection {
            enabled = true
            profile = PredictiveTestSelectionProfile.FAST
            mode = PredictiveTestSelectionMode.REMAINING_TESTS
        }
    }
}

fun develocity(test: Test, config: DevelocityTestConfiguration.() -> Unit) {
    createProxy(test.extensions.getByName("develocity"), DevelocityTestConfiguration::class.java).apply(config)
}
