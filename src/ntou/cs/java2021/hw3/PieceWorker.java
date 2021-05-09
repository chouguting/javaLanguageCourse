package ntou.cs.java2021.hw3;

import java.util.Scanner;

/**
 * PieceWorker:臨時工,用工作量計算工資
 * 可輸入資料及取得薪水
 *
 * @author 00857005 周固廷
 */
public class PieceWorker extends Employee {
    private int wage;
    private int piece;

    @Override
    public void inputData(Scanner input) {
        System.out.print("Please input wage: ");
        wage = input.nextInt();
        System.out.print("Please input piece: ");
        piece = input.nextInt();
    }

    @Override
    public int getEarnings() {
        return wage * piece;
    }

    @Override
    public String toString() {
        String str = String.format("Piece Worker => wage: %,d, piece: %,d, calculated earnings: %,d, bonus: %,d"
                , wage, piece, getEarnings(), this.getBonus().getBonus(getEarnings()));

        return str;
    }
}
