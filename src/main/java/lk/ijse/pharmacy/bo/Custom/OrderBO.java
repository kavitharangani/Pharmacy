package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderBO {
    public  boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException ;

    public  String generateNextOrderId() throws SQLException ;

    public  String splitOrderId(String currentOrderId) ;

    public int countOrders() throws SQLException ;

    public  double getTotalOrderSales() throws SQLException;
}
