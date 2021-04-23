package polymorphishTest;

public class AnimalTest {
    public static void main(String[] args){
        Animal animal=new Cat();
        animal.makeSound();
        Object aa=6;
        Object bb=animal;

        System.out.println(aa);
    }
}
