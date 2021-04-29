package ntou.cs.java2021.hw3;

import java.util.ArrayList;

public class Player {
	public static final double MAX_HP = 1999;
	public static final int DEFAULT_HP = 200;
	public static final int DEFAULT_ATK = 50;

	private final String name;
	private double hp;
	private ArrayList<ATK> equipment = new ArrayList<ATK>();

	public Player(String name) {
		this(name, DEFAULT_HP);
	}

	public Player(String name, double hp) {
		ArrayList<ATK> list = new ArrayList<ATK>();
		list.add(new NormalWeapon(DEFAULT_ATK, 0));
		this.name = name;
		setHp(hp);
		this.equipment = list;
	}

	public Player(String name, double hp, ArrayList<ATK> equipments) {
		this.name = name;
		setHp(hp);
		this.equipment = equipments;
	}

	public String getName() {
		return name;
	}

	public double getHp() {
		return hp;
	}

	public final void setHp(double hp) {
		if ((0 < hp) && (hp < MAX_HP))
			this.hp = hp;
		else
			this.hp = 0;
	}

	public ArrayList<ATK> getEquipments() {
		return equipment;
	}

	public void setEquipments(ArrayList<ATK> equipments) {
		this.equipment = equipments;
	}

	public double attack() {
		System.out.printf("%s攻擊:\n", this.name);
		double atkSum = 0;
		for (ATK atk : equipment) {
			atkSum += atk.attack();
			System.out.println(atk.getAttackString());
		}
		return atkSum;
	}

	public double defend() {
		System.out.printf("%s防禦:\n", this.name);
		double defSum = 0;
		for (ATK atk : equipment) {
			defSum += atk.defend();
			System.out.println(atk.getDefendString());
		}
		return defSum;
	}

	@Override
	public String toString() {
		return "Player [hp=" + hp + ", equipments=" + equipment + "]";
	}


}
