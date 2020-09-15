package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.creator.WarehouseCreator;
import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.entity.Warehouse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WarehouseTriangleCreatorTest {
    WarehouseCreator<Triangle> warehouseCreator = new WarehouseTriangleCreator();
    TriangleAction triangleAction = TriangleAction.getInstance();
    Warehouse warehouse = Warehouse.getInstance();

    @Test
    public void testCreateWarehouse() {
        Point pointX = new Point(2.00, 1.00);
        Point pointY = new Point(2.00, 6.00);
        Point pointZ = new Point(6.00, 1.00);
        Triangle triangle = new Triangle(pointX, pointY, pointZ);
        warehouseCreator.createWarehouse(triangle);
        TriangleParams actual = warehouse.get(triangle.getId());
        TriangleParams expected = new TriangleParams(triangleAction.perimeter(triangle), triangleAction.square(triangle));
        Assert.assertEquals(actual, expected);
    }
}
