package ntou.cs.java2021.hw3;

import java.util.Scanner;

/**
 * SalariedEmployee:以工作週數計算薪水的員工
 * 可輸入資料及取得薪水
 *
 * @author 00857005 周固廷
 */
public class SalariedEmployee extends Employee {
    private int weekSalary;
    private int workingWeeks;

    @Override
    public void inputData(Scanner input) {
        System.out.print("Please input weekly salary: ");
        weekSalary = input.nextInt();
        System.out.print("Please input working weeks: ");
        workingWeeks = input.nextInt();
    }

    @Override
    public int getEarnings() {
        return weekSalary * workingWeeks;
    }

    @Override
    public String toString() {
        String str = String.format("Salaried Employee => weekly salary: %,d, working weeks: %,d, calculated earnings: %,d, bonus: %,d"
                , weekSalary, workingWeeks, getEarnings(), this.getBonus().getBonus(getEarnings()));
        return str;
    }
}
