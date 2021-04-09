package inheritanceTest;

public class Student extends Human{
    int studentID;

    public Student(String name, int age, double weight, int studentID) {
        super(name, age, weight);
        this.studentID = studentID;
    }

    public void show(){
        this.setWeight(22);

    }
}
