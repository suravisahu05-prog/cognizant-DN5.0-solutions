import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Suravi";
        int loginAttempts = 3;

        // Single parameter
        logger.info("User {} logged in successfully", username);

        // Multiple parameters
        logger.warn("User {} has {} failed login attempts", username, loginAttempts);

        // Error with an exception, still using parameterized message
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred while processing user {}: {}", username, e.getMessage());
        }
    }
}
