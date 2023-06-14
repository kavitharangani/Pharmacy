package lk.ijse.pharmacy.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pharmacy.bo.BOFactory;
import lk.ijse.pharmacy.bo.Custom.AttendanceBO;
import lk.ijse.pharmacy.bo.Custom.EmployeeBO;
import lk.ijse.pharmacy.bo.Custom.Impl.EmployeeBOImpl;
import lk.ijse.pharmacy.model.AttendanceDTO;
import lk.ijse.pharmacy.model.AttendanceTm;
import lk.ijse.pharmacy.model.EmployeesDTO;
import lk.ijse.pharmacy.model.OrderTm;


import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class AttendanceFromController implements Initializable {

    public ToggleGroup btnGroup;
    @FXML
    private TableColumn<?, ?> tblId;

    @FXML
    private TableColumn<?, ?> tblDate;

    @FXML
    private TableColumn<?, ?> tblTime;

    @FXML
    private TableColumn<?, ?> tblAttendens;

    @FXML
    private Label lblName;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblTime;

    @FXML
    private TextField txtDate;

    @FXML
    private ComboBox<?> txtAttendance;

    @FXML
    private ComboBox<String> txtEmployeeId;

    @FXML
    private TableView<AttendanceTm> tblAttendens01;

    @FXML
    private ComboBox<String> txtEmployeeName;

    private ObservableList<OrderTm> obList = FXCollections.observableArrayList();
    private java.awt.Label txtEmID;
    private JFXPanel root;

    AttendanceBO attendanceBO = (AttendanceBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ATTENDANCE);
    EmployeeBO employeeBO = new EmployeeBOImpl();

    @FXML
    void btnSaveOnAction(ActionEvent event) throws ParseException {
        String id = txtEmployeeId.getSelectionModel().getSelectedItem();
        RadioButton selectedButton = (RadioButton)btnGroup.getSelectedToggle();
        String text = selectedButton.getText();
        String date = String.valueOf(LocalDate.now());
        String time = String.valueOf(LocalTime.now());

        ObservableList<AttendanceTm> obList = FXCollections.observableArrayList();
        AttendanceTm tm = new AttendanceTm(id,date,time,text);
        obList.add(tm);
        tblAttendens01.setItems(obList);

        AttendanceDTO attendance= new AttendanceDTO(id,date,text);
        try {
           boolean isSave = attendanceBO.save(attendance);
            if (isSave){
                new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cbmIdOnAction(ActionEvent event) {
        String id = txtEmployeeId.getSelectionModel().getSelectedItem();

        try {
            EmployeesDTO employee = employeeBO.search(id);

            lblName.setText((String) employee.getEmployeeName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadEmployeeId();
 //       loadAttendance();
        loadDateAndTime();
        setvaluefortable();
    }

    private void setvaluefortable() {
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tblAttendens.setCellValueFactory(new PropertyValueFactory<>("attendance"));
    }

    private void loadDateAndTime() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
        lblTime.setText(String.valueOf(LocalTime.now()));
    }


//    private void loadAttendance() {
//        ObservableList<String> obList= FXCollections.observableArrayList();
//        List<String> names= attendanceBO.generateEmployeeAttendance();
//
//        for (String name : names){
//            obList.add(name);
//        }
//    }

    private void loadEmployeeId() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> ids = employeeBO.generateEmployeeId();

            for (String id : ids) {
                obList.add(id);
            }
            txtEmployeeId.setItems(obList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}