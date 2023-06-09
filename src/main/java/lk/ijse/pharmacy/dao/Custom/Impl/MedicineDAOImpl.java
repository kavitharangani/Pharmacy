package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.MedicineDAO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.pharmacy.jhj.MedicineModel.countMedicines;

public class MedicineDAOImpl implements MedicineDAO {
    private Medicine medicine;
    @Override
    public boolean save(Medicine dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO medicine (mediCode,description,name,packSize,unitPrice,qtyOnStock)VALUES (?,?,?,?,?,?)", medicine.getMediCode(), medicine.getDescription(), medicine.getName(), medicine.getPackSize(), medicine.getUnitPrize(), medicine.getQtyOnStock());

    }

    @Override
    public Medicine delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM medicine WHERE mediCode =?", id);

    }


    @Override
    public ArrayList<Medicine> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Medicine search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM medicine WHERE mediCode= ?" );
        rst.next();
        return new Medicine(id + "", rst.getString("MediCode"),rst.getString("description"),rst.getString("name"),rst.getString("size"),rst.getDouble("price"),rst.getInt("qty"));
    }

    @Override
    public boolean update(Medicine dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE medicine SET description=?,name=?,packSize=?,unitPrice=? ,qtyOnStock=? WHERE mediCode = ? ", medicine.getDescription(), medicine.getName(), medicine.getPackSize(), medicine.getUnitPrize(), medicine.getQtyOnStock(), medicine.getMediCode());

    }

    @Override
    public ArrayList<Medicine> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Medicine> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Medicine> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(Medicine dto) throws SQLException {
        String sql = "SELECT mediCode FROM Medicine";
        List<String> id = new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return id;
    }

    @Override
    public ArrayList<Medicine> count() throws SQLException, ClassNotFoundException {
        ArrayList<Medicine> countMedicines = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) as  MedicineCount FROM pharmacy.medicine;");
        if (resultSet.next()) {
            Medicine medicine = new Medicine(resultSet.getString("mediCode"));
            countMedicines().add(medicine);
        }
        return countMedicines();
    }


    @Override
    public List<String> splitOrderId(String dto) {
        return null;
    }


    @Override
    public double getTotalOrderSales() throws SQLException {
        return 0;
    }
}
   /*public static boolean updateQtySupplies1(List<CartPlaceOrderDTO> dtoList) throws SQLException, ClassNotFoundException {
        for (CartPlaceOrderDTO dto : dtoList) {
            if (!updateQtySupplies1((List<CartPlaceOrderDTO>) dto)) {
                return false;
            }
        }
        return true;
    }*/
