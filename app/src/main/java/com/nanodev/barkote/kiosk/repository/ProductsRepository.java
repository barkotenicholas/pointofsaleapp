package com.nanodev.barkote.kiosk.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.nanodev.barkote.kiosk.database.Roomdatabase;
import com.nanodev.barkote.kiosk.database.entities.Products;
import com.nanodev.barkote.kiosk.database.interfaces.KioskDao;
import com.nanodev.barkote.kiosk.retrofit.Shop;
import com.nanodev.barkote.kiosk.retrofit.calls.NetworkCalls;
import com.nanodev.barkote.kiosk.retrofit.instance.KioskInstance;
import com.nanodev.barkote.kiosk.retrofit.model.ProductsCall;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRepository {


    public static NetworkCalls networkCalls;
    public Call<List<ProductsCall>> productsCall;
    private KioskDao kioskDao;
    private LiveData<List<Products>> allProducts;

    public ProductsRepository(Application application) {
        Roomdatabase database = (Roomdatabase) Roomdatabase.getInstance(application);
        kioskDao = database.kioskDao();
        allProducts = kioskDao.getAllProducts();
        networkCalls = KioskInstance.getApiClient();

    }

    //database room
    public void insert(Products products) {
        new InsertProductAsyncTask(kioskDao).execute(products);
    }

    public void update(Products products) {
        new UpdateProductAsyncTask(kioskDao).execute(products);
    }

    public LiveData<List<Products>> getAllProducts() {


        return allProducts;
    }

    //retrofit
    public void getShop() {

    }

    public void getProducts() {

        Shop shop = new Shop("ketiow");
        productsCall = ProductsRepository.networkCalls.getAllProducts(shop);

        productsCall.clone().enqueue(new Callback<List<ProductsCall>>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductsCall>> call, @NonNull Response<List<ProductsCall>> response) {

                if (response.isSuccessful()) {
                    List<ProductsCall> productsCallList = response.body();

                    assert productsCallList != null;
                    for (ProductsCall product : productsCallList) {
                        Products newproducts = new Products(product);
                        new InsertProductAsyncTask(kioskDao).execute(newproducts);

                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductsCall>> call, @NonNull Throwable t) {

            }
        });
    }

    private static class InsertProductAsyncTask extends AsyncTask<Products, Void, Void> {
        private KioskDao kioskDao;

        private InsertProductAsyncTask(KioskDao kioskDao) {
            this.kioskDao = kioskDao;
        }

        @Override
        protected Void doInBackground(Products... products) {
            kioskDao.insert(products[0]);
            return null;
        }
    }

    private static class UpdateProductAsyncTask extends AsyncTask<Products, Void, Void> {
        private KioskDao kioskDao;

        private UpdateProductAsyncTask(KioskDao kioskDao) {
            this.kioskDao = kioskDao;
        }

        @Override
        protected Void doInBackground(Products... products) {
            kioskDao.insert(products[0]);
            return null;
        }
    }
}
