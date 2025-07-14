package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private static final Thread busyThread = new Thread(() -> {
        try {
            System.out.println("[PSHEVCHE] Starting busy thread");
            Thread.sleep(100000000);
        } catch (InterruptedException ignored) {
            while (Files.notExists(Paths.get("marker.txt"))) {
                System.out.println("[PSHEVCHE] Waiting for permission to complete interrupt");
            }
            System.out.println("[PSHEVCHE] - Thread interrupted");
        }
    });

    @BeforeAll
    static void setup() {
        busyThread.setDaemon(false);
        busyThread.start();
        Runtime.getRuntime().addShutdownHook(new Thread(busyThread::interrupt));
    }


    @Test
    void someLibraryMethodReturnsTrue() {
        assertTrue(true);
    }
}
