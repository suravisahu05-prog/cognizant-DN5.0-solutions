public class FinancialForecastingTest {
    public static void main(String[] args) {
        // Method 1: Simple recursive compounding
        double presentValue = 10000;
        double growthRate = 0.08; // 8% annual growth
        int years = 5;

        double futureValue = FinancialForecaster.predictFutureValue(presentValue, growthRate, years);
        System.out.printf("Future value after %d years: %.2f%n", years, futureValue);

        // Method 2: Recursive prediction based on historical data
        double[] pastRevenue = {10000, 10500, 11000, 11800, 12500, 13200};
        double forecast = FinancialForecaster.predictFromHistoricalData(pastRevenue, 0, 0, 0);
        System.out.printf("Forecasted next value based on historical growth: %.2f%n", forecast);
    }
}
