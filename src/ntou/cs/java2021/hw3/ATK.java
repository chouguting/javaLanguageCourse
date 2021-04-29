package ntou.cs.java2021.hw3;

public interface ATK {
	double attack();

	double defend();

	default String getDefendString() {
		return String.format("[%s可抵擋 %.2f 點的傷害]", this.getClass().getSimpleName(), defend());
	}

	default String getAttackString() {
		return String.format("[%s可造成 %.2f 點的傷害]", this.getClass().getSimpleName(), attack());
	}
}
