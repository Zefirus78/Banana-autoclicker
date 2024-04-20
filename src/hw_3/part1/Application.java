package hw_3.part1;

import hw_3.part1.contracts.GeometricFigure;
import hw_3.part1.models.Circle;
import hw_3.part1.models.Square;
import hw_3.part1.models.Triangle;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Application {
    public static void totalArea(List<GeometricFigure> figureArray){
        double total = 0;
        for (GeometricFigure figure : figureArray) {
            System.out.println(figure.area());
            total += round(figure.area());
        }
        System.out.println(total);
    }
    public static void main(String[] args) {
        List<GeometricFigure> figures = new ArrayList<>();
        figures.add(new Square(50));
        figures.add(new Circle(30));
        figures.add(new Triangle(15,8));
        totalArea(figures);

    }

}
