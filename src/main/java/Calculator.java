public abstract class Calculator {
    public static double plus(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("Ділення на 0 не можливо");
        }
        return a / b;
    }
    public static double sqrt(double a) throws InvalidInputException {
        if (a <= 0){
            throw new InvalidInputException("Помилка");
        }
        return Math.sqrt(a);
    }
}
