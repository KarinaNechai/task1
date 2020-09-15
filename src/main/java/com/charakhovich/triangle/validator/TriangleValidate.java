package com.charakhovich.triangle.validator;

import com.charakhovich.triangle.action.VectorAction;
import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Vector;

public class TriangleValidate {
    private static VectorAction vectorAction = VectorAction.getInstance();

    public static boolean isTriangle(Point pointX, Point pointY, Point pointZ) {
        boolean result;
        Vector vectorXY = new Vector(pointX, pointY);
        Vector vectorXZ = new Vector(pointX, pointZ);
        Vector vectorYZ = new Vector(pointY, pointZ);
        result=!(vectorAction.isCollinearVectors(vectorXY,vectorXZ)||vectorAction.isCollinearVectors(vectorXY,vectorYZ));
        return result;
    }
}
