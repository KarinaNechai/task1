package com.charakhovich.triangle.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Generator {
    private final static long MIN_ID = 1;
    private final static long MAX_ID = 100000;
    private static long counter;
    static final Logger logger = LogManager.getLogger();

    private Generator() {
    }

    public static long generateID() {
        counter++;
        if (MAX_ID - MIN_ID + 1 - counter < 0) {
            counter = MIN_ID;
        }
        return counter;
    }
}