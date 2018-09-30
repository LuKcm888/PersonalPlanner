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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends Application {

    //TODO: Implement a logger for debugging!

    public static class Display {

        private static Stage primaryWindow;
        private static Stage addActivityWindow;
        private static Button addActivityButton;
        private static Button submitButton;

        /* Primary Stage Name Constants */
        private static final String APP_TITLE = "Weekly Planner";
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
        private static final String NEW_TASK_NAME = "newTaskName";
        private static final String ADD_NEW_TASK = "Add New Task";
        private static final TextField newActivityTextField = new TextField();
        private static Button newActivityButton;


        private static TableView<GreenActivity> weeklyTable = new TableView<>();
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



        Display.primaryWindow = primaryStage;
        Display.primaryWindow.setTitle(Display.APP_TITLE);

        Display.weeklyTable.setEditable(true);
        
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

        Display.weeklyTable.setItems(Display.activities);

        Display.weeklyTable.getColumns().addAll(taskColumn ,mondayColumn, tuesdayColumn, wednesdayColumn, thursdayColumn,
        		fridayColumn, saturdayColumn, sundayColumn, RemoveButtonColumn);


        /*
        *   Add Activity Button Logic
        *
        *   When clicked, the add activity button will open a window that will prompt the user
        *   to add a new activity to the calender.  This setOnAction also creates the window
        *   (currently called the "addActivityWindow") which generates the window and text bod
        *   that the user can enter their data into.
        *
        *   Also, the addActivityButton contains the setOnAction logic for the newActivityButton
        *   (the submit button for  the newActivityWindow.
        *
        *   TODO: Come up with better names for these variables.  The current ones are confusing.
        *
        *
        */
        Display.addActivityButton = new Button(Display.ADD_ACTIVITY_BUTTON_NAME);
        Display.addActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Display.addActivityWindow = new Stage();
                Display.addActivityWindow.setTitle(Display.ADD_ACTIVITY_WINDOW_NAME);


                Display.newActivityButton = new Button(Display.ADD_NEW_TASK);

                GridPane addActivityWindowGridPane = new GridPane();
                addActivityWindowGridPane.add(Display.newActivityButton,0, 0);
                addActivityWindowGridPane.add(Display.newActivityTextField,1,0);
                Scene addActivityWindowScene = new Scene(addActivityWindowGridPane);
                Display.addActivityWindow.setScene(addActivityWindowScene);

                Display.addActivityWindow.initModality(Modality.WINDOW_MODAL);
                Display.addActivityWindow.initOwner(Display.primaryWindow);

                Display.addActivityWindow.setX(Display.primaryWindow.getX()+ 500);
                Display.addActivityWindow.setY(Display.primaryWindow.getY());

                Display.addActivityWindow.setOnHidden(e -> System.out.println("Window-level cleanup"));
                Display.addActivityWindow.show();


                Display.newActivityButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        try {

        
	    submitButton = new Button();
	    submitButton.setText(SUBMIT_BUTTON_NAME);
	    submitButton.setOnAction(new EventHandler<ActionEvent> (){
	        @Override
	        public void handle(ActionEvent e) {

                ArrayList<GreenActivity> sqlGreenAcitivityList = new ArrayList<GreenActivity>();

	            for (int i = 0; i < Display.activities.size(); i ++) {

	                // Check to see if values entered are numeric
                    GreenActivity tempActivity =  Display.activities.get(i);
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


        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(Display.weeklyTable);
        borderpane.setLeft(Display.addActivityButton);
        
        borderpane.setBottom(Display.submitButton);

        Scene scene = new Scene(borderpane);

        Display.primaryWindow.setScene(scene);
        Display.primaryWindow.setOnHidden(e -> Platform.exit());
        Display.primaryWindow.show();
    }


    public ObservableList<GreenActivity> getActivities() {
        return Display.activities;
    }

   /* public void setActivities (ObservableList<GreenActivity> activities ) {
        this.activities = activities;
    }*/


}