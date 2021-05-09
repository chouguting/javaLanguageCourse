package ntou.cs.java2021.hw3;

/**
 * ATK: 所有可攻擊物件的INTERFACE
 * 要求提供計算攻擊和防守的功能
 * 另外提供攻擊和防守的輸出字串
 *
 * @author 00857005 周固廷
 */
public interface ATK {
	double attack();

	double defend();

	default String getDefendString() {
		return String.format("[%s可抵擋 %.0f 點的傷害]", this.getClass().getSimpleName(), defend());
	}

	default String getAttackString() {
		return String.format("[%s可造成 %.0f 點的傷害]", this.getClass().getSimpleName(), attack());
	}
}
