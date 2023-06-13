package lk.ijse.pharmacy.dao;

import lk.ijse.pharmacy.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
     boolean save(T dto) throws SQLException ;
     boolean delete(String id) throws SQLException;
     T search(String id) throws SQLException;
     boolean update(T dto) throws SQLException;
     ArrayList<T> getIds() throws SQLException;

}
