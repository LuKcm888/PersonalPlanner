package com.lukcm888.planner;

import java.util.ArrayList;

public interface ActivityObject {	
	
	String name ="";
	int hours = 0;
	String category = "";
    ArrayList <String> hoursPerDay = new ArrayList<String>();

	void writeData();
	
	void readData();

    int sumHours(ArrayList <String> weeklyHoursList);


	
}
