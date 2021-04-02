package ntou.cs.java2021.hw2;


import java.util.Scanner;

public class PokerGameTest {
	public static void main(String[] args) {
		PokerGame game = new PokerGame();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("Please input your choice (0: quit, 1: play, 2: restart): ");
			int choice = input.nextInt();
			if (choice == 0) break;

			if (choice == 1) {
				try {
					game.dealFiveCards();
				} catch (NullPointerException e) {
					System.out.println("No card can be dealt, please restart the game!");
				}
			}

			if (choice == 2) {
				System.out.println("Game restarted");
				game.gameInit();
			}
			if (choice == 3) {
				try {
					game.dealTest();
				} catch (NullPointerException e) {
					System.out.println("No card can be dealt, please restart the game!");
				}
			}

			System.out.println("\n");
		}

		System.out.println("Game over!!");
	}
} // end class PokerGame
