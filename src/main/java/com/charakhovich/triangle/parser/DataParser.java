package com.charakhovich.triangle.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataParser {
    static final Logger logger = LogManager.getLogger();
    static final int NUMBER_READ_COORDINATE = 6;
    private static final String REGEX_SPLITTER = "\\s+";

    public Double[] parserData(String strToParse) {
        Double[] coordinates = new Double[NUMBER_READ_COORDINATE];
        String[] templ = strToParse.split(REGEX_SPLITTER);
        for (int i = 0; i < NUMBER_READ_COORDINATE; i++) {
            coordinates[i] = Double.valueOf(templ[i]);
        }
        return coordinates;
    }

}
