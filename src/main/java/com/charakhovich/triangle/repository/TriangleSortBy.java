package com.charakhovich.triangle.repository;

import com.charakhovich.triangle.entity.Triangle;

import java.util.Comparator;

public enum TriangleSortBy implements Comparator<Triangle> {
    ID {
        @Override
        public final int compare(Triangle o1, Triangle o2) {
            if (o1 == null) {
                return o2 == null ? 0 : -1;
            }
            if (o2 == null) {
                return 1;
            }
            Long tempO1 =  o1.getId();
            Long tempO2 = o2.getId();
            return (tempO1.compareTo(tempO2));
        }
    },
    FIRST_COORDINATE_POINT_X {
        @Override
        public int compare(Triangle o1, Triangle o2) {

            if (o1 == null) {
                return o2 == null ? 0 : -1;
            }
            if (o2 == null) {
                return 1;
            }
            Double tempO1 = o1.getPointX().getX();
            Double tempO2 = o2.getPointX().getX();
            return (tempO1.compareTo(tempO2));
        }
},
}
