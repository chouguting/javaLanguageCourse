package ntou.cs.java2021.ex1;

public class EmployeeTest {
    public static void main(String[] args){
        Employee employee1=new Employee("Bob" ,"Jones", 34500);
        Employee employee2=new Employee("Susan" ,"Baker", 37809);
        System.out.println(employee1.getInfo());
        System.out.println(employee2.getInfo());
        System.out.println("Increasing employee salaries by 10%");
        employee1.setMonthlySalary(employee1.getMonthlySalary()*1.1);
        employee2.setMonthlySalary(employee2.getMonthlySalary()*1.1);
        System.out.println(employee1.getInfo());
        System.out.println(employee2.getInfo());
    }
}
