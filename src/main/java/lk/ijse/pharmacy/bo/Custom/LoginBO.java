package lk.ijse.pharmacy.bo.Custom;

import javafx.event.ActionEvent;
import lk.ijse.pharmacy.bo.SuperBO;

import java.io.IOException;

public interface LoginBO extends SuperBO {
    public boolean btnOnAction(javafx.event.ActionEvent actionEvent) throws IOException;
    public boolean btnForgotPasswordOnAction(ActionEvent actionEvent) throws IOException;
    public boolean btnSignupOnAction(ActionEvent actionEvent) throws IOException ;

}
