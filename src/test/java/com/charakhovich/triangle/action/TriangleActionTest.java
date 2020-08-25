package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleActionTest {
TriangleAction triangleAction=new TriangleAction();
    @Test
    public void testIsTriangle() {
        Triangle triangle=new Triangle(new Point(2.00,3.00),new Point(3.00,2.00),new Point(8.00,9.00));
        Triangle triangle1=new Triangle(new Point(2.00,3.00),new Point(2.00,2.00),new Point(2.00,15.00));
         }

    @Test
    public void testCalculateSquare() {
        Triangle triangle=new Triangle(new Point(0.00,0.00),new Point(0.00,2.00),new Point(2.00,2.00));
        Assert.assertEquals( triangleAction.square(triangle),2.00);
    }

    @Test
    public void testIsAcute() {
    }
}