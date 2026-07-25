public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection - dependency is passed in, not created internally
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerDetails(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Found: " + customer);
    }
}
