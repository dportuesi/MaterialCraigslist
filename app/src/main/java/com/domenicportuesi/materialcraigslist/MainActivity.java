package com.domenicportuesi.materialcraigslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.domenicportuesi.materialcraigslist.craigslistapi.CraigslistAPI;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MaterialCraigslistMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CraigslistAPI().execute();

    }
}
