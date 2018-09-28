package com.lukcm888.planner;

import com.lukcm888.Util.ApplicationUtilities;

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

public class Display extends Application {

    private Stage primaryWindow;
    private Stage addActivityWindow;
    private static Button addActivityButton;
    private static Button submitButton;
    private static GridPane g;

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
    private TextField newActivityTextField = new TextField();
    private String newActivitySubmisson;
    private Button newActivityButton;
    
    private static TableView<GreenActivity> weeklyTable;
    //private static GetPropValues getPropValues;


    public static ObservableList<GreenActivity> activities = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryWindow = primaryStage;
        primaryWindow.setTitle(APP_TITLE);
        
        //	Name Column
        TableColumn<GreenActivity, String> taskColumn = new TableColumn<GreenActivity, String>(TASK);
        taskColumn.setMinWidth(100);
        taskColumn.setCellValueFactory(new PropertyValueFactory<>(NAME));
       
        //	Monday Column
        TableColumn<GreenActivity, String> mondayColumn = new TableColumn<GreenActivity, String>(MONDAY);
        mondayColumn.setMinWidth(100);
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>(MONDAY_HOUR_LOGGER));
        
        //	Tuesday Column
        TableColumn<GreenActivity, String> tuesdayColumn = new TableColumn<GreenActivity, String>(TUESDAY);
        tuesdayColumn.setMinWidth(100);
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>(TUESDAY_HOUR_LOGGER));
        
        // Wednesday Column
        TableColumn<GreenActivity, String> wednesdayColumn = new TableColumn<GreenActivity, String>(WEDNESDAY);
        wednesdayColumn.setMinWidth(100);
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>(WEDNESDAY_HOUR_LOGGER));
      
        //	Thursday Column
        TableColumn<GreenActivity, String> thursdayColumn = new TableColumn<GreenActivity, String>(THURSDAY);
        thursdayColumn.setMinWidth(100);
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>(THURSDAY_HOUR_LOGGER));
        
        //	Friday Column
        TableColumn<GreenActivity, String> fridayColumn = new TableColumn<GreenActivity, String>(FRIDAY);
        fridayColumn.setMinWidth(100);
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>(FRIDAY_HOUR_LOGGER));
        
        //	Saturday Column
        TableColumn<GreenActivity, String> saturdayColumn = new TableColumn<GreenActivity, String>(SATURDAY);
        saturdayColumn.setMinWidth(100);
        saturdayColumn.setCellValueFactory(new PropertyValueFactory<>(SATURDAY_HOUR_LOGGER));
        
        //  Sunday Column
        TableColumn<GreenActivity, String> sundayColumn = new TableColumn<GreenActivity, String>(SUNDAY);
        sundayColumn.setMinWidth(100);
        sundayColumn.setCellValueFactory(new PropertyValueFactory<>(SUNDAY_HOUR_LOGGER));
        
     	//  Total Hours Column
        TableColumn<GreenActivity, String> totalHoursColumn = new TableColumn<GreenActivity, String>(TOTAL_HOURS);
        totalHoursColumn.setMinWidth(100);
        totalHoursColumn.setCellValueFactory(new PropertyValueFactory<>(TOTAL_HOURS_LOGGER));

        //  RemoveButton Column
        TableColumn<GreenActivity, String> RemoveButtonColumn = new TableColumn<GreenActivity, String>(REMOVE_BUTTON_NAME);
        RemoveButtonColumn.setMinWidth(100);
        RemoveButtonColumn.setCellValueFactory(new PropertyValueFactory<>(REMOVE_BUTTON));

        // instansiate textfields
        weeklyTable = new TableView<>();

        weeklyTable.getColumns().addAll(taskColumn ,mondayColumn, tuesdayColumn, wednesdayColumn, thursdayColumn,
        		fridayColumn, saturdayColumn, sundayColumn, RemoveButtonColumn);
        

        /*
        *   Add Activity Button Logic
        *
        *   When clicked, the add activity button will open a window that will prompt the user to add a new activity
        *   to the calender.  This setOnAction also creates the window (currently called the "addActivityWindow")
        *   Which generates the window and text bod that the user can enter their data into.
        *
        *   Also, the addActivityButton contains the setOnAction logic for the newActivityButton (the submit button for
        *   the newActivityWindow.
        *
        *   TODO: Come up with better names for these variables.  The current ones are confusing and can be flushed out.
        *
        */
        addActivityButton = new Button(ADD_ACTIVITY_BUTTON_NAME);
        addActivityButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                addActivityWindow = new Stage();
                addActivityWindow.setTitle(ADD_ACTIVITY_WINDOW_NAME);


                newActivityButton = new Button(ADD_NEW_TASK);

                GridPane addActivityWindowGridPane = new GridPane();
                addActivityWindowGridPane.add(newActivityButton,0, 0);
                addActivityWindowGridPane.add(newActivityTextField,1,0);
                Scene addActivityWindowScene = new Scene(addActivityWindowGridPane);
                addActivityWindow.setScene(addActivityWindowScene);

                addActivityWindow.initModality(Modality.WINDOW_MODAL);
                addActivityWindow.initOwner(primaryWindow);

                addActivityWindow.setX(primaryWindow.getX()+ 500);
                addActivityWindow.setY(primaryWindow.getY());

                addActivityWindow.setOnHidden(e -> System.out.println("Window-level cleanup"));
                addActivityWindow.show();


                newActivityButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        try {

        
	    submitButton = new Button();
	    submitButton.setText(SUBMIT_BUTTON_NAME);
	    submitButton.setOnAction(new EventHandler<ActionEvent> (){
	        @Override
	        public void handle(ActionEvent e) {

                    for (int i = 0; i < activities.size(); i ++) {
                        // Check to see if values entered are numeric

                        GreenActivity tempActivity =  activities.get(i);
                        tempActivity.loadWeeklyHours();
                        if (ApplicationUtilities.isNumeric(tempActivity.getWeeklyHoursList())) {
                            tempActivity.sumHours(tempActivity.getWeeklyHoursList());
                            // need to also submit hours as ints into db
                        } else {
                            System.out.println("could not submit data: hours must be in numeric format!");
                        }


                        System.out.println(tempActivity.getMondayHourLogger().getText());
                        System.out.println(tempActivity.getTuesdayHourLogger().getText());
                        System.out.println(tempActivity.getWednesdayHourLogger().getText());
                        System.out.println(tempActivity.getThursdayHourLogger().getText());
                        System.out.println(tempActivity.getFridayHourLogger().getText());
                        System.out.println(tempActivity.getSaturdayHourLogger().getText());
                        System.out.println(tempActivity.getSundayHourLogger().getText());
                        //getPropValues = new GetPropValues();

                        /* Test to get print username and password from config file*/
                        /*
	                    try {
					        System.out.println(getPropValues.getUserName());
					        System.out.println(getPropValues.getPassword());
				        } catch (IOException e1) {
					        // TODO Auto-generated catch block
					        e1.printStackTrace();
				        }
				    */
                    }
	        }
	    });


        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(weeklyTable);
        borderpane.setLeft(addActivityButton);
        
        borderpane.setBottom(submitButton);
         
        
        Scene scene = new Scene(borderpane);

        primaryWindow.setScene(scene);
        primaryWindow.setOnHidden(e -> Platform.exit());
        primaryWindow.show();
    }

    //  Loads in data (usually gets data from csv or data on internet
    private ObservableList<GreenActivity> getActivity(String name) {




            System.out.println("Before adding new data");
            for (int i = 0; i < activities.size(); i++) {
                System.out.println("Name of Activity number " + i + " is " + activities.get(i).getName());
            }

            GreenActivity temp = new GreenActivity(name, 20, "coding");
            // TODO: Figure out why the activities Obeservable Object is allowing enttites to be overwritten
    		activities.add(temp);

            System.out.println("AFTER adding new data");
    		for (int i = 0; i < activities.size(); i++) {
    		    System.out.println("Name of Activity number " + i + " is " + activities.get(i).getName());
            }

            System.out.println("ActivitiesList size is: " + activities.size());

		return activities;

    }


    /*
     *   Remove Button logic
     *
     *   Gives the user the ability to remove a recently added task completely from the calender
     *
     *
     * */
    private void removeItem() {


    }

    public ObservableList<GreenActivity> getActivities() {
        return activities;
    }

    public void setActivities (ObservableList<GreenActivity> activities ) {
        this.activities = activities;
    }


}