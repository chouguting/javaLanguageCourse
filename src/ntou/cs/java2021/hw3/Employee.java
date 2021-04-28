package ntou.cs.java2021.hw3;

import java.util.Scanner;

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