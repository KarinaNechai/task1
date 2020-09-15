package com.charakhovich.triangle.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataValidateTest {

    @Test(dataProvider = "numbers")
    public void testIsValid(String string, boolean expected) {
        Assert.assertEquals( DataValidate.isValid(string), expected);
    }

   @DataProvider(name = "numbers")
    public Object[][] numbers () {
        return new Object[][]{
                {"12.", true},
                {"12.00", true},
                {"-12.00", true},
                {"+12.00", true},
                {"-.1", true},
                {"112.00", false},
                {"12,145", false}
        };
    }
}