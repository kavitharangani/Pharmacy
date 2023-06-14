package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.OrderDetailDAO;
import lk.ijse.pharmacy.entity.CartPlaceOrder;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl  implements OrderDetailDAO {
    public static boolean save(String orderId, List<CartPlaceOrder> dtoList, double total) throws SQLException {
        for (CartPlaceOrder dto : dtoList){
            if (!save(orderId,dto,total)){
                return false;
            }
        }
        return true;
    }

    private static boolean save(String orderId, CartPlaceOrder dto,double total) throws SQLException {
        String sql = "INSERT INTO supplieorderdetail VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty(),total);
    }
    public static boolean save1(String orderId, List<CartPlaceOrder> dtoList) throws SQLException {
        for (CartPlaceOrder dto : dtoList){
            if (!save1(orderId,dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean save1(String orderId, CartPlaceOrder dto) throws SQLException {
        String sql = "INSERT INTO orderdetail VALUES (?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty());
    }

}
