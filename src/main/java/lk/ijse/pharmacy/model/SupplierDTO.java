package lk.ijse.pharmacy.model;


public class SupplierDTO {
    private String suppliesID;
    private String contact;
    private String  suppliesName;
    private String suppliesNic;
    private String suppliesCompany;

    public SupplierDTO(String suppliesID, String contact, String suppliesName, String suppliesNic, String suppliesCompany) {
        this.suppliesID = suppliesID;
        this.contact = contact;
        this.suppliesName = suppliesName;
        this.suppliesNic = suppliesNic;
        this.suppliesCompany = suppliesCompany;
    }


    public String getSuppliesID() {
        return suppliesID;
    }

    public void setSuppliesID(String suppliesID) {
        this.suppliesID = suppliesID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSuppliesName() {
        return suppliesName;
    }

    public void setSuppliesName(String suppliesName) {
        this.suppliesName = suppliesName;
    }

    public String getSuppliesNic() {
        return suppliesNic;
    }

    public void setSuppliesNic(String suppliesNic) {
        this.suppliesNic = suppliesNic;
    }

    public String getSuppliesCompany() {
        return suppliesCompany;
    }

    public void setSuppliesCompany(String suppliesCompany) {
        this.suppliesCompany = suppliesCompany;
    }
}
