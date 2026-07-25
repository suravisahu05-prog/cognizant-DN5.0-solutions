public class TaskManagementTest {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design database schema", "In Progress"));
        taskList.addTask(new Task(2, "Write unit tests", "Pending"));
        taskList.addTask(new Task(3, "Deploy to server", "Pending"));

        System.out.println("\n--- All Tasks ---");
        taskList.traverseTasks();

        System.out.println("\n--- Search Task ID 2 ---");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\n--- Delete Task ID 1 ---");
        taskList.deleteTask(1);

        System.out.println("\n--- All Tasks After Delete ---");
        taskList.traverseTasks();
    }
}
