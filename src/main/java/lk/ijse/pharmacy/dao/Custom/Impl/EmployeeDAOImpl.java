package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.EmployeeDAO;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {


    @Override
    public boolean save(Employee dto) throws SQLException {
        return CrudUtil.execute("INSERT INTO employee(employeeName,contact,employeeId,employeenic,employeeAdress) VALUES(?,?,?,?,?)", dto.getEmployeeName(), dto.getContact(), dto.getEmployeeId(), dto.getEmployeenic(), dto.getEmployeeAdress());

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.execute("DELETE FROM employee WHERE employeeId = ?", id);

    }

    @Override
    public Employee search(String id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE employeeId = ?";
        ResultSet resultSet = CrudUtil.execute(sql,id);

        if (resultSet.next()){
            return new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return null;

    }


    @Override
    public boolean update(Employee dto) throws SQLException {
        return CrudUtil.execute("UPDATE employee SET employeeName=?,contact=?,employeenic=?,employeeAdress=? WHERE employeeId=?", dto.getEmployeeName(), dto.getContact(), dto.getEmployeenic(), dto.getEmployeeAdress(), dto.getEmployeeId());

    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

    @Override
    public List<String> getId() throws SQLException {
        String sql = "SELECT employeeId FROM Employee";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }
}
