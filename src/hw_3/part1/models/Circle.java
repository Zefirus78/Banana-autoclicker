package hw_3.part1.models;

import hw_3.part1.contracts.GeometricFigure;

import java.lang.Math;

public class Circle implements GeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
