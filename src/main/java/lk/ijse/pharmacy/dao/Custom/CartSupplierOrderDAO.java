package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.CartSupplierOrder;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;

public interface CartSupplierOrderDAO extends CrudDAO<CartSupplierOrder> {
    boolean save(String suppliesOrderId, LocalDate now, String supplierId, double total) throws SQLException;

}
