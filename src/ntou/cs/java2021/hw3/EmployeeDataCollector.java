package ntou.cs.java2021.hw3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * EmployeeDataCollector: 提供輸入介面 讓用戶輸入資料 及顯示結果
 *
 * @author 00857005 周固廷
 */
public class EmployeeDataCollector {

	private Scanner input = new Scanner(System.in);
	private ArrayList<Employee> list = new ArrayList<Employee>();

	public EmployeeDataCollector() {
		input = new Scanner(System.in);
		list = new ArrayList<Employee>();
	}

	public void collectEmployeeData() {
		out:
		while (true) {
			System.out.printf("---Earnings Calculation System:\n" +
					"1. Salaried Employee\n" +
					"2. Hourly Employee\n" +
					"3. Commission Employee\n" +
					"4. Piece Worker\n" +
					"Please input (1~4, -1 to end): ");
			int choice = input.nextInt();
			switch (choice) {
				case -1:
					System.out.println("Input finished!\n");
					break out;
				case 1:
					inputEmployeeData(new SalariedEmployee());
					break;
				case 2:
					inputEmployeeData(new HourlyEmployee());
					break;
				case 3:
					inputEmployeeData(new CommissionEmployee());
					break;
				case 4:
					inputEmployeeData(new PieceWorker());
					break;
			}
		}
		int counter = 1;
		int totalEarnings = 0;
		int totalBonus = 0;
		System.out.println("---Result:");
		for (Employee employee : list) {
			System.out.printf("No. %d:\n", counter++);
			System.out.println(employee);
			totalEarnings += employee.getEarnings();
			totalBonus += employee.getBonus().getBonus(employee.getEarnings());
		}

		System.out.printf("\nTotal earnings: %,d\n", totalEarnings);
		System.out.printf("Total bonus: %,d\n", totalBonus);
	}

	public void inputEmployeeData(Employee employee) {
		employee.inputData(input);
		setBonus(employee);
		list.add(employee);
	}

	public void setBonus(Employee employee) {
		System.out.print("Please input type of Bonus (1: static, 2: dynamic): ");
		int bonusChoice = input.nextInt();
		if (bonusChoice == 1) {
			employee.setBonus(new StaticBonus());
		} else {
			employee.setBonus(new DynamicBonus());
		}
		System.out.println();
	}


	@Override
	public String toString() {
		return "EmployeeDataCollector{" +
				"input=" + input +
				", list=" + list +
				'}';
	}
}
