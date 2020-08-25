package com.charakhovich.triangle.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataValidateTest {

    @Test(dataProvider = "dataProvider")
    public void testIsValid(String string, boolean expected) {
        DataValidate dataValidate = new DataValidate();
        Assert.assertEquals(dataValidate.isValid(string), expected);
    }

    @DataProvider(name = "stringCoordinatesOfTriangle")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"12. 0.00 12.00 3.00 14.00 5.00", false},
                {"12.00 0.00 12.00 3.00 14.00 5.00", true},
                {"   12.00 4.00 12.00 3.00 14.00 5.00", true},
                {"12.00 0.00 12.00     3.00 14.00 5.00   ", true},
                {"12,00 0.00 12.00 3.00 14.00 5.00   ", false},
                {"", false}
        };
    }
}