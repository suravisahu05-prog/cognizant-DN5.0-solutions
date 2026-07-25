public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Base notifier - just email
        Notifier basicNotifier = new EmailNotifier();
        basicNotifier.send("Server is down!");

        System.out.println("---");

        // Email + SMS
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Server is down!");

        System.out.println("---");

        // Email + SMS + Slack (stacking decorators)
        Notifier fullNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        fullNotifier.send("Server is down!");
    }
}
