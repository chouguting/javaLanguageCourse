package inheritanceTest;

/**
 *
 *
 */

public class Human extends Object{
    protected String name;
    protected int age;
    private double weight;

    public Human() {
    }

    public Human(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
