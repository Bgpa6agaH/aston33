package Task2;

import java.awt.*;

public class Circle extends Shape {

    private final double radius;

    public Circle(double radius, Color fillColor, Color borderColor) {
        super(fillColor,borderColor);
        this.radius = radius;
            }

    // Геттер для стороны (без параметров)
    public double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        Formula circlePerimeter = radius -> 2 * Math.PI * radius[0];
        return this.calculate(circlePerimeter, this.getRadius());
    }

    @Override
    public double calculateArea() {
        Formula circleArea = radius -> Math.PI * radius[0] * radius[0];
        return this.calculate(circleArea, this.getRadius());
    }

}
