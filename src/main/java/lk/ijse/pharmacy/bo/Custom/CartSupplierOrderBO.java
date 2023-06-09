package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.model.CartPlaceOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface CartSupplierOrderBO {
    public  boolean save(String suppliesID, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException ;

    }
