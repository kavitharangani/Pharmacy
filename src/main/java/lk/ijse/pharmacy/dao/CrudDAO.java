package lk.ijse.pharmacy.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
     boolean save(T dto) throws SQLException ;
     boolean delete(String id) throws SQLException;
     T search(String id) throws SQLException;
     boolean update(T dto) throws SQLException;
     List<String> getIds() throws SQLException;

}
