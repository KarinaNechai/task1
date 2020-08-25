package com.charakhovich.triangle.creator;

import com.charakhovich.triangle.entity.Shape;
import com.charakhovich.triangle.exception.TriangleException;

import java.util.List;

public interface ShapeCreator {
   Shape createShape(List<Double> coordinate) throws TriangleException;
}
