package ntou.cs.java2021.hw3;

public class PowerWeapon extends Weapon {
    public PowerWeapon(double offense, double defense) {
        super(offense, defense);
    }

    @Override
    public double attack() {
        return this.getOffense() * 1.2;
    }
}
