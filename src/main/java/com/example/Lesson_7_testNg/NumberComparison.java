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


}