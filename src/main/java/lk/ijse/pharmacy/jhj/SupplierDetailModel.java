package lk.ijse.pharmacy.jhj;

import lk.ijse.pharmacy.model.SupplierDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDetailModel {
    public static boolean delete(String id) throws SQLException {
        String sql ="DELETE FROM supplier WHERE suppliesID = ?";
        return CrudUtil.execute(sql,id);
    }

    public static boolean save(SupplierDTO supplier) throws SQLException {
        String sql = "INSERT INTO supplier (suppliesID,contact,suppliesName,suppliesNic,suppliesCompany) VALUES (?,?,?,?,?)";
        return CrudUtil.execute(sql,supplier.getSuppliesID(),supplier.getContact(),supplier.getSuppliesName(),supplier.getSuppliesNic(),supplier.getSuppliesCompany());

    }

    public static boolean update(SupplierDTO supplier) throws SQLException {
        String sql ="UPDATE supplier SET contact=?,suppliesName=?,suppliesNic=?,suppliesCompany=? WHERE suppliesID = ? ";
        return CrudUtil.execute(sql,supplier.getContact(),supplier.getSuppliesName(),supplier.getSuppliesNic(),supplier.getSuppliesCompany(),supplier.getSuppliesID());

    }

    public static SupplierDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE suppliesID= ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            String suppliesID=resultSet.getString(1);
            String contact=resultSet.getString(2);
            String suppliesName=resultSet.getString(3);
            String suppliesNic=resultSet.getString(4);
            String suppliesCompany=resultSet.getString(5);

            return new SupplierDTO(suppliesID,contact,suppliesName,suppliesNic,suppliesCompany);
        }
        return null;
    }

    public static List<String> generateSupplierId() throws SQLException {
        String sql = "SELECT suppliesID FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);

        List<String>ids=new ArrayList<>();
        while (resultSet.next()){
            ids.add(resultSet.getString(1));
        }
        return ids;
    }


    public static String generateNextOrderId() throws SQLException {
        String sql = "SELECT  suppliesOrderId FROM suppliesorder ORDER BY suppliesOrderId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);
        if(resultSet.next()) {
            String currentSuppliesID = resultSet.getString(1);
                String[] strings = currentSuppliesID.split("[K]");
                int id = Integer.parseInt(strings[1]);
                id++;
                return "K0"+id;
        }
        return "K001";
    }

}
