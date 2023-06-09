package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.OrderBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.entity.Supplier;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO, SuperBO {
    @Override
    public boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException {
        String sql ="INSERT INTO orders(orderId,orderDate,custID,total)VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,now,customerId,total);
    }

    @Override
    public String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] strings = currentOrderId.split("O0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O0"+id;
        }
        return "O001";
    }

    @Override
    public ArrayList<Supplier> countOrders() throws SQLException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return countOrders();
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
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
