package com.string.learn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void testAddition() {
        int a = 10;
        int b = 20;
        int result = a + b;

        System.out.println("Result: " + result);

        Assert.assertEquals(result, 30);
    }

    @Test
    public void testString() {
        String name = "Shabina";

        System.out.println("Name: " + name);

        Assert.assertTrue(name.contains("Shab"));
    }
}