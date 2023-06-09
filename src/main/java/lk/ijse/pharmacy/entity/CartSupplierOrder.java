package lk.ijse.pharmacy.entity;

public class CartSupplierOrder {
    private String code;
    private Integer qty;

    public CartSupplierOrder(String code,Integer qty){
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
