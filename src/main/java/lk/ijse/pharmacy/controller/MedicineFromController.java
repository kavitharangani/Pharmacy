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
import lk.ijse.pharmacy.jhj.MedicineModel;

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
    private boolean isDelete;
    private boolean isUpdate;
    private boolean isSave;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (txtMeId2.getText().matches("[M0-9]{4}$")) {
            String id = txtMeId2.getText();
            try {
                //boolean isDelete = MedicineModel.delete(id);
                medicineBO.delete(id);
                if (isDelete) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Ok").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
        }




    @FXML
    void btnSearchOnaction(ActionEvent event) {
        if(txtMeId2.getText().matches("^[M0-9]{4}$")) {
            String id = txtMeId2.getText();
            try {

                MedicineDTO medicine = MedicineModel.search(id);
                if (medicine != null) {
                    txtMeId2.setText(medicine.getMediCode());
                    txtDescription.setText(medicine.getDescription());
                    txtName.setText(medicine.getName());
                    txtPackSize.setText(medicine.getPackSize());
                    txtPrice.setText(String.valueOf(medicine.getUnitPrize()));
                    txtQty.setText(String.valueOf(medicine.getQtyOnStock()));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if(txtMeId2.getText().matches("^[M0-9]{4}$")) {
            String id = txtMeId2.getText();
            String name = txtName.getText();
            String description = txtDescription.getText();
            Double price = Double.valueOf(txtPrice.getText());
            Integer qty = Integer.valueOf(txtQty.getText());
            String size = txtPackSize.getText();

            //MedicineDTO medicine = new MedicineDTO(id, name, description, size, price, qty);


            try {
               // boolean isUpdate = MedicineModel.update(medicine);
                medicineBO.update(new MedicineDTO(id,name,description,price,qty,size));
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").show();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"ID NOT VALIED !!!").show();
        }
    }

    @FXML
    void btnsaveOnAction(ActionEvent event) {
        if (txtMeId2.getText().matches("^[M0-9]{4}$")) {
            String id = txtMeId2.getText();
            String name = txtName.getText();
            String description = txtDescription.getText();
            Double price = Double.valueOf(txtPrice.getText());
            Integer qty = Integer.valueOf(txtQty.getText());
            String size = txtPackSize.getText();



            try {
                //boolean isSave = MedicineModel.save(medicine);
                medicineBO.save(id,name,description,price,qty,size);
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
