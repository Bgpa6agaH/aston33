package com.example.Lesson_7_junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArithmeticOperationsTest {

    @Test
    public void testAddPositiveNumbers() {
        Assertions.assertEquals(5, ArithmeticOperations.add(2, 3), "Сложение положительных чисел");
    }

    @Test
    public void testAddNegativeNumbers() {
        Assertions.assertEquals(-5, ArithmeticOperations.add(-2, -3), "Сложение отрицательных чисел");
    }

    @Test
    public void testAddPositiveAndNegative() {
        Assertions.assertEquals(3, ArithmeticOperations.add(5, -2), "Сложение положительного и отрицательного");
    }

    @Test
    public void testAddZero() {
        Assertions.assertEquals(5, ArithmeticOperations.add(5, 0), "Сложение с нулем");
        Assertions.assertEquals(5, ArithmeticOperations.add(0, 5), "Сложение с нулем");
        Assertions.assertEquals(0, ArithmeticOperations.add(0, 0), "Сложение нулей");
    }

    @Test
    public void testAddIntegerMaxValue() {
        Assertions.assertEquals(Integer.MIN_VALUE, ArithmeticOperations.add(Integer.MAX_VALUE, 1), "Сложение с Integer.MAX_VALUE (переполнение)");
    }

    @Test
    public void testAddIntegerMinValue() {
        Assertions.assertEquals(Integer.MAX_VALUE, ArithmeticOperations.add(Integer.MIN_VALUE, -1), "Сложение с Integer.MIN_VALUE (переполнение)");
    }


    @Test
    public void testSubtractPositiveNumbers() {
        Assertions.assertEquals(3, ArithmeticOperations.subtract(5, 2), "Вычитание положительных чисел");
    }

    @Test
    public void testSubtractNegativeNumbers() {
        Assertions.assertEquals(-3, ArithmeticOperations.subtract(-5, -2), "Вычитание отрицательных чисел");
    }

    @Test
    public void testSubtractPositiveAndNegative() {
        Assertions.assertEquals(7, ArithmeticOperations.subtract(5, -2), "Вычитание положительного и отрицательного");
    }

    @Test
    public void testSubtractZero() {
        Assertions.assertEquals(5, ArithmeticOperations.subtract(5, 0), "Вычитание нуля");
        Assertions.assertEquals(-5, ArithmeticOperations.subtract(0, 5), "Вычитание из нуля");
        Assertions.assertEquals(0, ArithmeticOperations.subtract(0, 0), "Вычитание нулей");
    }

    @Test
    public void testSubtractIntegerMaxValue() {
        Assertions.assertEquals(Integer.MIN_VALUE, ArithmeticOperations.subtract(Integer.MAX_VALUE, -1), "Вычитание Integer.MAX_VALUE (переполнение)");
    }

    @Test
    public void testSubtractIntegerMinValue() {
        Assertions.assertEquals(Integer.MAX_VALUE, ArithmeticOperations.subtract(Integer.MIN_VALUE, 1), "Вычитание Integer.MIN_VALUE (переполнение)");
    }

    @Test
    public void testMultiplyPositiveNumbers() {
        Assertions.assertEquals(6, ArithmeticOperations.multiply(2, 3), "Умножение положительных чисел");
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        Assertions.assertEquals(6, ArithmeticOperations.multiply(-2, -3), "Умножение отрицательных чисел");
    }

    @Test
    public void testMultiplyPositiveAndNegative() {
        Assertions.assertEquals(-6, ArithmeticOperations.multiply(2, -3), "Умножение положительного и отрицательного");
    }

    @Test
    public void testMultiplyZero() {
        Assertions.assertEquals(0, ArithmeticOperations.multiply(5, 0), "Умножение на ноль");
        Assertions.assertEquals(0, ArithmeticOperations.multiply(0, 5), "Умножение на ноль");
        Assertions.assertEquals(0, ArithmeticOperations.multiply(0, 0), "Умножение нулей");
    }

    @Test
    public void testMultiplyIntegerMaxValue() {
        Assertions.assertEquals(Integer.MAX_VALUE, ArithmeticOperations.multiply(Integer.MAX_VALUE, 1), "Умножение на 1 (Integer.MAX_VALUE)");
    }

    @Test
    public void testMultiplyByMinusOne() {
        Assertions.assertEquals(-Integer.MAX_VALUE, ArithmeticOperations.multiply(Integer.MAX_VALUE, -1), "Умножение Integer.MAX_VALUE на -1");
    }


    @Test
    public void testDividePositiveNumbers() {
        Assertions.assertEquals(3.0, ArithmeticOperations.divide(6, 2), "Деление положительных чисел");
    }

    @Test
    public void testDivideNegativeNumbers() {
        Assertions.assertEquals(3.0, ArithmeticOperations.divide(-6, -2), "Деление отрицательных чисел");
    }

    @Test
    public void testDividePositiveAndNegative() {
        Assertions.assertEquals(-3.0, ArithmeticOperations.divide(6, -2), "Деление положительного и отрицательного");
    }

    @Test
    public void testDivideZeroByPositive() {
        Assertions.assertEquals(0.0, ArithmeticOperations.divide(0, 5), "Деление нуля на положительное число");
    }


    @Test
    public void testDivideByZero() {
        double result = ArithmeticOperations.divide(5, 0);
        Assertions.assertTrue(Double.isNaN(result), "Деление на ноль должно возвращать NaN");
    }

    @Test
    public void testDivideIntegerMaxValue() {
        Assertions.assertEquals(Integer.MAX_VALUE, ArithmeticOperations.divide(Integer.MAX_VALUE, 1), "Деление Integer.MAX_VALUE на 1");
    }

    @Test
    public void testDivideByMinusOne() {
        Assertions.assertEquals(-Integer.MAX_VALUE, ArithmeticOperations.divide(Integer.MAX_VALUE, -1), "Деление Integer.MAX_VALUE на -1");
    }
}