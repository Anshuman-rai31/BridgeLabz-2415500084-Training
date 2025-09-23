class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    private String teamSize;

    public Manager(int employeeID, String department, double salary, String teamSize) {
        this.employeeID = employeeID;
        this.department = department;
        this.setSalary(salary);
        this.teamSize = teamSize;
    }

    public void displayManagerDetails() {
        displayEmployeeDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Manager manager = new Manager(1001, "IT", 120000.0, "10 members");
        manager.displayManagerDetails();
    }
}
