package lk.ijse.pharmacy.bo.Custom;

import javafx.collections.ObservableList;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean delete(String id) throws SQLException, ClassNotFoundException ;

    public ArrayList<Customer> countCustomers() throws SQLException, ClassNotFoundException ;

    public Customer search(String id) throws SQLException, ClassNotFoundException ;

    public  boolean update(CustomerDTO customer) throws SQLException, ClassNotFoundException ;

    public ArrayList<CustomerDTO> getIds() throws SQLException, ClassNotFoundException ;

    public ObservableList getAllAvailableItems(String other) throws SQLException ;

    public  ObservableList<CustomerDTO> getAllAvailableItems() throws SQLException, ClassNotFoundException;
}
