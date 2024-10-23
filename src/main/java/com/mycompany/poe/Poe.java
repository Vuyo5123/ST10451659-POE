package com.mycompany.poe;
import java.util.Scanner;

public class Poe {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String Username;
        String Password;
        String name;
        String Lastname;
        // asking for the users first and last name 
        System.out.println("Please enter your First name and Last name");
        name = Input.next();
        Lastname = Input.next();

        boolean login = false;
        while (!login) {
            System.out.println("Please enter a username");
            Username = Input.next();

            // Check if the username meets the criteria
            if (checkUserName(Username)) {
                System.out.println("Username successfully captured");
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
                continue;
            }

            System.out.println("Please enter a password");
            Password = Input.next();

            // Check if the password meets the complexity rules
            if (checkPasswordComplexity(Password)) {
                System.out.println("Password successfully captured");
                login = true;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
                continue;
            }

            // Display welcome message if both username and password are valid
            if (login) {
                System.out.println(registerUser(Username, Password));
                System.out.println("Welcome " + name + " " + Lastname + ", it's great to see you again");
            } else {
                System.out.println("Username or password incorrect, please try again");
            }
        }
    }
    // checks if the username meet the requirements 
    public static boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public static boolean checkPasswordComplexity(String password) {
        boolean containsCapital = false;
        boolean containsNumber = false;
        boolean containsSpecialChar = false;
        
        // Loop goes through each character in the password 
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);
            // checks if its a digit
            if (Character.isDigit(currentChar)) {
                containsNumber = true;
            }
            // checks if the character is a speacial character 
            if (!Character.isLetterOrDigit(currentChar)) {
                containsSpecialChar = true;
            }
            // checks if the character is uppercase 
            if (Character.isUpperCase(currentChar)) {
                containsCapital = true;
            }
            // If all condtions are met to stop the loop 
            if (containsCapital && containsNumber && containsSpecialChar) {
                break;
            }
        }

        return containsNumber && containsSpecialChar && containsCapital && password.length() >= 8;
    }
    
    public static String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "The username is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "The password does not meet the complexity requirements.";
        }
        return "The username and password have been registered successfully.";
    }
    // if the inputed login details match the stored ones
    public static boolean loginUser(String enteredUsername, String storedUsername, String enteredPassword, String storedPassword) {
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }
    // Returns login status message based on success or failed
    public static String returnLoginStatus(boolean loginSuccess) {
        return loginSuccess ? "Login successful" : "Login failed";
    }
}
