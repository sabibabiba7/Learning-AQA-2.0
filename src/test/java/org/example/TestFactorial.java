package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TestFactorial {
    @Test
    public void testFactorial() {
        Assert.assertEquals(Factorial.factorial(5), 120, "Факториал числа 5 должен быть равен 120");
        Assert.assertEquals(Factorial.factorial(0), 1, "Факториал числа 0 должен быть равен 1");
        Assert.assertEquals(Factorial.factorial(1), 1, "Факториал числа 1 должен быть равен 1");
        Assert.assertEquals(Factorial.factorial(3), 6, "Факториал числа 3 должен быть равен 6");
    }
}

