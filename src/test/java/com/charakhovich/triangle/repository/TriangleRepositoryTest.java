package com.charakhovich.triangle.repository;

import com.charakhovich.triangle.entity.Point;
import com.charakhovich.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryTest {
    Triangle triangle1;
    Triangle triangle2;
    Triangle triangle3;
    TriangleRepository triangleRepository=TriangleRepository.getInstance();

    @BeforeClass
    public void setUp(){
        triangle1= new Triangle(new Point(2.00, 1.00), new Point(2.00, 6.00), new Point(6.00, 1.00));
        triangle2 = new Triangle(new Point(2.00, 1.00), new Point(0.00, 4.00), new Point(6.00, 1.00));
        triangle3 = new Triangle(new Point(2.00, 1.00), new Point(2.00, 20.00), new Point(6.00, 1.00));
        triangleRepository.add(triangle3);
        triangleRepository.add(triangle1);
        triangleRepository.add(triangle2);
    }

    @Test
    public void testSortById() {
        List<Triangle> expectedTriangleList= new ArrayList<>();
        expectedTriangleList.add(triangle1);
        expectedTriangleList.add(triangle2);
        expectedTriangleList.add(triangle3);
        triangleRepository.sort(ComparatorTriangle.ID);
        List<Triangle> actualTriangleList=triangleRepository.getTriangleList();
        Assert.assertEquals(actualTriangleList,expectedTriangleList);
    }
    @Test
    public void testSortBySquare() {
        List<Triangle> expectedTriangleList= new ArrayList<>();
        expectedTriangleList.add(triangle2);
        expectedTriangleList.add(triangle1);
        expectedTriangleList.add(triangle3);
        triangleRepository.sort(ComparatorTriangle.SQUARE);
        List<Triangle> actualTriangleList=triangleRepository.getTriangleList();
        Assert.assertEquals(actualTriangleList,expectedTriangleList);
    }

}