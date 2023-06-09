package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.model.AttendanceDTO;

import java.sql.SQLException;

public interface AttendanceBO extends SuperBO {
    public  boolean save(AttendanceDTO attendance) throws SQLException, ClassNotFoundException;
    public AttendanceDTO search(String id) throws SQLException, ClassNotFoundException;

}
