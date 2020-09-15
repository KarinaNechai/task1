package com.charakhovich.triangle.creator;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Shape;
import com.charakhovich.triangle.exception.TriangleException;

public interface ShapeCreator <T extends Shape>{
    T create(Point pointX,Point...points) throws TriangleException;
}
