package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.SpecificationTriangle;

public class SpecificationTrianglePerimeterBetweenMinMax implements SpecificationTriangle {
    private TriangleAction triangleAction = TriangleAction.getInstance();
    private double minPerimeter;
    private double maxPerimeter;
    public SpecificationTrianglePerimeterBetweenMinMax(double minPerimeter, double maxPerimeter) {
        this.minPerimeter=minPerimeter;
        this.maxPerimeter=maxPerimeter;
    }
    public boolean specify(Triangle triangle) {
        double perimeter=triangleAction.perimeter(triangle);
        return perimeter>minPerimeter&&perimeter<maxPerimeter;
    }
}
