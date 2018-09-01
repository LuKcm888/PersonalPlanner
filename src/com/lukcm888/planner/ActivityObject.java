package com.lukcm888.planner;

public interface ActivityObject {	
	
	public String name ="";
	public int hours = 0; 
	public String category = "";

	public void writeData();
	
	public void readData();
	
}
