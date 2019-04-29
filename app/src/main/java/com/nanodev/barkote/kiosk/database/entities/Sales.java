package com.nanodev.barkote.kiosk.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = Shop.class,
        parentColumns = "shop_name",
        childColumns = "shop_name"),
        indices = {@Index("shop_name")})
@TypeConverters(DateConverter.class)
public class Sales {

    private String shop_name;

    private Date date;

    @PrimaryKey
    private int product_id;

    private String product;

    private int quantity;

    private int total_price;

    public boolean sync;

    public Sales(String shop_name, Date date, int product_id, String product, int quantity, int total_price, boolean sync) {
        this.shop_name = shop_name;
        this.date = date;
        this.product_id = product_id;
        this.product = product;
        this.quantity = quantity;
        this.total_price = total_price;
        this.sync = sync;
    }


    public boolean isSync() {
        return sync;
    }

    public String getShop_name() {
        return shop_name;
    }

    public Date getDate() {
        return date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal_price() {
        return total_price;
    }
}
