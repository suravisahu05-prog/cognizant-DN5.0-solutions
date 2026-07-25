public class FinancialForecaster {

    // Recursive method to predict future value based on a fixed growth rate
    // presentValue: current value, growthRate: e.g. 0.05 for 5%, years: how many years ahead to predict
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base case: 0 years ahead means the value is just the present value
        if (years == 0) {
            return presentValue;
        }

        // Recursive case: grow the value by one more year, then recurse for the remaining years
        double nextYearValue = presentValue * (1 + growthRate);
        return predictFutureValue(nextYearValue, growthRate, years - 1);
    }

    // A second recursive method: predicting future value from historical data
    // using an average growth rate calculated recursively
    public static double predictFromHistoricalData(double[] pastValues, int index, double growthSum, int growthCount) {
        // Base case: reached the end of comparisons
        if (index >= pastValues.length - 1) {
            double avgGrowthRate = growthSum / growthCount;
            double lastValue = pastValues[pastValues.length - 1];
            return lastValue * (1 + avgGrowthRate);
        }

        // Calculate growth rate between this pair of consecutive values
        double growth = (pastValues[index + 1] - pastValues[index]) / pastValues[index];

        // Recurse to the next pair, accumulating the growth sum and count
        return predictFromHistoricalData(pastValues, index + 1, growthSum + growth, growthCount + 1);
    }
}
