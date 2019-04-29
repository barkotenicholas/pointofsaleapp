package com.nanodev.barkote.kiosk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class KopaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopa);
        init();
    }

    private void init() {
        setUpToolbar();
    }

    private void setUpToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
