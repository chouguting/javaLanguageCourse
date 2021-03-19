package ntou.cs.java2021.ex1;

public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    public String getInfo(){
        String theFullInfo="";
        theFullInfo+=this.getFirstName();
        theFullInfo+=" ";
        theFullInfo+=this.getLastName();
        theFullInfo+="s; Yearly Salary: ";
        theFullInfo+=String.format("%.2f", this.getMonthlySalary());
        return theFullInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
        if(this.monthlySalary<0)this.monthlySalary=0;
    }
}
