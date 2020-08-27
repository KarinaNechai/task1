package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.exception.TriangleException;
import com.charakhovich.triangle.validator.TriangleValidate;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleFactory implements com.charakhovich.triangle.creator.ShapeFactory {
    static final Logger logger = LogManager.getLogger();
    static TriangleValidate triangleValidate = new TriangleValidate();
    static final int TRIANGLE_COUNT_POINT = 3;

      @Override
    public Triangle create(Point... points) throws TriangleException {
        if (points.length <TRIANGLE_COUNT_POINT) {
            throw new TriangleException("Can't create triangle.The number of points is less than   "+ TRIANGLE_COUNT_POINT);
        }
        Point pointX=points[0];
        Point pointY=points[1];
        Point pointZ=points[2];
        boolean isValidTriangle=TriangleValidate.isTriangle(pointX,pointY,pointZ);
        Triangle triangle;
        if (isValidTriangle) {
            triangle = new Triangle(pointX,pointY,pointZ);
            logger.log(Level.INFO, "Triangle create. " + triangle.toString());
        } else {
            throw new TriangleException("Parameters of triangle isn't valid. Can't create triangle");
        }
        return triangle;
    }
}
