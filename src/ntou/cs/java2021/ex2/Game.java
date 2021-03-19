package ntou.cs.java2021.ex2;

public class Game {
    public static void main(String[] args) {
        // Code here
        Player player1 = new Player();
        System.out.printf("Player1 -> HP: %,d, attack: %,d%n", player1.getHp(), player1.getAttackPoints());
        // Code here
        Player player2 = new Player();
        System.out.printf("Player2 -> HP: %,d, attack: %,d%n", player2.getHp(), player2.getAttackPoints());

        while (true) {
            player1.attack(player2);
            System.out.printf("Player1 attacks! Player2's HP becomes %,d%n", player2.getHp());

            // Code here to determine winner and exit while
            if (player2.getHp() <= 0) {
                System.out.println("Player1 wins!");
                break;
            }

            player2.attack(player1);
            System.out.printf("Player2 attacks! Player1's HP becomes %,d%n", player1.getHp());

            // Code here to determine winner and exit while
            if (player1.getHp() <= 0) {
                System.out.println("Player2 wins!");
                break;
            }
        }
    }
}