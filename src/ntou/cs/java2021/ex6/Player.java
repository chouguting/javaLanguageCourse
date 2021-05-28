package ntou.cs.java2021.ex6;

public class Player {
    private String firstName;
    private String lastName;
    private long salary;

    public Player() {
        this("", "", 0); // call other constructor
    }

    public Player(String firstName, String lastName, long salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // set first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // set last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // get salary
    public long getSalary() {
        return salary;
    }

    // set salary
    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Account [firstName=" + firstName + ", lastName=" + lastName + ", balance=" + salary + "]";
    }

}