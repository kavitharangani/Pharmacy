package lk.ijse.pharmacy.jhj;

import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.model.MedicineDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineModel {


    public static boolean delete(String id) throws SQLException {
        String sql="DELETE FROM medicine WHERE mediCode =?";
        System.out.println(id);
        return CrudUtil.execute(sql,id);

    }


    public static boolean save(MedicineDTO medicine) throws SQLException {
        String sql ="INSERT INTO medicine (mediCode,description,name,packSize,unitPrice,qtyOnStock)VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql,medicine.getMediCode(),medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock());
    }

    public static MedicineDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM medicine WHERE mediCode= ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            String MediCode = resultSet.getString(1);
            String description = resultSet.getString(2);
            String name =resultSet.getString(3);
            String size = resultSet.getString(4);
            Double price = resultSet.getDouble(5);
            Integer qty = resultSet.getInt(6);


           return  new MedicineDTO(MediCode, description, name,size,price,qty);

        }
        return null;
    }

    public static boolean update(MedicineDTO medicine) throws SQLException {
        String sql ="UPDATE medicine SET description=?,name=?,packSize=?,unitPrice=? ,qtyOnStock=? WHERE mediCode = ? ";
        System.out.println(medicine.getMediCode());
        return CrudUtil.execute(sql,medicine.getDescription(),medicine.getName(),medicine.getPackSize(),medicine.getUnitPrize(),medicine.getQtyOnStock(),medicine.getMediCode());
    }

    public static List<String> generateMedicineId() throws SQLException {
        String sql="SELECT mediCode FROM Medicine";
        List<String> id =new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

    public static boolean updateQtySupplies(List<CartPlaceOrderDTO> dtoList) throws SQLException {
        for (CartPlaceOrderDTO dto : dtoList){
            if(!updateQtySupplies1(dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean updateQtySupplies1(CartPlaceOrderDTO dto) throws SQLException {
        String sql = "UPDATE medicine SET qtyOnStock = (qtyOnStock - ?) WHERE mediCode = ?";

        return CrudUtil.execute(sql,dto.getQty(),dto.getCode());
    }

    public static ArrayList<Medicine> countMedicines() throws SQLException {
        String sql = "SELECT COUNT(*) as MedicineCount FROM pharmacy.medicine;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }
}
