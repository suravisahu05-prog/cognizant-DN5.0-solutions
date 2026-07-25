import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSubtractTest {
    private Calculator calculator = new Calculator();

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
    }
}
