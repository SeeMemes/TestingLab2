import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import equations.EquationSystem;
import equations.functions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EquationSystemTest {
    private static Cosine cos = mock(Cosine.class);
    private static Secant sec = mock(Secant.class);
    private static Sine sin = mock(Sine.class);
    private static Tan tan = mock(Tan.class);
    private static Cot cot = mock(Cot.class);
    private static NaturalLogarithm ln = mock(NaturalLogarithm.class);
    private static RandomLogarithm log5 = mock(RandomLogarithm.class);
    private static RandomLogarithm log10 = mock(RandomLogarithm.class);
    private static EquationSystem ES = null;

    private static void fillMock(Function<Double, Double> f, String tableName) throws CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(tableName))) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                final double x = Double.parseDouble(record[0]);
                final double y = Double.parseDouble(record[1]);
                when(f.apply(x)).thenReturn(y);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setup() throws CsvException {
        fillMock(cos, "cos_table.csv");
        fillMock(sin, "sin_table.csv");
        fillMock(tan, "tan_table.csv");
        fillMock(cot, "cot_table.csv");
        fillMock(sec, "sec_table.csv");

        fillMock(ln, "ln_table.csv");
        fillMock(log5, "log5_table.csv");
        fillMock(log10, "log10_table.csv");

        ES = new EquationSystem(cos, sin, tan, cot, sec,
                ln, log5, log10);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"fs_non_positive_table.csv"})
    public void testESonNonPositive(double x, double expectedY) {
        final double delta = 0.5;
        assertEquals(expectedY, ES.apply(x), delta);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"fs_positive_table.csv"})
    public void testESonPositive(double x, double expectedY) {
        final double delta = 0.5;
        assertEquals(expectedY, ES.apply(x), delta);
    }
}
