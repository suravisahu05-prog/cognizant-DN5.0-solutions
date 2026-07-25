import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CalculatorServiceParameterizedTest {

    private CalculatorService calculatorService = new CalculatorService();

    // Using @ValueSource - tests isEven with multiple single int inputs
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 100})
    void testIsEven_withEvenNumbers(int number) {
        assertTrue(calculatorService.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 99})
    void testIsEven_withOddNumbers(int number) {
        assertFalse(calculatorService.isEven(number), number + " should be odd");
    }

    // Using @CsvSource - tests add() with multiple pairs of inputs and their expected result
    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "10, 20, 30",
        "-5, 5, 0",
        "0, 0, 0"
    })
    void testAdd_withMultipleInputPairs(int a, int b, int expectedSum) {
        assertEquals(expectedSum, calculatorService.add(a, b));
    }
}
