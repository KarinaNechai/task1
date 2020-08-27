package com.charakhovich.triangle.creator;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Shape;
import com.charakhovich.triangle.exception.TriangleException;

public interface ShapeFactory {
    Shape create(Point...points) throws TriangleException;
}
