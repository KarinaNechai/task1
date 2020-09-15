package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleCreatorTest {
   TriangleCreator triangleCreator=new TriangleCreator();

    @Test
    public void testTriangleCreator() throws TriangleException {
        Point pointX = new Point(2.00, 1.00);
        Point pointY = new Point(2.00, 6.00);
        Point pointZ = new Point(6.00, 1.00);
        Triangle actual;
        actual = triangleCreator.create(pointX, pointY, pointZ);
        Triangle expected;
        expected = new Triangle(pointX, pointY, pointZ);
        Assert.assertEquals(actual, expected);
    }
    @Test(expectedExceptions = TriangleException.class,expectedExceptionsMessageRegExp = "Parameters of triangle isn't valid. Can't create triangle")
    public void testTriangleCreatorException() throws TriangleException {
        Point pointX = new Point(2.00, 1.00);
        Point pointY = new Point(2.00, 1.00);
        Point pointZ = new Point(6.00, 1.00);
        Triangle actual;
        triangleCreator.create(pointX, pointY, pointZ);
    }
    @Test(expectedExceptions = TriangleException.class,expectedExceptionsMessageRegExp =
            "Can't create triangle.Few points to create a triangle")
    public void testTriangleCreatorExceptionFewPoints() throws TriangleException {
        Point pointX = new Point(2.00, 1.00);
        Point pointY = new Point(2.00, 1.00);
        triangleCreator.create(pointX, pointY);
    }
}