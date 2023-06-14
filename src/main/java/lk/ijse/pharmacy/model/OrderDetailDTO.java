package lk.ijse.pharmacy.model;

import javafx.scene.control.Button;

public class OrderDetailDTO {
    private String orderId;
    private  String mediCode;
    private Integer orderQTY;

    public OrderDetailDTO(String orderId, String mediCode, Integer orderQTY) {
        this.orderId = orderId;
        this.mediCode = mediCode;
        this.orderQTY = orderQTY;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMediCode() {
        return mediCode;
    }

    public void setMediCode(String mediCode) {
        this.mediCode = mediCode;
    }

    public Integer getOrderQTY() {
        return orderQTY;
    }

    public void setOrderQTY(Integer orderQTY) {
        this.orderQTY = orderQTY;
    }
}
