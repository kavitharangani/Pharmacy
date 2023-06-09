package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.model.SupplierDTO;
import lk.ijse.pharmacy.jhj.SupplierDetailModel;

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


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if(txtSuId.getText().matches("^[S0-9]{4}$")) {
            String id = txtSuId.getText();
            try {
                boolean isDelete = SupplierDetailModel.delete(id);
                if (isDelete) {
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
    void btnSearchOnaction(ActionEvent event) {
        if(txtSuId.getText().matches("^[S0-9]{4}$")) {
            String id = txtSuId.getText();
            try {
                SupplierDTO supplier = SupplierDetailModel.search(id);
                if (supplier != null) {
                    txtSuId.setText(supplier.getSuppliesID());
                    txtSupContact.setText(supplier.getContact());
                    txtSuName.setText(supplier.getSuppliesName());
                    txtSuNic.setText(supplier.getSuppliesNic());
                    txtSupCompany.setText(supplier.getSuppliesCompany());
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
                boolean isUpdate = SupplierDetailModel.update(supplier);
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

            SupplierDTO supplier = new SupplierDTO(id, contact, name, nic, company);


            try {
                boolean isSave = SupplierDetailModel.save(supplier);
                if (isSave) {
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
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtSuId.setText("");
        txtSupContact.setText("");
        txtSuName.setText("");
        txtSuNic.setText("");
        txtSupCompany.setText("");

    }
}
