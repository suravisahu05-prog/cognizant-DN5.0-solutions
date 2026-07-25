import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorAddTest {
    private Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(5, 3), "5 + 3 should equal 8");
    }
}
