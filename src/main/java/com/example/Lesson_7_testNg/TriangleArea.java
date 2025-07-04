package com.example.Lesson_7_testNg;

public class TriangleArea {

    /**
     * Вычисляет площадь треугольника по основанию и высоте.
     *
     * @param base   Основание треугольника.
     * @param height Высота треугольника.
     * @return Площадь треугольника. Возвращает -1, если основание или высота отрицательны.
     */
    public static double calculateArea(double base, double height) {
        if (base < 0 || height < 0) {
            return -1;
        }

        double area = 0.5 * base * height;
        if (Double.isInfinite(area)) {
            throw new ArithmeticException("Площадь треугольника слишком велика для представления типом double.");
        }
        return area;
    }


}
