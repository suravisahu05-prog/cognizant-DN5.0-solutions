public class StripeGateway {
    public void sendStripeCharge(double amount, String currency) {
        System.out.println("Processing Stripe charge of " + amount + " " + currency);
    }
}
