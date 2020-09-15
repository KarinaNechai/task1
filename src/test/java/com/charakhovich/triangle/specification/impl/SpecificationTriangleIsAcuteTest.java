package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SpecificationTriangleIsAcuteTest {
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;

    @BeforeClass
    public void init(){
        triangle1= new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
        triangle2 = new Triangle(new Point(2.00, 1.00), new Point(0.00, 4.00), new Point(6.00, 1.00));
        triangle3 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 6.00), new Point(6.00, 1.00));
    }

    @Test(dataProvider = "triangleIsAcute")
    public void testSpecify(Triangle triangle,boolean result) {
        SpecificationTriangleIsAcute specification=new SpecificationTriangleIsAcute();
        Assert.assertEquals(specification.specify(triangle),result);
    }
    @DataProvider(name = "triangleIsAcute")
    public Object[][] triangleIsAcute() {
        return new Object[][]{
                {triangle1, false},
                {triangle2, false},
                {triangle3, true},
        };
    }
}