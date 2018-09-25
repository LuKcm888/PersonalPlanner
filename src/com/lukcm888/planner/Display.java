package com.lukcm888.planner;

import java.io.IOException;

import com.lukcm888.Util.ApplicationUtilities;
import com.lukcm888.dataaccess.GetPropValues;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application {

    private Stage window;
    private final Text actiontarget  = new Text();;
    private static Button b1;
    private static Button submitButton;
    private static GridPane g;
    
    private static final String TASK = "Task";
    private static final String MONDAY = "Monday";
    private static final String TUESDAY = "Tuesday";
    private static final String WEDNESDAY = "Wednesday";
    private static final String THURSDAY = "Thursday";
    private static final String FRIDAY = "Friday";
    private static final String SATURDAY = "Saturday";
    private static final String SUNDAY = "Sunday";
    private static final String TOTALHOURS = "TotalHours";
    private static final String NAME = "name";
    private static final String MONDAY_HOUR_LOGGER = "mondayHourLogger";
    private static final String TUESDAY_HOUR_LOGGER = "tuesdayHourLogger";
    private static final String WEDNESDAY_HOUR_LOGGER = "wednesdayHourLogger";
    private static final String THURSDAY_HOUR_LOGGER = "thursdayHourLogger";
    private static final String FRIDAY_HOUR_LOGGER = "fridayHourLogger";
    private static final String SATURDAY_HOUR_LOGGER = "saturdayHourLogger";
    private static final String SUNDAY_HOUR_LOGGER = "sundayHourLogger";
    
    private static GreenActivity g1;
    
    private static TableView<GreenActivity> table;
    private static GetPropValues getPropValues;
    
   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;      
        window.setTitle("Weekly Planner");
        
        //	Monday Column
        TableColumn<GreenActivity, String> taskColumn = new TableColumn<GreenActivity, String>(TASK);
        taskColumn.setMinWidth(200);
        taskColumn.setCellValueFactory(new PropertyValueFactory<>(NAME));
       
        //	Monday Column
        TableColumn<GreenActivity, String> mondayColumn = new TableColumn<GreenActivity, String>(MONDAY);
        mondayColumn.setMinWidth(200);
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>(MONDAY_HOUR_LOGGER));
        
        //	Tuesday Column
        TableColumn<GreenActivity, String> tuesdayColumn = new TableColumn<GreenActivity, String>(TUESDAY);
        tuesdayColumn.setMinWidth(200);
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>(TUESDAY_HOUR_LOGGER));
        
        // Wednesday Column
        TableColumn<GreenActivity, String> wednesdayColumn = new TableColumn<GreenActivity, String>(WEDNESDAY);
        wednesdayColumn.setMinWidth(200);
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>(WEDNESDAY_HOUR_LOGGER));
      
        //	Thursday Column
        TableColumn<GreenActivity, String> thursdayColumn = new TableColumn<GreenActivity, String>(THURSDAY);
        thursdayColumn.setMinWidth(200);
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>(THURSDAY_HOUR_LOGGER));
        
        //	Friday Column
        TableColumn<GreenActivity, String> fridayColumn = new TableColumn<GreenActivity, String>(FRIDAY);
        fridayColumn.setMinWidth(200);
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>(FRIDAY_HOUR_LOGGER));
        
        //	Saturday Column
        TableColumn<GreenActivity, String> saturdayColumn = new TableColumn<GreenActivity, String>(SATURDAY);
        saturdayColumn.setMinWidth(200);
        saturdayColumn.setCellValueFactory(new PropertyValueFactory<>(SATURDAY_HOUR_LOGGER ));
        
        //  Sunday Column
        TableColumn<GreenActivity, String> sundayColumn = new TableColumn<GreenActivity, String>(SUNDAY);
        sundayColumn.setMinWidth(200);
        sundayColumn.setCellValueFactory(new PropertyValueFactory<>(SUNDAY_HOUR_LOGGER));
        
     	//  TOTAL HOURS
        TableColumn<GreenActivity, String> totalHoursColumn = new TableColumn<GreenActivity, String>(TOTALHOURS);
        totalHoursColumn.setMinWidth(200);
        totalHoursColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        
        // instanite textfields
        
        table = new TableView<>();
        table.setItems(getActivity());

        
        table.getColumns().addAll(taskColumn ,mondayColumn, tuesdayColumn, wednesdayColumn, thursdayColumn, 
        		fridayColumn, saturdayColumn, sundayColumn);
        
     
        b1 = new Button();
        b1.setText("get new tasks");

        
	    submitButton = new Button();
	    submitButton.setText("Submit");
	    submitButton.setOnAction(new EventHandler<ActionEvent> (){
	    		@Override
	        public void handle(ActionEvent e) {
	    		    //String textData = g1.getMondayHourLogger().getText();
	            //actiontarget.setFill(Color.FIREBRICK);
	            //actiontarget.setText(textData);

                    // Check to see if values entered are numeric
                    g1.loadWeeklyHours();
                    if(ApplicationUtilities.isNumeric(g1.getWeeklyHoursList())) {
                        g1.sumHours(g1.getWeeklyHoursList());
                        // need to also submit hours as ints into db
                    }
                    else {
                        System.out.println("could not submit data: hours must be in numeric format!");
                    }


	            System.out.println(g1.getMondayHourLogger().getText());
	            getPropValues =new GetPropValues();

	            /* Test to get print username and password from config file*/
	            try {
					System.out.println(getPropValues.getUserName());
					System.out.println(getPropValues.getPassword());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

	        }
	    });

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(table);
        borderpane.setLeft(b1);
        
        borderpane.setBottom(submitButton);
         
        
        Scene scene = new Scene(borderpane);

        window.setScene(scene);
        window.show();
    }

    //  Loads in data (usually gets data from csv or data on internet
    public ObservableList<GreenActivity> getActivity() {
    	
    		ObservableList<GreenActivity> activites = FXCollections.observableArrayList();
    		
    		g1 = new GreenActivity("Program Java code", 20, "coding");

    		activites.add(g1);
    		
		return activites;
    	
    }


}