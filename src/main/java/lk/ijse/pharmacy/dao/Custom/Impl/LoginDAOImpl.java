package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.LoginDAO;
import lk.ijse.pharmacy.dao.SuperDAO;
import lk.ijse.pharmacy.entity.Login;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean save(Login dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Login> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Login search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Login dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Login> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Login> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Login> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(Login dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Login> count() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> splitOrderId(String dto) {
        return null;
    }

    @Override
    public double getTotalOrderSales() throws SQLException {
        return 0;
    }
}
