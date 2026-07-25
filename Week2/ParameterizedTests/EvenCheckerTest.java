import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EvenCheckerTest {

    private EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 100, 0})
    void testIsEven_withEvenNumbers(int number) {
        assertTrue(evenChecker.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 99, -7})
    void testIsEven_withOddNumbers(int number) {
        assertFalse(evenChecker.isEven(number), number + " should be odd");
    }
}
