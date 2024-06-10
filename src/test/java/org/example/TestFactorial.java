package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestFactorial {
    @Test
    public void testFactorial() {
        assertEquals("Факториал числа 5 должен быть равен 120", 120, Factorial.factorial(5));
        assertEquals("Факториал числа 0 должен быть равен 1", 1, Factorial.factorial(0));
        assertEquals("Факториал числа 1 должен быть равен 1", 1, Factorial.factorial(1));
        assertEquals("Факториал числа 3 должен быть равен 6", 6, Factorial.factorial(3));
    }
}

