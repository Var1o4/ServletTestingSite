package com.example.yadaun.AuthServlet;


import java.util.Locale;
import java.util.ResourceBundle;
public class Main {
    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("de"));
        String usernameLabel = bundle.getString("registration.username.label");
        System.out.println(usernameLabel);

    }

}

