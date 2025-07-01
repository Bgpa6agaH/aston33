package com.example.Lesson_7_testNg;

public class ArithmeticOperations {

    /**
     * Выполняет сложение двух целых чисел.
     *
     * @param a Первое целое число.
     * @param b Второе целое число.
     * @return Сумма a и b.
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Выполняет вычитание двух целых чисел.
     *
     * @param a Первое целое число (уменьшаемое).
     * @param b Второе целое число (вычитаемое).
     * @return Разность a и b.
     */
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Выполняет умножение двух целых чисел.
     *
     * @param a Первое целое число.
     * @param b Второе целое число.
     * @return Произведение a и b.
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Выполняет деление двух целых чисел.
     *
     * @param a Первое целое число (делимое).
     * @param b Второе целое число (делитель).
     * @return Результат деления a на b.  Возвращает Double.NaN, если b равно 0.
     */
    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Ошибка: Деление на ноль!");
            return Double.NaN; // Возвращаем специальное значение, чтобы обозначить ошибку
        }
        return (double) a / b; // Приведение к double для точного деления
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        System.out.println("Сложение: " + num1 + " + " + num2 + " = " + add(num1, num2));
        System.out.println("Вычитание: " + num1 + " - " + num2 + " = " + subtract(num1, num2));
        System.out.println("Умножение: " + num1 + " * " + num2 + " = " + multiply(num1, num2));
        System.out.println("Деление: " + num1 + " / " + num2 + " = " + divide(num1, num2));

        System.out.println("\nТестирование деления на 0");
        num1 = 7;
        num2 = 0;
        System.out.println("Деление: " + num1 + " / " + num2 + " = " + divide(num1, num2));  // Проверка деления на ноль
    }
}