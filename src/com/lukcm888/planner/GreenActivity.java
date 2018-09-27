package com.lukcm888.planner;

import javafx.scene.control.TextField;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class GreenActivity implements ActivityObject {

	private String name ="";
	private int hours = 0;
	private String category ="";
	private ArrayList <String> weeklyHoursList = null;
	
	
	private TextField mondayHourLogger;
	private TextField tuesdayHourLogger;
	private TextField wednesdayHourLogger;
	private TextField thursdayHourLogger;
	private TextField fridayHourLogger;
	private TextField saturdayHourLogger;
	private TextField sundayHourLogger;
	private Button removeButton;

	private static final String REMOVE_BUTTON_NAME = "Remove";
	
	
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList <String> getWeeklyHoursList() { return weeklyHoursList;}

    public void setWeeklyHoursList(ArrayList <String> weeklyHoursList ) {

	    this.weeklyHoursList = weeklyHoursList;

	}

	public void loadWeeklyHours() {

	    weeklyHoursList.add(this.getMondayHourLogger().getText());
        weeklyHoursList.add( this.getTuesdayHourLogger().getText());
        weeklyHoursList.add(this.getWednesdayHourLogger().getText());
        weeklyHoursList.add(this.getThursdayHourLogger().getText());
        weeklyHoursList.add(this.getFridayHourLogger().getText());
        weeklyHoursList.add(this.getSaturdayHourLogger().getText());
        weeklyHoursList.add(this.getSundayHourLogger().getText());

	}
	
	
	public TextField getMondayHourLogger() {
		return mondayHourLogger;
	}

	public void setMondayHourLogger(TextField mondayHourLogger) {
		this.mondayHourLogger = mondayHourLogger;
	}

	public TextField getTuesdayHourLogger() {
		return tuesdayHourLogger;
	}

	public void setTuesdayHourLogger(TextField tuesdayHourLogger) {
		this.tuesdayHourLogger = tuesdayHourLogger;
	}

	public TextField getWednesdayHourLogger() {
		return wednesdayHourLogger;
	}

	public void setWednesdayHourLogger(TextField wednesdayHourLogger) {
		this.wednesdayHourLogger = wednesdayHourLogger;
	}

	public TextField getThursdayHourLogger() {
		return thursdayHourLogger;
	}

	public void setThursdayHourLogger(TextField thrusdayHourLogger) {
		this.thursdayHourLogger = thrusdayHourLogger;
	}

	public TextField getFridayHourLogger() {
		return fridayHourLogger;
	}

	public void setFridayHourLogger(TextField fridayHourLogger) {
		this.fridayHourLogger = fridayHourLogger;
	}

	public TextField getSaturdayHourLogger() {
		return saturdayHourLogger;
	}

	public void setSaturdayHourLogger(TextField saturdayHourLogger) {
		this.saturdayHourLogger = saturdayHourLogger;
	}

	public TextField getSundayHourLogger() {
		return sundayHourLogger;
	}

	public void setSundayHourLogger(TextField sundayHourLogger) {
		this.sundayHourLogger = sundayHourLogger;
	}

	public Button getRemoveButton() {
	    return removeButton;
	}

	public void setRemoveButton(Button removeButton) {
	    this.removeButton = removeButton;
	}

	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readData() {
		// TODO Auto-generated method stub
		
	}

    @Override
    public int sumHours(ArrayList <String> weeklyHoursList) {
	    int totalHours = 0;
	    for (String hour: weeklyHoursList) {

	       totalHours += Integer.parseInt(hour);
        }

        return totalHours;

    }


	
}
