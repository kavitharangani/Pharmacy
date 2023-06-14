package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.Attendance;
import lk.ijse.pharmacy.entity.Customer;

import java.sql.SQLException;

public interface AttendanceDAO extends CrudDAO<Attendance> {
//    static boolean save(Customer customer) {
//        return false;
//    }
    public boolean saveAttendance(Attendance attendance) throws SQLException;
}
