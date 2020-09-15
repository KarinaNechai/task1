package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Vector;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VectorActionTest {
    VectorAction vectorAction = VectorAction.getInstance();
    Vector vectorA;
    Vector vectorB;
    Vector vectorC;
    Vector vectorD;

    @BeforeClass
    public void setUp() {
        vectorA = new Vector(new Point(2.00, 2.00), new Point(2, 2));
        vectorB = new Vector(new Point(2.00, 1.00), new Point(2, 6));
        vectorC = new Vector(new Point(2.00, 1.00), new Point(2, 8));
        vectorD = new Vector(new Point(2.00, 1.00), new Point(6, 1));
    }

    @Test(dataProvider = "vectorsScalarMultiplication")
    public void testScalarMultiplication(Vector vectorX, Vector vectorY, double expected) {
        double actual = vectorAction.scalarMultiplication(vectorX, vectorY);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "vectorIsZero")
    public void testIsZeroVector(Vector vector, boolean expected) {
        boolean actual = vectorAction.isZeroVector(vector);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "collinearVectors")
    public void testIsCollinearVectors(Vector vectorX, Vector vectorY, boolean expected) {
        boolean actual = vectorAction.isCollinearVectors(vectorX, vectorY);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "vectorsScalarMultiplication")
    public Object[][] vectorsScalarMultiplication() {
        return new Object[][]{
                {vectorA, vectorB, 25},
                {vectorB, vectorC, 49},
                {vectorC, vectorD, 0},
        };
    }

    @DataProvider(name = "vectorIsZero")
    public Object[][] vectorIsZero() {
        return new Object[][]{
                {vectorA, true},
                {vectorB, false},
                {vectorC, false},
        };
    }

    @DataProvider(name = "collinearVectors")
    public Object[][] collinearVectors() {
        return new Object[][]{
                {vectorA, vectorB, true},
                {vectorB, vectorC, true},
                {vectorC, vectorD, false},
        };
    }
}