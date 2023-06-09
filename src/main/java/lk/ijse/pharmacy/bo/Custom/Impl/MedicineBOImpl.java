package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.EmployeeBO;
import lk.ijse.pharmacy.bo.Custom.MedicineBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.MedicineDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.pharmacy.jhj.MedicineModel.countMedicines;

public class MedicineBOImpl implements MedicineBO, SuperBO {
    MedicineDAO medicineDAO = (MedicineDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.MEDICINE);

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return medicineDAO.delete(id);

    }

    @Override
    public boolean save(Medicine medicine) throws SQLException, ClassNotFoundException {
        return medicineDAO.save(new Medicine(medicine.getMediCode(),medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock()));

    }

    @Override
    public Medicine search(String id) throws SQLException, ClassNotFoundException {
        Medicine medicine = medicineDAO.search(id);
        return new Medicine(medicine.getMediCode(),medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock() );
    }

    @Override
    public boolean update(Medicine medicine) throws SQLException, ClassNotFoundException {
       return medicineDAO.update(new Medicine(medicine.getMediCode(),medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock()));
    }

    @Override
    public List<String> generateMedicineId() throws SQLException {
        String sql = "SELECT mediCode FROM Medicine";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

    @Override
    public boolean updateQtySupplies1(List<CartPlaceOrderDTO> dtoList) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateQtySupplies(CartPlaceOrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<Medicine> countMedicines() throws SQLException, ClassNotFoundException {
        ArrayList<Medicine> countMedicines = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) as  MedicineCount FROM pharmacy.medicine;");
        if (resultSet.next()) {
            Medicine medicine = new Medicine(resultSet.getString("mediCode"));
            countMedicines().add(medicine);
        }
        return countMedicines();
    }
}
