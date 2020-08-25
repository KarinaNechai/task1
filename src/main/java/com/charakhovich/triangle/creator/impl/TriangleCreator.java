package com.charakhovich.triangle.creator.impl;

import com.charakhovich.triangle.creator.ShapeCreator;
import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Shape;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.exception.TriangleException;
import com.charakhovich.triangle.validator.TriangleValidate;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleCreator implements ShapeCreator {
    static final Logger logger = LogManager.getLogger();
    TriangleValidate triangleValidate = new TriangleValidate();

    @Override
    public Shape createShape(List<Double> coordinate) throws TriangleException {
        final int countOfCoordinate = 6;
        final int countOfPointTriangle = 3;
        final int step = 2;
        Triangle triangle;
        Point[] trianglePoints = new Point[countOfPointTriangle];
        if (coordinate.size() < countOfCoordinate) {
            throw new TriangleException("The number of coordinates is less than 6. Can't create triangle");
        }
        for (int i = 0; i < countOfCoordinate; i = i + step) {
            trianglePoints[i] = new Point(coordinate.get(i), coordinate.get(i + 1));
        }
        if (triangleValidate.isTriangle(trianglePoints[0], trianglePoints[1], trianglePoints[2])) {
            triangle = new Triangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
            logger.log(Level.INFO,"Triangle create. "+triangle.toString());
        } else {
            throw new TriangleException("Parameters of triangle isn't valid. Can't create triangle");
        }
        return triangle;
    }
}
