package ntou.cs.java2021.hw2;

import java.util.Scanner;

/**
 * PokerGameTest 處理用戶輸入並呼叫對應的遊戲功能
 *
 * @author 00857005周固廷
 */

public class PokerGameTest {
    public static void main(String[] args) {
        PokerGame game = new PokerGame();
        Scanner input = new Scanner(System.in);
        //讓用戶輸入數字操作遊戲
        while (true) {
            System.out.print("Please input your choice (0: quit, 1: play, 2: restart): ");
            int choice = input.nextInt();
            if (choice == 0) break;
            //開始一局遊戲
            if (choice == 1) {
                try {
                    game.dealFiveCards();
                } catch (NullPointerException e) {
                    System.out.println("No card can be dealt, please restart the game!");
                }
            }
            //重啟遊戲
            if (choice == 2) {
                System.out.println("Game restarted");
                game.gameInit();
            }
            //選擇三是測試用的
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
