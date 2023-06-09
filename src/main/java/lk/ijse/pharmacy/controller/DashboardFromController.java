package lk.ijse.pharmacy.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pharmacy.bo.Custom.CustomerBO;
import lk.ijse.pharmacy.bo.Custom.Impl.CustomerBOImpl;
import lk.ijse.pharmacy.bo.Custom.Impl.MedicineBOImpl;
import lk.ijse.pharmacy.bo.Custom.Impl.OrderBOImpl;
import lk.ijse.pharmacy.bo.Custom.MedicineBO;
import lk.ijse.pharmacy.bo.Custom.OrderBO;
import lk.ijse.pharmacy.dao.Custom.Impl.CustomerDAOImpl;
import lk.ijse.pharmacy.dao.Custom.Impl.MedicineDAOImpl;
import lk.ijse.pharmacy.dao.Custom.Impl.OrderDAOImpl;
import lk.ijse.pharmacy.entity.Medicine;
import lk.ijse.pharmacy.entity.Supplier;
import lk.ijse.pharmacy.model.CustomersDTO;
import lk.ijse.pharmacy.model.MedicineDTO;
import lk.ijse.pharmacy.model.OrderTm;


import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class DashboardFromController {

    @FXML
    private Label lblTotalSales;

    @FXML
    private Label lblTotalCustomer;

    @FXML
    private Label lblTotalOrders;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane LoadContext;

    @FXML
    private Label lblTotalMedicine;

    @FXML
    private Label lblMonthlyOrders;

    private PlaceSupplierFromController clmDate;
    private PlaceSupplierFromController clmIncome;
    private ChoiceBox tblIncome;
    private Object SalesModel;

    @FXML
    public void initialize(){

        try {
            int customerCount = CustomerDAOImpl.countCustomers();
            int countOrders = OrderDAOImpl.countOrders();
            double totalOrderSales = OrderDAOImpl.getTotalOrderSales();
            int medicineCount= MedicineDAOImpl.countMedicines();
            double totalMonthlySales = OrderDAOImpl.getTotalOrderSales();

            lblTotalCustomer.setText(String.valueOf(customerCount));
            lblTotalOrders.setText(String.valueOf(countOrders));
            lblTotalSales.setText(String.valueOf(totalOrderSales));
            lblTotalMedicine.setText(String.valueOf(medicineCount));
            lblMonthlyOrders.setText(String.valueOf(totalMonthlySales));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnOnWhatsappAction(ActionEvent event) {
        try {
           java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.whatsapp.com/");
           desktop.browse(uri);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    @FXML
    void btnOnFaceBookAction(ActionEvent event) {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.facebook.com/");
            desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void btnOnTwitterAction(ActionEvent event) {
       try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.twitter.com/");
           desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void btnOnInsterAction(ActionEvent event) {
        try {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            URI uri = new URI("https://www.instagram.com/");
            desktop.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/customer_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/employee_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnMedicineOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/medicine_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/placeOrder_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnSupplierOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/supplier_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnPlaceSupplierOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/placeSupplier_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);

    }

    public void btnAttendanceOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/view/attendance_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        LoadContext.getChildren().clear();
        LoadContext.getChildren().add(load);
    }

    public void btnhomeOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_from.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage =(Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("/view/dashboard_from.fxml");
        stage.centerOnScreen();
    }
    @FXML
    void btnLgoutOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage =(Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("/view/login_form.fxml");
        stage.centerOnScreen();
    }
}
