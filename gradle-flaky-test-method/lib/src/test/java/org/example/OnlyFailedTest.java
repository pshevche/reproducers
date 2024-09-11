package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class OnlyFailedTest {
    @Test
    void failingTest1() {
        fail("failingTest1 goes boom!");
    }

    @Test
    void failingTest2() {
        fail("failingTest2 goes boom!");
    }

    @Test
    void failingTest3() {
        fail("failingTest3 goes boom!");
    }
}
