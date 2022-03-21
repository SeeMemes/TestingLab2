package functions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import equations.functions.Cosine;
import equations.functions.Sine;
import equations.functions.Tan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TanTest {
    private static Tan tan = mock(Tan.class);
    private static Sine sin = new Sine();
    private static Cosine cos = new Cosine();

    @BeforeAll
    public static void setup() throws CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader("tan_table.csv"))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(tan.apply(x)).thenReturn(y);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvFileSource(files = {"cos_table.csv"})
    public void testCosnoDelta (double x, double expectedY) {
        final double cosDelta = 0.0;
        assertEquals( expectedY, cos.apply( x ), cosDelta );
    }

    @ParameterizedTest
    @CsvFileSource(files = {"sin_table.csv"})
    public void testSinnoDelta (double x, double expectedY) {
        final double sinDelta = 0.0;
        assertEquals( expectedY, sin.apply( x ), sinDelta );
    }

    @ParameterizedTest
    @CsvFileSource(files = {"cos_table.csv"})
    public void testCoswDelta (double x, double expectedY) {
        final double cosDelta = 0.4;
        assertEquals( expectedY, cos.apply( x ), cosDelta );
    }

    @ParameterizedTest
    @CsvFileSource(files = {"sin_table.csv"})
    public void testSinwDelta (double x, double expectedY) {
        final double sinDelta = 0.082005;
        assertEquals( expectedY, sin.apply( x ), sinDelta );
    }
}
