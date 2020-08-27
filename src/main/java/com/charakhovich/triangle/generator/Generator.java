package com.charakhovich.triangle.generator;

public class Generator {
    private static final long MIN_ID = 1;
    private static final long MAX_ID = 100000;
    private static long counter;

    private Generator() {
        counter = MIN_ID;
    }

    public static long generateID() {
        counter++;
        if (MIN_ID + counter > MAX_ID) {
            counter = MIN_ID;
        }
        return counter;
    }
}