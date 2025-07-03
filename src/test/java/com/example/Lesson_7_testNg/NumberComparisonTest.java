package com.example.Lesson_7_testNg;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class NumberComparisonTest {


    // Вспомогательный метод для перехвата вывода в консоль
    private String getConsoleOutput(int a, int b) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        NumberComparison.compareNumbers(a, b);

        System.setOut(originalOut);
        return outputStream.toString().trim(); // Обрезаем пробелы в начале и конце
    }

    @Test
    public void testCompareNumbers_aGreaterThanB() {
        int a = 5;
        int b = 2;
        String expectedOutput = a+" больше "+b;
        String actualOutput = getConsoleOutput(a, b);
        assertEquals(actualOutput, expectedOutput, "Тест 1: Ошибка при a > b");
    }

    @Test
    public void testCompareNumbers_aLessThanB() {
        int a = 2;
        int b = 5;
        String expectedOutput = a+" меньше "+b;
        String actualOutput = getConsoleOutput(a, b);
        assertEquals(actualOutput, expectedOutput, "Тест 2: Ошибка при a < b");
    }

    @Test
    public void testCompareNumbers_aEqualsB() {
        int a = 3;
        int b = 3;
        String expectedOutput = a+" равно "+b;
        String actualOutput = getConsoleOutput(a, b);
        assertEquals(actualOutput, expectedOutput, "Тест 3: Ошибка при a = b");
    }

    @Test
    public void testCompareNumbers_minValue_minValue() {
        String expectedOutput = Integer.MIN_VALUE + " равно " + Integer.MIN_VALUE;
        String actualOutput = getConsoleOutput(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(actualOutput, expectedOutput, "Тест 4: Ошибка при MIN_VALUE = MIN_VALUE");
    }

    @Test
    public void testCompareNumbers_maxValue_maxValue() {
        String expectedOutput = Integer.MAX_VALUE + " равно " + Integer.MAX_VALUE;
        String actualOutput = getConsoleOutput(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(actualOutput, expectedOutput, "Тест 5: Ошибка при MAX_VALUE = MAX_VALUE");
    }

    @Test
    public void testCompareNumbers_minValue_maxValue() {
        String expectedOutput = Integer.MIN_VALUE + " меньше " + Integer.MAX_VALUE;
        String actualOutput = getConsoleOutput(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(actualOutput, expectedOutput, "Тест 6: Ошибка при MIN_VALUE < MAX_VALUE");
    }

    @Test
    public void testCompareNumbers_maxValue_minValue() {
        String expectedOutput = Integer.MAX_VALUE + " больше " + Integer.MIN_VALUE;
        String actualOutput = getConsoleOutput(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertEquals(actualOutput, expectedOutput, "Тест 7: Ошибка при MAX_VALUE > MIN_VALUE");
    }
}
