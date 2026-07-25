# Library Management System - Analysis

## Linear Search
Checks each book one at a time from the start, comparing its title to the
target, until a match is found or the list ends. Works on data in any order
(sorted or not), but can be slow for large collections.

## Binary Search
Requires the books to already be sorted by title. It repeatedly checks the
middle element and eliminates half of the remaining search range each time,
based on whether the target title comes alphabetically before or after the
middle title.

## Time Complexity Comparison
| Algorithm | Best Case | Average Case | Worst Case | Requires Sorted Data |
|-----------|-----------|---------------|------------|---------------------|
| Linear Search | O(1) | O(n) | O(n) | No |
| Binary Search | O(1) | O(log n) | O(log n) | Yes |

## When to Use Each, Based on Dataset Size and Order
- **Small library (few hundred books) or frequently changing catalog**: Linear
  search is simpler and avoids the overhead of maintaining a sorted order,
  since the performance difference is negligible at small scale.
- **Large library (thousands of books) with relatively stable catalog**:
  Binary search is far more efficient - for 100,000 books, linear search
  could take up to 100,000 comparisons in the worst case, while binary
  search would take only about 17 (since log2(100,000) ≈ 17).
- If the catalog changes very frequently (new books added/removed constantly),
  the cost of re-sorting before each binary search may offset its speed
  advantage, making linear search more practical unless the list can be kept
  sorted incrementally (e.g., inserting new books in their correct sorted
  position rather than at the end).
