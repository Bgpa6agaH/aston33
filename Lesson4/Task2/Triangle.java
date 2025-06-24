package Task2;

import java.awt.*;

public class Triangle extends Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA,
                    double sideB,
                    double sideC,
                    Color fillColor,
                    Color borderColor) {
        super(fillColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double calculatePerimeter() {
        Formula TriangleArea = (values) -> values[0] + values[1] + values[2];
        return this.calculate(TriangleArea, sideA, sideB, sideC);

    }

    @Override
    public double calculateArea() {
        Formula TriangleArea = (values) -> {
            double p = values[0] + values[1] + values[2];
            return Math.sqrt(p * (p - values[0]) * (p - values[1]) * (p - values[2]));
        };
        return this.calculate(TriangleArea, sideA, sideB, sideC);

    }
}
