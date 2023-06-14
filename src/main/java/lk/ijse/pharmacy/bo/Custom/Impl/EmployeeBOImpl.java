package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.EmployeeBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.EmployeeDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.model.EmployeesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO, SuperBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean save(EmployeesDTO dto) throws SQLException {
        return employeeDAO.save(new Employee(dto.getEmployeeName(),dto.getContact(),dto.getEmployeeId(),dto.getEmployeenic(),dto.getEmployeeAdress()));

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public EmployeesDTO search(String id) throws SQLException{
        Employee employee = employeeDAO.search(id);
        return new EmployeesDTO(employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress());
    }

    @Override
    public boolean update(EmployeesDTO employee) throws SQLException {
        return employeeDAO.update(new Employee(employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress()));
    }

    @Override
    public EmployeesDTO searchEmployee(String id) throws SQLException {
        Employee employee = employeeDAO.search(id);
        return new EmployeesDTO(employee.getEmployeeName(),employee.getContact(),employee.getEmployeeId(),employee.getEmployeenic(),employee.getEmployeeAdress());

    }

    @Override
    public List<String> generateEmployeeId() throws SQLException {
        return employeeDAO.getId();
    }

}
