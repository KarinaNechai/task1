package com.charakhovich.triangle.validator;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Point;

public class TriangleValidate {
    TriangleAction triangleAction = new TriangleAction();

    public boolean isTriangle(Point X, Point Y, Point Z) {
        Point vectorA = triangleAction.Vector(X, Y);
        Point vectorB = triangleAction.Vector(X, Z);
        double scalarMultiplication = triangleAction.scalarMultiplication(vectorA, vectorB);
        return scalarMultiplication != 0;
    }
}
