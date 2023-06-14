package lk.ijse.pharmacy.bo.Custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pharmacy.bo.Custom.CustomerBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.CustomerDAO;
import lk.ijse.pharmacy.dao.Custom.Impl.CustomerDAOImpl;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomersDTO;
import lk.ijse.pharmacy.model.CustomersDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO, SuperBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    public boolean save(CustomersDTO dto) throws SQLException{
         return customerDAO.save(new Customer(dto.getCustId(),dto.getCustName(),dto.getContact(),dto.getCustNic()));
    }


    public boolean delete(String id) throws SQLException {
        return customerDAO.delete(id);

    }


    public CustomersDTO search(String id) throws SQLException {
        Customer customer = customerDAO.search(id);
        return new CustomersDTO(customer.getCustId(),customer.getCustName(),customer.getContact(),customer.getCustNic());
    }


    public  boolean update(CustomersDTO customer) throws SQLException {
        return customerDAO.update(new Customer(customer.getCustId(), customer.getCustName(), customer.getContact(), customer.getCustNic()));
    }

        public ArrayList<String> getIds() throws SQLException {
        return customerDAO.getId();
    }



    private  boolean next() {
        return false;
    }

    public  ObservableList<CustomersDTO> getAllAvailableItems() throws SQLException{
        ResultSet rs= CrudUtil.execute("SELECT * from customer ");
        ObservableList<CustomersDTO> list = FXCollections.observableArrayList();
        while (rs.next()){
            CustomersDTO item = new CustomersDTO(rs.getString(1),rs.getString(2),rs.getString
                    (3),rs.getString(4),rs.getString(5));


            list.add(item);
        }
        return null;
    }

    public CustomersDTO searchCustomer(String id) throws SQLException {
        Customer customer = customerDAO.searchCustomer(id);
        return new CustomersDTO(customer.getCustId(),customer.getCustName(),customer.getContact(),customer.getCustNic());
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.deleteCustomer(id);
    }

    @Override
    public int countCustomers() throws SQLException {
        String sql = "SELECT COUNT(*) as customerCount FROM pharmacy.customer;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }


}
