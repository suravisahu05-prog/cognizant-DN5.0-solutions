public class AlertService {
    private NotificationSender notificationSender;

    public AlertService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void raiseAlert(String message) {
        notificationSender.sendNotification(message);
    }
}
