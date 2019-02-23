package com.domenicportuesi.materialcraigslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.domenicportuesi.materialcraigslist.craigslistScraper.FrontPageCategories;
import com.domenicportuesi.materialcraigslist.craigslistScraper.Locations;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MaterialCraigslistMain";
    ArrayList<FrontPageCategories.Category> frontPageCategories;
    ArrayList<Locations.LocationsCategory> Locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            frontPageCategories = new FrontPageCategories().execute().get();
            Locations = new Locations().execute().get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "DEBUG HERE!!!!!!!!!!!!!");
        for (com.domenicportuesi.materialcraigslist.craigslistScraper.Locations.LocationsCategory lc : Locations){
            Log.d(TAG, lc.getCountryName());
//            for (com.domenicportuesi.materialcraigslist.craigslistScraper.Locations.LocationsCategory lc1 : lc.getStateCategories()){
//                Log.d(TAG, lc1.getStateName());
//                for(com.domenicportuesi.materialcraigslist.craigslistScraper.Locations.LocationsCategory lc2 : lc1.getAreaCategories()){
//                    Log.d(TAG, lc2.getAreaName());
//                }
//            }
        }

    }
}
