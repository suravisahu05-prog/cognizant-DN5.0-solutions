public class CheckoutService {
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout() {
        // These must happen in this exact order for checkout to make sense
        paymentProcessor.validatePayment();
        paymentProcessor.chargeCustomer();
        paymentProcessor.sendReceipt();
    }
}
