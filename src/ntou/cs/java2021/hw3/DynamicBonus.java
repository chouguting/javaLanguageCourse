package ntou.cs.java2021.hw3;

/**
 * DynamicBonus:會根據薪水改變的加成獎金
 *
 * @author 00857005 周固廷
 */
public class DynamicBonus implements Bonus {
	@Override
	public int getBonus(int salary) {
		return (int) (salary * 0.1);
	}

}
