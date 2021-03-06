package ntou.cs.java2021.hw1;

import java.util.Scanner;
/*
*  by 00857005 周固廷
* */
public class PalindromeTest {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a number (-1 to leave): ");
            long input;
            input = scanner.nextLong();
            if (input == -1L) break;

            try {
                palindrome.setValue(input);
            } catch (Palindrome.OutOfRangeException e) {
                System.out.println("the length of the number is not an odd number");
                System.out.println(input + " is not a palindrome.");
                continue;
            } catch (Palindrome.NotPalindromeException e) {
                System.out.println(input + " is not a palindrome");
                continue;
            } catch (Palindrome.NumberTooBigException e) {
                System.out.println("Number is too big");
                continue;
            }
            System.out.println(palindrome + " is a palindrome!!!");
        }
    }
}
