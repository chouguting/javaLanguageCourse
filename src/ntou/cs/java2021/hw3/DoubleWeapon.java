package ntou.cs.java2021.hw3;

import java.security.SecureRandom;

public class DoubleWeapon extends Weapon {
    private boolean hasDoubled = false;

    public DoubleWeapon(double offense, double defense) {
        super(offense, defense);
    }

    @Override
    public double attack() {
        SecureRandom secureRandom = new SecureRandom();
        if (secureRandom.nextInt(5) == 0) {
            hasDoubled = true;
            return this.getOffense() * 2;
        }
        hasDoubled = false;
        return this.getOffense();
    }

    @Override
    public String getAttackString() {
        if (hasDoubled) {
            return String.format("[%s可造成 %.2f 點的傷害]", this.getClass().getSimpleName(), attack() * 2);
        }
        return super.getAttackString();
    }
}
