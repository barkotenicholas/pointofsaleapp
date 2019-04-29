package com.nanodev.barkote.kiosk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.nanodev.barkote.kiosk.R;

public class Config {

    private Context context;
    private SharedPreferences sharedPreferences;
    public Config(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);

    }

    public void showMessage(String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }


    public void writeShopName(String shop_name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.kiosk),shop_name);
        editor.apply();
    }

    public String readShopName(){
        return sharedPreferences.getString(context.getString(R.string.kiosk),"");
    }
}
