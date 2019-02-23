package com.domenicportuesi.materialcraigslist.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.domenicportuesi.materialcraigslist.R;
import com.domenicportuesi.materialcraigslist.activity.categories.ActivityCategories;
import com.domenicportuesi.materialcraigslist.util.AutoFitGridLayoutManager;

import java.util.ArrayList;

public class ActivityHome extends AppCompatActivity implements HomeRecyclerviewAdapter.ItemListener
{
    RecyclerView recyclerViewHomepage;
    ArrayList<HomeItem> homepageItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerViewHomepage = (RecyclerView) findViewById(R.id.recyclerview_home);
        homepageItems = new ArrayList();
        homepageItems.add(new HomeItem("Item 1", R.drawable.battle, "#09A9FF"));
        homepageItems.add(new HomeItem("Item 2", R.drawable.battle, "#3E51B1"));
        homepageItems.add(new HomeItem("Item 3", R.drawable.battle, "#673BB7"));
        homepageItems.add(new HomeItem("Item 4", R.drawable.battle, "#4BAA50"));
        homepageItems.add(new HomeItem("Item 5", R.drawable.battle, "#F94336"));
        homepageItems.add(new HomeItem("Item 6", R.drawable.battle, "#0A9B88"));

        HomeRecyclerviewAdapter adapter = new HomeRecyclerviewAdapter(this, homepageItems, this);
        recyclerViewHomepage.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/
        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerViewHomepage.setLayoutManager(layoutManager);

        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewHomepage.setLayoutManager(manager);
    }

    @Override
    public void onItemClick(HomeItem item)
    {
        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ActivityCategories.class);
        startActivity(intent);
    }
}
