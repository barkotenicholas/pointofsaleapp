package com.nanodev.barkote.kiosk.retrofit.model;

public class RegisterShop {

    private String database,
    kiosk,
    username,
    password;

    public RegisterShop(String database, String kiosk, String username, String password) {
        this.database = database;
        this.kiosk = kiosk;
        this.username = username;
        this.password = password;
    }
}
