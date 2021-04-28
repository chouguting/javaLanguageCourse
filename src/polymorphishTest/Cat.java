package polymorphishTest;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("moew");
    }

    public void 前進() {
        System.out.println("GOGO");
    }

    @Override
    public void breath() {

    }
}
