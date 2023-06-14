package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.CustomerDAO;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public static int countCustomers() throws SQLException {
        String sql = "SELECT COUNT(*) as customerCount FROM pharmacy.customer;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public boolean save(Customer dto) throws SQLException {
        return CrudUtil.execute("INSERT INTO customer (custId,custName,contact,custNic) VALUES (?,?,?,?)",dto.getCustId(), dto.getCustName(),  dto.getContact(), dto.getCustNic());

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return CrudUtil.execute("DELETE FROM customer WHERE custId = ?",id);
    }

    @Override
    public Customer search(String id) throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM customer WHERE custId=?" );
        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
                    );
        }
        return null;
    }

    @Override
    public boolean update(Customer dto) throws SQLException{
        return CrudUtil.execute( "UPDATE customer SET custName=?,contact=?,custNic=? WHERE custId = ? ",dto.getCustName(), dto.getContact(), dto.getCustNic(), dto.getCustId());

    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<String> getId() throws SQLException {
        ArrayList<String> allCustomers = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT custId FROM customer");
        if ((resultSet.next())) {
            String id = resultSet.getString(1);
            allCustomers.add(id);
        }
        return allCustomers;

    }

    @Override
    public Customer searchCustomer(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE custID = ?";
        ResultSet resultSet = CrudUtil.execute(sql,id);

        if (resultSet.next()){
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return CrudUtil.execute("DELETE FROM customer WHERE custId = ?",id);
    }
}
