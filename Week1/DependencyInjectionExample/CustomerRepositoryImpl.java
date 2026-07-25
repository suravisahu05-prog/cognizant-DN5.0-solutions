public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        // Simulating a database lookup
        return "Customer[id=" + id + ", name=Suravi Sahu]";
    }
}
