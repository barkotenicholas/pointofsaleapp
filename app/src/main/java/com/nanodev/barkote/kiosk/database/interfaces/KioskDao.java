package com.nanodev.barkote.kiosk.database.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.nanodev.barkote.kiosk.database.entities.Kopa;
import com.nanodev.barkote.kiosk.database.entities.Products;
import com.nanodev.barkote.kiosk.database.entities.Sales;
import com.nanodev.barkote.kiosk.database.entities.Shop;

import java.util.List;

@Dao
public interface KioskDao {

    @Insert
    void insert(Products products);

    @Query("SELECT * FROM products")
    LiveData<List<Products>> getAllProducts();

    @Update
    void Update(Products products);

    @Insert
    void insertKopa(Kopa kopa);

    @Query("SELECT * FROM kopa")
    LiveData<List<Kopa>> getAllKopa();

    @Update
    void updateKopa(Kopa kopa);

    @Insert
    void insertSale(Sales sales);

    @Query("SELECT * FROM sales")
    LiveData<List<Sales>> getAllSales();


    @Insert
    void insertShop(Shop shop);
}
