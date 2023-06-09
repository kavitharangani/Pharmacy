package lk.ijse.pharmacy.dao.Custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pharmacy.dao.Custom.CustomerDAO;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lk.ijse.pharmacy.jhj.CustomerModel.next;

public class CustomerDAOImpl implements CustomerDAO {
    private Customer customer;

    @Override
    public boolean save(Customer dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO customer (custId,custName,contact,custNic) VALUES (?,?,?,?)",dto.getCustId(), dto.getCustName(),  dto.getContact(), dto.getCustNic());

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM customer WHERE custId = ?",id);
    }


    @Override
    public ArrayList<Customer> countCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> countCustomers = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) as customerCount FROM pharmacy.customer;");
        if (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString("custId"), resultSet.getString("custName"), resultSet.getString("contact"), resultSet.getString("custNic"));
            countCustomers.add(customer);
        }
        return countCustomers;
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE custId=?" );
        rst.next();
        return new Customer(id + "", rst.getString("custName"),rst.getString("contact"),rst.getString("custNic"));
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute( "UPDATE customer SET custName=?,contact=?,custNic=? WHERE custId = ? ",customer.getCustName(), customer.getContact(), customer.getCustNic(), customer.getCustId());

    }

    @Override
    public ArrayList<Customer> getIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> allCustomers = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT custId FROM customer");
        if ((resultSet.next())) {
            String id = resultSet.getString("id");
            allCustomers.add(id);
        }
        return getIds();

    }

    @Override
    public ArrayList<Customer> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        ResultSet rs= CrudUtil.execute("SELECT * from Custome where type = '"+ this +"' AND qty>0 ");
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        while (next()){
            CustomerDTO item = new CustomerDTO(rs.getString(1),rs.getString(2),rs.getString
                    (3),rs.getString(4),rs.getString(5));

            list.add(item);
        }
        return getAllAvailableItems();
    }

    @Override
    public ArrayList<Customer> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        ResultSet rs= CrudUtil.execute("SELECT * from customer ");
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        while (rs.next()){
            CustomerDTO item = new CustomerDTO(rs.getString(1),rs.getString(2),rs.getString
                    (3),rs.getString(4),rs.getString(5));


            list.add(item);
        }
        return getAllAvailableItems();
    }

    public  List<CustomerDTO> getAll() {
        return null;
    }

    @Override
    public List<String> generate(Customer dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Customer> count() throws SQLException, ClassNotFoundException {
        return null;
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
