package com.nanodev.barkote.kiosk.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.nanodev.barkote.kiosk.database.entities.Products;
import com.nanodev.barkote.kiosk.repository.ProductsRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductsRepository productsRepository;
    private LiveData<List<Products>> allProducts;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productsRepository = new ProductsRepository(application);
        allProducts = productsRepository.getAllProducts();
    }

    public void update(Products products) {
        productsRepository.update(products);
    }


    public LiveData<List<Products>> getSales() {

        return allProducts;

    }

}
