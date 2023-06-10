package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.SupplierBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.SupplierDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Supplier;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.pharmacy.jhj.OrderModel.countOrders;

public class SupplierBOImpl implements SupplierBO, SuperBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean save(String orderId, LocalDate now, double total) throws SQLException, ClassNotFoundException {
       //return supplierDAO.save(new Supplier(String orderId, LocalDate now, double tota));
        return SQLUtil.execute("INSERT INTO suppliesorder(suppliesOrderID,Date,total)VALUES (?,?,?)", orderId, now, total);

    }

    @Override
    public String generateNextOrderId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String splitOrderId(String currentOrderId) {
        return null;
    }

    @Override
    public int countOrders() throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return countOrders();
    }

    @Override
    public double getTotalOrderSales() throws SQLException, ClassNotFoundException {
        String sql = "SELECT SUM(total)  FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        double total = 0;
        if (resultSet.next()) {
            total = resultSet.getInt(1);
        }
        return getTotalOrderSales();
    
    }

    @Override
    public List<String> getIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT suppliesID FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<String> id = new ArrayList<>();

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return getIds();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
