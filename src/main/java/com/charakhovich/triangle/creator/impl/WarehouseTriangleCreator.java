package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.creator.WarehouseCreator;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.entity.Warehouse;

public class WarehouseTriangleCreator implements WarehouseCreator<Triangle> {
    private TriangleAction triangleAction = new TriangleAction();
    private Warehouse warehouse = Warehouse.getInstance();

    @Override
    public boolean createWarehouse(Triangle triangle) {
        double perimeterTriangle = triangleAction.perimeter(triangle);
        double squareTriangle = triangleAction.square(triangle);
        TriangleParams triangleParams = new TriangleParams(perimeterTriangle, squareTriangle);
        TriangleParams putParams = warehouse.put(triangle.getId(), triangleParams);
        return putParams != null;
    }
}
