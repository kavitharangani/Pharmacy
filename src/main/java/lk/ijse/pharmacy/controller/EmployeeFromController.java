package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.EmployeeBO;
import lk.ijse.pharmacy.model.EmployeeDTO;
import lk.ijse.pharmacy.jhj.EmployeeModel;

import java.security.cert.PolicyNode;
import java.sql.SQLException;

public class EmployeeFromController {

    @FXML
    private TextField txtEmContact;

    @FXML
    private TextField txtEmName;

    @FXML
    private TextField txtEmAddress;

    @FXML
    private TextField txtEmID;

    @FXML
    private TextField txtEmNIC;

    @FXML
    private Label txtContact;
    private PolicyNode LoadContext;

    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);
    private boolean isDelete;
    private boolean isSave;
    private boolean isUpdate;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtEmID.getText().matches("^[E0-9]{4}$")) {
        String id=txtEmID.getText();
        try {
           // boolean isDelete=EmployeeModel.delete(id);
            employeeBO.delete(id);
            if (isDelete){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } else {
        new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
    }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (txtEmID.getText().matches("^[E0-9]{4}$")){
        String name = txtEmName.getText();
        String contact = txtEmContact.getText();
        String id = txtEmID.getText();
        String nic = txtEmNIC.getText();
        String address = txtEmAddress.getText();

       // EmployeeDTO employee =new EmployeeDTO(name,contact,id,nic,address);

        try {
           // boolean isSave= EmployeeModel.save(employee);

            employeeBO.save(new EmployeeDTO(name,contact,id,nic,address));
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        } else {
            new Alert(Alert.AlertType.ERROR, "ID NOT VALIDATED!!!").show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if(txtEmID.getText().matches("^[E0-9]{4}$")){
        String id = txtEmID.getText();
        try {
            EmployeeDTO employee=EmployeeModel.search(id);
            if (employee != null){
               txtEmName.setText(String.valueOf(employee.getEmployeeName()));
               txtEmContact.setText(String.valueOf(employee.getContact()));
               txtEmID.setText(String.valueOf(employee.getEmployeeId()));
               txtEmNIC.setText(String.valueOf(employee.getEmployeenic()));
               txtEmAddress.setText(String.valueOf(employee.getEmployeeAdress()));

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
        if(txtEmID.getText().matches("^[E0-9]{4}$")) {
            String name = txtEmName.getText();
            String contact = txtEmContact.getText();
            String id = txtEmID.getText();
            String nic = txtEmNIC.getText();
            String address = txtEmAddress.getText();

            //EmployeeDTO employee = new EmployeeDTO(name, contact, id, nic, address);

            try {
                //boolean isUpdate = EmployeeModel.update(employee);
                employeeBO.update(new EmployeeDTO(name,contact,id,nic,address));
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    public void btnClearOnAction(ActionEvent actionEvent) {
       txtEmName.setText("");
       txtEmContact.setText("");
       txtEmID.setText("");
       txtEmNIC.setText("");
       txtEmAddress.setText("");
    }

}
