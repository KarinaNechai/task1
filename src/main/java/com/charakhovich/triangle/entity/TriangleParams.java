package com.charakhovich.triangle.entity;

public class TriangleParams {
    private double perimeter;
    private double square;

    public TriangleParams(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleParams that = (TriangleParams) o;
        return Double.compare(that.getPerimeter(), getPerimeter()) == 0 &&
                Double.compare(that.getSquare(), getSquare()) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(this.perimeter);
        result = prime * result + Double.hashCode(this.square);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strResult = new StringBuilder("TriangleParams{");
        strResult.append("{ perimeter=").append(perimeter);
        strResult.append(", square=").append(square);
        strResult.append('}');
        return strResult.toString();
    }
}
