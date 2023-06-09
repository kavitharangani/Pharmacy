package lk.ijse.pharmacy.entity;

public class CartPlaceOrder {
    private String code;
    private Integer qty;

    public  CartPlaceOrder(String code,Integer qty){
        this.code=code;
        this.qty=qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
