package ntou.cs.java2021.hw2;

import java.security.SecureRandom;

/**
 * Weapon帶有一個攻擊值的武器 可以用亂數聲成一個新武器
 *
 * @author 00857005周固廷
 */
public class Weapon {

    public static int MAX_VALUE = 200000000;
    private int offense;

    public Weapon() {
        this(Weapon.generateRandomOffense());
    }

    public Weapon(Weapon weapon) {
        this(weapon.offense);
    }

    public Weapon(int offense) {
        //攻擊力要在合法範圍內
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

    private static int generateRandomOffense() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(100000000) + 100000000;
    }

    @Override
    public String toString() {
        return String.format("a weapon with offense %,d", offense);
    }
}
