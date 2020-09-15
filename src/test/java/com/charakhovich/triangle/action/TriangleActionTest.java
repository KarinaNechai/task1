package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleActionTest {
    TriangleAction triangleAction = TriangleAction.getInstance();
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;

    @BeforeClass
    public void setUp(){
        triangle1= new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
        triangle2 = new Triangle(new Point(2.00, 1.00), new Point(0.00, 4.00), new Point(6.00, 1.00));
        triangle3 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 6.00), new Point(6.00, 1.00));

    }

    @Test(dataProvider = "triangleSquare")
    public void testSquare(Triangle triangle, double square) {
        Assert.assertEquals(triangleAction.square(triangle), square);
    }

    @Test(dataProvider = "trianglePerimeter")
    public void testPerimeter(Triangle triangle, double perimeter) {
        Assert.assertEquals(triangleAction.perimeter(triangle), perimeter);
    }

    @Test(dataProvider = "triangleIsAcute")
    public void testTestIsAcute(Triangle triangle,boolean result) {
        Assert.assertEquals(triangleAction.isAcute(triangle),result);
    }

    @Test(dataProvider = "triangleIsObtuse")
    public void testIsObtuse(Triangle triangle,boolean result) {
        Assert.assertEquals(triangleAction.isObtuse(triangle),result);
    }

    @Test(dataProvider = "triangleIsRectangular")
    public void testIsRectangular(Triangle triangle,boolean result) {
        Assert.assertEquals(triangleAction.isRectangular(triangle),result);
    }

    @DataProvider(name = "triangleSquare")
    public Object[][] triangleSquare() {
        return new Object[][]{
                {triangle1, 10.00},
                {triangle2, 6.0},
                {triangle3, 10.00},
        };
    }

    @DataProvider(name = "trianglePerimeter")
    public Object[][] trianglePerimeter() {
        return new Object[][]{
                {triangle1, 15.40},
                {triangle2, 14.31},
                {triangle3, 14.77},
        };
    }
    @DataProvider(name = "triangleIsAcute")
    public Object[][] triangleIsAcute() {
        return new Object[][]{
                {triangle1, false},
                {triangle2, false},
                {triangle3, true},
        };
    }
    @DataProvider(name = "triangleIsObtuse")
    public Object[][] triangleIsObtuse() {
        return new Object[][]{
                {triangle1, false},
                {triangle2, true},
                {triangle3, false},
        };
    }
    @DataProvider(name = "triangleIsRectangular")
    public Object[][] triangleIsRectangular() {
        return new Object[][]{
                {triangle1, true},
                {triangle2, false},
                {triangle3, false},
        };
    }
}