package lk.ijse.pharmacy.entity;

public class Attendance {
    private String employeeId;
    private String date;
    private String attendance;

    public Attendance(String employeeId, String date, String attendance) {
        this.employeeId=employeeId;
        this.date=date;
        this.attendance=attendance;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
