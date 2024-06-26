import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD1 {
    private List<Employee> employees;

    public EmployeeCRUD1() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void updateEmployee(int id, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                employees.set(i, updatedEmployee);
                System.out.println("Employee updated: " + updatedEmployee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
        System.out.println("Employee with ID " + id + " removed.");
    }

    public static void main(String[] args) {
        EmployeeCRUD1 employeeCRUD = new EmployeeCRUD1();

        // Create
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        Employee emp2 = new Employee(2, "Jane Smith", "Marketing");
        employeeCRUD.addEmployee(emp1);
        employeeCRUD.addEmployee(emp2);

        // Read
        System.out.println("All employees: " + employeeCRUD.getAllEmployees());

        // Update
        Employee updatedEmp1 = new Employee(1, "John Doe", "Product Management");
        employeeCRUD.updateEmployee(1, updatedEmp1);

        System.out.println("All employees after update: " + employeeCRUD.getAllEmployees());

        // Delete
        employeeCRUD.deleteEmployee(2);

        System.out.println("All employees after deletion: " + employeeCRUD.getAllEmployees());
    }
}
