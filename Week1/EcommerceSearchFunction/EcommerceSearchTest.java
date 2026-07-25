import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Mouse", "Electronics"),
            new Product(110, "Desk Chair", "Furniture"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(107, "Bookshelf", "Furniture")
        };

        // Linear search - works directly on the unsorted array
        int targetId = 103;
        int linearResult = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Linear Search: Product ID " + targetId +
                " found at index " + linearResult);

        // Binary search - array must be sorted by productId first
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        int binaryResult = SearchAlgorithms.binarySearch(sortedProducts, targetId);
        System.out.println("Binary Search: Product ID " + targetId +
                " found at index " + binaryResult + " (in sorted array)");
    }
}
