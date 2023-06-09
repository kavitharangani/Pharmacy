package lk.ijse.pharmacy.model;

import java.time.LocalTime;

public class AttendanceTm {
    private String id;
    private String date;
    private LocalTime time;
    private String attendance;

    public AttendanceTm(String id,String date,LocalTime time,String attendance){
        this.id = id;
        this.date = date;
        this.time = time;
        this.attendance = attendance;
    }

}
