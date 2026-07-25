public class EmployeeArrayManager {
    private Employee[] employees;
    private int count; // tracks how many slots are actually filled

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add - O(1) if space available, since we just place at the next free index
    public void addEmployee(Employee emp) {
        if (count >= employees.length) {
            System.out.println("Array is full, cannot add more employees");
            return;
        }
        employees[count] = emp;
        count++;
        System.out.println("Added: " + emp);
    }

    // Search - O(n), must check each element until found
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse - O(n), visits every element once
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete - O(n), must find the element first, then shift all following elements left
    public void deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee ID " + employeeId + " not found");
            return;
        }

        // Shift all elements after the deleted one, one position to the left
        for (int i = indexToDelete; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null; // clear the now-duplicate last slot
        count--;
        System.out.println("Deleted employee ID: " + employeeId);
    }
}
