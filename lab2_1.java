class Employee {
    private String name;
    private int employeeId;
    private String role;
    private double basicSalary;
    private double bonus;

    public Employee(String name, int employeeId, String role, double basicSalary, double bonus) {
        this.name = name;
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public Employee(String name, int employeeId, String role, double bonus) {
        this.name = name;
        this.employeeId = employeeId;
        this.role = role;
        this.basicSalary = 5000.0;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getRole() {
        return role;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public double calculateTotalSalary() {
        return basicSalary + bonus;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Role: " + role);
        System.out.println("Total Salary: " + calculateTotalSalary());
    }
}

class HR {
    private Employee[] employees;
    private int employeeCount;

    public HR(int capacity) {
        employees = new Employee[capacity];
        employeeCount = 0;
    }

    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = employee;
            logAction("Employee " + employee.getName() + " added.");
        } else {
            System.out.println("Employee system is full. Cannot add more employees.");
        }
    }

    public void updateBonus(int employeeId, double bonus) {
        Employee employee = findEmployee(employeeId);
        if (employee != null) {
            employee.bonus = bonus;
            logAction("Bonus updated for employee ID " + employeeId + ".");
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    public void displayAllEmployees() {
        System.out.println("\n--- All Employees ---");
        if (employeeCount == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayDetails();
            System.out.println("----------------------");
        }
    }

    protected boolean isEmployeeExists(int employeeId) {
        return findEmployee(employeeId) != null;
    }

    Employee findEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    void logAction(String action) {
        System.out.println("Log: " + action);
    }
}

class Company {
    public static String getWelcomeMessage(String companyName) {
        return "Welcome to " + companyName + "!";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Company.getWelcomeMessage("Tech Solutions Inc."));

        HR hrDepartment = new HR(5);

        Employee employee1 = new Employee("Alice Smith", 101, "Software Engineer", 60000.0, 5000.0);
        Employee employee2 = new Employee("Bob Johnson", 102, "Data Analyst", 55000.0, 3000.0);
        Employee employee3 = new Employee("Charlie Brown", 103, "Project Manager", 70000.0, 8000.0);
        Employee employee4 = new Employee("Diana Lee", 104, "HR Manager", 65000.0, 6000.0);
        Employee employee5 = new Employee("Eve Williams", 105, "Marketing Specialist", 50000.0, 4000.0);
        Employee employee6 = new Employee("Frank Miller", 106, "Sales Representative", 45000.0, 2000.0);

        hrDepartment.addEmployee(employee1);
        hrDepartment.addEmployee(employee2);
        hrDepartment.addEmployee(employee3);
        hrDepartment.addEmployee(employee4);
        hrDepartment.addEmployee(employee5);
        hrDepartment.addEmployee(employee6);

        hrDepartment.displayAllEmployees();

        hrDepartment.updateBonus(102, 4000.0);
        System.out.println("\n--- Employees after bonus update ---");
        hrDepartment.displayAllEmployees();
    }
}
