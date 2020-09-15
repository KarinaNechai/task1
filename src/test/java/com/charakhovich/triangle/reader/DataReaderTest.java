package com.charakhovich.triangle.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataReaderTest {
    private static final String TEST_FILE_PATH = "data/temp.txt";

    @Test
    public void testDataReader() {
        List<String> expected = new ArrayList<>();
        expected.add("(1.00,2.00) (3.00,1.00) (2.00,3.00)");
        expected.add("(2.00,12.00) (43.00,1.00) (2.00,3.00)");
        DataReader dataReader = new DataReader();
        List<String> actual = dataReader.readDataFromFile(TEST_FILE_PATH);
        Assert.assertEquals(actual, expected);
    }
}