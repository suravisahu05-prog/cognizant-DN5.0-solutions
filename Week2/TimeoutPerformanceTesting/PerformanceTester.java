public class PerformanceTester {
    public void performTask() {
        try {
            // Simulating a task that takes some time to complete
            Thread.sleep(500); // 500 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
