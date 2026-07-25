public class InventoryManagementTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Laptop", 10, 55000.0));
        manager.addProduct(new Product(102, "Mouse", 50, 500.0));
        manager.addProduct(new Product(103, "Keyboard", 30, 1200.0));

        System.out.println("\n--- All Products ---");
        manager.displayAllProducts();

        System.out.println("\n--- Updating Product 102 ---");
        manager.updateProduct(102, 40, 450.0);

        System.out.println("\n--- Deleting Product 103 ---");
        manager.deleteProduct(103);

        System.out.println("\n--- Final Inventory ---");
        manager.displayAllProducts();
    }
}
