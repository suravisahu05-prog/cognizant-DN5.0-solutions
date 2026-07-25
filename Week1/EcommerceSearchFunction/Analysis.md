# E-commerce Search Function - Analysis

## Big O Notation
Big O notation describes how an algorithm's runtime (or memory use) grows as
the input size grows, ignoring constant factors and focusing on the dominant
trend. It lets us compare algorithms independent of hardware speed, by looking
at how operations scale as the number of products increases.

## Best, Average, Worst Case
- **Best case**: the fewest operations needed - e.g., the target is the very
  first element checked.
- **Average case**: the expected number of operations across typical inputs.
- **Worst case**: the maximum operations needed - e.g., the target is at the
  very end, or doesn't exist at all.

## Linear Search vs Binary Search

| Aspect          | Linear Search | Binary Search |
|-----------------|--------------|---------------|
| Requires sorted data | No | Yes |
| Best case | O(1) | O(1) |
| Average case | O(n) | O(log n) |
| Worst case | O(n) | O(log n) |

Linear search checks each product one at a time, so with 1 million products,
a worst-case search could take up to 1 million comparisons. Binary search,
by repeatedly halving the search range, would take at most about 20
comparisons for the same 1 million products (since log2(1,000,000) ≈ 20).

## Which Is More Suitable for This Platform?
Binary search is far more suitable for an e-commerce platform with a large
and frequently searched product catalog, since search speed directly affects
user experience. The one tradeoff is that binary search requires the product
list to be kept sorted by the search key (productId here) - which is a
reasonable cost since product listings are usually updated far less often
than they are searched.
