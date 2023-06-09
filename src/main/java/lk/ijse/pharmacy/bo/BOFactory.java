package lk.ijse.pharmacy.bo;

import lk.ijse.pharmacy.bo.Custom.Impl.AttendanceBOImpl;
import lk.ijse.pharmacy.bo.Custom.Impl.CustomerBOImpl;
import lk.ijse.pharmacy.bo.Custom.Impl.EmployeeBOImpl;

public class BOFactory {
    private static  BOFactory boFactory;
    private BOFactory(){

    }
    public static  BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,EMPLOYEE,SUPPLIER,MEDICINE,ATTENDANCE,CARTPLACE_ORDER,CRATSUPPLIER_ORDER
    }

    public SuperBO getBO (BOTypes types){
        switch (types){
            case  CUSTOMER:
                return new CustomerBOImpl();
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            default:
                return null;
        }
    }
}
