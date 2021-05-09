package ntou.cs.java2021.hw3;

import java.util.Scanner;

/**
 * HourlyEmployee:以小時和時薪計算薪水的員工
 * 可輸入資料及取得薪水
 */
public class HourlyEmployee extends Employee {
    private int wage;
    private int hours;

    @Override
    public void inputData(Scanner input) {
        System.out.print("Please input wage: ");
        wage = input.nextInt();
        System.out.print("Please input hours: ");
        hours = input.nextInt();
    }

    @Override
    public int getEarnings() {
        int totalSalary = 0;
        if (hours <= 40) {
            totalSalary += wage * hours;
        } else {
            totalSalary += wage * 40 + (int) (1.5 * wage * (hours - 40));
        }
        return totalSalary;
    }

    @Override
    public String toString() {
        String str = String.format("Hourly Employee => hourly salary: %,d, hours: %,d, calculated earnings: %,d, bonus: %,d"
                , wage, hours, getEarnings(), this.getBonus().getBonus(getEarnings()));

        return str;
    }
}
