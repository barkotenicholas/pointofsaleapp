package com.nanodev.barkote.kiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        init();
    }

    private void init() {
        setUpToolBar();
    }

    private void setUpToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
