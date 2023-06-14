package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.CartPlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public interface CartPlaceOrderDAO extends CrudDAO<CartPlaceOrder> {
    boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException;
}
