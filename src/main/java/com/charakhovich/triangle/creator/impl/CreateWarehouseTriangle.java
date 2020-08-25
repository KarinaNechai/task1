package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.creator.CreateWarehouse;
import com.charakhovich.triangle.entity.Shape;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.warehouse.Warehouse;

public class CreateWarehouseTriangle implements CreateWarehouse {

    @Override
    public boolean createWarehouse(Shape shape) {
        if (!(shape instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) shape;
        TriangleAction triangleAction = new TriangleAction();
        double perimeterTriangle = triangleAction.perimeter(triangle);
        double squareTriangle = triangleAction.square(triangle);
        TriangleParams triangleParams = new TriangleParams(perimeterTriangle, squareTriangle);
        return Warehouse.getInstance().add(triangle.getId(), triangleParams);
    }
}
