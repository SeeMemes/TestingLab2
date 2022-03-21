package equations.functions;

import java.util.function.Function;

public class Cosine implements Function<Double, Double> {
    private final int N;

    public Cosine(int n) {
        N = n;
    }

    public Cosine() {
        this(10);
    }

    private int fact(int n, int res) {
        if (n == 0) return res;
        else return fact(n - 1, res * n);
    }

    @Override
    public Double apply(Double x) {
        x = x % (2 * Math.PI);

        double result = 0;
        for (int k = 0; k <= N / 2; k++) result += Math.pow(-1, k) * Math.pow(x, 2 * k) / fact(2 * k, 1);
        return result;
    }
}
