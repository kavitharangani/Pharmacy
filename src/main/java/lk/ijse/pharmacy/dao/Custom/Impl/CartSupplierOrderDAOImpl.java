package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.CartSupplierOrderDAO;
import lk.ijse.pharmacy.entity.*;

import java.sql.SQLException;
import java.util.List;

public class CartSupplierOrderDAOImpl implements CartSupplierOrderDAO {


    @Override
    public boolean save(CartSupplierOrder dto) throws SQLException {
        return false;
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

}
