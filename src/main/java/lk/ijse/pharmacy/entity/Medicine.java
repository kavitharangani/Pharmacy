package lk.ijse.pharmacy.entity;

public class Medicine {
    private String mediCode;
    private String description;
    private String name;
    private String packSize;
    private double unitPrize;
    private int qtyOnStock;

    public Medicine(String code, String mediCode, String description, String name, String size, double price, int qty){
        this.mediCode= this.mediCode;
        this.description= this.description;
        this.name= this.name;
        this.packSize=packSize;
        this.unitPrize=unitPrize;
        this.qtyOnStock=qtyOnStock;
    }


    public Medicine() {
    }


    public Medicine(String employeeName, String contact, String employeeId, String employeenic, String employeeAddress) {

    }

    public Medicine(String mediCode) {

    }

    public String getMediCode() {
        return mediCode;
    }

    public void setMediCode(String mediCode) {
        this.mediCode = mediCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public Double getUnitPrize() {
        return unitPrize;
    }

    public void setUnitPrize(Double unitPrize) {
        this.unitPrize = unitPrize;
    }

    public Integer getQtyOnStock() {
        return qtyOnStock;
    }

    public void setQtyOnStock(Integer qtyOnStock) {
        this.qtyOnStock = qtyOnStock;
    }
}
