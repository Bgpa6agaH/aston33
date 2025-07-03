package com.example.Lesson_7_testNg;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticOperationsTest {

    @Test
    public void testAddPositiveNumbers() {
        Assert.assertEquals(ArithmeticOperations.add(2, 3), 5, "Сложение положительных чисел");
    }

    @Test
    public void testAddNegativeNumbers() {
        Assert.assertEquals(ArithmeticOperations.add(-2, -3), -5, "Сложение отрицательных чисел");
    }

    @Test
    public void testAddPositiveAndNegative() {
        Assert.assertEquals(ArithmeticOperations.add(5, -2), 3, "Сложение положительного и отрицательного");
    }

    @Test
    public void testAddZero() {
        Assert.assertEquals(ArithmeticOperations.add(5, 0), 5, "Сложение с нулем");
        Assert.assertEquals(ArithmeticOperations.add(0, 5), 5, "Сложение с нулем");
        Assert.assertEquals(ArithmeticOperations.add(0, 0), 0, "Сложение нулей");
    }

    @Test
    public void testAddIntegerMaxValue() {
        Assert.assertEquals(ArithmeticOperations.add(Integer.MAX_VALUE, 1), Integer.MIN_VALUE, "Сложение с Integer.MAX_VALUE (переполнение)");
    }

    @Test
    public void testAddIntegerMinValue() {
        Assert.assertEquals(ArithmeticOperations.add(Integer.MIN_VALUE, -1), Integer.MAX_VALUE, "Сложение с Integer.MIN_VALUE (переполнение)");
    }


    @Test
    public void testSubtractPositiveNumbers() {
        Assert.assertEquals(ArithmeticOperations.subtract(5, 2), 3, "Вычитание положительных чисел");
    }

    @Test
    public void testSubtractNegativeNumbers() {
        Assert.assertEquals(ArithmeticOperations.subtract(-5, -2), -3, "Вычитание отрицательных чисел");
    }

    @Test
    public void testSubtractPositiveAndNegative() {
        Assert.assertEquals(ArithmeticOperations.subtract(5, -2), 7, "Вычитание положительного и отрицательного");
    }

    @Test
    public void testSubtractZero() {
        Assert.assertEquals(ArithmeticOperations.subtract(5, 0), 5, "Вычитание нуля");
        Assert.assertEquals(ArithmeticOperations.subtract(0, 5), -5, "Вычитание из нуля");
        Assert.assertEquals(ArithmeticOperations.subtract(0, 0), 0, "Вычитание нулей");
    }

    @Test
    public void testSubtractIntegerMaxValue() {
        Assert.assertEquals(ArithmeticOperations.subtract(Integer.MAX_VALUE, -1), Integer.MIN_VALUE, "Вычитание Integer.MAX_VALUE (переполнение)");
    }

    @Test
    public void testSubtractIntegerMinValue() {
        Assert.assertEquals(ArithmeticOperations.subtract(Integer.MIN_VALUE, 1), Integer.MAX_VALUE, "Вычитание Integer.MIN_VALUE (переполнение)");
    }

    @Test
    public void testMultiplyPositiveNumbers() {
        Assert.assertEquals(ArithmeticOperations.multiply(2, 3), 6, "Умножение положительных чисел");
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        Assert.assertEquals(ArithmeticOperations.multiply(-2, -3), 6, "Умножение отрицательных чисел");
    }

    @Test
    public void testMultiplyPositiveAndNegative() {
        Assert.assertEquals(ArithmeticOperations.multiply(2, -3), -6, "Умножение положительного и отрицательного");
    }

    @Test
    public void testMultiplyZero() {
        Assert.assertEquals(ArithmeticOperations.multiply(5, 0), 0, "Умножение на ноль");
        Assert.assertEquals(ArithmeticOperations.multiply(0, 5), 0, "Умножение на ноль");
        Assert.assertEquals(ArithmeticOperations.multiply(0, 0), 0, "Умножение нулей");
    }

    @Test
    public void testMultiplyIntegerMaxValue() {
        Assert.assertEquals(ArithmeticOperations.multiply(Integer.MAX_VALUE, 1), Integer.MAX_VALUE, "Умножение на 1 (Integer.MAX_VALUE)");
    }

    @Test
    public void testMultiplyByMinusOne() {
        Assert.assertEquals(ArithmeticOperations.multiply(Integer.MAX_VALUE, -1), -Integer.MAX_VALUE, "Умножение Integer.MAX_VALUE на -1");
    }


    @Test
    public void testDividePositiveNumbers() {
        Assert.assertEquals(ArithmeticOperations.divide(6, 2), 3.0, "Деление положительных чисел");
    }

    @Test
    public void testDivideNegativeNumbers() {
        Assert.assertEquals(ArithmeticOperations.divide(-6, -2), 3.0, "Деление отрицательных чисел");
    }

    @Test
    public void testDividePositiveAndNegative() {
        Assert.assertEquals(ArithmeticOperations.divide(6, -2), -3.0, "Деление положительного и отрицательного");
    }

    @Test
    public void testDivideZeroByPositive() {
        Assert.assertEquals(ArithmeticOperations.divide(0, 5), 0.0, "Деление нуля на положительное число");
    }


    @Test
    public void testDivideByZero() {
        double result = ArithmeticOperations.divide(5, 0);
        Assert.assertTrue(Double.isNaN(result), "Деление на ноль должно возвращать NaN");
    }

    @Test
    public void testDivideIntegerMaxValue() {
        Assert.assertEquals(ArithmeticOperations.divide(Integer.MAX_VALUE, 1), (double) Integer.MAX_VALUE, "Деление Integer.MAX_VALUE на 1");
    }

    @Test
    public void testDivideByMinusOne() {
        Assert.assertEquals(ArithmeticOperations.divide(Integer.MAX_VALUE, -1), (double) -Integer.MAX_VALUE, "Деление Integer.MAX_VALUE на -1");
    }

}

