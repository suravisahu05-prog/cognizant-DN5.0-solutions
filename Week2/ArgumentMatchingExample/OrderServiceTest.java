import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    public void testPlaceOrder_verifyExactArguments() {
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        OrderService orderService = new OrderService(mockGateway);

        orderService.placeOrder("CUST101", 500.0);

        // Verify the method was called with these EXACT argument values
        verify(mockGateway).processPayment("CUST101", 500.0);
    }

    @Test
    public void testPlaceOrder_verifyWithArgumentMatchers() {
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        OrderService orderService = new OrderService(mockGateway);

        orderService.placeOrder("CUST202", 750.0);

        // Verify using matchers - checks ANY String customerId, but amount must be > 0
        verify(mockGateway).processPayment(anyString(), doubleThat(amount -> amount > 0));
    }

    @Test
    public void testPlaceOrder_verifyWithEqMatcher() {
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        OrderService orderService = new OrderService(mockGateway);

        orderService.placeOrder("CUST303", 1000.0);

        // eq() explicitly matches a specific value - useful when mixing with other matchers
        verify(mockGateway).processPayment(eq("CUST303"), eq(1000.0));
    }
}
