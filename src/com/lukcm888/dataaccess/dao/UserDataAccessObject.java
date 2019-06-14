package com.lukcm888.dataaccess.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDataAccessObject {

    static final String JDBC_DRIVER = " ";
    static final String DB_URL = "";

    private static String USER ="";
    private static String PASS ="";

    public void createUser() {



    }

    //TODO:  Reseach to see if their is a more proper way to make a login method
        public void userLoginIn (String userName, String password) {


        Connection connection = null;
        Statement s = null;

        try {


            //Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            s = connection.createStatement();

            String sql = "SELECT *FROM USERS "+ userName;

            s.execute(sql);


        }catch (SQLException se){

        }finally {
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
    }



}
