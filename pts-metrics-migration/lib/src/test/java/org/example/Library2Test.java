package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Library2Test {
    @Test
    void someLibraryMethodReturnsTrue() {
        Library2 classUnderTest = new Library2();
        assertFalse(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'bla'");
    }
}
