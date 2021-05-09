package ntou.cs.java2021.hw3;

import java.util.Scanner;

/**
 * Employee:員工的基本功能 可輸入資料、可設定、取得獎金 可得到薪水
 */
public abstract class Employee extends Object {

    private Bonus bonus;

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public abstract void inputData(Scanner input);

    public abstract int getEarnings();

}