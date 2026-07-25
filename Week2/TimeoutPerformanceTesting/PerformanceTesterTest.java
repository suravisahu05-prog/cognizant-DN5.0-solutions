import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

public class PerformanceTesterTest {

    private PerformanceTester performanceTester = new PerformanceTester();

    // Approach 1: Using @Timeout annotation - fails the test if it runs longer than specified
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testPerformTask_withTimeoutAnnotation() {
        performanceTester.performTask();
    }

    // Approach 2: Using assertTimeout - checks the code completes within the given Duration
    @Test
    void testPerformTask_withAssertTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            performanceTester.performTask();
        });
    }
}
