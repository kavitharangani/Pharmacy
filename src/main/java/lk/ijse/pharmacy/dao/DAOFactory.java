package lk.ijse.pharmacy.dao;

import lk.ijse.pharmacy.bo.Custom.Impl.AttendanceBOImpl;
import lk.ijse.pharmacy.dao.Custom.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private  DAOFactory(){

    }
    public static DAOFactory daoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory():daoFactory;
    }

    public static DAOFactory getDaoFactory() {
        return daoFactory;
    }


    public static void setDaoFactory(DAOFactory daoFactory) {
        DAOFactory.daoFactory = daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ATTENDANCE,EMPLOYEE,MEDICINE,SUPPLIER,LOGIN,CARTPLACE_ORDER,ORDER,
   }

    public SuperDAO getDAO (DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case MEDICINE:
                return new MedicineDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case CARTPLACE_ORDER:
                return new CartPlaceOrderDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            default:
                return null;
        }
    }
}

