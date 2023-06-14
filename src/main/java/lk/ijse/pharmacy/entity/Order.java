package lk.ijse.pharmacy.entity;

public class Order {
    private Object orderId;
    private Object now;
    private Object customerId;
    private Object total;
    private boolean currentOrderId;

    public Order(Object orderId, Object now, Object customerId, Object total, boolean currentOrderId) {
        this.orderId = orderId;
        this.now = now;
        this.customerId = customerId;
        this.total = total;
        this.currentOrderId = currentOrderId;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getNow() {
        return now;
    }

    public void setNow(Object now) {
        this.now = now;
    }

    public Object getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

    public boolean isCurrentOrderId() {
        return currentOrderId;
    }

    public void setCurrentOrderId(boolean currentOrderId) {
        this.currentOrderId = currentOrderId;
    }
}
