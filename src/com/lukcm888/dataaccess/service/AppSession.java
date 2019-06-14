package com.lukcm888.dataaccess.service;


import com.lukcm888.java.Driver;
import javafx.stage.Stage;

public class AppSession {

    private Stage primaryStage;

    private Driver driver;

    public Stage getPrimaryStage() {

        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Driver getDriver() {

        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
