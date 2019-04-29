package com.nanodev.barkote.kiosk.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Shop")
public class Shop {

    @PrimaryKey
    @NonNull
    private String shop_name;

    public Shop(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_name() {
        return shop_name;
    }


    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }


}
