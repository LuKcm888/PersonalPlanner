package com.lukcm888.java.controllers;

import com.lukcm888.java.Driver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.logging.Logger;

public class MainWindowController {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private static final String CLASSNAME = LoginWindowController.class.getName();

    @FXML
    protected void handleAddActivityButtonAction(ActionEvent event) {

        LOGGER.info(CLASSNAME+".runMainWindow(): Entering Method");

    }
}
