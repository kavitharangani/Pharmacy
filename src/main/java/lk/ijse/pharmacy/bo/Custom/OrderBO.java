package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.entity.Supplier;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface OrderBO extends SuperBO {
    public  boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException ;

    public  String splitOrderId(String currentOrderId) ;

    public ArrayList<Supplier> countOrders() throws SQLException ;

    String generateNextOrderId()throws SQLException;

    double getTotalOrderSales() throws SQLException;
}
