package com.charakhovich.triangle.comparator;

import com.charakhovich.triangle.entity.Triangle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public enum TriangleSortBy implements Comparator<Triangle> {
    ID {
        @Override
        public final int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getId() - o2.getId());
        }
    },
    COORDINATE_X_POINT_A {
        @Override
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getPointX().getX() - o2.getPointX().getX());
        }
    },
    COORDINATE_Y_POINT_A {
        @Override
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getPointY().getX() - o2.getPointY().getX());
        }
    };

    public List<Triangle> sortTriangle(List<Triangle> triangleList, TriangleSortBy triangleSortBy) {
        ArrayList <Triangle> resultList;
        resultList = (ArrayList<Triangle>) triangleList;
        triangleList.sort(triangleSortBy);
        return resultList;
    }
}
