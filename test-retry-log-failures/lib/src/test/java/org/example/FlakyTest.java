package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.fail;

class FlakyTest {
    @Test
    void flakyTest() throws IOException {
        Path markerFile = Paths.get("marker.txt");
        if (!Files.exists(markerFile)) {
            Files.createFile(markerFile);
            fail();
        }
    }
}
