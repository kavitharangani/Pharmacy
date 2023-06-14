package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.PurchaseOrderBO;
import lk.ijse.pharmacy.dao.Custom.*;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.entity.CartPlaceOrder;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.model.MedicineDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    MedicineDAO medicineDAO = (MedicineDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.MEDICINE);
    CartPlaceOrderDAO cartPlaceOrderDAO = (CartPlaceOrderDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.CARTPLACE_ORDER);
    private Object orderId;


    @Override
    public boolean save(CartPlaceOrder dto) throws SQLException{
        String sql = "INSERT INTO orderdetail VALUES (?,?,?)";
        return CrudUtil.execute(sql,orderId,dto.getCode(),dto.getQty());

    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public MedicineDTO search(String id) throws SQLException {
        return null;
    }


    @Override
    public boolean update(CartPlaceOrder dto) throws SQLException {
        return false;
    }

    @Override
    public List<String> getIds() throws SQLException{
        return null;
    }

    @Override
    public ArrayList<CartPlaceOrder> count() throws SQLException{
        return null;
    }

    @Override
    public boolean save(String customerId, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave =cartPlaceOrderDAO.save(orderId, LocalDate.now(),customerId,total);
            if (isSave){
                boolean isUpdated = medicineDAO.updateQtySupplies(dtoList);
                if (isUpdated){
                    boolean isSaveOrderDetail = OrderDetailDAO.save1(orderId,dtoList);
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
    public List<String> generateMedicineId() throws SQLException {
        String sql="SELECT mediCode FROM Medicine";
        List<String> id =new ArrayList<>();

        ResultSet resultSet = CrudUtil.execute(sql);

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }
        return id;
    }

}
