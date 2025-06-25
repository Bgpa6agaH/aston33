package Task2;

import java.awt.*;



public class MyRectangle extends Shape {

    private final double length;
    private final double width;

    public MyRectangle(double length, double width, Color fillColor, Color borderColor) {
        super(fillColor,borderColor);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }



    @Override
    public double calculatePerimeter() {
        Formula RectanglePerimeter = values -> (2 * (values[0] + values[1]));
        return this.calculate(RectanglePerimeter, length, width);
    }

    @Override
    public double calculateArea() {
        Formula RectangleArea = values -> values[0]*values[1];
        return this.calculate(RectangleArea, length,width );
    }

}