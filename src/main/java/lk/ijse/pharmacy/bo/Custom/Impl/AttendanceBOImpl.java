package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.AttendanceBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.dao.Custom.AttendanceDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.entity.Attendance;
import lk.ijse.pharmacy.model.AttendanceDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceBOImpl  implements AttendanceBO, SuperBO {
    AttendanceDAO attendanceDAO = (AttendanceDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.ATTENDANCE);

    private AttendanceDTO attendance;
    private AttendanceDTO dto;


    @Override
    public boolean save(AttendanceDTO attendance) throws SQLException, ClassNotFoundException {
        return attendanceDAO.save(new Attendance(dto.getEmployeeId(),dto.getAttendance()));
    }

    public AttendanceDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM attendance WHERE employeeId = ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            String employeeName=resultSet.getString(1);
            String employeeId=resultSet.getString(2);
            String date= String.valueOf(resultSet.getDate(3));
            String attendance=resultSet.getString(4);


            return new AttendanceDTO(employeeName,employeeId,date,attendance);
        }
        return null;
    }

}
