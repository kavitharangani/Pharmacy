package lk.ijse.pharmacy.model;

import java.time.LocalTime;

public class AttendanceTm {
    private String id;
    private String date;
    private String time;
    private String attendance;

    public AttendanceTm(String id,String date,String time,String attendance){
        this.id = id;
        this.date = date;
        this.time = time;
        this.attendance = attendance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
