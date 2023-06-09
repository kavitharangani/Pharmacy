package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.CartPlaceOrderDAO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.entity.CartPlaceOrder;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CartPlaceOrderDAOImpl implements CartPlaceOrderDAO {

    private String orderId;
    private LocalDate now;
    private String customerId;
    private double total;

    public boolean save(String orderId, LocalDate now, String customerId, double total) throws SQLException {
        String sql ="INSERT INTO orders(orderId,orderDate,custID,total)VALUES (?,?,?,?)";
        return CrudUtil.execute(sql,orderId,now,customerId,total);
    }



    @Override
    public boolean save(String orderId, List<CartPlaceOrderDTO> dtoList) throws SQLException {
        for (CartPlaceOrderDTO dto : dtoList){
            if (!save1(orderId,dto)){
                return false;
            }
        }
        return true;
    }

    private  boolean save1(String orderId, CartPlaceOrderDTO dto) throws SQLException {
        String sql = "INSERT INTO orderdetail VALUES (?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty());
    }

    @Override
    public boolean updateQtySupplies(List<CartPlaceOrderDTO> dtoList) throws SQLException {
        for (CartPlaceOrderDTO dto : dtoList){
            if(!updateQtySupplies1(dto)){
                return false;
            }
        }
        return true;
    }

    private static boolean updateQtySupplies1(CartPlaceOrderDTO dto) throws SQLException {
        String sql = "UPDATE medicine SET qtyOnStock = (qtyOnStock - ?) WHERE mediCode = ?";
        return CrudUtil.execute(sql,dto.getQty(),dto.getCode());
    }

    public String generateNextOrderId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    public String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] strings = currentOrderId.split("O0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O0"+id;
        }
        return "O001";
    }

    public int countOrders() throws SQLException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count;
    }

    public double getTotalOrderSales() throws SQLException {
        String sql = "SELECT SUM(total)  FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        double total = 0 ;
        if (resultSet.next()) {
            total =  resultSet.getInt(1);
        }
        return total;
    }

    @Override
    public boolean save(CartPlaceOrder dto) throws SQLException {
       return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public CartPlaceOrder search(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(CartPlaceOrder dto) throws SQLException {
        return false;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }


}
