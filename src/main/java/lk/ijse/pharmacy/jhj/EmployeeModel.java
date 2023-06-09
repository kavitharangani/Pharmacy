package lk.ijse.pharmacy.jhj;

import lk.ijse.pharmacy.model.EmployeeDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    public static boolean save(EmployeeDTO employee) throws SQLException {
        String sql = "INSERT INTO employee(employeeName,contact,employeeId,employeenic,employeeAdress) VALUES(?,?,?,?,?)";
        return CrudUtil.execute(sql, employee.getEmployeeName(), employee.getContact(), employee.getEmployeeId(), employee.getEmployeenic(), employee.getEmployeeAdress());
    }


    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM employee WHERE employeeId = ?";
        return CrudUtil.execute(sql, id);
    }

    public static EmployeeDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE employeeId = ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            String employeeName = resultSet.getString(1);
            String contact = resultSet.getString(2);
            String employeeId = resultSet.getString(3);
            String employeenic = resultSet.getString(4);
            String employeeAddress = resultSet.getString(5);

            return new EmployeeDTO(employeeName, contact, employeeId, employeenic, employeeAddress);
        }
        return null;
    }

    public static boolean update(EmployeeDTO employee) throws SQLException {
        String sql = "UPDATE employee SET employeeName=?,contact=?,employeenic=?,employeeAdress=? WHERE employeeId=?";
        return CrudUtil.execute(sql, employee.getEmployeeName(), employee.getContact(), employee.getEmployeenic(), employee.getEmployeeAdress(), employee.getEmployeeId());
    }


    public static List<String> generateEmployeeId() throws SQLException {
        String sql = "SELECT employeeId FROM Employee";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

    public static List<String> generateEmployeeAttendance() throws SQLException {
        String sql = "SELECT employeeId FROM Employee";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

}
