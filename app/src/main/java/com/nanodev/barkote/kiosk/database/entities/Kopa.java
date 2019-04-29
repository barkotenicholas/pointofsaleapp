package com.nanodev.barkote.kiosk.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(foreignKeys = @ForeignKey(entity = Shop.class,
        parentColumns = "shop_name",
        childColumns = "shop_name"),
        indices = {@Index("shop_name")})
public class Kopa {

    @NonNull
    @PrimaryKey
    private String name;

    private String shop_name;

    private int product_id;

    private int quantity;

    private boolean paid;

    private boolean sync;

    public Kopa(String name, String shop_name, int product_id, int quantity, boolean paid, boolean sync) {
        this.name = name;
        this.shop_name = shop_name;
        this.product_id = product_id;
        this.quantity = quantity;
        this.paid = paid;
        this.sync = sync;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public boolean isPaid() {
        return paid;
    }

    public boolean isSync() {
        return sync;
    }

    public String getName() {
        return name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }
}
