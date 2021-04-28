package polymorphishTest;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public void breath() {

    }
}
