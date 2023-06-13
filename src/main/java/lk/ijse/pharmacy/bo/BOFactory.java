package lk.ijse.pharmacy.bo;

import lk.ijse.pharmacy.bo.Custom.Impl.*;
import lk.ijse.pharmacy.bo.Custom.LoginBO;

public class BOFactory {
    private static  BOFactory boFactory;
    private BOFactory(){

    }
    public static  BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,EMPLOYEE,SUPPLIER,MEDICINE,ATTENDANCE,CARTPLACE_ORDER,CRATSUPPLIER_ORDER,ORDER,LOGIN,PURCHASEORDERBO
    }

    public SuperBO getBO (BOTypes types){
        switch (types){
            case  CUSTOMER:
                return new CustomerBOImpl();
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case MEDICINE:
                return new MedicineBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case LOGIN:
                return new LogingBOImpl();
            case CARTPLACE_ORDER:
                return  new CartPlaceOrderImpl();
            case PURCHASEORDERBO:;
            return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
