package com.charakhovich.triangle.obsever;
import com.charakhovich.triangle.entity.Triangle;

public interface Observer {
    void actionPerformed(Triangle triangle);
}
