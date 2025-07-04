package com.example.Lesson_7_testNg;

public class ArithmeticOperations {


    public static int add(int a, int b) {
        return a + b;
    }


    public static int subtract(int a, int b) {
        return a - b;
    }


    public static int multiply(int a, int b) {
        return a * b;
    }


    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Ошибка: Деление на ноль!");
            return Double.NaN;
        }
        return (double) a / b;
    }


}