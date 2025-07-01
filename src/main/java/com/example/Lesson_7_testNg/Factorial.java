package com.example.Lesson_7_testNg;

public class Factorial {

    /**
     * Вычисляет факториал числа.
     *
     * @param n Число, факториал которого нужно вычислить.
     * @return Факториал числа n.  Возвращает -1, если n отрицательное.
     */
    public static long calculateFactorial(int n) {
        if (n < 0) {
            return -1; // Ошибка: факториал не определен для отрицательных чисел
        }
        if (n == 0) {
            return 1; // Факториал 0 равен 1
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        int number = 5;
        long factorial = calculateFactorial(number);
        if (factorial == -1) {
            System.out.println("Невозможно вычислить факториал отрицательного числа.");
        } else {
            System.out.println("Факториал числа " + number + " равен " + factorial);
        }

        number = -2;
        factorial = calculateFactorial(number);
        if (factorial == -1) {
            System.out.println("Невозможно вычислить факториал отрицательного числа.");
        } else {
            System.out.println("Факториал числа " + number + " равен " + factorial);
        }

        number = 0;
        factorial = calculateFactorial(number);
        if (factorial == -1) {
            System.out.println("Невозможно вычислить факториал отрицательного числа.");
        } else {
            System.out.println("Факториал числа " + number + " равен " + factorial);
        }
    }
}