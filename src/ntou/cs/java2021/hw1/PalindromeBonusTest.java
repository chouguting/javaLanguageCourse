package ntou.cs.java2021.hw1;

import java.util.Scanner;

public class PalindromeBonusTest {
    public static void main(String[] args) {
        PalindromeBonus palindrome = new PalindromeBonus();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a number (-1 to leave): ");
            long input;
            input = scanner.nextLong();
            if (input == -1L) break;

            try {
                palindrome.setValue(input);
            } catch (PalindromeBonus.OutOfRangeException e) {
                System.out.println("the length of the number is not an odd number");
                System.out.println(input + " is not a palindrome.");
                continue;
            } catch (PalindromeBonus.NotPalindromeException e) {
                System.out.println(input + " is not a palindrome");
                continue;
            } catch (PalindromeBonus.NumberTooBigException e) {
                System.out.println("Number is too big");
                continue;
            }
            System.out.println(palindrome + " is a palindrome!!!");
        }
    }
}
