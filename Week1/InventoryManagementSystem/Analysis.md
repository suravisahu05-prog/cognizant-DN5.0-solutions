# Inventory Management System - Analysis

## Why Data Structures & Algorithms Matter Here
A warehouse inventory can hold thousands of products, and operations like adding
new stock, updating quantities, or removing sold-out items happen constantly.
Without an efficient data structure, every such operation could require scanning
the entire inventory, which becomes very slow as the inventory grows. Choosing
the right data structure keeps these operations fast even at scale.

## Data Structure Comparison
- **ArrayList**: Simple to use, but searching for a product by ID takes O(n)
  time since it may need to scan every element.
- **HashMap**: Chosen for this implementation. Storing products keyed by
  productId gives O(1) average time complexity for add, update, and delete,
  since HashMap directly computes the storage location from the key's hash
  code instead of scanning.

## Time Complexity of Chosen Operations (HashMap-based)
- **Add**: O(1) average — direct insertion using productId as key
- **Update**: O(1) average — direct lookup by key, then modify fields
- **Delete**: O(1) average — direct removal using productId as key
- (Worst case for all three is O(n) if many keys collide into the same hash
  bucket, though this is rare with a good hash function like Integer's default)

## Optimization Ideas
- If frequent range queries (e.g., "all products under ₹500") are needed, a
  **TreeMap** (sorted by price or productId) could help, giving O(log n)
  range search instead of scanning the whole HashMap.
- For read-heavy systems with multiple threads, a **ConcurrentHashMap** would
  avoid race conditions without needing to lock the entire structure.
- Caching frequently accessed products separately could reduce repeated
  lookups for popular items.
