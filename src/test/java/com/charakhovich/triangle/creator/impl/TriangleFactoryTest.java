package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.creator.impl.TriangleFactory;
import com.charakhovich.triangle.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleFactoryTest {

    @Test
    public void testCreate() throws TriangleException {
        TriangleFactory triangleFactory=new TriangleFactory();
        Point pointX=new Point(2.00,1.00);
        Point pointY=new Point(2.00,6.00);
        Point pointZ=new Point(6.00,1.00);
        Triangle triangle;
        triangle = triangleFactory.create(pointX, pointY, pointZ);
        Assert.assertNotNull(triangle);
    }
   /*@Test(expectedExceptions = )
    public void testCreateWithException() throws TriangleException {
        TriangleFactory triangleFactory=new TriangleFactory();
        Point pointX=new Point(2.00,1.00);
        Point pointY=new Point(2.00,6.00);
        Point pointZ=new Point(6.00,1.00);
        Triangle triangle;
        triangle = triangleFactory.create(pointX, pointY, pointZ);
        Assert.assertNotNull(triangle);
    }*/
}