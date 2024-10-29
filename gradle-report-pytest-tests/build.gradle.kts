import com.gradle.develocity.agent.gradle.test.ImportJUnitXmlReports
import com.gradle.develocity.agent.gradle.test.JUnitXmlDialect

val reportsDir = layout.buildDirectory.dir("reports/pytest")
val pytest by tasks.registering(Exec::class) {
    commandLine("pytest", "--junitxml=${reportsDir.get().asFile.absolutePath}/pytest.xml")
    outputs.dir(reportsDir)
}

ImportJUnitXmlReports.register(tasks, pytest, JUnitXmlDialect.GENERIC)
