package com.nanodev.barkote.kiosk.retrofit.calls;

import com.nanodev.barkote.kiosk.retrofit.Shop;
import com.nanodev.barkote.kiosk.retrofit.model.ProductsCall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface NetworkCalls {

    //get routes
    @GET("/products")
    Call<List<ProductsCall>> getAllProducts(@Body Shop shop);

}
