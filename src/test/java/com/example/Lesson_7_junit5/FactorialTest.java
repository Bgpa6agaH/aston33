package com.example.Lesson_7_junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {


    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120"
    })
    @DisplayName("Тест расчета факториала с валидными данными (малые числа)")
    void testCalculateFactorialValidInput(int n, long expectedFactorial) {
        long actualFactorial = Factorial.calculateFactorial(n);
        assertEquals(expectedFactorial, actualFactorial, "Факториал числа " + n + " рассчитан неверно.");
    }

    @Test
    @DisplayName("Тест расчета факториала для максимального допустимого числа (20)")
    void testCalculateFactorialMaximumValidInput() {
        int n = 20;
        long expectedFactorial = 2432902008176640000L;
        long actualFactorial = Factorial.calculateFactorial(n);
        assertEquals(expectedFactorial, actualFactorial, "Факториал числа " + n + " рассчитан неверно.");
    }

    @Test
    @DisplayName("Тест выброса IllegalArgumentException при отрицательном вводе")
    void testCalculateFactorialNegativeInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculateFactorial(-1));
    }

    @Test
    @DisplayName("Тест выброса ArithmeticException при переполнении")
    void testCalculateFactorialOverflowThrowsException() {
        assertThrows(ArithmeticException.class, () -> Factorial.calculateFactorial(21));
    }
}