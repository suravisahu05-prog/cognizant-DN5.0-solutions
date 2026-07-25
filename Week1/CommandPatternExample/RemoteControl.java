public class RemoteControl {
    private Command command;

    // Set which command this remote should trigger
    public void setCommand(Command command) {
        this.command = command;
    }

    // Executes whichever command is currently set
    public void pressButton() {
        if (command == null) {
            System.out.println("No command set!");
            return;
        }
        command.execute();
    }
}
