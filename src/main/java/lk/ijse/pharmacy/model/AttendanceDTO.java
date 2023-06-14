package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.entity.Medicine;

import java.time.LocalTime;

public class AttendanceDTO  {
    private String employeeId;
    private String date;
    private String attendance;

    public AttendanceDTO(String id, String date ,String text) {
        this.employeeId=id;
        this.date=date;
        this.attendance=text;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}