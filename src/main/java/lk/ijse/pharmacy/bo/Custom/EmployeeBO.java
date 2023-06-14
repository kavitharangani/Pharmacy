package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.model.EmployeesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    public boolean save(EmployeesDTO employee) throws SQLException ;

    public  boolean delete(String id) throws SQLException ;

    EmployeesDTO search(String id) throws SQLException;

    boolean update(EmployeesDTO employee) throws SQLException ;

    public EmployeesDTO searchEmployee(String id) throws SQLException;

    List<String> generateEmployeeId() throws SQLException;
}
