package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.fail;

class MixedOutcomesTest {

    @Test
    void successfulTest() {
    }

    @Test
    void failingTest() {
        fail("failingTest goes boom!");
    }

    @Test
    void flakyTest() throws IOException {
        Path markerFlakyTest = Paths.get("markerFlakyTest");
        if (Files.exists(markerFlakyTest)) {
            return;
        }
        Files.createFile(markerFlakyTest);
        fail("flakyTest goes boom!");
    }
}
