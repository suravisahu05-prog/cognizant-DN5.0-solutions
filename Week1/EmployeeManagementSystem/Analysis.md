# Employee Management System - Analysis

## Array Representation in Memory
An array stores its elements in one contiguous block of memory, with each
element placed right after the previous one. Because of this, the position
of any element can be calculated directly from its index using a simple
formula (base address + index * element size), which is why accessing an
element by index is instant (O(1)) - the system doesn't need to search, it
jumps straight to the memory location.

**Advantages:**
- Fast, constant-time access by index
- Simple and memory-efficient (no extra pointers/references needed per
  element, unlike linked lists)
- Good cache performance since elements sit next to each other in memory

## Time Complexity of Operations (Array-based)
| Operation | Time Complexity | Reason |
|-----------|-----------------|--------|
| Add | O(1) | Places new element at the next free index |
| Search | O(n) | Must check elements one by one until found |
| Traverse | O(n) | Visits every element exactly once |
| Delete | O(n) | Must find the element, then shift all following elements left to close the gap |

## Limitations of Arrays
- **Fixed size**: the array's capacity must be decided upfront; once full, it
  cannot grow (as reflected in this implementation printing "Array is full").
- **Costly insertion/deletion in the middle**: since elements must be shifted
  to keep the array contiguous, both operations are O(n) instead of O(1).
- **Wasted space**: if the array is created larger than needed, unused slots
  still occupy memory.

## When to Use Arrays
Arrays are best suited when the number of records is known in advance or
changes rarely, and when fast index-based access is the primary requirement
(e.g., reading employee records by a fixed slot number). For an employee
management system where hiring/firing happens frequently and the total count
is unpredictable, a dynamic structure like `ArrayList` or `LinkedList` would
generally be more practical, since it can grow or shrink without a fixed
upfront capacity.
