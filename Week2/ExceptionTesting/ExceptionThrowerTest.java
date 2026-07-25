import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionThrowerTest {

    private ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    void testThrowException_withNegativeValue() {
        // assertThrows checks that the given code block throws the expected exception type
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> exceptionThrower.throwException(-5),
            "Should throw IllegalArgumentException for negative value"
        );

        // Optionally verify the exception's message too
        assertEquals("Value cannot be negative", exception.getMessage());
    }

    @Test
    void testThrowException_withValidValue() {
        // Should NOT throw - just runs normally without any exception
        exceptionThrower.throwException(10);
    }
}
