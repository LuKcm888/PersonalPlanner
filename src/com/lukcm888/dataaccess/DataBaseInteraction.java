package com.lukcm888.dataaccess;

import com.lukcm888.planner.GreenActivity;


import java.sql.*;
import java.util.ArrayList;



public class DataBaseInteraction {

	static final String JDBC_DRIVER = "";
	static final String DB_URL = "";

	private static String USER ="";
	private static String PASS ="";

	/*
	   Logs the total totalHours recorded by the user for each task into
	   the database.
	 */
	public void insertHours(ArrayList<GreenActivity> sqlGreenAcitivityList) {

		Connection connection = null;
		Statement s = null;
		try {

			System.out.println("Entering DB");

			Class.forName(JDBC_DRIVER);


			System.out.println("Connecting to a selected database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");


            System.out.println("About to execute for loop");
            for (int i = 0; i < sqlGreenAcitivityList.size(); i ++ ) {

                System.out.println("Inserting records into the table...");
                s = connection.createStatement();
                String sql = "USE test";
                s.executeUpdate(sql);

                GreenActivity activity = sqlGreenAcitivityList.get(i);

                String name = activity.getName();
                int mon = Integer.parseInt(activity.getMondayHourLogger().getText());
                int tues = Integer.parseInt(activity.getTuesdayHourLogger().getText());
                int wed = Integer.parseInt(activity.getWednesdayHourLogger().getText());
                int thur = Integer.parseInt(activity.getThursdayHourLogger().getText());
                int fri = Integer.parseInt(activity.getFridayHourLogger().getText());
                int sat = Integer.parseInt(activity.getSaturdayHourLogger().getText());
                int sun = Integer.parseInt(activity.getSundayHourLogger().getText());

                System.out.println(mon);

                sql = "INSERT INTO saved_data (task, monday, tuesday, wednesday, thursday, friday, saturday, sunday) VALUES " +
                        "('"+ name +"',"+ mon +","+ tues +","+ wed +","+ thur +","+ fri +","+ sat +","+ sun +")";
                s.executeUpdate(sql);

                sql = "SHOW TABLES";

                s.executeUpdate(sql);
                System.out.println("Inserted records into the table...");
            }
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(s!=null)
					connection.close();
			}catch(SQLException se){
			}
			try{
				if(connection!=null)
					connection.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");

    }

}
