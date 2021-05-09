package ntou.cs.java2021.hw3;
/**
 * StaticBonus:不論薪水是多少都會固定的加成獎金
 *
 * @author 00857005 周固廷
 */
public class StaticBonus implements Bonus {
	@Override
	public int getBonus(int salary) {
		return 10000;
	}

}
