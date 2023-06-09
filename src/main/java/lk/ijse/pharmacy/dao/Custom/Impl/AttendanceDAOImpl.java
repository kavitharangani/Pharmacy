package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.AttendanceDAO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Attendance;
import lk.ijse.pharmacy.model.AttendanceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    private AttendanceDTO attendance;

    @Override
    public boolean save(Attendance dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(  "INSERT INTO attendance (employeeId,attendance) VALUES (?,?)",attendance.getEmployeeId(),attendance.getAttendance());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }


    @Override
    public ArrayList<Attendance> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }


    public Attendance search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM attendance WHERE employeeId = ?",id + "" );
        rst.next();
        return new Attendance(id + "",rst.getString("date"),rst.getString("attendance"));
    }

    @Override
    public boolean update(Attendance dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Attendance> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Attendance> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Attendance> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(Attendance dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Attendance> count() throws SQLException, ClassNotFoundException {
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

}