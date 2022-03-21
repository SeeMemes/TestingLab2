package equations.functions;

import java.util.function.Function;

public class Secant extends Cosine implements Function<Double, Double> {
    private final Cosine cosine = new Cosine();

    private Double normalize( Double x ) {
        x = x % ( -2 * Math.PI );
        if ( x > 0 ) x -= 2 * Math.PI;
        return x;
    }

    @Override
    public Double apply(Double x) {
        x = normalize(x);
        return 1 / cosine.apply(x);
    }
}
