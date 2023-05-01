package com.example.projektkalkuleringsprojekt2semexam.model;

public class User {

    private int userID;
    private String userName;
    private String userPassword;
    private String firstName;
    private String lastName;
    private String birthDate;
    private Enum role;
    private String email;
    private int phoneNumber;

    public User(int userID, String userName, String userPassword, String firstName, String lastName,
                String birthdate, String gender, String email, int phoneNumber) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthdate;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(int userID, String userName, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Enum getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return userID + " " + userName + " " + userPassword + " " + firstName + " " + lastName + " "
                + birthDate + " " + role + " " + email + " " + phoneNumber + " ";
    }

}
