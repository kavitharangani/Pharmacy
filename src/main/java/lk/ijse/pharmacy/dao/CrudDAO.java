package lk.ijse.pharmacy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
     boolean save(T dto) throws SQLException, ClassNotFoundException ;
     boolean delete(String id) throws SQLException, ClassNotFoundException;
     ArrayList<T> countCustomers() throws SQLException, ClassNotFoundException ;
     T search(String id) throws SQLException, ClassNotFoundException;
     boolean update(T dto) throws SQLException, ClassNotFoundException ;
     ArrayList<T> getIds() throws SQLException, ClassNotFoundException ;
     ArrayList<T> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException;
     ArrayList<T> getAllAvailableItems() throws SQLException, ClassNotFoundException;
     List<String> generate(T dto) throws SQLException, ClassNotFoundException ;
     ArrayList<T> count() throws SQLException, ClassNotFoundException ;
     List<String> splitOrderId(String dto) ;
     double getTotalOrderSales() throws SQLException;

}
