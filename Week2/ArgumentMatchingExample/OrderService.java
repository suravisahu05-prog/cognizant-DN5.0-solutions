public class OrderService {
    private PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void placeOrder(String customerId, double amount) {
        paymentGateway.processPayment(customerId, amount);
    }
}
