package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.CartPlaceOrder;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface CartPlaceOrderDAO extends CrudDAO<CartPlaceOrder> {
    boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException;


    boolean save(String orderId, List<CartPlaceOrderDTO> dtoList);

    boolean updateQtySupplies(List<CartPlaceOrderDTO> dtoList);

    ;
}
