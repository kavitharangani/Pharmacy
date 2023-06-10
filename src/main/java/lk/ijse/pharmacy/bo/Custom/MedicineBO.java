package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.model.MedicineDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MedicineBO {
    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public boolean save(Medicine medicine) throws SQLException, ClassNotFoundException ;

    public  Medicine search(String id) throws SQLException, ClassNotFoundException;

    public  boolean update(MedicineDTO medicine) throws SQLException, ClassNotFoundException ;

    public  List<String> generateMedicineId() throws SQLException ;

    public  boolean updateQtySupplies1(List<CartPlaceOrderDTO> dtoList) throws SQLException, ClassNotFoundException ;

    boolean updateQtySupplies(CartPlaceOrderDTO dto) throws SQLException, ClassNotFoundException ;

    public ArrayList<Medicine> countMedicines() throws SQLException, ClassNotFoundException ;

    void save(String id, String name, String description, Double price, Integer qty, String size);
}
