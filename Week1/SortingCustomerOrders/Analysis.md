# Sorting Customer Orders - Analysis

## Sorting Algorithms Overview
- **Bubble Sort**: Repeatedly steps through the list, comparing adjacent
  elements and swapping them if they're in the wrong order. Simple but slow,
  since large elements "bubble up" to their position one step at a time.
- **Insertion Sort**: Builds the sorted array one element at a time by taking
  each new element and inserting it into its correct position among the
  already-sorted elements before it.
- **Quick Sort**: Picks a "pivot" element, partitions the array so smaller
  elements go left and larger go right of the pivot, then recursively sorts
  each side. Very fast in practice due to good cache performance and average
  case efficiency.
- **Merge Sort**: Splits the array in half repeatedly until single elements
  remain, then merges them back together in sorted order. Consistently
  O(n log n) even in the worst case, but needs extra memory for merging.

## Time Complexity Comparison

| Algorithm | Best Case | Average Case | Worst Case |
|-----------|-----------|---------------|------------|
| Bubble Sort | O(n) | O(n^2) | O(n^2) |
| Quick Sort | O(n log n) | O(n log n) | O(n^2) |

## Why Quick Sort Is Generally Preferred Over Bubble Sort
Bubble Sort compares and swaps adjacent elements repeatedly, resulting in
roughly n^2 operations even for moderately sized order lists - this becomes
very slow as the number of orders grows into the thousands or more. Quick
Sort's divide-and-conquer approach means each recursive call handles a
smaller portion of the data, giving O(n log n) performance on average, which
scales far better. For example, sorting 10,000 orders would take about
100,000,000 operations with Bubble Sort, versus roughly 130,000 with Quick
Sort - a massive practical difference for a live e-commerce platform sorting
orders by price in real time.
