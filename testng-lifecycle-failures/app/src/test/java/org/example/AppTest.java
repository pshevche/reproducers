package org.example;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppTest {

    private static final Path LIFECYCLE_MARKER_FILE = Paths.get("flakyLifecycleMarker.txt");
    private static final Path TEST_MARKER_FILE = Paths.get("flakyTestMarker.txt");

    @AfterSuite
    public void flakyAfterSuite() throws IOException {
        if (!Files.exists(LIFECYCLE_MARKER_FILE)) {
            Files.createFile(LIFECYCLE_MARKER_FILE);
            throw new RuntimeException("AfterSuite goes boom!");
        }
    }

    @Test
    public void flakyTest() throws IOException {
        if (!Files.exists(TEST_MARKER_FILE)) {
            Files.createFile(TEST_MARKER_FILE);
            throw new RuntimeException("test goes boom!");
        }
    }

    @Test
    public void successfulTest() {

    }
}
