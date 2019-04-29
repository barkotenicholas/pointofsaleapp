package com.nanodev.barkote.kiosk.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.nanodev.barkote.kiosk.database.Roomdatabase;
import com.nanodev.barkote.kiosk.database.entities.Sales;
import com.nanodev.barkote.kiosk.database.interfaces.KioskDao;

import java.util.List;

public class SalesRepository {
    private KioskDao kioskDao;
    private LiveData<List<Sales>> allSales;


    public SalesRepository(Application application) {
        Roomdatabase database = (Roomdatabase) Roomdatabase.getInstance(application);
        kioskDao = database.kioskDao();
        allSales = kioskDao.getAllSales();
    }


    public void insert(Sales Sales) {
        new InsertSaleAsyncTask(kioskDao).execute(Sales);
    }


    public LiveData<List<Sales>> getAllSales() {

        return allSales;
    }

    private static class InsertSaleAsyncTask extends AsyncTask<Sales, Void, Void> {
        private KioskDao kioskDao;

        private InsertSaleAsyncTask(KioskDao kioskDao) {
            this.kioskDao = kioskDao;
        }

        @Override
        protected Void doInBackground(Sales... sales) {
            kioskDao.insertSale(sales[0]);
            return null;
        }
    }

}
