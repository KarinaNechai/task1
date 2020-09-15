package com.charakhovich.triangle.repository;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;

import java.util.Comparator;

public enum ComparatorTriangle implements Comparator<Triangle> {
    ID {
        @Override
        public final int compare(Triangle triangle1, Triangle triangle2) {
            if (triangle1 == null) {
                return triangle2 == null ? 0 : -1;
            }
            if (triangle2 == null) {
                return 1;
            }
            Long tempO1 = triangle1.getId();
            Long tempO2 = triangle2.getId();
            return (tempO1.compareTo(tempO2));
        }
    },
    SQUARE {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            TriangleAction triangleAction = TriangleAction.getInstance();
            if (triangle1 == null) {
                return 0;
            }
            if (triangle2 == null) {
                return 1;
            }
            Double squareTriangle1 = triangleAction.square(triangle1);
            Double squareTriangle2 = triangleAction.square(triangle2);
            return (squareTriangle1.compareTo(squareTriangle2));
        }
    }
}
