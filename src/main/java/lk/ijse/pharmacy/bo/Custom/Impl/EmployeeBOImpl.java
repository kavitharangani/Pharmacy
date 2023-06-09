package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.EmployeeBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.EmployeeDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.model.EmployeeDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO, SuperBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);


    @Override
    public boolean save(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getEmployeeName(),dto.getContact(),dto.getEmployeeId(),dto.getEmployeenic(),dto.getEmployeeAdress()));

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute( "DELETE FROM employee WHERE employeeId = ?",id);
    }

    @Override
    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {
        Employee employee = employeeDAO.search(id);
        return new EmployeeDTO(employee.getEmployeeId(),employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress());
    }

    @Override
    public boolean update(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<String> generate(String dto) throws SQLException, ClassNotFoundException {
        String sql = "SELECT employeeId FROM Employee";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

    @Override
    public List<String> generateEmployeeAttendance() throws SQLException {
        String sql = "SELECT employeeId FROM Employee";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

}
