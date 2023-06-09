package lk.ijse.pharmacy.dao.Custom.Impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.pharmacy.dao.Custom.OrderDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private Object orderId;
    private Object now;
    private Object customerId;
    private Object total;
    private boolean currentOrderId;

    @Override
    public boolean save(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException {
        String sql ="INSERT INTO orders(orderId,orderDate,custID,total)VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,now,customerId,total);
    }

    @Override
    public MysqlxCrud.Order delete(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MysqlxCrud.Order> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public MysqlxCrud.Order search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public boolean update(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<MysqlxCrud.Order> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MysqlxCrud.Order> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MysqlxCrud.Order> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(MysqlxCrud.Order dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }


    @Override
    public ArrayList<MysqlxCrud.Order> count() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return null;
    }

   @Override
    public List<String> splitOrderId(String dto) {
        return null;
   }
        /*if(null != currentOrderId) {
            String[] strings = currentOrderId.slp("O0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return Collections.singletonList("O0" + id);
        }
        return Collections.singletonList("O001");
    }*/


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
