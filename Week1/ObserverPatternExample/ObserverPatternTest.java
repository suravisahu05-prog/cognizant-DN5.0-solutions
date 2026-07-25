public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        System.out.println("Price update 1:");
        stockMarket.setStockPrice("AAPL", 195.50);

        System.out.println("\nDeregistering WebApp...");
        stockMarket.deregister(webApp);

        System.out.println("\nPrice update 2:");
        stockMarket.setStockPrice("AAPL", 198.75);
    }
}
