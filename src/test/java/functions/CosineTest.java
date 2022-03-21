package functions;

import equations.functions.Cosine;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosineTest {
    private final Cosine cos = new Cosine();
    private final double sinDelta = 0.4;;

    @ParameterizedTest
    @CsvFileSource(files = {"cos_table.csv"})
    public void testTaylorRow(double x, double expectedY) {
        assertEquals(expectedY, cos.apply(x), sinDelta);
    }
}
