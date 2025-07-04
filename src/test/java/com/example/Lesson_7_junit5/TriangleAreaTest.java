package com.example.Lesson_7_junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TriangleAreaTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 0.5",
            "-1, 10, -1",
            "2, 1073741823, 1073741823"  // {2,((int)Double.MAX_VALUE)>>1,(int)Double.MAX_VALUE>>1
    })
    public void testCalculateArea(double base, double height, double expectedArea) {
        double area = TriangleArea.calculateArea(base, height);
        Assertions.assertEquals(expectedArea, area, 0.0001, // Adding a delta for double comparison
                "Площадь для " + base + " и " + height + " рассчитана не верно");
    }

    @Test
    public void testCalculateAreaOverflowThrowsException() {
        Assertions.assertThrows(ArithmeticException.class, () -> TriangleArea.calculateArea(4, Double.MAX_VALUE),
                "Ожидалось исключение ArithmeticException при переполнении double.");
    }


}

