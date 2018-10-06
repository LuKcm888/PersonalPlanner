package com.lukcm888.user;

import java.sql.Date;
import java.util.UUID;

public class User {

    private String uniqueId;
    private int sqlId;
    private String firstName;
    private String lastName;
    private Date creationDate;
    private String userName;
    private String userLoginPassword;
    private String email;
    private String street;
    private String city;
    private int zip;
    private int phoneNumber;

    //TODO: Implement enum PHONE_TYPE properly
    /*private enum PHONE_TYPE {
        WORK, HOME,

        BOTH;
    }*/


    public User(String firstName, String lastName,Date creationDate, String userName, String userLoginPassword,
                String email, String street, String city, int zip, int phoneNumber) {

        uniqueId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = creationDate;
        this.userName = userName;
        this.userLoginPassword = userLoginPassword;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.phoneNumber = phoneNumber;

    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getSqlId() {
        return sqlId;
    }

    public void setSqlId(int sqlId) {
        this.sqlId = sqlId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
