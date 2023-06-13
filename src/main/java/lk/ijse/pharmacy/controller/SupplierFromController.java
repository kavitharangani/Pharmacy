package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.SupplierBO;
import lk.ijse.pharmacy.model.SupplierDTO;


import java.sql.SQLException;

public class SupplierFromController {

    @FXML
    private TextField txtSuName;

    @FXML
    private TextField txtSuId;

    @FXML
    private TextField txtSuNic;

    @FXML
    private TextField txtSupContact;

    @FXML
    private TextField txtSupCompany;

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SUPPLIER);


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if(txtSuId.getText().matches("^[S0-9]{4}$")) {
            try {
                boolean isDelete = supplierBO.delete(txtSuId.getText());
                if (isDelete){
                    new Alert(Alert.AlertType.CONFIRMATION).show();
                }else {
                    new Alert(Alert.AlertType.ERROR, "ID NOT FOUND").show();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }

    }

    @FXML
    void btnSearchOnaction(ActionEvent event) {
        if(txtSuId.getText().matches("^[S0-9]{4}$")) {
            String id = txtSuId.getText();
            try {
                SupplierDTO supplier = supplierBO.search(id);
                if (supplier != null) {
                    txtSuId.setText(supplier.getSuppliesID());
                    txtSupContact.setText(supplier.getContact());
                    txtSuName.setText(supplier.getSuppliesName());
                    txtSuNic.setText(supplier.getSuppliesNic());
                    txtSupCompany.setText(supplier.getSuppliesCompany());
                } else {
                new Alert(Alert.AlertType.ERROR, "Customer Not Found").show();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if(txtSuId.getText().matches("^[S0-9]{4}$")) {
            String id = txtSuId.getText();
            String contact = txtSupContact.getText();
            String name = txtSuName.getText();
            String nic = txtSuNic.getText();
            String company = txtSupCompany.getText();

            SupplierDTO supplier = new SupplierDTO(id, contact, name, nic, company);


            try {
                boolean isUpdate = supplierBO.update(supplier);

                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnsaveOnAction(ActionEvent event) {
        if (txtSuId.getText().matches("^[S0-9]{4}$")) {
            String id = txtSuId.getText();
            String contact = txtSupContact.getText();
            String name = txtSuName.getText();
            String nic = txtSuNic.getText();
            String company = txtSupCompany.getText();
            try {
                boolean isSave =  supplierBO.save(new SupplierDTO(id,contact,name,nic,company));
                if (isSave) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }
    @FXML
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtSuId.setText("");
        txtSupContact.setText("");
        txtSuName.setText("");
        txtSuNic.setText("");
        txtSupCompany.setText("");

    }
}
