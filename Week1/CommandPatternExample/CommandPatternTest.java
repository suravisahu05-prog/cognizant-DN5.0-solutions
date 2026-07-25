public class CommandPatternTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        Command turnOn = new LightOnCommand(livingRoomLight);
        Command turnOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Press button to turn light on
        remote.setCommand(turnOn);
        remote.pressButton();

        // Press button to turn light off
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
