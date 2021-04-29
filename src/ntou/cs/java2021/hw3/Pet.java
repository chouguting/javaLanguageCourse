package ntou.cs.java2021.hw3;

import java.security.SecureRandom;

public class Pet implements ATK {
	private int maxAttack;
	private double lastAttack;

	public Pet(int maxAttack) {
		if (maxAttack > 0) {
			this.maxAttack = maxAttack;
		}
	}

	@Override
	public double attack() {
		SecureRandom secureRandom = new SecureRandom();
		lastAttack = 1 + secureRandom.nextInt(maxAttack - 1);
		return lastAttack;
	}

	@Override
	public double defend() {
		return 0;
	}


	@Override
	public String getAttackString() {
		return String.format("[%s可造成 %.2f 點的傷害]", this.getClass().getSimpleName(), lastAttack);
	}
}
