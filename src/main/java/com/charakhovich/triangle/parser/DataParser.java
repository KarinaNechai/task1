package com.charakhovich.triangle.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataParser {
    static final Logger logger = LogManager.getLogger();
    private static final String SPLITTER = "\\s+";

    public Double[] parserData(String str) {
        String[] arrayString = str.split(SPLITTER);
        int numberCoordinates = arrayString.length;
        Double[] coordinates = new Double[numberCoordinates];
        for (int i = 0; i < numberCoordinates; i++) {
            coordinates[i] = Double.valueOf(arrayString[i]);
        }
        return coordinates;
    }

}
