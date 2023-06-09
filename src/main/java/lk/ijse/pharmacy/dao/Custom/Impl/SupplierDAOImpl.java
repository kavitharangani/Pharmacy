package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.SupplierDAO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.*;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.pharmacy.jhj.OrderModel.countOrders;

public class SupplierDAOImpl implements SupplierDAO {

    private Object orderId;
    private Object now;
    private Object total;
    private boolean currentOrderId;

    @Override
    public boolean save(Supplier dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO suppliesorder(suppliesOrderID,Date,total)VALUES (?,?,?)", orderId, now, total);

    }

    @Override
    public Supplier delete(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Supplier> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Supplier dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Supplier> getIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT suppliesID FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<String> id = new ArrayList<>();

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return getIds();
    }

    @Override
    public ArrayList<Supplier> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Supplier> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(Supplier dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Supplier> count() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return countOrders();
    }

    @Override
    public List<String> splitOrderId(String dto) {
        /*if(currentOrderId != null) {
            String[] strings = currentOrderId.split("K0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "K0"+id;
        }
        return "K001";*/
        return null;
    }

    @Override
    public double getTotalOrderSales() throws SQLException {
        String sql = "SELECT SUM(total)  FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        double total = 0;
        if (resultSet.next()) {
            total = resultSet.getInt(1);
        }
        return getTotalOrderSales();
    }
}

   /* public static String generateNextOrderId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "SELECT suppliesId FROM suppliesorder ORDER BY suppliesId DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }*/



