import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(4, 7);
        assertEquals(11, result, "4 + 7 should equal 11");
    }
}
