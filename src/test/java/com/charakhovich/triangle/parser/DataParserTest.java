package com.charakhovich.triangle.parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DataParserTest {
    private static final String COORDINATE_SEPARATOR = "\\,";
    private static final String POINT_SEPARATOR = "[()]";

    @Test(dataProvider = "dataCoordinates")
    public void testParseCoordinates(String parseString, List<String> expected) {
        DataParser dataParser = new DataParser();
        List<String> actual=dataParser.parseData(parseString,COORDINATE_SEPARATOR);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataPoints")
    public void testParsePoints(String parseString, List<String> expected) {
        DataParser dataParser = new DataParser();
        List<String> actual=dataParser.parseData(parseString,POINT_SEPARATOR);
        Assert.assertEquals(actual, expected);
    }
    @DataProvider(name = "dataCoordinates")
    public Object[][] dataCoordinates() {
        return new Object[][]{
                {"12. ,  14", Arrays.asList("12.", "14")},
                {"12.00,14", Arrays.asList("12.00","14")}
        };
    }

    @DataProvider(name = "dataPoints")
    public Object[][] dataPoints() {
        return new Object[][]{
                {"(12.,14) (14,145.00)", Arrays.asList("12.,14", "14,145.00")},
                {"(10.00,   14)", Arrays.asList("10.00,   14")}
        };
    }
}