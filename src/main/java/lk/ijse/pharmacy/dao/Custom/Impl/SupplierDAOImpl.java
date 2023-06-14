package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.SupplierDAO;
import lk.ijse.pharmacy.entity.*;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean save(Supplier dto) throws SQLException {
        return CrudUtil.execute("INSERT INTO supplier(suppliesID,contact,suppliesName,suppliesNic,suppliesCompany) VALUES (?,?,?,?,?)",dto.getSuppliesID(),dto.getContact(),dto.getSuppliesName(),dto.getSuppliesNic(),dto.getSuppliesCompany());

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.execute("DELETE FROM supplier WHERE suppliesID= ?",id);
    }



    @Override
    public Supplier search(String id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM supplier WHERE suppliesID=?",id+"" );
        if (rst.next()){
            return new Supplier(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)

            );
        }
        return null;
    }

    @Override
    public boolean update(Supplier dto) throws SQLException {
        return CrudUtil.execute("UPDATE supplier SET contact=?,suppliesName=?,suppliesNic=?,suppliesCompany=? WHERE suppliesID=?",dto.getContact(),dto.getSuppliesName(),dto.getSuppliesNic(),dto.getSuppliesCompany(),dto.getSuppliesID());
    }

    public List<String> getIds() throws SQLException {
        String sql = "SELECT suppliesID FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<String>id = new ArrayList<>();

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }


}



