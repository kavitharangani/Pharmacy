package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MedicineBO {
    public  boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public boolean save(Medicine medicine) throws SQLException, ClassNotFoundException ;

    public  Medicine search(String id) throws SQLException ;

    public  boolean update(Medicine medicine) throws SQLException, ClassNotFoundException ;

    public  List<String> generateMedicineId() throws SQLException ;

    public  boolean updateQtySupplies1(List<CartPlaceOrderDTO> dtoList) throws SQLException, ClassNotFoundException ;

    boolean updateQtySupplies(CartPlaceOrderDTO dto) throws SQLException, ClassNotFoundException ;

    public ArrayList<Medicine> countMedicines() throws SQLException, ClassNotFoundException ;

    }
