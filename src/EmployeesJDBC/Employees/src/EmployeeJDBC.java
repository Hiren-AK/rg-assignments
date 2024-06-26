import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String JDBC_USER = "hiren";
    private static final String JDBC_PASSWORD = "123456789";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Create
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (id, name, department) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getDepartment());
            pstmt.executeUpdate();
            System.out.println("Employee added: " + employee);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                Employee employee = new Employee(id, name, department);
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // Update
    public void updateEmployee(int id, Employee updatedEmployee) {
        String sql = "UPDATE Employee SET name = ?, department = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, updatedEmployee.getName());
            pstmt.setString(2, updatedEmployee.getDepartment());
            pstmt.setInt(3, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee updated: " + updatedEmployee);
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee with ID " + id + " removed.");
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        // Adding employees
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        Employee emp2 = new Employee(2, "Jane Smith", "Marketing");
        employeeJDBC.addEmployee(emp1);
        employeeJDBC.addEmployee(emp2);

        // Reading all employees
        System.out.println("All employees: " + employeeJDBC.getAllEmployees());

        // Updating an employee
        Employee updatedEmp1 = new Employee(1, "John Doe", "Product Management");
        employeeJDBC.updateEmployee(1, updatedEmp1);

        // Reading all employees after update
        System.out.println("All employees after update: " + employeeJDBC.getAllEmployees());

        // Deleting an employee
        employeeJDBC.deleteEmployee(2);

        // Reading all employees after deletion
        System.out.println("All employees after deletion: " + employeeJDBC.getAllEmployees());
    }
}
