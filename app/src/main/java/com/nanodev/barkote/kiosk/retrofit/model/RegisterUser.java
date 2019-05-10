package com.nanodev.barkote.kiosk.retrofit.model;

public class RegisterUser {
    private   String email;
    private String password;

    public RegisterUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
