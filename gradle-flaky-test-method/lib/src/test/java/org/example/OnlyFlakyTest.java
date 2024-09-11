package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.fail;

class OnlyFlakyTest {
    @Test
    void flakyTest1() throws IOException {
        Path markerFlakyTest1 = Paths.get("markerFlakyTest1");
        if (Files.exists(markerFlakyTest1)) {
            return;
        }
        Files.createFile(markerFlakyTest1);
        fail("flakyTest1 goes boom!");
    }

    @Test
    void flakyTest2() throws IOException {
        Path markerFlakyTest2 = Paths.get("markerFlakyTest2");
        if (Files.exists(markerFlakyTest2)) {
            return;
        }
        Files.createFile(markerFlakyTest2);
        fail("flakyTest2 goes boom!");
    }

    @Test
    void flakyTest3() throws IOException {
        Path markerFlakyTest3 = Paths.get("markerFlakyTest3");
        if (Files.exists(markerFlakyTest3)) {
            return;
        }
        Files.createFile(markerFlakyTest3);
        fail("flakyTest3 goes boom!");
    }
}
