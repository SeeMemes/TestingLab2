package utils.exceptions;

public class LogarithmDegreeException extends ArithmeticException{
    public LogarithmDegreeException(double degree){
        super(degree > 0 ?
                (degree == 1 ? "The degree must not be equal to 1" : "Something went wrong")
                : ("The degree must be greater than 0 and not be equal to 1"));
    }
}
