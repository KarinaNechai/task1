package com.charakhovich.triangle.repository;

import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.impl.SpecificationTriangleMaxSquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {
    private List<Triangle> triangleList;

    private TriangleRepository() {
        triangleList = new ArrayList<>();
    }

    public static TriangleRepository getInstance() {
        return TriangleRepository.SingletonHolder.HOLDER_INSTANCE;
    }

    private static class SingletonHolder {
        static final TriangleRepository HOLDER_INSTANCE = new TriangleRepository();
    }

    public void sort(ComparatorTriangle triangleSortBy) {
        triangleList.sort(triangleSortBy);
    }

    public List<Triangle> query(SpecificationTriangleMaxSquare specification) {
        ArrayList<Triangle> resultList = (ArrayList<Triangle>) triangleList.stream()
                .filter(specification::specify).collect(Collectors.toList());
        return resultList;
    }

    public boolean add(Triangle triangle) {
        return triangleList.add(triangle);
    }

    public Triangle get(int index) {
        return triangleList.get(index);
    }

    public Triangle set(int index, Triangle element) {
        return triangleList.set(index, element);
    }

    public Triangle remove(int index) {
        return triangleList.remove(index);
    }

    public List<Triangle> getTriangleList() {
        return Collections.unmodifiableList(triangleList);
    }
}
