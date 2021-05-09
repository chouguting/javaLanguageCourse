package ntou.cs.java2021.hw3;

/**
 * NormalWeapon:一般的武器,可取得攻擊力及防禦力
 */
public class NormalWeapon extends Weapon {
    public NormalWeapon(double offense, double defense) {
        super(offense, defense);
    }

    @Override
    public double attack() {
        return this.getOffense();
    }

}
