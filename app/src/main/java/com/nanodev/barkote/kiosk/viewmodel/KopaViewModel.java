package com.nanodev.barkote.kiosk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.nanodev.barkote.kiosk.database.entities.Kopa;
import com.nanodev.barkote.kiosk.repository.KopaRepository;

import java.util.List;

public class KopaViewModel extends AndroidViewModel {

    private KopaRepository kopaRepository;
    private LiveData<List<Kopa>> allKopa;


    public KopaViewModel(@NonNull Application application) {
        super(application);
        kopaRepository = new KopaRepository(application);
        allKopa = kopaRepository.getAllKopa();
    }

    public void  insert(Kopa kopa){
        kopaRepository.insert(kopa);
    }

    public void update(Kopa kopa){
        kopaRepository.update(kopa);
    }

    public LiveData<List<Kopa>> getSales(){

        return allKopa;
    }
}
