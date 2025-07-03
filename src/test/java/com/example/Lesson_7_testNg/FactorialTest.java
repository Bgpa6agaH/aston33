package com.example.Lesson_7_testNg;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test(dataProvider = "validFactorialData")
    public void testCalculateFactorialValidInput(int n, long expectedFactorial) {
        long actualFactorial = Factorial.calculateFactorial(n);
        Assert.assertEquals(actualFactorial, expectedFactorial,
                "Факториал числа " + n + " рассчитан неверно.");
    }

    @DataProvider(name = "validFactorialData")
    public Object[][] validFactorialData() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {5, 120},
                {20, 2432902008176640000L} // Добавим тест для 20 (максимальное допустимое значение)
        };
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialNegativeInputThrowsException() {
        Factorial.calculateFactorial(-1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testCalculateFactorialOverflowThrowsException() {
        Factorial.calculateFactorial(21);
    }





}
