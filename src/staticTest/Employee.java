package staticTest;

public class Employee {
    private static int count=0;


    public Employee() {
        Employee.count++;
    }

    public int getCount(){
        return count;
    }
}
