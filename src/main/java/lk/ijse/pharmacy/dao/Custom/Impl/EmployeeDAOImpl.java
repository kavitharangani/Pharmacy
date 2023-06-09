package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.EmployeeDAO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.model.EmployeeDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private EmployeeDTO employee;

    @Override
    public boolean save(Employee dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO employee(employeeName,contact,employeeId,employeenic,employeeAdress) VALUES(?,?,?,?,?)", employee.getEmployeeName(), employee.getContact(), employee.getEmployeeId(), employee.getEmployeenic(), employee.getEmployeeAdress());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM employee WHERE employeeId = ?", id);

    }


    @Override
    public ArrayList<Employee> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Employee search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE employeeId = ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            String employeeName = resultSet.getString(1);
            String contact = resultSet.getString(2);
            String employeeId = resultSet.getString(3);
            String employeenic = resultSet.getString(4);
            String employeeAddress = resultSet.getString(5);

            return new Employee(employeeName, contact, employeeId, employeenic, employeeAddress);
        }
        return null;

    }

    @Override
    public boolean update(Employee dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE employee SET employeeName=?,contact=?,employeenic=?,employeeAdress=? WHERE employeeId=?", employee.getEmployeeName(), employee.getContact(), employee.getEmployeenic(), employee.getEmployeeAdress(), employee.getEmployeeId());

    }

    @Override
    public ArrayList<Employee> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Employee> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Employee> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(Employee dto) throws SQLException, ClassNotFoundException {
        String sql = "SELECT employeeId FROM Employee";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

    @Override
    public ArrayList<Employee> count() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> splitOrderId(String dto) {
        return null;
    }

    @Override
    public double getTotalOrderSales() throws SQLException {
        return 0;
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
