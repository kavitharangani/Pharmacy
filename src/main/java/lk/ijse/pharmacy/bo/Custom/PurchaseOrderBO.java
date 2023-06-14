package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.entity.CartPlaceOrder;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.model.MedicineDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO extends SuperBO {
    public boolean save(CartPlaceOrder dto) throws SQLException ;

    public boolean delete(String id) throws SQLException ;

    public MedicineDTO search(String id) throws SQLException ;

    public boolean update(CartPlaceOrder dto) throws SQLException ;

    public List<String> getIds() throws SQLException;

    public ArrayList<CartPlaceOrder> count() throws SQLException ;

    boolean save(String customerId, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException;

    List<String> generateMedicineId() throws SQLException;


}
