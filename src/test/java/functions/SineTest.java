package functions;

import equations.functions.Sine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SineTest {
    private final Sine sin = new Sine();
    private final double sinDelta = 0.08200494902353769;

    @ParameterizedTest
    @CsvFileSource(files = {"sin_table.csv"})
    public void testTaylorRow(double x, double expectedY) {
        assertEquals(expectedY, sin.apply(x), sinDelta);
    }
}
