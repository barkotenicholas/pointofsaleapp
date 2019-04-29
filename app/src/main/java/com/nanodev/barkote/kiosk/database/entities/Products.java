package com.nanodev.barkote.kiosk.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.nanodev.barkote.kiosk.retrofit.model.ProductsCall;

@Entity(foreignKeys = @ForeignKey(entity = Shop.class,
        parentColumns = "shop_name",
        childColumns = "shop_name"),
        indices = {@Index("shop_name")})
public class Products {

    private String shop_name;

    @PrimaryKey
    @NonNull
    private String name ;

    private int product_id ;

    private int  quantity ;

    private String description;

    private String type;

    private int price ;

    private boolean sync = true;

    public Products(String shop_name, @NonNull String name, int product_id, int quantity, String description, String type, int price, boolean sync) {
        this.shop_name = shop_name;
        this.name = name;
        this.product_id = product_id;
        this.quantity = quantity;
        this.description = description;
        this.type = type;
        this.price = price;
        this.sync = sync;
    }

    public Products(ProductsCall product) {
        this.shop_name = product.getShopName();
        this.name = product.getName();
        this.product_id = product.getProductId();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.type = product.getType();
        this.price = product.getPrice();
        this.sync = product.getSync();
    }

    public boolean isSync() {
        return sync;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getName() {
        return name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
