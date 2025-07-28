package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class DepartmentInserter extends Thread {
    private List<Employee> employees;

    public DepartmentInserter(List<Employee> employees) {
        this.employees = employees;
    }

    public void run() {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            for (Employee e : employees) {
                stmt.setInt(1, e.id);
                stmt.setString(2, e.name);
                stmt.setString(3, e.department);
                stmt.setDouble(4, e.salary);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
