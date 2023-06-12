package lk.ijse.pharmacy.dao.Custom;

import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.model.CustomersDTO;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer> {

    public Customer searchCustomer(String id) throws SQLException;
    public boolean deleteCustomer(String id) throws SQLException;
    public boolean save(Customer dto) throws SQLException;
    public boolean update(Customer dto) throws SQLException;

}
