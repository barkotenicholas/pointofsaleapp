package com.nanodev.barkote.kiosk;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nanodev.barkote.kiosk.config.Config;

import java.util.Objects;

public class ShopName extends AppCompatActivity {

    public EditText editText;
    public String shop_name;
    public Dialog dialog;
    public Config config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_name);
        editText = findViewById(R.id.shopname);
        dialog = new Dialog(ShopName.this);

        config = new Config(getApplicationContext());
        if(config.readShopName().equals("")){
            config.showMessage("You dont have a shop");
        }else {
            String a = config.readShopName();
            Intent intent = new Intent(ShopName.this,MainActivity.class);
            intent.putExtra("ShopName",a);
            startActivity(intent);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shopname,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.shopname:
                saveShopName();
        default:
            return super.onOptionsItemSelected(item);
        }

    }

    private void saveShopName() {
        shop_name = editText.getText().toString().trim();

        if(shop_name.isEmpty()){
            editText.setError("Please enter a Kiosk name !");
        }else {
            showPopUp(shop_name);
        }

    }
    public void showPopUp(final String shop_name) {

        TextView txtclose;
        Button btnFollow;
        TextView kioskname;

        dialog.setContentView(R.layout.popupwindow);

        txtclose = dialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        kioskname = dialog.findViewById(R.id.kioskname);

        kioskname.setText(shop_name);
        btnFollow = dialog.findViewById(R.id.save);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                config.writeShopName(shop_name);
                Toast.makeText(ShopName.this,"saving kiosk name ",Toast.LENGTH_SHORT).show();
                editText.getText().clear();
                dialog.dismiss();
            }
        });
    }
}
