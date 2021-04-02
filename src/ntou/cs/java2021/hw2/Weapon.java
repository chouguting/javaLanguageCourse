package ntou.cs.java2021.hw2;

import java.security.SecureRandom;

public class Weapon {
	
	public static int MAX_VALUE = 200000000;
	private int offense;

	public Weapon() {
		this(Weapon.generateRandomOffense());
	}

	public Weapon (Weapon weapon) {
		this(weapon.offense);
	}

	public Weapon(int offense) {
		if ((0 < offense) && (offense <= MAX_VALUE)) {
			this.offense = offense;
		}
	}

	public int getOffense() {
		return offense;
	}

	public void setOffense(int offense) {
		if ((0 < offense) && (offense <= MAX_VALUE)) {
			this.offense = offense;
		}
	}

	private static int generateRandomOffense(){
		SecureRandom secureRandom=new SecureRandom();
		return secureRandom.nextInt(100000000)+100000000;
	}


	@Override
	public String toString() {
		return String.format("a weapon with offense %,d", offense);
	}
}
