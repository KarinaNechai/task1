package com.charakhovich.triangle.entity;

import com.charakhovich.triangle.generator.Generator;
import com.charakhovich.triangle.obsever.impl.TriangleObserver;

public class Triangle extends Shape {
    private Point pointX;
    private Point pointY;
    private Point pointZ;
    private Long triangleId;
    private TriangleObserver observer;

    public Triangle(Point pointX, Point pointY, Point pointZ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointZ = pointZ;
        triangleId = Generator.generateID();
    }

    public Triangle() {
        triangleId = Generator.generateID();
    }

    public Point getPointX() {
        return pointX;
    }

    public void setPointX(Point pointX) {
        this.pointX = pointX;
        notifyObservers();
    }

    public Point getPointY() {
        return pointY;
    }

    public void setPointY(Point pointY) {
        this.pointY = pointY;
        notifyObservers();
    }

    public Point getPointZ() {
        return pointZ;
    }

    public void setPointZ(Point pointZ) {
        this.pointZ = pointZ;
        notifyObservers();
    }

    public long getId() {
        return triangleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getPointX().equals(triangle.getPointX()) &&
                getPointY().equals(triangle.getPointY()) &&
                getPointZ().equals(triangle.getPointZ());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getPointX().hashCode();
        result = prime * result + this.getPointY().hashCode();
        result = prime * result + this.getPointZ().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strResult;
        strResult = new StringBuilder("Triangle ");
        strResult.append("{ pointX=(").append(pointX.getX()).append(',').append(pointX.getY()).append(')');
        strResult.append(" ,pointY=(").append(pointY.getX()).append(',').append(pointY.getY()).append(')');
        strResult.append(" ,pointZ=(").append(pointZ.getX()).append(',').append(pointZ.getY()).append(")}");
        return strResult.toString();
    }

    private void notifyObservers() {
        if (observer != null) {
            observer.actionPerformed(this);
        }
    }

    public void attach(TriangleObserver observer) {
        this.observer = observer;
    }

    public void detach(TriangleObserver observer) {
        this.observer = null;
    }
}
