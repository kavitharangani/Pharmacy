package lk.ijse.pharmacy.bo.Custom.Impl;

import javafx.event.ActionEvent;
import lk.ijse.pharmacy.bo.Custom.LoginBO;
import lk.ijse.pharmacy.bo.SuperBO;
import lk.ijse.pharmacy.dao.Custom.LoginDAO;
import lk.ijse.pharmacy.dao.DAOFactory;

import java.io.IOException;

public class LogingBOImpl implements LoginBO,SuperBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.daoFactory().getDAO(DAOFactory.DAOTypes.LOGIN);

    @Override
    public boolean btnOnAction(ActionEvent actionEvent) throws IOException {
        return false;
    }

    @Override
    public boolean btnForgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        return false;
    }

    @Override
    public boolean btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        return false;
    }
}
