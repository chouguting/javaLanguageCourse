package ntou.cs.java2021.hw3;

import java.util.Scanner;

public class CommissionEmployee extends Employee {
    private double commisionRate;
    private int grossSales;

    @Override
    public void inputData(Scanner input) {
        System.out.print("Please input commission rate: ");
        commisionRate = input.nextDouble();
        System.out.print("Please input gross sales: ");
        grossSales = input.nextInt();
    }

    @Override
    public int getEarnings() {
        return (int) (commisionRate * grossSales);
    }

    @Override
    public String toString() {
        String str = String.format("Commission Employee => commission rate: %.2f, gross sales: %,d, calculated earnings: %,d, bonus: %,d"
                , commisionRate, grossSales, getEarnings(), this.getBonus().getBonus(this.getEarnings()));
        return str;
    }
}
