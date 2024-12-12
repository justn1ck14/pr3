import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static double readNumber(Scanner scanner) throws InvalidInputException {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            throw new InvalidInputException("Не являється числом.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a;
        double b;
        double opsresult = 0;
        char nextops;
        boolean isRunning = true;

        while (isRunning) {
            try {
                System.out.println("Перше значення:");
                a = readNumber(scanner);

                System.out.println("Виберіть дію (+, -, *, /, s):");
                char operation = scanner.next().charAt(0);

                System.out.println("Друге значення:");
                b = readNumber(scanner);

                switch (operation) {
                    case '+':
                        opsresult = Calculator.plus(a, b);
                        break;
                    case '-':
                        opsresult = Calculator.minus(a, b);
                        break;
                    case '*':
                        opsresult = Calculator.multiply(a, b);
                        break;
                    case '/':
                        opsresult = Calculator.divide(a, b);
                        break;
                    case 's':
                        opsresult = Calculator.sqrt(a);
                        break;
                    default:
                        System.out.println("Такої операції не інснує");
                        return;
                }

            } catch (ArithmeticException exception) {
                System.out.println("Ділення на нуль не можливо");
                return;
            } catch (InvalidInputException exception) {
                System.out.println("Помилка введення: " + exception.getMessage());
                scanner.next();
            } finally {
                if (opsresult != 0.0) {
                    System.out.println("Відповідь: " + opsresult);
                }
                System.out.println("Чи хочете ви продовжити?(y/n)");
                nextops = scanner.next().charAt(0);
                switch (nextops) {
                    case 'y':
                        continue;
                    case 'n':
                        isRunning = false;
                        break;
                }
            }
        }
    }

}