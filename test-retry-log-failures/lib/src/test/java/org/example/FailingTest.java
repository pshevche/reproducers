package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class FailingTest {
    @Test
    void alwaysFailingTest() {
        fail();
    }
}
