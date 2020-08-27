package com.charakhovich.triangle.specification;

import com.charakhovich.triangle.entity.Triangle;

public interface Specification  {
    boolean specify(Triangle triangle);
}
