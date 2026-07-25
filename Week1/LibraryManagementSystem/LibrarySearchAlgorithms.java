public class LibrarySearchAlgorithms {

    // Linear Search by title - works on unsorted array
    // Best: O(1), Average: O(n), Worst: O(n)
    public static int linearSearchByTitle(Book[] books, String targetTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search by title - requires array sorted alphabetically by title
    // Best: O(1), Average/Worst: O(log n)
    public static int binarySearchByTitle(Book[] sortedBooks, String targetTitle) {
        int low = 0, high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = sortedBooks[mid].getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
