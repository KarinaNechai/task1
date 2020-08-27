package com.charakhovich.triangle.repository;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.specification.impl.SpecificationMaxSquare;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TriangleRepositoryTest {
    Triangle triangle1 = new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
    Triangle triangle2 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 6.00), new Point(6.00, 1.00));
    Triangle triangle3 = new Triangle(new Point(2.00, 1.00), new Point(4.00, 3.00), new Point(6.00, 1.00));

    @BeforeClass
    public void init() {
        TriangleRepository.getInstance().add(triangle3);
        TriangleRepository.getInstance().add(triangle1);
        TriangleRepository.getInstance().add(triangle2);
    }

    @Test
    public void testSort() {
        TriangleRepository.getInstance().sort(TriangleSortBy.ID);
        List<Triangle> triangleList=TriangleRepository.getInstance().getTriangleList();
        System.out.println();
    }

    @Test
    public void testQuery() {
        SpecificationMaxSquare specificationMaxSquare=new SpecificationMaxSquare(5);
        List<Triangle> triangleList=TriangleRepository.getInstance().query(specificationMaxSquare);
        Assert.assertEquals(triangleList.size(),2); System.out.println();
    }

    @Test
    public void testAdd() {
    }
}