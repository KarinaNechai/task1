package com.charakhovich.triangle.obsever.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.creator.impl.TriangleCreator;
import com.charakhovich.triangle.creator.impl.WarehouseTriangleCreator;
import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.entity.Warehouse;
import com.charakhovich.triangle.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleObserverTest {
    TriangleCreator triangleCreator = new TriangleCreator();
    WarehouseTriangleCreator warehouseTriangleCreator = new WarehouseTriangleCreator();
    TriangleAction triangleAction = TriangleAction.getInstance();
    TriangleObserver triangleObserver = new TriangleObserver();

    @Test
    public void testActionPerformed() throws TriangleException {
        Point pointX = new Point(2.00, 1.00);
        Point pointY = new Point(2.00, 6.00);
        Point pointZ = new Point(6.00, 1.00);
        Triangle triangle = triangleCreator.create(pointX, pointY, pointZ);
        warehouseTriangleCreator.createWarehouse(triangle);
        triangle.attach(triangleObserver);
        triangle.setPointX(new Point(1.00, 1.00));
        triangle.attach(triangleObserver);
        TriangleParams actual = new TriangleParams(triangleAction.perimeter(triangle),triangleAction.square(triangle));
        TriangleParams expected = Warehouse.getInstance().get(triangle.getId());
        Assert.assertEquals(actual, expected);
    }
}