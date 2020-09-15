package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.Vector;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.decimal4j.util.DoubleRounder;

public class TriangleAction {
    static final Logger logger = LogManager.getLogger(TriangleAction.class);
    private static final int ROUNDING_PRECISION = 2;
    private VectorAction vectorAction = VectorAction.getInstance();

    private static class SingletonHolder {
        static final TriangleAction HOLDER_INSTANCE = new TriangleAction();
    }

    public static TriangleAction getInstance() {
        return TriangleAction.SingletonHolder.HOLDER_INSTANCE;
    }

    public double square(Triangle triangle) {
        Vector vectorA = new Vector(triangle.getPointX(), triangle.getPointY());
        Vector vectorB = new Vector(triangle.getPointX(), triangle.getPointZ());
        double result = Math.abs((vectorA.getCoordinateX() * vectorB.getCoordinateY() - vectorB.getCoordinateX() * vectorA.getCoordinateY()) / 2);
        result = DoubleRounder.round(result, ROUNDING_PRECISION);
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
        result = DoubleRounder.round(result, ROUNDING_PRECISION);
        logger.log(Level.INFO, triangle.toString() + " perimeter:" + result);
        return result;
    }

    public boolean isAcute(Triangle triangle) {
        Vector vectorXY = new Vector(triangle.getPointX(), triangle.getPointY());
        Vector vectorXZ = new Vector(triangle.getPointX(), triangle.getPointZ());
        Vector vectorYZ = new Vector(triangle.getPointY(), triangle.getPointZ());
        Vector vectorYX = new Vector(triangle.getPointY(), triangle.getPointX());
        Vector vectorZX = new Vector(triangle.getPointZ(), triangle.getPointX());
        Vector vectorZY = new Vector(triangle.getPointZ(), triangle.getPointY());
        double scalarMultiTriangleVectors = vectorAction.scalarMultiplication(vectorXY, vectorXZ) *
                vectorAction.scalarMultiplication(vectorYZ, vectorYX) *
                vectorAction.scalarMultiplication(vectorZX, vectorZY);
        boolean isAcute = scalarMultiTriangleVectors > 0;
        logger.log(Level.INFO, triangle.toString() + " isAcute:" + isAcute);
        return isAcute;
    }

    public boolean isObtuse(Triangle triangle) {
        Vector vectorXY = new Vector(triangle.getPointX(), triangle.getPointY());
        Vector vectorXZ = new Vector(triangle.getPointX(), triangle.getPointZ());
        Vector vectorYZ = new Vector(triangle.getPointY(), triangle.getPointZ());
        Vector vectorYX = new Vector(triangle.getPointY(), triangle.getPointX());
        Vector vectorZX = new Vector(triangle.getPointZ(), triangle.getPointX());
        Vector vectorZY = new Vector(triangle.getPointZ(), triangle.getPointY());
        double scalarMultiTriangleVectors = vectorAction.scalarMultiplication(vectorXY, vectorXZ) *
                vectorAction.scalarMultiplication(vectorYZ, vectorYX) *
                vectorAction.scalarMultiplication(vectorZX, vectorZY);
        boolean isObtuse = scalarMultiTriangleVectors < 0;
        logger.log(Level.INFO, triangle.toString() + " isObtuse:" + isObtuse);
        return isObtuse;
    }

    public boolean isRectangular(Triangle triangle) {
        Vector vectorXY = new Vector(triangle.getPointX(), triangle.getPointY());
        Vector vectorXZ = new Vector(triangle.getPointX(), triangle.getPointZ());
        Vector vectorYZ = new Vector(triangle.getPointY(), triangle.getPointZ());
        Vector vectorYX = new Vector(triangle.getPointY(), triangle.getPointX());
        Vector vectorZX = new Vector(triangle.getPointZ(), triangle.getPointX());
        Vector vectorZY = new Vector(triangle.getPointZ(), triangle.getPointY());
        double scalarMultiTriangleVectors = vectorAction.scalarMultiplication(vectorXY, vectorXZ) *
                vectorAction.scalarMultiplication(vectorYZ, vectorYX) *
                vectorAction.scalarMultiplication(vectorZX, vectorZY);
        boolean isRectangular = scalarMultiTriangleVectors == 0;
        logger.log(Level.INFO, triangle.toString() + " isRectangular:" + isRectangular);
        return isRectangular;
    }
}
