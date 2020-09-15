package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.creator.ShapeCreator;
import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.exception.TriangleException;
import com.charakhovich.triangle.validator.TriangleValidate;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleCreator implements ShapeCreator<Triangle> {
    static final Logger logger = LogManager.getLogger(ShapeCreator.class);
    static final int TRIANGLE_COUNT_POINT = 3;

    @Override
    public Triangle create(Point pointX,Point...points) throws TriangleException {
        if (points.length+1 <TRIANGLE_COUNT_POINT) {
            throw new TriangleException("Can't create triangle.Few points to create a triangle");
        }
        Point pointY=points[0];
        Point pointZ=points[1];
        boolean isValidTriangle;
        isValidTriangle=TriangleValidate.isTriangle(pointX,pointY,pointZ);
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
