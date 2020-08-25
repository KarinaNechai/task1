package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleActionTest {
TriangleAction triangleAction=new TriangleAction();
    @Test
    public void testIsTriangle() {
        Triangle triangle=new Triangle(new Point(2.00,3.00),new Point(3.00,2.00),new Point(8.00,9.00));
        Triangle triangle1=new Triangle(new Point(2.00,3.00),new Point(2.00,2.00),new Point(2.00,15.00));
      //  assertTrue(triangleAction.isTriangle(triangle));
       // assertFalse(triangleAction.isTriangle(triangle1));

    }

    @Test
    public void testCalculateSquare() {
    }

    @Test
    public void testIsAcute() {
    }
}