package ntou.cs.java2021.hw3;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class War {
	public static final int ATTACK = 1;
	public static final int DEFEND = 2;
	public static final int END = 3;
	private final SecureRandom random = new SecureRandom();
	private Player user;
	private Player npc;

	public War(Player user, Player npc) {
		this.user = user;
		this.npc = npc;
	}

	public void battle() {

		Scanner input = new Scanner(System.in);

		while (true) {

			System.out.print("\n請選擇: 1.攻擊 2.防禦 3.結束: ");
			int action = -1;

			try {
				action = input.nextInt();
			} catch (InputMismatchException e) {
				input.nextLine();
			}

			System.out.println();

			if (action == ATTACK) {

				attack(user, npc, 1);
				if (determineVictory(user, npc)) {
					input.close();
					return;
				}
				System.out.println();
				attack(npc, user, 1);
				if (determineVictory(user, npc)) {
					input.close();
					return;
				}
			} else if (action == DEFEND) {
				attack(npc, user, 2);
				if (random.nextInt(3) == 1) {
					System.out.println();
					selfHeal(user);
				}
				if (determineVictory(user, npc)) {
					input.close();
					return;
				}
			} else if (action == END) {
				System.out.println("遊戲結束!");
				input.close();
				return;
			} else {
				System.out.println("您輸入無效指令");
				continue;
			}
		}
	}

	public void attack(Player player1, Player player2, double defenseRate) {

		if (player1 == npc) {
			System.out.println("NPC攻擊前：\n" +
                    "HP of USER: " + String.format("%.1f", user.getHp()));

		} else {
            System.out.println("USER攻擊前：\n" +
                    "HP of NPC: " + String.format("%.1f", npc.getHp()));
		}

		double player1Attack = (player1.attack() - player2.defend() * defenseRate);
		if (player1Attack < 0) player1Attack = 0;
		if (defenseRate == 2) {
			System.out.println("防禦力變為2.0倍");
		}
		player2.setHp(player2.getHp() - player1Attack);

		if (player1 == npc) {
            System.out.println("NPC攻擊後：\n" +
                    "HP of USER: " + String.format("%.1f", user.getHp()));

		} else {
            System.out.println("USER攻擊後：\n" +
                    "HP of NPC: " + String.format("%.1f", npc.getHp()));
		}
	}

	public void selfHeal(Player player) {
		player.setHp(player.getHp() + (random.nextInt(141) + 10));
		System.out.println("USER自我療癒了!\n" +
				"自我療癒後：HP of USER: " + player.getHp());
	}

	public boolean determineVictory(Player user, Player npc) {
		if (user.getHp() <= 0) {
			System.out.println("玩家被NPC擊倒了！");
			return true;
		}
		if (npc.getHp() <= 0) {
			System.out.println("玩家擊倒了NPC！");
			return true;
		}
		return false;
	}
}
