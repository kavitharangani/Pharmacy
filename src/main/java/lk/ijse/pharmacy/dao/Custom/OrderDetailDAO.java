package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.entity.CartPlaceOrder;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public interface OrderDetailDAO {
    public static boolean save(String orderId, List<CartPlaceOrderDTO> dtoList, double total) throws SQLException {
        for (CartPlaceOrderDTO dto : dtoList) {
            if (!save(orderId, Collections.singletonList(dto), total)) {
                return false;
            }
        }
        return true;
    }

//    private static boolean save(LocalDate orderId, List<CartPlaceOrderDTO> dto, List<CartPlaceOrderDTO> total) throws SQLException {
//        String sql = "INSERT INTO supplieorderdetail VALUES (?,?,?,?)";
//        return CrudUtil.execute(sql, orderId, dto.getCode(), dto.getQty(), total);
//    }

    public static boolean save1(String orderId, List<CartPlaceOrderDTO> dtoList) throws SQLException {
        for (CartPlaceOrderDTO dto : dtoList) {
            if (!save1(orderId, Collections.singletonList(dto))) {
                return false;
            }
        }
        return true;
    }

    static boolean save1(String orderId, double dto) {
        return false;
    }

//    private static boolean save1(LocalDate orderId, List<CartPlaceOrderDTO> dto) throws SQLException {
//        String sql = "INSERT INTO orderdetail VALUES (?,?,?)";
//        return CrudUtil.execute(sql, orderId, dto.getCode(), dto.getQty());
//    }

}
