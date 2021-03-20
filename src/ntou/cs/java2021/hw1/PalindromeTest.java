package ntou.cs.java2021.hw1;

import java.util.Scanner;

public class PalindromeTest {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a 5-digit number (-1 to leave): ");
            int input;
            input = scanner.nextInt();
            if (input == -1) break;

            try {
                palindrome.setValue(input);
            } catch (Palindrome.NotFiveDigitException e) {
                System.out.println("Number must be 5 digits");
                System.out.println(input + " is not a palindrome.");
                continue;
            } catch (Palindrome.NotPalindromeException e) {
                System.out.println(input + " is not a palindrome");
                continue;
            }
            System.out.println(palindrome + " is a palindrome!!!");
        }
    }
}
