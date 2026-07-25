public class SearchAlgorithms {

    // Linear Search - checks every element one by one, works on unsorted array
    // Best case: O(1) - item found at first position
    // Average case: O(n)
    // Worst case: O(n) - item at last position or not present at all
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - requires a SORTED array, repeatedly halves the search range
    // Best case: O(1) - item found at the middle on first try
    // Average case: O(log n)
    // Worst case: O(log n) - item at the edge of range or not present
    public static int binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0, high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return mid;
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
