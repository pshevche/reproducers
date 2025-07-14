package org.example;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class ParentWithInnerTest {

    @Test
    void parentTest() {

    }

    @Nested
    class Inner {
        @Test
        void innerTest() {
            fail("boom!");
        }
    }
}
