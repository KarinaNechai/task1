package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SpecificationTrianglePerimeterBetweenMinMaxTest {
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;

    @BeforeClass
    public void init() {
        triangle1 = new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
        triangle2 = new Triangle(new Point(2.00, 1.00), new Point(0.00, 4.00), new Point(6.00, 1.00));
        triangle3 = new Triangle(new Point(2.00, 1.00), new Point(2.00, 15.00), new Point(6.00, 1.00));
    }

    @Test(dataProvider = "perimeterBetweenMinMax")
    public void testSpecify(Triangle triangle, double min, double max, boolean excepted) {
        SpecificationTrianglePerimeterBetweenMinMax specification = new SpecificationTrianglePerimeterBetweenMinMax(min, max);
        Assert.assertEquals(specification.specify(triangle), excepted);
    }

    @DataProvider(name = "perimeterBetweenMinMax")
    public Object[][] perimeterBetweenMinMax() {
        return new Object[][]{
                {triangle1, 1, 10, false},
                {triangle2, 1, 10, false},
                {triangle3, 1, 10, false},
                {triangle1, 5, 20, true},
                {triangle2, 5, 20, true},
                {triangle3, 5, 20, false},
        };
    }
}
