import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Hobbit", "J.R.R. Tolkien"),
            new Book(2, "Atomic Habits", "James Clear"),
            new Book(3, "Deep Work", "Cal Newport"),
            new Book(4, "Sapiens", "Yuval Noah Harari")
        };

        String targetTitle = "Deep Work";

        // Linear search - works directly on unsorted array
        int linearResult = LibrarySearchAlgorithms.linearSearchByTitle(books, targetTitle);
        System.out.println("Linear Search: '" + targetTitle + "' found at index " + linearResult);

        // Binary search - array must be sorted by title first
        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        int binaryResult = LibrarySearchAlgorithms.binarySearchByTitle(sortedBooks, targetTitle);
        System.out.println("Binary Search: '" + targetTitle + "' found at index " + binaryResult + " (in sorted array)");
    }
}
