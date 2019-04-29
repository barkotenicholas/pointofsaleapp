package com.nanodev.barkote.kiosk.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.nanodev.barkote.kiosk.database.entities.Kopa;
import com.nanodev.barkote.kiosk.database.entities.Products;
import com.nanodev.barkote.kiosk.database.entities.Sales;
import com.nanodev.barkote.kiosk.database.entities.Shop;
import com.nanodev.barkote.kiosk.database.interfaces.KioskDao;

@Database(entities = {Shop.class,Products.class,Sales.class,Kopa.class},version = 1, exportSchema = false)
public abstract class Roomdatabase extends RoomDatabase {

    private static RoomDatabase roomDatabase;

    public abstract KioskDao kioskDao();

    public static synchronized  RoomDatabase getInstance(Context context){
        if(roomDatabase == null){
            roomDatabase = Room.databaseBuilder(context.getApplicationContext(),Roomdatabase.class,"kiosk").fallbackToDestructiveMigration().build();
        }
        return  roomDatabase;
    }
}
