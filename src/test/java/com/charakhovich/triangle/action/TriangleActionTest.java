package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleActionTest {
    static TriangleAction triangleAction = new TriangleAction();
    Triangle triangle1 = new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
    Triangle triangle2 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 6.00), new Point(6.00, 1.00));
    Triangle triangle3 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 3.00), new Point(6.00, 1.00));

    @Test
    public void testIsAcute() {
    }

    @Test(dataProvider = "dataSquare")
    public void testSquare(Triangle triangle, double square) {
        Assert.assertEquals(triangleAction.square(triangle), square);
    }

    @Test(dataProvider = "dataPerimeter")
    public void testPerimeter(Triangle triangle, double perimeter) {
        Assert.assertEquals(triangleAction.perimeter(triangle), perimeter);
    }

    @Test(dataProvider = "dataIsAcute")
    public void testTestIsAcute(Triangle triangle,boolean result) {
        Assert.assertEquals(triangleAction.isAcute(triangle),result);
    }

    @Test(dataProvider = "dataIsObtuse")
    public void testIsObtuse(Triangle triangle,boolean result) {
        Assert.assertEquals(triangleAction.isObtuse(triangle),result);
    }

    @Test(dataProvider = "dataIsRectangular")
    public void testIsRectangular(Triangle triangle,boolean result) {
        Assert.assertEquals(triangleAction.isRectangular(triangle),result);
    }

    @DataProvider(name = "dataSquare")
    public Object[][] dataSquare() {
        return new Object[][]{
                {triangle1, 10.00},
                {triangle2, 10.00},
                {triangle3, 4.00},
        };
    }

    @DataProvider(name = "dataPerimeter")
    public Object[][] dataPerimetr() {
        return new Object[][]{
                {triangle1, 15.40},
                {triangle2, 14.77},
                {triangle3, 9.66},
        };
    }
    @DataProvider(name = "dataIsAcute")
    public Object[][] dataIsAcute() {
        return new Object[][]{
                {triangle1, true},
                {triangle2, false},
                {triangle3, false},
        };
    }
    @DataProvider(name = "dataIsObtuse")
    public Object[][] dataIsObtuse() {
        return new Object[][]{
                {triangle1, false},
                {triangle2, false},
                {triangle3, false},
        };
    }
    @DataProvider(name = "dataIsRectangular")
    public Object[][] dataIsRectangular() {
        return new Object[][]{
                {triangle1, false},
                {triangle2, true},
                {triangle3, true},
        };
    }
}