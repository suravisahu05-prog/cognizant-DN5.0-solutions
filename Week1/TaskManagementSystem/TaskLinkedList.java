public class TaskLinkedList {
    private TaskNode head;

    // Add - O(1) if adding at head, O(n) if adding at tail
    // Here we add at the tail to preserve insertion order, so it's O(n)
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);

        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added: " + task);
    }

    // Search - O(n), must traverse from head until found
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse - O(n), visits every node once
    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete - O(n), must find the node and relink the previous node to skip it
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Special case: deleting the head node
        if (head.task.getTaskId() == taskId) {
            System.out.println("Deleted: " + head.task);
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task ID " + taskId + " not found");
        } else {
            System.out.println("Deleted: " + current.next.task);
            current.next = current.next.next; // skip the node to remove it
        }
    }
}
