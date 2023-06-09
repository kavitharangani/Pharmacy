package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pharmacy.model.CustomerDTO;
import lk.ijse.pharmacy.jhj.CustomerModel;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterFormController {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtContact;

    @FXML
    private AnchorPane root;


    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage =(Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("/view/login_form.fxml");
        stage.centerOnScreen();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(txtId.getText().matches("^[U0-9]{4}$")){
            String id = txtId.getText();
            String name = txtName.getText();
            String contact = txtContact.getText();
            String nic = txtNic.getText();

            CustomerDTO customer = new CustomerDTO(id, name, contact, nic);

            try {
                boolean isSave= CustomerModel.save(customer);
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

}

