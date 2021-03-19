package ntou.cs.java2021.ex2;

import java.util.Random;

public class Player {
    private long hp;
    private int attackPoints;


    public Player() {
        Random random = new Random();
        this.hp = (long) (random.nextFloat() * 1000000000L) + 9000000000L;
        this.attackPoints = (int) (random.nextFloat() * 100000000) + 100000000;
    }


    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void attack(Player target) {
        target.setHp(target.getHp() - this.attackPoints);
    }
}
