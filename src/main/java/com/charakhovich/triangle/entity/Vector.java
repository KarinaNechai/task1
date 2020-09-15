package com.charakhovich.triangle.entity;

public class Vector {
    private double coordinateX;
    private double coordinateY;

    public Vector(Point pointX, Point pointY) {
        double coordinateX=pointY.getX() - pointX.getX();
        double coordinateY=pointY.getY() - pointX.getY();
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        boolean result= Double.compare(vector.coordinateX, this.coordinateX) == 0 &&
                Double.compare(vector.coordinateY,this.coordinateY) == 0;
        return result;
    }

    @Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result= result*prime+Double.hashCode(coordinateX);
        result=result*prime+ Double.hashCode(coordinateY);
        return result;
    }
    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder("Vector");
        strResult.append("{coordinateX=").append(coordinateX).append(';');
        strResult.append(" coordinateY=").append(coordinateY).append('}');
        return strResult.toString();
    }
}
