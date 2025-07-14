package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void someLibraryMethodReturnsTrue() {
        Library classUnderTest = new Library();
        assertFalse(!classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'bla'");
    }
}
