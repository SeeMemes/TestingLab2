package equations.functions;

import java.util.function.Function;

public class Tan extends Sine implements Function<Double, Double> {
    private final Sine sin = new Sine();
    private final Cosine cos = new Cosine();

    @Override
    public Double apply(Double x) {
        x = x % (2 * Math.PI);

        return sin.apply(x) / cos.apply(x);
    }
}
