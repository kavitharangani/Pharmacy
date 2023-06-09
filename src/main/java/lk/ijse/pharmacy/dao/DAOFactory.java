package lk.ijse.pharmacy.dao;

import lk.ijse.pharmacy.bo.Custom.Impl.AttendanceBOImpl;
import lk.ijse.pharmacy.dao.Custom.Impl.AttendanceDAOImpl;
import lk.ijse.pharmacy.dao.Custom.Impl.CustomerDAOImpl;
import lk.ijse.pharmacy.dao.Custom.Impl.EmployeeDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private  DAOFactory(){

    }
    public static DAOFactory daoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory():daoFactory;
    }

   public enum DAOTypes{
        CUSTOMER,ATTENDANCE,EMPLOYEE
   }

    public SuperDAO getDAO (DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            default:
                return null;
        }
    }
}

