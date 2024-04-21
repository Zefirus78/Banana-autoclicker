package hw_3.part1.models;

import hw_3.part1.contracts.GeometricFigure;

public class Square implements GeometricFigure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}
