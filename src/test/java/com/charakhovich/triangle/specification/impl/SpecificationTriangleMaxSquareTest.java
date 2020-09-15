package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SpecificationTriangleMaxSquareTest {
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;

    @BeforeClass
    public void init(){
        triangle1= new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
        triangle2 = new Triangle(new Point(2.00, 1.00), new Point(0.00, 4.00), new Point(6.00, 1.00));
        triangle3 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 6.00), new Point(6.00, 1.00));
    }
    @Test(dataProvider = "triangleMaxSquare")
    public void testSpecify(Triangle triangle,int maxSquare, boolean result) {
        SpecificationTriangleMaxSquare specification=new SpecificationTriangleMaxSquare(maxSquare);
        Assert.assertEquals(specification.specify(triangle),result);
    }

    @DataProvider(name = "triangleMaxSquare")
    public Object[][] triangleMaxSquare() {
        return new Object[][]{
                {triangle1, 4,true},
                {triangle2, 4,true},
                {triangle3, 4,true},
                {triangle1,7,true},
                {triangle2,7,false},
                {triangle3,7,true},
        };
    }
}