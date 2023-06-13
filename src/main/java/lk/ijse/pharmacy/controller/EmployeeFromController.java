package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.EmployeeBO;
import lk.ijse.pharmacy.model.EmployeesDTO;
import lombok.SneakyThrows;

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

    EmployeeBO  employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtEmID.getText().matches("^[E0-9]{4}$")) {
            try {
                boolean isDelete = employeeBO.delete(txtEmID.getText());
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
        if (txtEmID.getText().matches("^[E0-9]{4}$")){
            String name = txtEmName.getText();
            String contact = txtEmContact.getText();
            String id = txtEmID.getText();
            String nic = txtEmNIC.getText();
            String address = txtEmAddress.getText();

            try {
                boolean isSave = employeeBO.save(new EmployeesDTO(name,contact,id,nic,address));
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
        if (txtEmID.getText().matches("^[E0-9]{4}$")) {
            String id = txtEmID.getText();
            try {
                EmployeesDTO employee= employeeBO.searchEmployee(id);
                System.out.println(id);
                if (employee != null) {
                    txtEmName.setText(employee.getEmployeeName());
                    txtEmContact.setText(employee.getContact());
                    txtEmID.setText(employee.getEmployeeId());
                    txtEmNIC.setText(employee.getEmployeenic());
                    txtEmAddress.setText(employee.getEmployeeAdress());

                } else {
                    //new Alert(Alert.AlertType.ERROR, "Employee Not Found").show();
                }
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "IT IS NOT VALIED").show();

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

            try {
                boolean isUpdate = employeeBO.update(new EmployeesDTO(name, contact, id, nic, address));
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Employee Not Update").show();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR, "IT IS NOT VALIED").show();

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
