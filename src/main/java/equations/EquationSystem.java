package equations;

import equations.functions.*;

import java.util.function.Function;

public class EquationSystem implements Function<Double, Double> {
    private final Cosine cos;
    private final Sine sin;
    private final Tan tan;
    private final Secant sec;
    private final NaturalLogarithm ln;
    private final RandomLogarithm log5;
    private final RandomLogarithm log10;

    public EquationSystem(Cosine cos, Sine sin, Tan tan, Secant sec, NaturalLogarithm ln,
                          RandomLogarithm log5, RandomLogarithm log10) {
        this.cos = cos;
        this.sin = sin;
        this.tan = tan;
        this.sec = sec;
        this.ln = ln;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            final double cosX = cos.apply(x);
            final double sinX = sin.apply(x);
            final double tanX = tan.apply(x);
            final double secX = sec.apply(x);
            return ((((cosX + secX) / tanX) - cosX) * (Math.pow(sinX, 2) + cosX))
                    / ((Math.pow(cosX + sinX, 2) / Math.pow(cosX, 2)) * tanX);
        } else {
            final double lnX = ln.apply(x);
            final double log5X = log5.apply(x);
            final double log10X = log10.apply(x);
            return Math.pow(Math.pow(((log5X - lnX) * log10X) - (log10X * log5X), 3), 2);
        }
    }
}
