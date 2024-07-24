package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class FactoryTest {

    private final boolean shouldFail;

    @Factory(dataProvider = "dp")
    public FactoryTest(boolean shouldFail) {
        this.shouldFail = shouldFail;
    }

    @DataProvider
    static Object[][] dp() {
        return new Object[][]{
            {false},
            {true}
        };
    }

    @Test
    public void successfulTest() {
    }

    @Test
    public void failingTest() {
        assertFalse(shouldFail);
    }
}
