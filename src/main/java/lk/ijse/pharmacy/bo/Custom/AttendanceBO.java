package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.model.AttendanceDTO;

import java.sql.SQLException;
import java.util.List;

public interface AttendanceBO extends SuperBO {
    public  boolean save(AttendanceDTO attendance) throws SQLException;
    public AttendanceDTO search(String id) throws SQLException, ClassNotFoundException;

    List<String> generateEmployeeAttendance();
}

