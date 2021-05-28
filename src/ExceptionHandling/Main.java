package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double quotient(int numerator, int denominator)
            throws ArithmeticException {
        //if (denominator == 0) throw new ArithmeticException();
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int denominator = scanner.nextInt();
            quotient(5, denominator);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("1");
        } catch (InputMismatchException e) {
            System.out.println("1.5");
            return;
        } finally {
            System.out.println("2");
        }
        System.out.println("3");

    }
}
