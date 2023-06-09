package lk.ijse.pharmacy.model;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;

public class OrderTm {
    private String code;
    private  String description;
    private Integer qty;
    private  Double unitPrice;
    private  Double total;
    private Button btn;

    public OrderTm(String code,String description,Integer qty,Double unitPrice,Double total,Button btn){
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.btn = btn;

    }

    public Object getCode() {
        return null;
    }

    public Object getQty() {
        return null;
    }
}
