package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.CartSupplierOrderDAO;
import lk.ijse.pharmacy.entity.*;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CartSupplierOrderDAOImpl implements CartSupplierOrderDAO {


    private Object orderId;
    private Object now;
    private Object total;


    @Override
    public boolean save(CartSupplierOrder dto) throws SQLException {
        String sql ="INSERT INTO suppliesorder(suppliesOrderID,Date,total)VALUES (?,?,?)";
        return CrudUtil.execute(sql,orderId,now,total);
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public CartSupplierOrder search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(CartSupplierOrder dto) throws SQLException{
        return false;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }


    @Override
    public boolean save(String orderId, LocalDate now, String supplierId, double total) throws SQLException {
        String sql ="INSERT INTO suppliesorder(suppliesOrderID,Date,total)VALUES (?,?,?)";
        return CrudUtil.execute(sql,orderId,now,total);
    }
}
