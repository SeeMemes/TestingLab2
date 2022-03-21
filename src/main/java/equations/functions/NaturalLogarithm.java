package equations.functions;


import java.util.function.Function;

public class NaturalLogarithm implements Function<Double, Double> {
    private final int N;

    public NaturalLogarithm(int n) {
        N = n;
    }

    public NaturalLogarithm() {
        this(10);
    }

    @Override
    public Double apply(Double x) {
        double result = 0;
        for (int k = 1; k <= N; k++) result += Math.pow(-1, k + 1) * Math.pow(x - 1, k) / k;
        return result;
    }
}
