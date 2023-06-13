package lk.ijse.pharmacy.bo.Custom;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.model.CustomersDTO;
import lk.ijse.pharmacy.model.SupplierDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface SupplierBO extends SuperBO {

    public  boolean save(SupplierDTO dto) throws SQLException;

    public SupplierDTO search(String id) throws SQLException;

    public  int countOrders() throws SQLException ;

    public  double getTotalOrderSales() throws SQLException ;

    public  List<String> getIds() throws SQLException;

    public boolean delete(String id) throws SQLException ;

    public  boolean update(SupplierDTO supplier) throws SQLException ;


}
