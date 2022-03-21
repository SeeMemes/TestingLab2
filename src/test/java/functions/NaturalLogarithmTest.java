package functions;

import equations.functions.NaturalLogarithm;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class NaturalLogarithmTest {

    private final NaturalLogarithm lnTest = new NaturalLogarithm( );
    private final double lnDelta = 0.3847;

    @ParameterizedTest
    @CsvFileSource( files={ "ln_table.csv" } )
    public void testMcLorenRow( double x, double expectedY ) {
        assertEquals(expectedY, lnTest.apply(x), lnDelta);
    }
}
