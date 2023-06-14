package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.MedicineBO;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.model.MedicineDTO;


import java.sql.SQLException;

public class MedicineFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMeId2;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtPackSize;

    MedicineBO medicineBO = (MedicineBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MEDICINE);
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtMeId2.getText().matches("[M0-9]{4}$")) {
            try {
                boolean isDelete= medicineBO.delete(txtMeId2.getText());
                if (isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Medicine Not Delete").show();
                }
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
        }

    @FXML
    void btnSearchOnaction(ActionEvent event) {

            String id = txtMeId2.getText();
            try {
                MedicineDTO medicine = medicineBO.search(id);
                System.out.println(id);

                if (medicine != null) {
                    txtMeId2.setText(medicine.getMediCode());
                    txtDescription.setText(medicine.getDescription());
                    txtName.setText(medicine.getName());
                    txtPackSize.setText(medicine.getPackSize());
                    txtPrice.setText(String.valueOf(medicine.getUnitPrize()));
                    txtQty.setText(String.valueOf(medicine.getQtyOnStock()));
                } else {
                new Alert(Alert.AlertType.ERROR, "Medicine Not Found").show();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if(txtMeId2.getText().matches("^[M0-9]{4}$")) {
            String id = txtMeId2.getText();
            String description = txtDescription.getText();
            String name = txtName.getText();
            String size = txtPackSize.getText();
            Double price = Double.valueOf(txtPrice.getText());
            Integer qty = Integer.valueOf(txtQty.getText());

            try {
                boolean isUpdate= medicineBO.update(new MedicineDTO(id,description,name,size,price,qty));
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Medicine Not Update").show();
                }
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnsaveOnAction(ActionEvent event) {
        if (txtMeId2.getText().matches("^[M0-9]{4}$")) {
            String mediCode= txtMeId2.getText();
            String description = txtDescription.getText();
            String name = txtName.getText();
            String size = txtPackSize.getText();
            Double price = Double.valueOf(txtPrice.getText());
            Integer qty = Integer.valueOf(txtQty.getText());
            try {
                boolean isSave =  medicineBO.save(new MedicineDTO(mediCode,description,name,size,price,qty));
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
        txtMeId2.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        txtPackSize.setText("");
    }
}
