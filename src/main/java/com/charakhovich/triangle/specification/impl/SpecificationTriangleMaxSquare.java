package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.SpecificationTriangle;

public class SpecificationTriangleMaxSquare implements SpecificationTriangle {
    private double maxSquare;
    private TriangleAction triangleAction = TriangleAction.getInstance();

    public SpecificationTriangleMaxSquare(double maxSquare) {
        this.maxSquare = maxSquare;
    }

    public boolean specify(Triangle triangle) {
        return triangleAction.square(triangle) > this.maxSquare;
    }
}
