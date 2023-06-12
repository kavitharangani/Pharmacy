package lk.ijse.pharmacy.controller;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.CustomerBO;
import lk.ijse.pharmacy.bo.Custom.Impl.CustomerBOImpl;
import lk.ijse.pharmacy.entity.Customer;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.jhj.CustomerModel;
import lk.ijse.pharmacy.model.CustomersDTO;

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

    CustomerBO customerBO  = new CustomerBOImpl();


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
            try {
                boolean isDelete = customerBO.deleteCustomer(txtId.getText());
                if (isDelete){
                    new Alert(Alert.AlertType.CONFIRMATION).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }
        }



    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtId.getText().matches("^[C0-9]{4}$")) {
            String id = txtId.getText();
            String name = txtName.getText();
            String contact = txtContact.getText();
            String nic = txtNic.getText();

            try {
                boolean isSave = customerBO.save(new CustomersDTO(id, name, contact, nic));
                if (isSave) {
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
    void btnSearchOnAction(ActionEvent event) {
        if (txtId.getText().matches("^[C0-9]{4}$")) {
            String id = txtId.getText();
            try {
                CustomersDTO customer = customerBO.searchCustomer(id);
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
        }else {
            new Alert(Alert.AlertType.ERROR, "IT IS NOT VALIED").show();

        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (txtId.getText().matches("^[C0-9]{4}$")) {
            String id = txtId.getText();
            String name = txtName.getText();
            String contact = txtContact.getText();
            String nic = txtNic.getText();

            try {
                boolean isUpdate = customerBO.update(new CustomersDTO(id, name, contact, nic));
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Customer Not Update").show();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "IT IS NOT VALIED").show();

        }

    }
}


