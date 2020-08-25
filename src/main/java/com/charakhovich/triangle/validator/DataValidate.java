package com.charakhovich.triangle.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidate {
    static final Logger logger = LogManager.getLogger();
    private static final String REGEX_PARAMETERS_TRIANGLE = "\\s*\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s+" +
            "\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s+\\d+\\.\\d{2}\\s*";

    public boolean isValid(String strToValidate) {
        boolean flag = false;
        Pattern pattern = Pattern.compile(REGEX_PARAMETERS_TRIANGLE);
        Matcher matcher = pattern.matcher(strToValidate);
        if (matcher.matches()) {
            flag = true;
        } else {
            logger.warn(strToValidate + " is not valid string");
        }
        return flag;
    }
}
