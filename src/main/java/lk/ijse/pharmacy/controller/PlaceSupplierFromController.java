package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pharmacy.bo.Custom.CustomerBO;
import lk.ijse.pharmacy.bo.Custom.Impl.*;
import lk.ijse.pharmacy.bo.Custom.MedicineBO;
import lk.ijse.pharmacy.bo.Custom.SupplierBO;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.model.MedicineDTO;
import lk.ijse.pharmacy.model.SuppliyerTm;
import lombok.SneakyThrows;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class PlaceSupplierFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label orderIdtxt;

    @FXML
    private TableView<SuppliyerTm> tblOrderCart;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colAction;



    @FXML
    private Label OrderDate;

    @FXML
    private JFXTextField txtQty1;

    @FXML
    private Button txtnew;

    @FXML
    private ComboBox<String> txtSuppId;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblqty;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblDiscription;

    @FXML
    private ComboBox<String> txtMeId;


    private ObservableList<SuppliyerTm> obList = FXCollections.observableArrayList();
       MedicineBO medicineBO = new MedicineBOImpl();
//      CustomerBO customerBO = new CustomerBOImpl();
//      SupplierBO supplierBO = new SupplierBOImpl();
    PurchaseSupplierBOImpl purchaseSupplierBO = new PurchaseSupplierBOImpl();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

        String code = txtMeId.getSelectionModel().getSelectedItem();
        String description = lblDiscription.getText();
        Integer qty = Integer.valueOf(txtQty1.getText());
        Double unitPrice = Double.valueOf(lblUnitPrice.getText());
        Double tot = qty * unitPrice;
        Button btn = new Button("REMOVE");

        setRemoveBtnOnAction(btn);
        SuppliyerTm tm = new SuppliyerTm(code, description, qty, unitPrice, tot, btn);
        System.out.println(code+description+qty+unitPrice+tot);

        obList.add(tm);
        tblOrderCart.setItems(obList);

        netTotal();

        txtQty1.setText("");

    }

    private void setRemoveBtnOnAction(Button btn) {

        btn.setOnAction((e) -> {
            ButtonType yes = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.INFORMATION, "ARE YOU SURE REMOVE THIS MATTIRIAL", yes, no).showAndWait();

            if (buttonType.orElse(no) == yes) {
                obList.remove(tblOrderCart.getSelectionModel().getSelectedItem());
                tblOrderCart.refresh();
                netTotal();
            }
        });
    }

    private void netTotal() {
        double netTotal = 0.0;
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            double total  = (double) colTotal.getCellData(i);
            netTotal += total;
        }
        lblNetTotal.setText(String.valueOf(netTotal));
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_from.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("/view/dashboard_from.fxml");
        stage.centerOnScreen();
    }

    @FXML
    void btnNewOnAction(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("/view/customer_from.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        root.getChildren().clear();
        root.getChildren().add(load);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

        String CustomerId = String.valueOf(txtSuppId.getSelectionModel().getSelectedItem());
        String OrderId = orderIdtxt.getText();
        double total = Double.parseDouble(lblNetTotal.getText());

        List<CartPlaceOrderDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            SuppliyerTm tm = obList.get(i);

            CartPlaceOrderDTO cartSuppliesDtokavi = new CartPlaceOrderDTO(tm.getCode(), tm.getQty());

            dtoList.add(cartSuppliesDtokavi);
        }

        try {
            boolean isSave = purchaseSupplierBO.save(CustomerId, OrderId, total, dtoList);
            if (isSave) {
                new Alert(Alert.AlertType.CONFIRMATION, "PLACED SUPPLIES").show();
                addBill();
            }
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }

    private void addBill() throws JRException, SQLException {
        String id = orderIdtxt.getText();
        JasperDesign load = null;
        load = JRXmlLoader.load(new File("D:\\2nd Semester\\Pharmacy\\src\\main\\resources\\report\\supplierReport.jrxml"));
        JRDesignQuery newQuery = new JRDesignQuery();
        String sql = "select i.description as name,i.unitPrice as unitPrice,oi.orderQTY , i.unitPrice*oi.orderQTY as subTotal  from medicine i inner join supplieorderdetail oi on  i.mediCode=oi.medicode where oi.suppliesOrderId = '"+id+"'";
        newQuery.setText(sql);
        load.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(load);
        HashMap<String,Object> hm=new HashMap<>();
        hm.put("pha","Name");
        //hm.put("orderId","O001");
        JasperPrint jp = JasperFillManager.fillReport(js, null, DBConnection.getInstance().getConnection());
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();

        lblDiscription.setText("");
        txtQty1.setText("");
        lblUnitPrice.setText("");
        lblqty.setText("");
        lblNetTotal.setText("");
    }


    @FXML
    void cmbCusIdOnAction(ActionEvent event) {


    }

    @FXML
    void cmbMeIdOnAction(ActionEvent event) {
        String id = (String) txtMeId.getSelectionModel().getSelectedItem();

        try {
            MedicineDTO medicine = medicineBO.search(id);

            lblDiscription.setText(medicine.getDescription());
            lblUnitPrice.setText(String.valueOf(medicine.getUnitPrize()));
            lblqty.setText(String.valueOf(medicine.getQtyOnStock()));

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR).show();
        }

    }

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
          loadMedicineId();
          loadSupplierId();
          setCellValueFactory();
          generateNextOrderId();
          loadDateAndTime();
    }

    void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    private void loadDateAndTime() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
        lblTime.setText(String.valueOf(LocalTime.now()));
    }

    private void loadMedicineId() throws SQLException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        List<String> ids = null;
        ids = purchaseSupplierBO.generateMedicineId();

        for (String id : ids) {
            obList.add(id);
        }
        txtMeId.setItems(obList);

    }

    private void loadSupplierId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> ids = purchaseSupplierBO.getIds();

            for (String id : ids) {
                obList.add(id);
            }

            txtSuppId.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void generateNextOrderId()  {
        String nextId = null;
        try {
            nextId = purchaseSupplierBO.generateNextOrderId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        orderIdtxt.setText(nextId);
    }

    public void cmbIdOnAction(ActionEvent actionEvent) {
        String id = txtMeId.getSelectionModel().getSelectedItem();

        try {
            MedicineDTO medicine = medicineBO.search(id);

            lblDiscription.setText(medicine.getDescription());
            lblUnitPrice.setText(String.valueOf(medicine.getUnitPrize()));
            lblqty.setText(String.valueOf(medicine.getQtyOnStock()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
