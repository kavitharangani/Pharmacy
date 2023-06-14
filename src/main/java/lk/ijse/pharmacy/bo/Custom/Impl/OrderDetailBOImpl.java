package lk.ijse.pharmacy.bo.Custom.Impl;

import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.OrderDAO;
import lk.ijse.pharmacy.dao.DAOFactory;
import lk.ijse.pharmacy.entity.Order;
import lk.ijse.pharmacy.model.OrderTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailBOImpl implements SuperBO {
    OrderDAO ordersDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    public List<OrderTm> getAllOrders() throws SQLException {
        List<Order> orders =ordersDAO.getAll();
        List<OrderTm > ordersDTOS =new ArrayList<>();

        for (Order order :orders){
            //ordersDTOS.add(new OrderTm(order.getOrderId(),order.getDate(),order.getTime(),order.getMemberId(),order.getOrthers()));
        }
        return ordersDTOS;
    }

}
