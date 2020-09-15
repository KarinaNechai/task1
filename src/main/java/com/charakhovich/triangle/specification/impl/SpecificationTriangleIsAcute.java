package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.SpecificationTriangle;

public class SpecificationTriangleIsAcute  implements SpecificationTriangle {
    private TriangleAction triangleAction = TriangleAction.getInstance();

    @Override
    public boolean specify(Triangle triangle) {
        return triangleAction.isAcute(triangle);
    }
}
