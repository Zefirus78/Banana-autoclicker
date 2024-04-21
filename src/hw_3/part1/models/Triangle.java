package hw_3.part1.models;

import hw_3.part1.contracts.GeometricFigure;

public class Triangle implements GeometricFigure {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (base * height) / 2;
    }
}
