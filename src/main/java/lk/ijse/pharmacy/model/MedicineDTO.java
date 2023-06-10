package lk.ijse.pharmacy.model;

public class MedicineDTO {
    private String mediCode;
    private String description;
    private String name;
    private String packSize;
    private Double unitPrize;
    private Integer qtyOnStock;

    public MedicineDTO(String id, String name, String description, String size, Double price, Integer qty) {

    }

    public MedicineDTO(String id, String name, String description, Double price, Integer qty, String size) {

    }

    public String getMediCode() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getPackSize() {
        return null;
    }

    public char[] getUnitPrize() {
        return new char[0];
    }

    public char[] getQtyOnStock() {
        return new char[0];
    }
}
