package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Encodes a message using Caesar cipher with the given shift.
     */
    public static String encode(String text, int shift) {
        shift = ((shift % 26) + 26) % 26;
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Decodes a Caesar-encoded message.
     */
    public static String decode(String text, int shift) {
        return encode(text, 26 - shift);
    }

    public static void main(String[] args) {
        String original = "Hello Maven CI/CD World!";
        int shift = 5;

        String encoded = encode(original, shift);
        String decoded = decode(encoded, shift);

        logger.info("Original : " + original);
        logger.info("Encoded  : " + encoded);
        logger.info("Decoded  : " + decoded);

        System.out.println("Original : " + original);
        System.out.println("Encoded  : " + encoded);
        System.out.println("Decoded  : " + decoded);
    }
}
