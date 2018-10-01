package com.lukcm888.planner;

import com.lukcm888.Util.ApplicationUtilities;


import com.lukcm888.dataaccess.DataBaseInteraction;
import com.lukcm888.dataaccess.GetPropValues;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Driver extends Application {

    //TODO: Implement a logger for debugging!

    public static class Display {

        private static Stage loginInWindow;
        private static GridPane liw_gridPane;
        private static TextField liw_UsernameTextField;
        private static TextField liw_PasswordTextField;
        private static Button liw_SubmitButton;


        private static Stage primaryWindow;
        private static Stage addActivityWindow;
        private static Button pw_AddActivityButton;
        private static Button pw_SubmitButton;
        private static BorderPane pw_BorderPane;



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


        private static TableView<GreenActivity> pw_WeeklyTable = new TableView<>();
        private static GetPropValues getPropValues;



        private static ObservableList<GreenActivity> activities = FXCollections.observableArrayList();


        public static ObservableList<GreenActivity> getActivities() {

            return activities;
        }

        public static void setActivities(ObservableList<GreenActivity> activities ) {
            Display.activities = activities;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Display.loginInWindow = primaryStage;
        Display.loginInWindow.setTitle(Display.PW_APP_TITLE);
        Display.liw_gridPane = new GridPane();

        Display.liw_UsernameTextField = new TextField();
        Display.liw_PasswordTextField = new TextField();

        Display.liw_SubmitButton = new Button("Submit Credentials");
        Display.liw_gridPane.add(Display.liw_UsernameTextField, 0, 0);
        Display.liw_gridPane.add(Display.liw_PasswordTextField, 0, 1);
        Display.liw_gridPane.add(Display.liw_SubmitButton, 0, 2);
        Scene liw_WindowScene = new Scene(Display.liw_gridPane);
        Display.loginInWindow.setScene(liw_WindowScene);

        Display.loginInWindow.setOnHidden(e -> Platform.exit());
        Display.loginInWindow.show();

        Display.liw_SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {

                    if (("admin").equalsIgnoreCase(Display.liw_UsernameTextField.getText()) &&
                            ("password").equalsIgnoreCase(Display.liw_PasswordTextField.getText())) {

                        runMainWindow(primaryStage);

                        Display.liw_UsernameTextField.clear();
                        Display.liw_PasswordTextField.clear();
                    } else {
                        System.out.println("Empty string");
                    }

                } catch (Exception e) {
                    System.out.println("An exception occured when trying to add a new" +
                            " activity to the schduele");
                }
            }
        });



    }


    public void runMainWindow(Stage primaryStage) {

        System.out.println("running main window");
        Display.primaryWindow = primaryStage;
        Display.primaryWindow.setTitle(Display.PW_APP_TITLE);

        Display.pw_WeeklyTable.setEditable(true);

        //	Name Column
        TableColumn<GreenActivity, String> taskColumn = new TableColumn<GreenActivity, String>(Display.TASK);
        taskColumn.setMinWidth(100);
        taskColumn.setCellValueFactory(new PropertyValueFactory<>(Display.NAME));

        //	Monday Column
        TableColumn<GreenActivity, String> mondayColumn = new TableColumn<GreenActivity, String>(Display.MONDAY);
        mondayColumn.setMinWidth(100);
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.MONDAY_HOUR_LOGGER));

        //	Tuesday Column
        TableColumn<GreenActivity, String> tuesdayColumn = new TableColumn<GreenActivity, String>(Display.TUESDAY);
        tuesdayColumn.setMinWidth(100);
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>(Display.TUESDAY_HOUR_LOGGER));

        // Wednesday Column
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


        /*
         *   Add Activity Button Logic
         *
         *   When clicked, the add activity button will open a window that will prompt the user
         *   to add a new activity to the calender.  This setOnAction also creates the window
         *   (currently called the "addActivityWindow") which generates the window and text bod
         *   that the user can enter their data into.
         *
         *   Also, the pw_AddActivityButton contains the setOnAction logic for the aaw_NewActivityButton
         *   (the submit button for  the newActivityWindow.
         *
         *   TODO: Come up with better names for these variables.  The current ones are confusing.
         *
         *
         */
        Display.pw_AddActivityButton = new Button(Display.ADD_ACTIVITY_BUTTON_NAME);
        Display.pw_AddActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                runAddAcitivityWindow();

            }
        });


        /*
         *   Submit Button logic:
         *
         *   The submit button will send the activities that are currently added to the
         *   user primaryWindow to the database
         *   TODO:  Determine if a new pw_WeeklyTable will be needed for every week that is
         *   added to the database.
         * */
        Display.pw_SubmitButton = new Button();
        Display.pw_SubmitButton.setText(Display.SUBMIT_BUTTON_NAME);
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
                    DataBaseInteraction db = new DataBaseInteraction();

                    db.insertHours(sqlGreenAcitivityList);

                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

        Display.pw_BorderPane = new BorderPane();
        Display.pw_BorderPane.setCenter(Display.pw_WeeklyTable);
        Display.pw_BorderPane.setLeft(Display.pw_AddActivityButton);

        Display.pw_BorderPane.setBottom(Display.pw_SubmitButton);

        Scene scene = new Scene(Display.pw_BorderPane);

        Display.primaryWindow.setScene(scene);
        Display.primaryWindow.setOnHidden(e -> Platform.exit());
        Display.primaryWindow.show();
    }


    public void runAddAcitivityWindow() {

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

        Display.addActivityWindow.setX(Display.primaryWindow.getX() + 500);
        Display.addActivityWindow.setY(Display.primaryWindow.getY());

        Display.addActivityWindow.setOnHidden(e -> System.out.println("Window-level cleanup"));
        Display.addActivityWindow.show();


        Display.aaw_NewActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {

                    System.out.println("New Activity submission value is " + "[" + Display.aaw_newActivityTextField.getText() + "]");
                    if (!("").equalsIgnoreCase(Display.aaw_newActivityTextField.getText()) && Display.aaw_newActivityTextField.getText() != null) {


                        Display.activities.add(new GreenActivity(Display.aaw_newActivityTextField.getText(), 20, "coding"));


                        System.out.println("submitted: " + "[" + Display.aaw_newActivityTextField.getText() + "]");
                        Display.aaw_newActivityTextField.clear();
                        Display.addActivityWindow.close();
                    } else {
                        System.out.println("Empty string");
                    }

                } catch (Exception e) {
                    System.out.println("An exception occured when trying to add a new" +
                            " activity to the schduele");
                }
            }
        });



    }

    public ObservableList<GreenActivity> getActivities() {
        return Display.activities;
    }

   /* public void setActivities (ObservableList<GreenActivity> activities ) {
        this.activities = activities;
    }*/


}