package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.OrderBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderBOImpl implements OrderBO, SuperBO {
    @Override
    public boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException {
        String sql ="INSERT INTO orders(orderId,orderDate,custID,total)VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,now,customerId,total);
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    @Override
    public String splitOrderId(String currentOrderId) {
        return null;
    }

    @Override
    public int countOrders() throws SQLException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return countOrders();
    }

    @Override
    public double getTotalOrderSales() throws SQLException {
        String sql = "SELECT SUM(total)  FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        double total = 0 ;
        if (resultSet.next()) {
            total =  resultSet.getInt(1);
        }
        return total;
    }

}
