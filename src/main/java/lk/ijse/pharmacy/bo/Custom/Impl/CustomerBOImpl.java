package lk.ijse.pharmacy.bo.Custom.Impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pharmacy.bo.Custom.CustomerBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.CustomerDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO, SuperBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private CustomerDTO dto;

    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
         return customerDAO.save(new Customer(dto.getCustId(),dto.getCustName(),dto.getContact(),dto.getCustNic()));
    }


    public Customer delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);

    }

    public ArrayList<Customer> countCustomers() throws SQLException, ClassNotFoundException {
        /*ArrayList<Customer>countCustomers = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) as customerCount FROM pharmacy.customer;");
        if (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString("CId"),resultSet.getString("CName"),resultSet.getString("CContact"),resultSet.getString("CNic"),resultSet.getString("CNic"));
            countCustomers.add(customer);
        }
        return countCustomers;*/
        return customerDAO.countCustomers();
    }

    public Customer search(String id) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(id);
        return new Customer(customer.getCustId(),customer.getCustName(),customer.getContact(),customer.getCustNic());
    }


    public  boolean update(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCustId(), dto.getCustName(), dto.getContact(), dto.getCustNic()));
    }

        public ArrayList<CustomerDTO> getIds() throws SQLException, ClassNotFoundException {
        ArrayList<String> allCustomers = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT custId FROM customer");
        if ((resultSet.next())) {
            String id = resultSet.getString("id");
            allCustomers.add(id);
        }
        return getIds();
    }


    public ObservableList getAllAvailableItems(String other) throws SQLException {
        ResultSet rs= CrudUtil.execute("SELECT * from Custome where type = '"+ this +"' AND qty>0 ");
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        while (next()){
            CustomerDTO item = new CustomerDTO(rs.getString(1),rs.getString(2),rs.getString
                    (3),rs.getString(4),rs.getString(5));

            list.add(item);
        }
        return list;
    }

    private  boolean next() {
        return false;
    }

    public  ObservableList<CustomerDTO> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        ResultSet rs= CrudUtil.execute("SELECT * from customer ");
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        while (rs.next()){
            CustomerDTO item = new CustomerDTO(rs.getString(1),rs.getString(2),rs.getString
                    (3),rs.getString(4),rs.getString(5));


            list.add(item);
        }
        return list;
    }

}
