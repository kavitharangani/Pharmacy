package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.entity.Medicine;

import java.time.LocalTime;

public class AttendanceDTO  {
    private String employeeId;
    private String attendance;

    public AttendanceDTO(String name, String employeeId, String date, String employeeName) {

    }

    public AttendanceDTO(String id, String date, LocalTime now, String text) {

    }

    public Object getEmployeeId() {
        return null;
    }

    public Object getAttendance() {
        return null;
    }
}