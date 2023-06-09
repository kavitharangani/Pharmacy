package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.model.CartPlaceOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface CartPlaceOrderBO {
    public  boolean save(String customerId, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException ;

    }
