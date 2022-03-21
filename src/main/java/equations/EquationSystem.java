package equations;

import equations.functions.*;

import java.util.Scanner;
import java.util.function.Function;

public class EquationSystem implements Function<Double, Double> {
    private final Cosine cos;
    private final Sine sin;
    private final Tan tan;
    private final Cot cot;
    private final Secant sec;
    private final NaturalLogarithm ln;
    private final RandomLogarithm log5;
    private final RandomLogarithm log10;

    public EquationSystem(Cosine cos, Sine sin, Tan tan, Cot cot, Secant sec, NaturalLogarithm ln,
                          RandomLogarithm log5, RandomLogarithm log10) {
        this.cos = cos;
        this.sin = sin;
        this.tan = tan;
        this.cot = cot;
        this.sec = sec;
        this.ln = ln;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            double cosX = cos.apply(x);
            double sinX = sin.apply(x);
            double tanX = tan.apply(x);
            double cotX = cot.apply(x);
            double secX = sec.apply(x);
            return ((((cosX + secX) / tanX) - cosX) * (Math.pow(sinX, 2) + cosX))
                    / ((Math.pow(cotX + sinX, 2) / Math.pow(cosX, 2)) * tanX);
        } else {
            double lnX = ln.apply(x);
            double log5X = log5.apply(x);
            double log10X = log10.apply(x);
            return Math.pow(Math.pow(((log5X - lnX) * log10X) - (log10X * log5X), 3), 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EquationSystem equationSystem = new EquationSystem(new Cosine(), new Sine(), new Tan(), new Cot(), new Secant(),
                new NaturalLogarithm(), new RandomLogarithm(5), new RandomLogarithm(10));
        System.out.println(equationSystem.apply(scanner.nextDouble()));
    }
}
