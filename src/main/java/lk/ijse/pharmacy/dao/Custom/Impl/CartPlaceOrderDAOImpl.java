package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.CartPlaceOrderDAO;
import lk.ijse.pharmacy.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartPlaceOrderDAOImpl implements CartPlaceOrderDAO {


    @Override
    public boolean save(CartPlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CartPlaceOrder> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public CartPlaceOrder search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public boolean update(CartPlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CartPlaceOrder> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartPlaceOrder> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartPlaceOrder> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(CartPlaceOrder dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartPlaceOrder> count() throws SQLException, ClassNotFoundException {
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
   /* public static boolean save(String customerId, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave = OrderModel.save(orderId, LocalDate.now(),customerId,total);
            if (isSave){
                boolean isUpdated = MedicineModel.updateQtySupplies(dtoList);
                if (isUpdated){
                    boolean isSaveOrderDetail = OrderDetailModel.save1(orderId,dtoList);
                    if(isSaveOrderDetail) {
                        connection.commit();
                        return true;
                    }
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean save(CartPlaceOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CartPlaceOrder> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(CartPlaceOrder customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CartPlaceOrder> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartPlaceOrder> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }*/
}
