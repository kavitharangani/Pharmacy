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
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.model.CartPlaceOrderDTO;
import lk.ijse.pharmacy.model.MedicineDTO;
import lk.ijse.pharmacy.jhj.*;
import lk.ijse.pharmacy.model.OrderTm;
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

public class PlaceOrderFromController implements Initializable {

    public JFXTextField txtQty1;

    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> txtCustomerId;

    @FXML
    private Button txtnew;

    @FXML
    private ComboBox<String> txtMeId;

    @FXML
    private Button txtQty;

    @FXML
    private TableView<OrderTm> tblOrderCart;

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
    private Label lblOrderDate;

    @FXML
    private Label lblTime;


    @FXML
    private Label orderIdtxt;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblDiscription;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblqty;

    private ObservableList<OrderTm> obList = FXCollections.observableArrayList();

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String code =txtMeId.getSelectionModel().getSelectedItem();
        String description = lblDiscription.getText();
        Integer qty = Integer.valueOf(txtQty1.getText());
        Double unitPrice= Double.valueOf(lblUnitPrice.getText());
        Double tot =qty * unitPrice;
        Button btn = new Button("REMOVE");


        setRemoveBtnOnAction(btn);
        OrderTm tm=new OrderTm(code,description,qty,unitPrice,tot,btn);


        obList.add(tm);
        tblOrderCart.setItems(obList);

        netTotal();

        txtQty1.setText("");

    }
    private void setRemoveBtnOnAction(Button btn) {

        btn.setOnAction((e)->{
            ButtonType yes = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> buttonType = new Alert(Alert.AlertType.INFORMATION, "ARE YOU SURE REMOVE THIS MATTIRIAL",yes,no).showAndWait();

            if (buttonType.orElse(no) == yes){
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
        Stage stage =(Stage) root.getScene().getWindow();
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

        String CustomerId = String.valueOf(txtCustomerId.getSelectionModel().getSelectedItem());
        String OrderId = orderIdtxt.getText();
        double total = Double.parseDouble(lblNetTotal.getText());

        System.out.println(OrderId);
        List<CartPlaceOrderDTO>dtoList = new ArrayList<>();
        for (int i = 0; i < tblOrderCart.getItems().size(); i++) {
            OrderTm tm = obList.get(i);

            CartPlaceOrderDTO cartSuppliesDto = new CartPlaceOrderDTO(tm.getCode(), tm.getQty());

            dtoList.add(cartSuppliesDto);
        }

        try {
            boolean isSave = PlaceOrderModel.save(CustomerId,OrderId,total,dtoList);
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"PLACED SUPPLIES").show();
                addBill();
            }
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }

    private void addBill() throws JRException, SQLException {
        String id = orderIdtxt.getText();
        JasperDesign load = null;
        load = JRXmlLoader.load(new File("E:\\KaviProject\\src\\main\\resources\\report\\newReport.jrxml"));
        JRDesignQuery newQuery = new JRDesignQuery();
        String sql = "select i.description as name,i.unitPrice as unitPrice,oi.orderQTY , i.unitPrice*oi.orderQTY as subTotal  from medicine i inner join orderdetail oi on  i.mediCode=oi.medicode where oi.orderId = '"+id+"'";
        newQuery.setText(sql);
        load.setQuery(newQuery);
        JasperReport js = JasperCompileManager.compileReport(load);
        HashMap<String,Object> hm=new HashMap<>();
        hm.put("pharmacyOrder","Name");
        hm.put("orderId","O001");
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
        String id = txtMeId.getSelectionModel().getSelectedItem();

        try {
            MedicineDTO medicine = MedicineModel.search(id);

            lblDiscription.setText(medicine.getDescription());
            lblUnitPrice.setText(String.valueOf(medicine.getUnitPrize()));
            lblqty.setText(String.valueOf(medicine.getQtyOnStock()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    void setCellValueFactory() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadMedicineId();
        loadCustomerId();
        setCellValueFactory();
        generateNextOrderId();
        loadDateAndTime();
    }
    private void loadMedicineId() {
        ObservableList<String> obList= FXCollections.observableArrayList();
        try {
            List<String> ids= MedicineModel.generateMedicineId();

            for (String id : ids){
                obList.add(id);
            }
            txtMeId.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void loadCustomerId() {
        ObservableList<String>obList=FXCollections.observableArrayList();
        try {
            List<String>ids= CustomerModel.getIds();

            for (String id : ids){
                obList.add(id);
            }

            txtCustomerId.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void generateNextOrderId() {
        try {
            String nextId = OrderModel.generateNextOrderId();
            orderIdtxt.setText(nextId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDateAndTime() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
        lblTime.setText(String.valueOf(LocalTime.now()));
    }

}
