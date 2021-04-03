package ntou.cs.java2021.hw2;

import java.security.SecureRandom;

/**
 * BattleGame 呼叫對應的遊戲功能 自己跑一場 Batman vs Superman
 *
 * @author 00857005周固廷
 */
public class BattleGame {

    public static void main(String[] args) {
        Player player1 = new Player("Batman");
        determineAllWeapons(player1);
        System.out.printf("%s -> HP: %,d, attack: %,d%n%n", player1.getName(), player1.getHp(), player1.getAttack());

        Player player2 = new Player("Superman");
        determineAllWeapons(player2);
        System.out.printf("%s -> HP: %,d, attack: %,d%n%n", player2.getName(), player2.getHp(), player2.getAttack());

        while (true) {
            player1.attack(player2);
            System.out.printf("%s attacks! %s's HP becomes %,d%n", player1.getName(), player2.getName(), player2.getHp());

            // Code here to determine winner and exit while
            if (player2.getHp() <= 0) {
                System.out.println(player1.getName() + " wins!");
                break;
            }

            player2.attack(player1);
            System.out.printf("%s attacks! %s's HP becomes %,d%n", player2.getName(), player1.getName(), player1.getHp());

            // Code here to determine winner and exit while
            if (player1.getHp() <= 0) {
                System.out.println(player2.getName() + " wins!");
                break;
            }
        }
    }

    // 取四個武器，第一個用製造的，第2~4則是亂數決定是製造或複製，
    // 第4個會無法成功製造或複製(因Player只能配戴3個武器)
    public static void determineAllWeapons(Player player) {
        SecureRandom random = new SecureRandom();
        player.makeWeapon();
        for (int i = 1; i <= 3; i++) {
            if (random.nextBoolean()) {
                player.makeWeapon();
            } else {
                player.cloneWeapon();
            }
        }
    }
}