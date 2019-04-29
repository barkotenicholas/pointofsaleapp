package com.nanodev.barkote.kiosk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.nanodev.barkote.kiosk.database.entities.Sales;
import com.nanodev.barkote.kiosk.repository.SalesRepository;

import java.util.List;

public class SalesViewModel extends AndroidViewModel {

    private SalesRepository salesRepository;
    private LiveData<List<Sales>> allsales;

    public SalesViewModel(@NonNull Application application) {
        super(application);
        salesRepository = new SalesRepository(application);
        allsales = salesRepository.getAllSales();
    }

    public LiveData<List<Sales>> getSales() {

        return allsales;
    }
}
