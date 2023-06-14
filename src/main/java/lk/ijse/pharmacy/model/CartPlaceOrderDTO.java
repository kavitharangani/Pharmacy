package lk.ijse.pharmacy.model;

public class CartPlaceOrderDTO {
    private Object code;
    private Integer qty;

    public CartPlaceOrderDTO(Object code, Integer qty) {
               this.code = code;
               this.qty = qty;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
