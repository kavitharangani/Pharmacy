package lk.ijse.pharmacy.model;

public class MedicineDTO {
    private String mediCode;
    private String description;
    private String name;
    private String packSize;
    private Double unitPrize;
    private Integer qtyOnStock;

    public MedicineDTO(String mediCode, String description, String name, String packSize, Double unitPrize, Integer qtyOnStock) {
        this.mediCode = mediCode;
        this.description = description;
        this.name = name;
        this.packSize = packSize;
        this.unitPrize = unitPrize;
        this.qtyOnStock = qtyOnStock;
    }

    public static int countMedicines() {
        return 0;
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


