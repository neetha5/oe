package com.example.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testEncode() {
        String result = App.encode("Hello", 3);
        assertEquals("Khoor", result);
    }

    @Test
    public void testDecode() {
        String result = App.decode("Khoor", 3);
        assertEquals("Hello", result);
    }

    @Test
    public void testRoundTrip() {
        String original = "Maven Pipeline";
        String encoded = App.encode(original, 7);
        assertEquals(original, App.decode(encoded, 7));
    }

    @Test
    public void testNonLettersUnchanged() {
        String result = App.encode("Hello, World! 123", 5);
        assertEquals("Mjqqt, Btwqi! 123", result);
    }

    @Test
    public void testZeroShift() {
        assertEquals("Java", App.encode("Java", 0));
    }
}
