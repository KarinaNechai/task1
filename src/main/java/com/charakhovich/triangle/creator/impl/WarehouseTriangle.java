package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.creator.WarehouseFactory;
import com.charakhovich.triangle.entity.Shape;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.entity.Warehouse;

public class WarehouseTriangle implements WarehouseFactory {
    static TriangleAction triangleAction = new TriangleAction();
    @Override
    public boolean createWarehouse(Shape shape) {
        if (!(shape instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) shape;
        double perimeterTriangle = triangleAction.perimeter(triangle);
        double squareTriangle = triangleAction.square(triangle);
        TriangleParams triangleParams = new TriangleParams(perimeterTriangle, squareTriangle);
        final TriangleParams put = Warehouse.getInstance().put(triangle.getId(), triangleParams);
        return Warehouse.getInstance().put(triangle.getId(), triangleParams)!=null;
    }
}
