package equations.functions;

import java.util.function.Function;

public class Tan extends Sine implements Function<Double, Double> {
    private final Sine sine = new Sine();

    private Double normalize(Double x) {
        x = x % (-2 * Math.PI);
        if (x > 0) x -= 2 * Math.PI;
        return x;
    }

    @Override
    public Double apply(Double x) {
        x = normalize(x);
        return sine.apply(x) / (1 - Math.pow(sine.apply(x), 2));
    }
}
