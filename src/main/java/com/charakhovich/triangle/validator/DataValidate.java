package com.charakhovich.triangle.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataValidate {
    static final Logger logger = LogManager.getLogger(DataValidate.class);
    private static final String REAL_NUMBER = "[+-]?(\\d{0,2}[.])?\\d{0,2}";

    public static boolean isValid(String number) {
        boolean flag;
        if (number.matches(REAL_NUMBER)){
            flag=true;
        }
        else {
            logger.log(Level.WARN,"Incorrect number:"+number);
            flag=false;
        }
        return flag;
    }
}
