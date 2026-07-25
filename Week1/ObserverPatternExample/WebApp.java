public class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("WebApp Notification: " + stockName + " is now $" + price);
    }
}
