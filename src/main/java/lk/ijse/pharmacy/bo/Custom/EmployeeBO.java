package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.model.EmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    public boolean save(EmployeeDTO employee) throws SQLException, ClassNotFoundException ;

    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException;

    public boolean update(EmployeeDTO employee) throws SQLException, ClassNotFoundException ;

    List<String> generate(String dto) throws SQLException, ClassNotFoundException ;

    public  List<String> generateEmployeeAttendance() throws SQLException ;
}
