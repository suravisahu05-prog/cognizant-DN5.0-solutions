# Financial Forecasting - Analysis

## Concept of Recursion
Recursion is a technique where a method calls itself to solve a smaller
version of the same problem, until it reaches a "base case" simple enough to
answer directly. Each recursive call breaks the problem down further, and the
base case stops the chain from continuing infinitely.

## How Recursion Simplifies This Problem
Predicting a value multiple years into the future naturally breaks down into
a repeated single-year calculation: "grow this year's value, then repeat for
the remaining years." Recursion expresses this directly - each call handles
just one year of growth and then delegates the rest to another call with one
fewer year remaining, avoiding the need for a separate explicit loop
structure while mirroring the natural repetitive structure of the problem.

## Time Complexity
`predictFutureValue` makes exactly one recursive call per year, so for `n`
years, there are `n` recursive calls - giving a time complexity of O(n).
Similarly, `predictFromHistoricalData` makes one call per pair of historical
values, so for `n` data points, it also runs in O(n) time.

## Optimizing to Avoid Excessive Computation
- **Tail recursion**: Both methods here are written so the recursive call is
  the very last operation (a "tail call"), which some compilers/JVMs can
  optimize to reuse the same stack frame instead of growing the call stack -
  though standard Java does not guarantee this optimization automatically.
- **Memoization**: If the same forecasts (same value, rate, and year count)
  are requested repeatedly, storing previously computed results in a cache
  (e.g., a HashMap) avoids recomputing them from scratch.
- **Convert to iteration**: For very large numbers of years, converting the
  recursive approach into a simple loop avoids any risk of a
  StackOverflowError from too many nested calls, while keeping the same O(n)
  time complexity but O(1) space instead of O(n) stack space.
