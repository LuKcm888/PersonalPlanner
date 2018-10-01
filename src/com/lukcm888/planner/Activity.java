package com.lukcm888.planner;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public abstract class Activity {

	protected String name ="";
	protected int totalHours = 0;
	protected String category = "";
	protected ArrayList <String> weeklyHoursList = new ArrayList<String>();
	protected final String REMOVE_BUTTON_NAME = "Remove";


    protected TextField mondayHourLogger;
    protected TextField tuesdayHourLogger;
    protected TextField wednesdayHourLogger;
    protected TextField thursdayHourLogger;
    protected TextField fridayHourLogger;
    protected TextField saturdayHourLogger;
    protected TextField sundayHourLogger;
	protected Button removeButton;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
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

    public void loadWeeklyHours() {

        weeklyHoursList.add(this.getMondayHourLogger().getText());
        weeklyHoursList.add( this.getTuesdayHourLogger().getText());
        weeklyHoursList.add(this.getWednesdayHourLogger().getText());
        weeklyHoursList.add(this.getThursdayHourLogger().getText());
        weeklyHoursList.add(this.getFridayHourLogger().getText());
        weeklyHoursList.add(this.getSaturdayHourLogger().getText());
        weeklyHoursList.add(this.getSundayHourLogger().getText());

    }

	public void sumHours(ArrayList <String> weeklyHoursList) {
		int total = 0;
		for (String hour: weeklyHoursList) {

			total += Integer.parseInt(hour);
		}

		totalHours = total;

	}

}
