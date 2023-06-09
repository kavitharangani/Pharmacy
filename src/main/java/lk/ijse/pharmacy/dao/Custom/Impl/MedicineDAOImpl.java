package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.MedicineDAO;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MedicineDAOImpl implements MedicineDAO {

    public static int countMedicines() throws SQLException {
        String sql = "SELECT COUNT(*) as MedicineCount FROM pharmacy.medicine;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public boolean updateQtySupplies(List<CartPlaceOrderDTO> dtoList) throws SQLException {
        for (CartPlaceOrderDTO dto : dtoList){
            if(!updateQtySupplies1(dto)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean save(Medicine dto) throws SQLException {
        return CrudUtil.execute("INSERT INTO medicine (mediCode,description,name,packSize,unitPrice,qtyOnStock)VALUES (?,?,?,?,?,?)", dto.getMediCode(), dto.getDescription(), dto.getName(), dto.getPackSize(), dto.getUnitPrize(), dto.getQtyOnStock());

    }

    private boolean updateQtySupplies1(CartPlaceOrderDTO dto) throws SQLException {
        String sql = "UPDATE medicine SET qtyOnStock = (qtyOnStock - ?) WHERE mediCode = ?";
        return CrudUtil.execute(sql,dto.getQty(),dto.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.execute("DELETE FROM medicine WHERE mediCode =?", id);

    }

    @Override
    public Medicine search(String id) throws SQLException {
        String sql = "SELECT * FROM medicine WHERE medicode=?";
        ResultSet resultSet=CrudUtil.execute(sql,id);
        if(resultSet.next()) {
            return new Medicine(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5),
                    resultSet.getInt(6)
            );
        }
        return null;
    }

    @Override
    public boolean update(Medicine dto) throws SQLException {
        return CrudUtil.execute("UPDATE medicine SET description=?,name=?,packSize=?,unitPrice=? ,qtyOnStock=? WHERE mediCode = ? ", dto.getDescription(), dto.getName(), dto.getPackSize(), dto.getUnitPrize(), dto.getQtyOnStock(), dto.getMediCode());

    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

}