package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE (ID, NAME, DEPARTMENT) VALUES (?, ?, ?)";
    private static final String UPDATE_EMPLOYEE_SQL = "UPDATE EMPLOYEE SET NAME = ?, DEPARTMENT = ? WHERE ID = ?";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";
    private static final String SELECT_EMPLOYEE_BY_ID_SQL = "SELECT * FROM EMPLOYEE WHERE ID = ?";
    private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM EMPLOYEE";

    public int save(Employee employee) {
        return jdbcTemplate.update(INSERT_EMPLOYEE_SQL, employee.getId(), employee.getName(), employee.getDepartment());
    }

    public void update(Employee employee) {
        String sql = "UPDATE EMPLOYEE SET NAME = ?, DEPARTMENT = ? WHERE ID = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
    }

    public int delete(int id) {
        return jdbcTemplate.update(DELETE_EMPLOYEE_SQL, id);
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_ID_SQL, new EmployeeRowMapper(), id);
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_ALL_EMPLOYEES_SQL, new EmployeeRowMapper());
    }

    class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("ID"));
            employee.setName(rs.getString("NAME"));
            employee.setDepartment(rs.getString("DEPARTMENT"));
            return employee;
        }
    }
}
