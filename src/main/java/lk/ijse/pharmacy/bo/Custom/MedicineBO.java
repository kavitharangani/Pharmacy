package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.MedicineDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface MedicineBO {
    public  boolean delete(String id) throws SQLException ;

    public MedicineDTO search(String id) throws SQLException;

    public  boolean update(MedicineDTO medicine) throws SQLException ;

    public ArrayList<Medicine> countMedicines() throws SQLException ;

    boolean save(MedicineDTO dto) throws SQLException;

    List<String> generateMedicineId() throws SQLException;
}
