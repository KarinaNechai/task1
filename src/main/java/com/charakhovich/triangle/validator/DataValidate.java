package com.charakhovich.triangle.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidate {
    static final Logger logger = LogManager.getLogger();
    private static final String COORDINATES_TRIANGLE = "\\s*\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s+" +
            "\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s*";

    public boolean isValid(String strToValidate) {
        boolean flag = false;
        Pattern pattern = Pattern.compile(COORDINATES_TRIANGLE);
        Matcher matcher = pattern.matcher(strToValidate);
        if (matcher.matches()) {
            flag = true;
        } else {
            logger.log(Level.WARN,strToValidate + " is not valid string");
        }
        return flag;
    }
}
