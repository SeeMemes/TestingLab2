package functions;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import equations.functions.NaturalLogarithm;
import equations.functions.RandomLogarithm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RandomLogarithmTest {
    private static NaturalLogarithm ln = mock(NaturalLogarithm.class);
    private static RandomLogarithm log5 = null;
    private static RandomLogarithm log10 = null;

    @BeforeAll
    public static void setup() throws CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("ln_table.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(ln.apply(x)).thenReturn(y);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log5 = new RandomLogarithm(5);
        log10 = new RandomLogarithm(10);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"log5_table.csv"})
    public void testLog5noDelta (double x, double expectedY) {
        final double log5Delta = 0.0;
        assertEquals( expectedY, log5.apply( x ), log5Delta );
    }

    @ParameterizedTest
    @CsvFileSource(files = {"log10_table.csv"})
    public void testLog10noDelta (double x, double expectedY) {
        final double log10Delta = 0.0;
        assertEquals( expectedY, log10.apply( x ), log10Delta );
    }

    @ParameterizedTest
    @CsvFileSource(files = {"log5_table.csv"})
    public void testLog5wDelta (double x, double expectedY) {
        final double log5Delta = 0.239;
        assertEquals( expectedY, log5.apply( x ), log5Delta );
    }

    @ParameterizedTest
    @CsvFileSource(files = {"log10_table.csv"})
    public void testLog10wDelta (double x, double expectedY) {
        final double log10Delta = 0.1671;
        assertEquals( expectedY, log10.apply( x ), log10Delta );
    }
}
