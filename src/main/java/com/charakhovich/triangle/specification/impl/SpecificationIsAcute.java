package com.charakhovich.triangle.specification.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.Specification;

public class SpecificationIsAcute implements Specification {
    static TriangleAction triangleAction = new TriangleAction();
    @Override
    public boolean specify(Triangle triangle) {
        boolean flag = triangleAction.isAcute(triangle);
        return flag;
    }
}
