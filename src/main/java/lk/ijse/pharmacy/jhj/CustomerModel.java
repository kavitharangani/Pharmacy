package lk.ijse.pharmacy.jhj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    private static String type;

    public static boolean save(CustomerDTO customer) throws SQLException {
        String sql = "INSERT INTO customer (custId,custName,contact,custNic) VALUES (?,?,?,?)";
        return CrudUtil.execute(sql, customer.getCustId(), customer.getCustName(),  customer.getContact(), customer.getCustNic());
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM customer WHERE custId = ?";
        return CrudUtil.execute(sql,id);
    }

    public static int countCustomers() throws SQLException {
        String sql = "SELECT COUNT(*) as customerCount FROM pharmacy.customer;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }

    public static CustomerDTO search(String id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE custID = ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);

        if (resultSet.next()) {
            String CId = resultSet.getString(1);
            String CName = resultSet.getString(2);
            String CContact = resultSet.getString(3);
            String CNic = resultSet.getString(4);

            return new CustomerDTO(CId, CName,CContact, CNic);
        }
        return null;
    }

    public static boolean update(CustomerDTO customer) throws SQLException {
        String sql = "UPDATE customer SET custName=?,contact=?,custNic=? WHERE custId = ? ";
        return CrudUtil.execute(sql, customer.getCustName(), customer.getContact(), customer.getCustNic(), customer.getCustId());
    }

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT custId FROM customer";
        ResultSet resultSet = CrudUtil.execute(sql);

        List<String>id= new ArrayList<>();

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

    public static ObservableList getAllAvailableItems(String other) throws SQLException {
        ResultSet rs= CrudUtil.execute("SELECT * from Custome where type = '"+type+"' AND qty>0 ");
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        while (next()){
            CustomerDTO item = new CustomerDTO(rs.getString(1),rs.getString(2),rs.getString
                    (3),rs.getString(4),rs.getString(5));

            list.add(item);
        }
        return list;
    }

    public static boolean next() {
        return false;
    }

    public static ObservableList<CustomerDTO> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        ResultSet rs= CrudUtil.execute("SELECT * from customer ");
        ObservableList<CustomerDTO> list = FXCollections.observableArrayList();
        while (rs.next()){
           CustomerDTO item = new CustomerDTO(rs.getString(1),rs.getString(2),rs.getString
                   (3),rs.getString(4),rs.getString(5));


            list.add(item);
        }
        return list;
    }

    public static List<CustomerDTO> getAll() {
        return null;
    }
}
