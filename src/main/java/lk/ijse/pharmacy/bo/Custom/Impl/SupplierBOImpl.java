package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.Custom.SupplierBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.SupplierDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.dao.SQLUtil;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.entity.Supplier;
import lk.ijse.pharmacy.model.CustomersDTO;
import lk.ijse.pharmacy.model.SupplierDTO;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupplierBOImpl implements SupplierBO, SuperBO {
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);


    @Override
    public boolean save(SupplierDTO dto) throws SQLException {
        return supplierDAO.save(new Supplier(dto.getSuppliesID(),dto.getContact(),dto.getSuppliesName(),dto.getSuppliesNic(),dto.getSuppliesCompany()));

    }

    @Override
    public SupplierDTO search(String id) throws SQLException {
        Supplier supplier = supplierDAO.search(id);
        return new SupplierDTO(supplier.getSuppliesID(),supplier.getContact(),supplier.getSuppliesName(),supplier.getSuppliesNic(),supplier.getSuppliesCompany());
    }

    @Override
    public int countOrders() throws SQLException {
        String sql = "SELECT COUNT(*) FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return countOrders();
    }

    @Override
    public double getTotalOrderSales() throws SQLException {
        String sql = "SELECT SUM(total)  FROM pharmacy.orders;";
        ResultSet resultSet = CrudUtil.execute(sql);
        double total = 0;
        if (resultSet.next()) {
            total = resultSet.getInt(1);
        }
        return getTotalOrderSales();

    }

    @Override
    public List<String> getIds() throws SQLException {
        String sql = "SELECT suppliesID FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<String> id = new ArrayList<>();

        while (resultSet.next()) {
            id.add(resultSet.getString(1));
        }
        return getIds();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean update(SupplierDTO supplier) throws SQLException {
        return supplierDAO.update(new Supplier(supplier.getSuppliesID(),supplier.getContact(),supplier.getSuppliesName(),supplier.getSuppliesNic(),supplier.getSuppliesCompany()));
    }


}