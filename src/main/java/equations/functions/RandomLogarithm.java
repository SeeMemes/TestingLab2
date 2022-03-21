package equations.functions;

import utils.exceptions.LogarithmDegreeException;

import java.util.function.Function;

public class RandomLogarithm extends NaturalLogarithm implements Function<Double, Double> {
    private final NaturalLogarithm naturalLogarithm = new NaturalLogarithm();

    double degree;

    public RandomLogarithm(double degree) {
        if (degree > 0 & degree != 1) this.degree = degree;
        else throw new LogarithmDegreeException(degree);
    }

    @Override
    public Double apply(Double x) {
        return naturalLogarithm.apply(x) / naturalLogarithm.apply(degree);
    }
}
