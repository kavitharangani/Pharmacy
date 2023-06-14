package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.AttendanceDAO;
import lk.ijse.pharmacy.entity.Attendance;
import lk.ijse.pharmacy.model.AttendanceDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    private AttendanceDTO attendance;

    @Override
    public boolean save(Attendance dto) throws SQLException{
        return CrudUtil.execute(  "INSERT INTO attendance (employeeId,attendance) VALUES (?,?)",attendance.getEmployeeId(),attendance.getAttendance());

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }


    public Attendance search(String id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM attendance WHERE employeeId = ?",id + "" );
        rst.next();
        return new Attendance(id + "",rst.getString("date"),rst.getString("attendance"));
    }

    @Override
    public boolean update(Attendance dto) throws SQLException {
        return false;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

    @Override
    public boolean saveAttendance(Attendance attendance) throws SQLException {
        return CrudUtil.execute(  "INSERT INTO attendance (employeeId,attendance) VALUES (?,?)",attendance.getEmployeeId(),attendance.getAttendance());

    }
}