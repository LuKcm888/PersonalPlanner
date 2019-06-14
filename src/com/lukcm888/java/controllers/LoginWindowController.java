package com.lukcm888.java.controllers;

import com.lukcm888.java.Driver;
import com.lukcm888.dataaccess.service.SessionHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class LoginWindowController {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private static final String CLASSNAME = LoginWindowController.class.getName();

    @FXML private Text actiontarget;

    @FXML TextField userName;

    @FXML TextField passwordField;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {

        LOGGER.info(CLASSNAME +".handleSubmitButtonAction(): Entering method.");
        actiontarget.setText("Sign in button pressed");

        System.out.println(userName.getText());
        System.out.println(passwordField.getText());

        SessionHandler session = new SessionHandler();

        Stage primaryStage = session.getAppSession().getPrimaryStage();
        LOGGER.info(CLASSNAME +".handleSubmitButtonAction(): getPrimaryStage: [" + primaryStage + "]");

        Driver driver = session.getAppSession().getDriver();
        LOGGER.info(CLASSNAME +".handleSubmitButtonAction(): getDriver: [" + driver+ "]");


        try {
            if (("admin").equalsIgnoreCase(userName.getText()) &&
                    ("password").equalsIgnoreCase(passwordField.getText())) {

                LOGGER.info(
                        CLASSNAME +".handleSubmitButtonAction(): About to call primary stage.");

                Parent root = FXMLLoader.load(getClass().getResource("../../resources/MainWindow.fxml"));
                primaryStage.setScene(new Scene(root, 600, 475));
                primaryStage.setTitle("Weekly Planner");
                primaryStage.show();
                LOGGER.info(CLASSNAME + ".handleSubmitButtonAction(): Clearing username and password fields.");
                userName.clear();
                passwordField.clear();
                LOGGER.info(CLASSNAME + ".handleSubmitButtonAction(): Exiting method.");
            } else {
                LOGGER.info(CLASSNAME +".handleSubmitButtonAction(): Invalid login.");
            }
        } catch (Exception e) {
            LOGGER.info(CLASSNAME +".handleSubmitButtonAction(): \"An exception occurred: " + e);
        }
    }
}
