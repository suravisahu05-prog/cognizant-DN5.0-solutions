import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void firstTest() {
        System.out.println("Running first test - e.g., initialize data");
    }

    @Test
    @Order(2)
    void secondTest() {
        System.out.println("Running second test - e.g., perform an action on that data");
    }

    @Test
    @Order(3)
    void thirdTest() {
        System.out.println("Running third test - e.g., verify final result");
    }
}
