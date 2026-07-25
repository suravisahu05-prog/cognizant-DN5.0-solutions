public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    public void processPayment(double amount) {
        // translates the generic call to Stripe's specific method
        stripeGateway.sendStripeCharge(amount, "USD");
    }
}
