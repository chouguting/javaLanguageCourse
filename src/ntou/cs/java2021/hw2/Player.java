package ntou.cs.java2021.hw2;

import java.security.SecureRandom;

public class Player {

	public static final long MAX_HP = 10000000000L;
	public static final long MIN_HP = 9000000000L;

	private final String name;
	private long hp;
	private Weapon[] myWeapon = new Weapon[3];
	private int weaponCount;



	public Player(String name) {
		this.name=name;
		SecureRandom secureRandom=new SecureRandom();
		this.hp= (long) (secureRandom.nextFloat()*(MAX_HP-MIN_HP))+MIN_HP;
	}

	public String getName() {
		return this.name;
	}

	public long getHp() {
		return this.hp;
	}

	public void setHp(long newHp) {
		this.hp=newHp;
		if(this.hp<0)this.hp=0;
	}

	public void makeWeapon() {
		if(weaponCount==3){
			System.out.println(this.name+" cannot make weapons now!!");
			return;
		}
		myWeapon[weaponCount]=new Weapon();
		System.out.println(this.name+" made a weapon with offense "+myWeapon[weaponCount].getOffense());
		weaponCount+=1;
	}

	public void cloneWeapon() {
		if(weaponCount==0||weaponCount==3){
			System.out.println(this.name+" cannot clone weapons now!!");
			return;
		}
		myWeapon[weaponCount]=new Weapon(myWeapon[weaponCount-1]);
		System.out.println(this.name+" cloned a weapon with offense "+myWeapon[weaponCount].getOffense());
		myWeapon[weaponCount-1].setOffense((int)(myWeapon[weaponCount-1].getOffense()*0.9));
		System.out.println("Batman's weapon#"+ weaponCount +" becomes: a weapon with offense "+myWeapon[weaponCount-1].getOffense());
		weaponCount+=1;
	}

	public int getAttack() {
		int attackSum=0;
		for(int i=0;i<weaponCount;i++){
			attackSum+=myWeapon[i].getOffense();
		}
		return attackSum;
	}

	public void attack(Player target) {
		target.setHp(target.getHp() - this.getAttack());
	}
}
