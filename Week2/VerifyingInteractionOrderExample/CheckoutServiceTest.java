import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class CheckoutServiceTest {

    @Test
    public void testCheckout_verifyMethodCallOrder() {
        PaymentProcessor mockProcessor = mock(PaymentProcessor.class);
        CheckoutService checkoutService = new CheckoutService(mockProcessor);

        checkoutService.checkout();

        // Create an InOrder verifier scoped to this mock
        InOrder inOrder = inOrder(mockProcessor);

        // Verify the methods were called in this exact sequence
        inOrder.verify(mockProcessor).validatePayment();
        inOrder.verify(mockProcessor).chargeCustomer();
        inOrder.verify(mockProcessor).sendReceipt();
    }
}
