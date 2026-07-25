public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // User selects Credit Card at runtime
        context.setPaymentStrategy(new CreditCardPayment());
        context.executePayment(1500.0);

        // User switches to PayPal at runtime
        context.setPaymentStrategy(new PayPalPayment());
        context.executePayment(750.0);
    }
}
