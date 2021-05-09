package ntou.cs.java2021.hw3;

/**
 * DoubleWeapon:攻擊力*1.2的武器,可取得攻擊力及防禦力
 *
 * @author 00857005 周固廷
 */
public class PowerWeapon extends Weapon {
    public PowerWeapon(double offense, double defense) {
        super(offense, defense);
    }

    @Override
    public double attack() {
        return Math.round(this.getOffense() * 1.2);
    }
}
