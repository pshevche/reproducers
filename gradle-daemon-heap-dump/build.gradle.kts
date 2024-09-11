import java.lang.management.ManagementFactory
import org.gradle.internal.logging.StandardOutputCapture

class CustomOutputListener : StandardOutputListener {

    override fun onOutput(output: CharSequence?) {
        if (output?.contains("Java heap space") == true) {
            val jvmName = ManagementFactory.getRuntimeMXBean().name
            val pid = jvmName.split("@")[0]
            ProcessBuilder(
                "jcmd",
                pid,
                "GC.heap_dump",
                "/Users/pshevche/dev/reproducers/gradle-daemon-heap-dump/pshevche_${pid}.hprof"
            )
                .start()
                .waitFor()
        }
    }
}

gradle.taskGraph.whenReady {
    (logging as StandardOutputCapture).start()
    val listener = CustomOutputListener()
    logging.addStandardOutputListener(listener)
    logging.addStandardErrorListener(listener)
}

tasks.register("polluteHeap") {
    doFirst {
        val strings = mutableListOf<String>()
        while (true) {
            strings.add("pollute")
        }
    }
}