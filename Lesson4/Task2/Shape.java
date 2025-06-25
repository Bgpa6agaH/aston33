package Task2;

import java.awt.*;

abstract public class Shape implements GeometricFigure {

    private Color fillColor;
    private Color borderColor;

    public Shape(Color fillColor, Color borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    Color getFillColor() {
        return fillColor;
    }

    public void toPrint(){
        System.out.println("Shape{" +
                " perimeter=" + calculatePerimeter() +
                " area=" + calculateArea() +
                " fillColor=" + this.fillColor +
                " borderColor=" + this.borderColor +
                '}');
    }

}
