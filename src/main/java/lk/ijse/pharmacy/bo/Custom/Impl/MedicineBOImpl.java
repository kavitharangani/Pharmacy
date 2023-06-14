package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.MedicineBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.MedicineDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.MedicineDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineBOImpl implements MedicineBO, SuperBO {
    MedicineDAO medicineDAO = (MedicineDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.MEDICINE);

    @Override
    public boolean delete(String id) throws SQLException {
        return medicineDAO.delete(id);

    }


    @Override
    public MedicineDTO search(String id) throws SQLException {
        Medicine medicine = medicineDAO.search(id);
        return new MedicineDTO(medicine.getMediCode(),medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock() );
    }

    @Override
    public boolean update(MedicineDTO medicine) throws SQLException {
       return medicineDAO.update(new Medicine(medicine.getMediCode(),medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock()));
    }


    @Override
    public ArrayList<Medicine> countMedicines() throws SQLException{
        ArrayList<Medicine> countMedicines = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(*) as  MedicineCount FROM pharmacy.medicine;");
        if (resultSet.next()) {
            Medicine medicine = new Medicine(resultSet.getString("mediCode"));
            countMedicines().add(medicine);
        }
        return countMedicines();
    }

    @Override
    public boolean save(MedicineDTO dto) throws SQLException {
        return medicineDAO.save(new Medicine(dto.getMediCode(),dto.getDescription(),dto.getName(),dto.getPackSize(),dto.getUnitPrize(),dto.getQtyOnStock()));
    }

    @Override
    public List<String> generateMedicineId() throws SQLException{
        String sql="SELECT mediCode FROM Medicine";
        List<String> id =new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

}
