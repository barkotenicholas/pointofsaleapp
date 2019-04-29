package com.nanodev.barkote.kiosk.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.nanodev.barkote.kiosk.database.Roomdatabase;
import com.nanodev.barkote.kiosk.database.entities.Kopa;
import com.nanodev.barkote.kiosk.database.entities.Products;
import com.nanodev.barkote.kiosk.database.interfaces.KioskDao;

import java.util.List;

public class KopaRepository {
    private KioskDao kioskDao;
    private LiveData<List<Kopa>> allKopa;


    public KopaRepository(Application application) {
        Roomdatabase database = (Roomdatabase) Roomdatabase.getInstance(application);
        kioskDao = database.kioskDao();
        allKopa = kioskDao.getAllKopa();
     }


    public void insert(Kopa kopa) {
        new InsertKopaAsyncTask(kioskDao).execute(kopa);
    }

    public void update(Kopa kopa) {
        new UpdateKopaAsyncTask(kioskDao).execute(kopa);
    }

    public LiveData<List<Kopa>> getAllKopa (){


        return allKopa;
    }

    private static class InsertKopaAsyncTask extends AsyncTask<Kopa, Void, Void> {
        private KioskDao kioskDao;

        private InsertKopaAsyncTask(KioskDao kioskDao) {
            this.kioskDao = kioskDao;
        }

        @Override
        protected Void doInBackground(Kopa... kopa) {
            kioskDao.insertKopa(kopa[0]);
            return null;
        }
    }

    private static class UpdateKopaAsyncTask extends AsyncTask<Kopa, Void, Void> {
        private KioskDao kioskDao;

        private UpdateKopaAsyncTask(KioskDao kioskDao) {
            this.kioskDao = kioskDao;
        }

        @Override
        protected Void doInBackground(Kopa... kopa) {
            kioskDao.updateKopa(kopa[0]);
            return null;
        }
    }
}
