# Task Management System - Analysis

## Types of Linked Lists
- **Singly Linked List**: Each node holds data plus a reference to only the
  *next* node. Traversal is one-directional (head to tail only).
- **Doubly Linked List**: Each node holds references to both the *next* and
  the *previous* node, allowing traversal in both directions and making
  backward deletion easier, at the cost of extra memory per node for the
  additional reference.

## Time Complexity of Operations (Singly Linked List)
| Operation | Time Complexity | Reason |
|-----------|-----------------|--------|
| Add (at tail) | O(n) | Must traverse to the end to find the last node |
| Search | O(n) | Must traverse from head, checking each node |
| Traverse | O(n) | Visits every node exactly once |
| Delete | O(n) | Must traverse to find the node, then relink the previous node's pointer |

Note: if tasks were always added at the *head* instead of the tail, Add would
become O(1) - but that would reverse the natural insertion order, which is
why this implementation adds at the tail instead.

## Advantages of Linked Lists Over Arrays for Dynamic Data
- **No fixed size**: a linked list grows and shrinks dynamically as tasks are
  added or removed, unlike an array which needs a predetermined capacity.
- **Efficient insertion/deletion at the head**: adding or removing the first
  element is O(1) for a linked list, versus O(n) for an array (which must
  shift every remaining element).
- **No wasted memory**: memory is allocated exactly as needed per task, one
  node at a time, rather than reserving a block upfront that might go
  partially unused.

The tradeoff is that linked lists lose the O(1) random access by index that
arrays provide, since reaching any node still requires traversing from the
head - this makes linked lists better suited for scenarios like this task
list, where tasks are frequently added/removed and rarely accessed by
position number.
