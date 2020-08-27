package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.decimal4j.util.DoubleRounder;

public class TriangleAction {
    static final Logger logger = LogManager.getLogger();
    static final int ROUNDING_PRECISION= 2;

    public double square(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        double result = Math.abs((vectorA.getX() * vectorB.getY() - vectorB.getX() * vectorA.getY()) / 2);
        result= DoubleRounder.round(result, ROUNDING_PRECISION);
        logger.log(Level.INFO, triangle.toString() + " square:" + result);
        return result;
    }

    public double perimeter(Triangle triangle) {
        int degree = 2;
        double lengthSideXY = Math.sqrt(Math.pow(triangle.getPointX().getX() - triangle.getPointY().getX(), degree) +
                Math.pow(triangle.getPointX().getY() - triangle.getPointY().getY(), degree));
        double lengthSideXZ = Math.sqrt(Math.pow(triangle.getPointX().getX() - triangle.getPointZ().getX(), degree) +
                Math.pow(triangle.getPointX().getY() - triangle.getPointZ().getY(), degree));
        double lengthSideYZ = Math.sqrt(Math.pow(triangle.getPointY().getX() - triangle.getPointZ().getX(), degree) +
                Math.pow(triangle.getPointY().getY() - triangle.getPointZ().getY(), degree));
        double result = lengthSideXY + lengthSideXZ + lengthSideYZ;
        result= DoubleRounder.round(result, ROUNDING_PRECISION);
        logger.log(Level.INFO, triangle.toString() + " perimeter:" + result);
        return result;
    }

    public boolean isAcute(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        Point vectorC = Vector(triangle.getPointY(), triangle.getPointZ());
        double scalarMultTriangleVectors = scalarMultiplication(vectorA, vectorB) * scalarMultiplication(vectorA, vectorC) *
                scalarMultiplication(vectorB, vectorC);
        boolean isAcute = scalarMultTriangleVectors > 0;
        logger.log(Level.INFO, triangle.toString() + " isAcute:" + isAcute);
        return isAcute;
    }

    public boolean isObtuse(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        Point vectorC = Vector(triangle.getPointY(), triangle.getPointZ());
        double scalarMultTriangleVectors = scalarMultiplication(vectorA, vectorB) * scalarMultiplication(vectorA, vectorC) *
                scalarMultiplication(vectorB, vectorC);
        boolean isObtuse = scalarMultTriangleVectors < 0;
        logger.log(Level.INFO, triangle.toString() + " isObtuse:" + isObtuse);
        return isObtuse;
    }

    public boolean isRectangular(Triangle triangle) {
        Point vectorXY = Vector(triangle.getPointY(), triangle.getPointX());
        Point vectorXZ = Vector(triangle.getPointZ(), triangle.getPointX());
        Point vectorYZ = Vector(triangle.getPointZ(), triangle.getPointY());
        double scalarMultTriangleVectors = scalarMultiplication(vectorXY, vectorXZ) *
                scalarMultiplication(vectorXY, vectorYZ) *
                scalarMultiplication(vectorXZ, vectorYZ);
        boolean isRectangular = scalarMultTriangleVectors == 0;
        logger.log(Level.INFO, triangle.toString() + " isRectangular:" + isRectangular);
        return isRectangular;
    }

    public Point Vector(Point pointA, Point pointB) {
        return new Point(pointB.getX() - pointA.getX(),
                pointB.getY() - pointA.getY());
    }

    public double scalarMultiplication(Point vectorA, Point vectorB) {
        return vectorA.getX() * vectorB.getY() + vectorB.getX() * vectorA.getY();
    }

}
