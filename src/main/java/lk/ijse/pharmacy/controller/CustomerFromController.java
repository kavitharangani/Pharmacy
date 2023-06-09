package lk.ijse.pharmacy.controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.CustomerBO;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.jhj.CustomerModel;

import java.sql.SQLException;

public class CustomerFromController {

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNic;
    private JFXPanel root;

    CustomerBO customerBO  = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);


    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtId.setText("");
        txtName.setText("");
        txtContact.setText("");
        txtNic.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtId.getText().matches("^[C0-9]{4}$")) {
            String custID = txtId.getText();
            try {
                boolean isDelete = CustomerModel.delete(custID);
                if (isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }

        }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(txtId.getText().matches("^[C0-9]{4}$")) {
            String id = txtId.getText();
            String name = txtName.getText();
            String contact = txtContact.getText();
            String nic = txtNic.getText();

            CustomerDTO customer = new CustomerDTO(id, name, contact, nic);

            try {
                boolean isSave=CustomerModel.save(customer);
                if (isSave){
                    new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if (txtId.getText().matches("^[C0-9]{4}$")) {
            String id = txtId.getText();
            try {
                CustomerDTO customer = CustomerModel.search(id);
                if (customer != null) {
                    txtId.setText(customer.getCustId());
                    txtName.setText(customer.getCustName());
                    txtContact.setText(customer.getContact());
                    txtNic.setText(customer.getCustNic());
                } else {
                    new Alert(Alert.AlertType.ERROR, "Customer Not Found").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }

    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtId.getText().matches("^[C0-9]{4}$")) {
            String id = txtId.getText();
            String name = txtName.getText();
            String contact = txtContact.getText();
            String nic = txtNic.getText();

            CustomerDTO customer = new CustomerDTO(id, name, contact, nic);

            try {
                boolean isUpdate = CustomerModel.update(customer);
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }

    }
}


