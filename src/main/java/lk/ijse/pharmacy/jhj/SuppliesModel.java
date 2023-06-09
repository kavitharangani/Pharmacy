package lk.ijse.pharmacy.jhj;

import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;

public class SuppliesModel {
    private static boolean save(String orderId, CartPlaceOrderDTO dto, double total) throws SQLException {
        String sql = "INSERT INTO supplieorderdetail VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty(),total);
    }
}
