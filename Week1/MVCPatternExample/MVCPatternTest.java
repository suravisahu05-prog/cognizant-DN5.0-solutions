public class MVCPatternTest {
    public static void main(String[] args) {
        
        Student student = new Student("Suravi Sahu", "S101", "A");

        
        StudentView view = new StudentView();

        
        StudentController controller = new StudentController(student, view);

       
        controller.updateView();

        System.out.println("\nUpdating student grade...\n");

        
        controller.setStudentGrade("A+");

        
        controller.updateView();
    }
}
