package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface SupplierBO extends SuperBO {

    public  boolean save(String orderId, LocalDate now, double total) throws SQLException, ClassNotFoundException ;

    public  String generateNextOrderId() throws SQLException,ClassNotFoundException ;

    public  String splitOrderId(String currentOrderId) ;

    public  int countOrders() throws SQLException, ClassNotFoundException ;

    public  double getTotalOrderSales() throws SQLException, ClassNotFoundException ;

    public  List<String> getIds() throws SQLException, ClassNotFoundException;
}
