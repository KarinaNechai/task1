package com.charakhovich.triangle.action;

import com.charakhovich.triangle.entity.Vector;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VectorAction {
    static final Logger logger = LogManager.getLogger(VectorAction.class);

    private static class SingletonHolder {
        static final VectorAction HOLDER_INSTANCE = new VectorAction();
    }

    public static VectorAction getInstance() {
        return VectorAction.SingletonHolder.HOLDER_INSTANCE;
    }

    public double scalarMultiplication(Vector vectorA, Vector vectorB) {
        double result = vectorA.getCoordinateX() * vectorB.getCoordinateX() + vectorB.getCoordinateY()
                * vectorB.getCoordinateY();
        return result;
    }

    public boolean isZeroVector(Vector vector) {
        boolean result = (vector.getCoordinateX() == 0) && (vector.getCoordinateY() == 0);
        logger.log(Level.INFO, vector.toString() + " is zero vector:" + result);
        return result;
    }

    public boolean isCollinearVectors(Vector vectorA, Vector vectorB) {
        boolean result = false;
        if (isZeroVector(vectorA) || isZeroVector(vectorB)) {
            return true;
        }
        boolean withZeroCoordinate = vectorA.getCoordinateX() * vectorA.getCoordinateY() * vectorB.getCoordinateY() *
                vectorB.getCoordinateX() == 0;
        if (withZeroCoordinate) {
            double n;
            n = (vectorA.getCoordinateX() != 0) ? vectorB.getCoordinateX() / vectorA.getCoordinateX() :
                    vectorB.getCoordinateY() / vectorA.getCoordinateY();
            double vectorNCoordinateX = vectorA.getCoordinateX() * n;
            double vectorNCoordinateY = vectorA.getCoordinateY() * n;
            result = (vectorB.getCoordinateX() == vectorNCoordinateX) && (vectorB.getCoordinateY() == vectorNCoordinateY);
        }
        if (!withZeroCoordinate) {
            double divCoordinateX = vectorA.getCoordinateX() / vectorB.getCoordinateX();
            double divCoordinateY = vectorA.getCoordinateY() / vectorB.getCoordinateY();
            result = (divCoordinateX == divCoordinateY);
        }
        return result;
    }
}
