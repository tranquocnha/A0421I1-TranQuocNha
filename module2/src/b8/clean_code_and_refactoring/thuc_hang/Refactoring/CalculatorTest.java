package b8.clean_code_and_refactoring.thuc_hang.Refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int a = 1;
        int b = 1;
        char o = '+';
        int expected = 2;

        int result = Calculater.calculate(a, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int a = 2;
        int b = 1;
        char o = '-';
        int expected = 1;

        int result = Calculater.calculater(a, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int a = 2;
        int b = 2;
        char o = '*';
        int expected = 4;

        int result = Calculater.calculater(a, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int a = 6;
        int b = 3;
        char o = '/';
        int expected = 2;

        int result = Calculater.calculater(a, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int a = 2;
        int b = 0;
        char o = '/';

        assertThrows(RuntimeException.class,
                ()-> {Calculater.calculater(a, b, o);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int a = 2;
        int b = 0;
        char o = '=';

        assertThrows(RuntimeException.class,
                ()-> {Calculater.calculater(a, b, o);});
    }
}
