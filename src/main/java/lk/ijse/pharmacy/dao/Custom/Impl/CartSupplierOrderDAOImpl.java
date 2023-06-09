package lk.ijse.pharmacy.dao.Custom.Impl;

import lk.ijse.pharmacy.dao.Custom.CartSupplierOrderDAO;
import lk.ijse.pharmacy.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartSupplierOrderDAOImpl implements CartSupplierOrderDAO {


    @Override
    public boolean save(CartSupplierOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CartSupplierOrder delete(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public ArrayList<CartSupplierOrder> countCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public CartSupplierOrder search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(CartSupplierOrder dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<CartSupplierOrder> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartSupplierOrder> getAllAvailableItems(String other) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartSupplierOrder> getAllAvailableItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> generate(CartSupplierOrder dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<CartSupplierOrder> count() throws SQLException, ClassNotFoundException {
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
   /* public static boolean save(String suppliesID, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave = SupplierModel.save(orderId, LocalDate.now(),total);
            if (isSave){
                boolean isUpdated = MedicineModel.updateQtySupplies(dtoList);
                if (isUpdated){
                    boolean isSaveOrderDetail = OrderDetailModel.save(orderId,dtoList,total);
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
    }*/
}
