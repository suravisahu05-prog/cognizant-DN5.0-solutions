import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    // HashMap chosen for O(1) average time add/update/delete/lookup by productId
    private Map<Integer, Product> inventory = new HashMap<>();

    // Add a new product - O(1) average
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // Update an existing product's quantity and price - O(1) average
    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated: " + product);
        } else {
            System.out.println("Product ID " + productId + " not found");
        }
    }

    // Delete a product - O(1) average
    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Product ID " + productId + " not found");
        }
    }

    public void displayAllProducts() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
