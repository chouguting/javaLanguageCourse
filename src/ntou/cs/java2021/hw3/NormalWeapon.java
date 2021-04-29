package ntou.cs.java2021.hw3;

public class NormalWeapon extends Weapon {
    public NormalWeapon(double offense, double defense) {
        super(offense, defense);
    }

    @Override
    public double attack() {
        return this.getOffense();
    }

}
