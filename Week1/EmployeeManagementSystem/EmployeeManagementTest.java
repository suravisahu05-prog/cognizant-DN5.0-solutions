public class EmployeeManagementTest {
    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(5);

        manager.addEmployee(new Employee(1, "Alice", "Manager", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        manager.addEmployee(new Employee(3, "Carol", "Designer", 55000));

        System.out.println("\n--- All Employees ---");
        manager.traverseEmployees();

        System.out.println("\n--- Search ID 2 ---");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\n--- Delete ID 2 ---");
        manager.deleteEmployee(2);

        System.out.println("\n--- All Employees After Delete ---");
        manager.traverseEmployees();
    }
}
