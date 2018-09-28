package com.lukcm888.planner;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.event.EventHandler;

public class GreenActivity extends Activity {


	public GreenActivity(String name, int hours, String category) {
		
		this.name = name;
		this.hours = hours;
		this.category = category;
		weeklyHoursList = new ArrayList<String>();
		
		mondayHourLogger = new TextField();
		mondayHourLogger.setPromptText("0");
        
		tuesdayHourLogger = new TextField();
		tuesdayHourLogger.setPromptText("0");
        
		wednesdayHourLogger = new TextField();
		wednesdayHourLogger.setPromptText("0");
        
		thursdayHourLogger = new TextField();
        thursdayHourLogger.setPromptText("0");
        
        fridayHourLogger = new TextField();
        fridayHourLogger.setPromptText("0");
        
        saturdayHourLogger = new TextField();
        saturdayHourLogger.setPromptText("0");
        
        sundayHourLogger = new TextField();
        sundayHourLogger.setPromptText("0");

        removeButton = new Button(REMOVE_BUTTON_NAME);
        callRemoveButton(removeButton);



		
	}
	
	public GreenActivity(String name, int hours, String category, TextField mondayHourLogger, TextField tuesdayHourLogger
			,TextField wednesdayHourLogger, TextField thursdayHourLogger, TextField fridayHourLogger, TextField saturdayHourLogger,
			TextField sundayHourLogger) {
		
		this.name = name;
		this.hours = hours;
		this.category = category;
        weeklyHoursList = new ArrayList<String>();
		this.mondayHourLogger = mondayHourLogger;
		this.tuesdayHourLogger = tuesdayHourLogger;
		this.wednesdayHourLogger = tuesdayHourLogger;
		this.thursdayHourLogger = thursdayHourLogger;
		this.fridayHourLogger = fridayHourLogger;
		this.saturdayHourLogger = saturdayHourLogger;
		this.sundayHourLogger = sundayHourLogger;

        removeButton = new Button(REMOVE_BUTTON_NAME);
	}

    @Override
    public String callRemoveButton(Button removeButton) {

        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
/*

                ObservableList tempList = Display.getActivities();

                String tempName = name;

                for (int i = 0; i < tempList.size(); i++ ) {
                        tempList.get(i);
                }
*/



            }
        });
        return null;

    }

}

