package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.Specification;

public class SpecificationMaxSquare implements Specification {
    private int maxSquare;

    public SpecificationMaxSquare(int maxSquare) {
        this.maxSquare = maxSquare;
    }

    static TriangleAction triangleAction = new TriangleAction();

    @Override
    public boolean specify(Triangle triangle) {
        boolean flag = triangleAction.square(triangle) > this.maxSquare;
        return flag;
    }
}
