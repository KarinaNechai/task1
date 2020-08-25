package com.charakhovich.triangle.entity;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.getX(), getX()) == 0 &&
                Double.compare(point.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result= result*prime+Double.hashCode(this.x) ;
        result=result*prime+ Double.hashCode(this.y);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder("Point");
        strResult.append("{ x=").append(x).append(';');
        strResult.append(" y=").append(x).append('}');
        return strResult.toString();
    }
}
