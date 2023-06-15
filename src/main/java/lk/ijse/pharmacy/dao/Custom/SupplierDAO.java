package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.Supplier;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface SupplierDAO extends CrudDAO<Supplier> {

     boolean save(String orderId, LocalDate now, double total) throws SQLException;

    public Supplier search(String id) throws SQLException;

    public boolean delete(String id) throws SQLException;

    public List<String> getIds() throws SQLException;



}
