package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlowSetupTest {

    @BeforeAll
    static void setupAll() throws InterruptedException {
        Thread.sleep(5000);
    }

    @BeforeEach
    void setupEach() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    void successfulTest() throws InterruptedException {
        Thread.sleep(1000);
    }
}
