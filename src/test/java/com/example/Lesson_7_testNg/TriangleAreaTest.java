package com.example.Lesson_7_testNg;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleAreaTest {

    @Test(dataProvider = "validAreaData")
    public void testCalculateArea(double base, double height, double expectedArea) {
        double area = TriangleArea.calculateArea(base, height);
        Assert.assertEquals(area, expectedArea,
                "Площадь для " + base + " и " + height + "рассчитана не верно");
    }

    @DataProvider(name = "validAreaData")
    public Object[][] validAreaData() {
        return new Object[][]{
                {1, 1, 0.5},
                {-1, 10, -1},
                {2, ((int) Double.MAX_VALUE) >> 1, (int) Double.MAX_VALUE >> 1}
        };

    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testCalculateAreaOverflowThrowsException() {
        TriangleArea.calculateArea(4, Double.MAX_VALUE);
    }


}