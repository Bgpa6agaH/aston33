package com.example.Lesson_7_junit5;

public class Factorial {

    /**
     * Факториал числа.
     *
     * @param n число, факториал которого нужно вычислить.
     * @return Факториал числа n, максимальное значение 2^63-1
     */
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Аргумент должен быть неотрицательным.");
        }

        if (n > 20) {
            // Факториал 21 уже превышает максимальное значение long
            throw new ArithmeticException("Факториал числа " + n + " слишком велик для типа long.");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }


}