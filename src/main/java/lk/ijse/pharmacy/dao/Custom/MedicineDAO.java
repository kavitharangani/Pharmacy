package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;

import java.sql.SQLException;
import java.util.List;

public interface MedicineDAO extends CrudDAO<Medicine> {
    boolean save(Medicine dto) throws SQLException;

    boolean updateQtySupplies(List<CartPlaceOrderDTO> dtoList) throws SQLException;
}
