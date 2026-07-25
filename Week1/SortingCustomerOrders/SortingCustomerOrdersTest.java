public class SortingCustomerOrdersTest {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order(1, "Suravi", 2500.0),
            new Order(2, "Rahul", 800.0),
            new Order(3, "Priya", 5200.0),
            new Order(4, "Aman", 1200.0)
        };

        System.out.println("--- Before Bubble Sort ---");
        for (Order o : ordersForBubble) System.out.println(o);

        SortingAlgorithms.bubbleSort(ordersForBubble);

        System.out.println("\n--- After Bubble Sort (by totalPrice) ---");
        for (Order o : ordersForBubble) System.out.println(o);

        Order[] ordersForQuick = {
            new Order(1, "Suravi", 2500.0),
            new Order(2, "Rahul", 800.0),
            new Order(3, "Priya", 5200.0),
            new Order(4, "Aman", 1200.0)
        };

        System.out.println("\n--- Before Quick Sort ---");
        for (Order o : ordersForQuick) System.out.println(o);

        SortingAlgorithms.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);

        System.out.println("\n--- After Quick Sort (by totalPrice) ---");
        for (Order o : ordersForQuick) System.out.println(o);
    }
}
