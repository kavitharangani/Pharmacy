package lk.ijse.pharmacy.bo.Custom;

import javafx.collections.ObservableList;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomersDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean save(CustomersDTO dto) throws SQLException ;

    public boolean delete(String id) throws SQLException ;

    public CustomersDTO search(String id) throws SQLException;

    public  boolean update(CustomersDTO customer) throws SQLException ;

    public ArrayList<String> getIds() throws SQLException ;

    public CustomersDTO searchCustomer(String id) throws SQLException;

    public boolean deleteCustomer(String id) throws SQLException;

    int countCustomers() throws SQLException;
}
