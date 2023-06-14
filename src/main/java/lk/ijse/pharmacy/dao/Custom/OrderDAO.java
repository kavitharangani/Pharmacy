package lk.ijse.pharmacy.dao.Custom;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.pharmacy.dao.CrudDAO;
import lk.ijse.pharmacy.entity.Employee;
import lk.ijse.pharmacy.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO extends CrudDAO<Order> {
    List<Order> getAll()throws SQLException;
}

