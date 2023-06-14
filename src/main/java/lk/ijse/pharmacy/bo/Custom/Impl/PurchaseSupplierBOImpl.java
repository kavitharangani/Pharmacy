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

public class PurchaseSupplierBOImpl implements PurchaseOrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    MedicineDAO medicineDAO = (MedicineDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.MEDICINE);
    OrderDAO OrderDAO = (OrderDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private PurchaseSupplierBOImpl cartSupplierOrderDAO;

    @Override
    public boolean save(CartPlaceOrder dto) throws SQLException {
        return false;
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
    public List<String> getIds() throws SQLException {
        String sql = "SELECT suppliesID FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<String>id = new ArrayList<>();

        while (resultSet.next()){
            id.add(resultSet.getString(1));
        }

        return id;

    }

    @Override
    public ArrayList<CartPlaceOrder> count() throws SQLException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0 ;
        if (resultSet.next()) {
            count =  resultSet.getInt(1);
        }
        return count();
    }

    @Override
    public boolean save(String customerId, String orderId, double total, List<CartPlaceOrderDTO> dtoList) throws SQLException {
        Connection connection = null;

        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSave =cartSupplierOrderDAO.save(orderId,LocalDate.now(),total);
            if (isSave){
                boolean isUpdated = medicineDAO.updateQtySupplies(dtoList);
                if (isUpdated){
                    boolean isSaveOrderDetail = OrderDetailDAO.save(orderId,dtoList,total);
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

    private boolean save(String orderId, LocalDate now, double total) throws SQLException {
        String sql ="INSERT INTO suppliesorder(suppliesOrderID,Date,total)VALUES (?,?,?)";
        return CrudUtil.execute(sql,orderId,now,total);
    }

    public String generateNextOrderId() throws SQLException {
        String sql = "SELECT  suppliesOrderId FROM suppliesorder ORDER BY suppliesOrderId DESC LIMIT 1";
        ResultSet resultSet = CrudUtil.execute(sql);
        if(resultSet.next()) {
            String currentSuppliesID = resultSet.getString(1);
            String[] strings = currentSuppliesID.split("[K]");
            int id = Integer.parseInt(strings[1]);
            id++;
            return "K0"+id;
        }
        return "K001";
    }

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
