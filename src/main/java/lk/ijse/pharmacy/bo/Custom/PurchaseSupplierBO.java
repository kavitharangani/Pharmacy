package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface PurchaseSupplierBO extends SuperBO {
    boolean save(String customerId, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException;

}
