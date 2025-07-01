package com.example.Lesson_7_testNg;

public class NumberComparison {

    /**
     * Сравнивает два целых числа и выводит результат.
     *
     * @param a Первое целое число.
     * @param b Второе целое число.
     */
    public static void compareNumbers(int a, int b) {
        if (a > b) {
            System.out.println(a + " больше " + b);
            return;
        }
        if (a < b) {
            System.out.println(a + " меньше " + b);
            return;
        }
            System.out.println(a + " равно " + b);
    }

    public static void main(String[] args) {
        int num1 = 15;
        int num2 = 7;
        compareNumbers(num1, num2);

        num1 = 3;
        num2 = 9;
        compareNumbers(num1, num2);

        num1 = 4;
        num2 = 4;
        compareNumbers(num1, num2);
    }
}