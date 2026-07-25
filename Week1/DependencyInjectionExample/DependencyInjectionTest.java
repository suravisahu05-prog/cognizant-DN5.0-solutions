public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the dependency
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject it into the service via constructor
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.printCustomerDetails("C101");
    }
}
