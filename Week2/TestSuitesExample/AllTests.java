import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorAddTest.class,
    CalculatorSubtractTest.class
})
public class AllTests {
    // No code needed here - this class just acts as a runner
    // that groups the two test classes together via annotations above
}
