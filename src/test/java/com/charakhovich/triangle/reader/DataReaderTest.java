package com.charakhovich.triangle.reader;

import com.charakhovich.triangle.exception.TriangleException;
import org.testng.annotations.Test;

public class DataReaderTest {

    @Test
    public void testReadShapeParamsFromFile() throws TriangleException {
        DataReader triangleReader=new DataReader();
        triangleReader.readShapeParamsFromFile("\\data\\1.txt");
    }
}