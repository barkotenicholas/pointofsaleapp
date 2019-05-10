package com.nanodev.barkote.kiosk.retrofit.calls;

import com.nanodev.barkote.kiosk.retrofit.Shop;
import com.nanodev.barkote.kiosk.retrofit.model.ProductsCall;
import com.nanodev.barkote.kiosk.retrofit.model.RegisterShop;
import com.nanodev.barkote.kiosk.retrofit.model.RegisterUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkCalls {

    //get routes
    @GET("/products")
    Call<List<ProductsCall>> getAllProducts(@Body Shop shop);



    @POST("/registerShop")
    Call<RegisterShop> registerProduct(@Body RegisterShop registerShop);

    @POST("/register")
    Call<RegisterUser> registerNewUser(@Body RegisterUser registerUser);



}
