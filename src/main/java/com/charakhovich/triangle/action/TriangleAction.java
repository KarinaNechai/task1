package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAction {
    static final Logger logger = LogManager.getLogger();

    public double square(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        return ((vectorA.getX() * vectorB.getY() - vectorB.getX() * vectorA.getY()) / 2);
    }
    public double perimeter(Triangle triangle){
        double lengthSideXY=Math.sqrt(Math.pow(triangle.getPointX().getX()-triangle.getPointY().getX(),2)+
                Math.pow(triangle.getPointX().getY()-triangle.getPointY().getY(),2));
        double lengthSideXZ=Math.sqrt(Math.pow(triangle.getPointX().getX()-triangle.getPointZ().getX(),2)+
                Math.pow(triangle.getPointX().getY()-triangle.getPointZ().getY(),2));
        double lengthSideYZ=Math.sqrt(Math.pow(triangle.getPointY().getX()-triangle.getPointZ().getX(),2)+
                Math.pow(triangle.getPointY().getY()-triangle.getPointZ().getY(),2));
        return lengthSideXY+lengthSideXZ+lengthSideYZ;
    }

    public boolean isAcute(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        Point vectorC =Vector(triangle.getPointY(), triangle.getPointZ());
        return scalarMultiplication(vectorA, vectorB) * scalarMultiplication(vectorA, vectorC) *
                scalarMultiplication(vectorB, vectorC) > 0;
    }

    public boolean isObtuseTriangle(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        Point vectorC = Vector(triangle.getPointY(), triangle.getPointZ());
        return scalarMultiplication(vectorA, vectorB) * scalarMultiplication(vectorA, vectorC) *
                scalarMultiplication(vectorB, vectorC) < 0;
    }

    public boolean isRectangularTriangle(Triangle triangle) {
        Point vectorA = Vector(triangle.getPointX(), triangle.getPointY());
        Point vectorB = Vector(triangle.getPointX(), triangle.getPointZ());
        Point vectorC = Vector(triangle.getPointY(), triangle.getPointZ());
        return scalarMultiplication(vectorA, vectorB) * scalarMultiplication(vectorA, vectorC) *
                scalarMultiplication(vectorB, vectorC) == 0;
    }

    public Point Vector(Point pointA, Point pointB) {
        return new Point(pointB.getX() - pointA.getX(),
                pointB.getY() - pointA.getY());
    }

    public double scalarMultiplication(Point vectorA, Point vectorB) {
        return vectorA.getX() * vectorB.getY() - vectorB.getX() * vectorA.getY();
    }

}
