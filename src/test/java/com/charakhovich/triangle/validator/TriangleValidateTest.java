package com.charakhovich.triangle.validator;

import com.charakhovich.triangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleValidateTest {

    @Test
    public void testIsTriangle() {
    }
    @Test(dataProvider = "points")
    public void testIsValid(Point pointX, Point pointY, Point pointZ, boolean expected) {
        TriangleValidate triangleValidate=new TriangleValidate();
        Assert.assertEquals(TriangleValidate.isTriangle(pointX,pointY,pointZ), expected);
    }

    @DataProvider(name = "points")
    public Object[][] points () {
        return new Object[][]{
                {new Point(12,12),new Point(10,10), new Point(12,12),false},
                {new Point(12,12),new Point(12,10), new Point(12,2),false},
                {new Point(12,12),new Point(10,10), new Point(12,32),true},
        };
    }
}