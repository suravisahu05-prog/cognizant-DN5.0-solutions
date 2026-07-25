import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAAPatternTest {

    private BankAccount account;

    // Setup - runs before EACH test method
    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0);
        System.out.println("Setup: created account with balance 1000.0");
    }

    // Teardown - runs after EACH test method
    @AfterEach
    void tearDown() {
        account = null;
        System.out.println("Teardown: account reset to null");
    }

    @Test
    void testDeposit() {
        // Arrange - account already set up with balance 1000.0 via @BeforeEach

        // Act
        account.deposit(500.0);

        // Assert
        assertEquals(1500.0, account.getBalance(), "Balance should increase by deposited amount");
    }

    @Test
    void testWithdraw() {
        // Arrange - account already set up with balance 1000.0 via @BeforeEach

        // Act
        account.withdraw(300.0);

        // Assert
        assertEquals(700.0, account.getBalance(), "Balance should decrease by withdrawn amount");
    }
}
