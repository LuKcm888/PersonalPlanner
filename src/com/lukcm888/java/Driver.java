package com.lukcm888.java;

import com.lukcm888.Util.ApplicationUtilities;

import java.util.Locale;
import java.util.logging.Logger;

import com.lukcm888.dataaccess.dao.GreenActivity;
import com.lukcm888.dataaccess.service.SessionHandler;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import com.lukcm888.dataaccess.service.DataBaseHandler;
import com.lukcm888.dataaccess.service.GetPropValues;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Driver extends Application {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
    private static final String CLASSNAME = Driver.class.getName();

    public static class Display {

        /* Stages */
        private static Stage primaryWindow;
        private static Stage addActivityWindow;
        private static Stage getProgressWindow;

        /* Primary Stage Assets */
        private static Button pw_AddActivityButton;
        private static Button pw_SubmitButton;
        private static BorderPane pw_BorderPane;
        private static GridPane pw_GridPane;
        private static DatePicker checkInDatePicker;
        /* Primary Stage Name Constants */
        private static final String PW_APP_TITLE = "Weekly Planner";
        private static final String TASK = "Task";
        private static final String MONDAY = "Monday";
        private static final String TUESDAY = "Tuesday";
        private static final String WEDNESDAY = "Wednesday";
        private static final String THURSDAY = "Thursday";
        private static final String FRIDAY = "Friday";
        private static final String SATURDAY = "Saturday";
        private static final String SUNDAY = "Sunday";
        private static final String TOTAL_HOURS = "TotalHours";
        private static final String REMOVE_BUTTON_NAME = "";
        private static final String SUBMIT_BUTTON_NAME = "Submit";
        /* Primary Stage Data Constants */
        private static final String NAME = "name";
        private static final String MONDAY_HOUR_LOGGER = "mondayHourLogger";
        private static final String TUESDAY_HOUR_LOGGER = "tuesdayHourLogger";
        private static final String WEDNESDAY_HOUR_LOGGER = "wednesdayHourLogger";
        private static final String THURSDAY_HOUR_LOGGER = "thursdayHourLogger";
        private static final String FRIDAY_HOUR_LOGGER = "fridayHourLogger";
        private static final String SATURDAY_HOUR_LOGGER = "saturdayHourLogger";
        private static final String SUNDAY_HOUR_LOGGER = "sundayHourLogger";
        private static final String TOTAL_HOURS_LOGGER = "totalHoursLogger";
        private static final String REMOVE_BUTTON = "removeButton";
        /* addActivityWindow Constants */
        private static final String ADD_ACTIVITY_WINDOW_NAME = "Add New Activity";
        private static final String ADD_ACTIVITY_BUTTON_NAME = "Add New Activity";
        private static final String ADD_NEW_TASK = "Add New Task";
        private static final TextField aaw_newActivityTextField = new TextField();

        private static Button aaw_NewActivityButton;
        /* loadProgress */
        private static final String GET_PROGRESS_WINDOW_NAME = "Overall Progress";
        private static final String GET_PROGRESS_BUTTON_NAME = "Progress";
        private static final String GET_PROGRESS = "Get Progress";
        private static TableView<GreenActivity> lp_Table = new TableView<>();
        /* add drop data for date range */
        private static Button ld_Get_Progress;
        /* seeActivityStats */
        private static TableView<GreenActivity> pw_WeeklyTable = new TableView<>();
        private static GetPropValues getPropValues;
        private static ObservableList<GreenActivity> activities = FXCollections.observableArrayList();
        public static ObservableList<GreenActivity> getActivities() {
            return activities;
        }
        public static void setActivities(ObservableList<GreenActivity> activities ) {
            Display.activities = activities;
        }

        //private static ObservableList<GreenActivity>  = FXCollections.observableArrayList();

    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        SessionHandler session = new SessionHandler();


        LOGGER.info(CLASSNAME +".start():  Entering method.");
        LOGGER.info(CLASSNAME +".start():  Setting up login window.");
        // Execute code to create login window
        Parent root = FXMLLoader.load(getClass().
                getResource("../resources/LoginWindow.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setTitle("Login");
        primaryStage.show();
        LOGGER.info(CLASSNAME +".start(): about to set data");
        session.getAppSession().setDriver(this);
        LOGGER.info(CLASSNAME +".start(): setDriver: [" + session.getAppSession().getDriver().toString() + "]");
        session.getAppSession().setPrimaryStage(primaryStage);
        LOGGER.info(CLASSNAME +".start(): setPrimaryStage: [" + session.getAppSession().getPrimaryStage().toString() + "]");

    } // End of start()

    public void runMainWindow(Stage primaryStage) {


        Display.primaryWindow = primaryStage;
        LOGGER.info(CLASSNAME+".runMainWindow(): primary stage set");
        Display.primaryWindow.setTitle(Display.PW_APP_TITLE);
        Display.pw_WeeklyTable.setEditable(true);
        LOGGER.info(CLASSNAME+".runMainWindow(): About to make stuff");
        //	Name Column
        TableColumn<GreenActivity, String> taskColumn = new TableColumn<GreenActivity, String>(Display.TASK);
        taskColumn.setMinWidth(100);
        taskColumn.setCellValueFactory(new PropertyValueFactory<>(Display.NAME));
        //	Monday Column
        TableColumn<GreenActivity, String> mondayColumn = new TableColumn<GreenActivity, String>(Display.MONDAY);
        mondayColumn.setMinWidth(100);
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.MONDAY_HOUR_LOGGER));
        //  Tuesday Column
        TableColumn<GreenActivity, String> tuesdayColumn = new TableColumn<GreenActivity, String>(Display.TUESDAY);
        tuesdayColumn.setMinWidth(100);
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.TUESDAY_HOUR_LOGGER));
        //  Wednesday Column
        TableColumn<GreenActivity, String> wednesdayColumn = new TableColumn<GreenActivity, String>(Display.WEDNESDAY);
        wednesdayColumn.setMinWidth(100);
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.WEDNESDAY_HOUR_LOGGER));
        //	Thursday Column
        TableColumn<GreenActivity, String> thursdayColumn = new TableColumn<GreenActivity, String>(Display.THURSDAY);
        thursdayColumn.setMinWidth(100);
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.THURSDAY_HOUR_LOGGER));
        //	Friday Column
        TableColumn<GreenActivity, String> fridayColumn = new TableColumn<GreenActivity, String>(Display.FRIDAY);
        fridayColumn.setMinWidth(100);
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.FRIDAY_HOUR_LOGGER));
        //	Saturday Column
        TableColumn<GreenActivity, String> saturdayColumn = new TableColumn<GreenActivity, String>(Display.SATURDAY);
        saturdayColumn.setMinWidth(100);
        saturdayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.SATURDAY_HOUR_LOGGER));
        //  Sunday Column
        TableColumn<GreenActivity, String> sundayColumn = new TableColumn<GreenActivity, String>(Display.SUNDAY);
        sundayColumn.setMinWidth(100);
        sundayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.SUNDAY_HOUR_LOGGER));
        //  Total Hours Column
        TableColumn<GreenActivity, String> totalHoursColumn = new TableColumn<GreenActivity, String>(Display.TOTAL_HOURS);
        totalHoursColumn.setMinWidth(100);
        totalHoursColumn.setCellValueFactory(new PropertyValueFactory<>(Display.TOTAL_HOURS_LOGGER));
        //  RemoveButton Column
        TableColumn<GreenActivity, String> RemoveButtonColumn = new TableColumn<GreenActivity, String>(Display.REMOVE_BUTTON_NAME);
        RemoveButtonColumn.setMinWidth(100);
        RemoveButtonColumn.setCellValueFactory(new PropertyValueFactory<>(Display.REMOVE_BUTTON));
        // Create tableview to add to menu
        Display.pw_WeeklyTable.setItems(Display.activities);
        Display.pw_WeeklyTable.getColumns().addAll(taskColumn, mondayColumn, tuesdayColumn, wednesdayColumn, thursdayColumn,
                fridayColumn, saturdayColumn, sundayColumn, RemoveButtonColumn);


        //  TODO:  Initialize the activities list based on the data from the account and what is in the database!

        // Call Data Base Handler class method init activities based on

        /**
         *   Add Activity Button Logic
         *
         *  Calls runAddAcitivityWindow()
         */
        Display.pw_AddActivityButton = new Button(Display.ADD_ACTIVITY_BUTTON_NAME);
        Display.pw_AddActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                runAddActivityWindow();
            }
        }); // End Add Activity Button Logic

        /**
         *  Get Progress Button Logic
         *
         *  Calls runGetProgressWindow()
         */
        Display.ld_Get_Progress = new Button(Display.GET_PROGRESS);
        Display.ld_Get_Progress.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                runGetProgressWindow();
            }
        }); // End Get Progress Button Logic

        /**
         *   Submit Button logic:
         *
         *   The submit button will send the activities that are currently added to the
         *   user primaryWindow to the database
         *   TODO:  Determine if a new pw_WeeklyTable will be needed for every week that is added to the database.
         * */
        Display.pw_SubmitButton = new Button(Display.SUBMIT_BUTTON_NAME);
        Display.pw_SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ArrayList<GreenActivity> sqlGreenAcitivityList = new ArrayList<GreenActivity>();
                for (int i = 0; i < Display.activities.size(); i++) {
                    // Check to see if values entered are numeric
                    GreenActivity tempActivity = Display.activities.get(i);
                    tempActivity.loadWeeklyHours();
                    if (ApplicationUtilities.isNumeric(tempActivity.getWeeklyHoursList())) {
                        tempActivity.sumHours(tempActivity.getWeeklyHoursList());
                        sqlGreenAcitivityList.add(tempActivity);
                    } else {
                        System.out.println("could not submit data: totalHours must be in numeric format!");
                    }
                    System.out.println(tempActivity.getMondayHourLogger().getText());
                    System.out.println(tempActivity.getTuesdayHourLogger().getText());
                    System.out.println(tempActivity.getWednesdayHourLogger().getText());
                    System.out.println(tempActivity.getThursdayHourLogger().getText());
                    System.out.println(tempActivity.getFridayHourLogger().getText());
                    System.out.println(tempActivity.getSaturdayHourLogger().getText());
                    System.out.println(tempActivity.getSundayHourLogger().getText());
                    Display.getPropValues = new GetPropValues();
                    /* Test to get print username and password from config file*/
                }
                try {
                    //System.out.println(Display.getPropValues.getUserName());
                    //System.out.println(Display.getPropValues.getPassword());
                    DataBaseHandler db = new DataBaseHandler();
                    db.insertHours(sqlGreenAcitivityList);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }); // End Submit Button Logic
        Display.checkInDatePicker = new DatePicker();
        Display.pw_BorderPane = new BorderPane();
        Display.pw_GridPane = new GridPane();
        Display.pw_BorderPane.setCenter(Display.pw_WeeklyTable);
        Display.pw_GridPane = new GridPane();
        Display.pw_GridPane.add(Display.pw_AddActivityButton, 0, 0);
        Display.pw_GridPane.add(Display.ld_Get_Progress, 0, 1);
        Display.pw_GridPane.add(Display.checkInDatePicker, 0, 2);
        Display.pw_BorderPane.setLeft(Display.pw_GridPane);
        Display.pw_BorderPane.setBottom(Display.pw_SubmitButton);
        Scene scene = new Scene(Display.pw_BorderPane);
        Display.primaryWindow.setScene(scene);
        Display.primaryWindow.setOnHidden(e -> Platform.exit());
        Display.primaryWindow.show();

    } // End of runMainWindow()

    /**
     *   runAddActivityWindow
     *
     *   runAddActivityWindow generates a window to add text bod
     *   that the user can enter their data into.
     *   Also, the pw_AddActivityButton contains the setOnAction logic for the aaw_NewActivityButton
     *   (the submit button for  the newActivityWindow.
     *   TODO: Come up with better names for these variables.  The current ones are confusing.
     */
    public void runAddActivityWindow() {
        LOGGER.info(CLASSNAME+".runAddAcitivityWindow(): Entering Method");
        Display.addActivityWindow = new Stage();
        Display.addActivityWindow.setTitle(Display.ADD_ACTIVITY_WINDOW_NAME);
        Display.aaw_NewActivityButton = new Button(Display.ADD_NEW_TASK);
        GridPane addActivityWindowGridPane = new GridPane();
        addActivityWindowGridPane.add(Display.aaw_NewActivityButton, 0, 0);
        addActivityWindowGridPane.add(Display.aaw_newActivityTextField, 1, 0);
        Scene addActivityWindowScene = new Scene(addActivityWindowGridPane);
        Display.addActivityWindow.setScene(addActivityWindowScene);
        Display.addActivityWindow.initModality(Modality.WINDOW_MODAL);
        Display.addActivityWindow.initOwner(Display.primaryWindow);
        Display.addActivityWindow.setX(Display.primaryWindow.getX() + 100);
        Display.addActivityWindow.setY(Display.primaryWindow.getY());
        Display.addActivityWindow.setOnHidden(e -> System.out.println("Window-level cleanup"));
        Display.addActivityWindow.show();
        Display.aaw_NewActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    System.out.println("New Activity submission value is " +
                            "[" + Display.aaw_newActivityTextField.getText() + "]");
                    if (!("").equalsIgnoreCase(Display.aaw_newActivityTextField.getText())
                            && Display.aaw_newActivityTextField.getText() != null) {
                        Display.activities.add(new GreenActivity(Display.aaw_newActivityTextField.getText(),
                                20, "coding"));
                        System.out.println("submitted: " + "[" + Display.aaw_newActivityTextField.getText() + "]");
                        Display.aaw_newActivityTextField.clear();
                        Display.addActivityWindow.close();
                    } else {
                        System.out.println("Empty string");
                    }
                } catch (Exception e) {
                    System.out.println("An exception occured when trying to add a new" +
                            " activity to the scheduele");
                }
            }
        });
        LOGGER.info(CLASSNAME+".runAddAcitivityWindow(): Exiting Method");
    } // End of runAddAcitivityWindow

    /**
     *  runGetProgressWindow()
     *
     * Prompts user to enter in a date range to load the activity data of that week
     * Will call dataaccess and backend to get the specific week
     *
     */
    public void runGetProgressWindow() {
        LOGGER.info(CLASSNAME+".runAddAcitivityWindow(): Entering Method");
        Display.getProgressWindow = new Stage();
        Display.getProgressWindow.setTitle(Display.GET_PROGRESS_WINDOW_NAME);
        Display.getProgressWindow.setX(Display.primaryWindow.getX() + 100);
        Display.getProgressWindow.setY(Display.primaryWindow.getY());


        Display.lp_Table.setEditable(true);





        Display.getProgressWindow.setOnHidden(e -> System.out.println("Window-level cleanup"));
        Display.getProgressWindow.show();

        LOGGER.info(CLASSNAME+".runAddAcitivityWindow(): Exiting Method");
    }

    public ObservableList<GreenActivity> getActivities() {
        return Display.activities;
    }

   /* public void setActivities (ObservableList<GreenActivity> activities ) {
        this.activities = activities;
    }*/


}