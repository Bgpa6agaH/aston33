package com.example.Lesson_7_testNg;

public class TriangleArea {

    /**
     * Вычисляет площадь треугольника по основанию и высоте.
     *
     * @param base Основание треугольника.
     * @param height Высота треугольника.
     * @return Площадь треугольника. Возвращает -1, если основание или высота отрицательны.
     */
    public static double calculateArea(double base, double height) {
        if (base < 0 || height < 0) {
            return -1; // Ошибка: основание и высота должны быть неотрицательными
        }
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        double base = 10.0;
        double height = 5.0;
        double area = calculateArea(base, height);
        if (area == -1) {
            System.out.println("Основание и высота должны быть неотрицательными.");
        } else {
            System.out.println("Площадь треугольника с основанием " + base + " и высотой " + height + " равна " + area);
        }

        base = -3;
        height = 6.0;
        area = calculateArea(base, height);
        if (area == -1) {
            System.out.println("Основание и высота должны быть неотрицательными.");
        } else {
            System.out.println("Площадь треугольника с основанием " + base + " и высотой " + height + " равна " + area);
        }

    }
}
