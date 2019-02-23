package com.domenicportuesi.materialcraigslist.activity.categories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.domenicportuesi.materialcraigslist.R;

import java.util.ArrayList;

public class ActivityCategories extends AppCompatActivity implements CategoriesRecyclerviewAdapter.ItemListener
{
    RecyclerView recyclerViewCategories;
    ArrayList<CategoryItem> categoryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        recyclerViewCategories = (RecyclerView) findViewById(R.id.recyclerview_categories);
        categoryItems = new ArrayList();
        categoryItems.add(new CategoryItem("Category 1", 100));
        categoryItems.add(new CategoryItem("Category 2", 200));
        categoryItems.add(new CategoryItem("Category 3", 102));
        categoryItems.add(new CategoryItem("Category 4", 140));
        categoryItems.add(new CategoryItem("Category 5", 170));
        categoryItems.add(new CategoryItem("Category 6", 190));

        CategoriesRecyclerviewAdapter adapter = new CategoriesRecyclerviewAdapter(this, categoryItems, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCategories.setLayoutManager(llm);
        recyclerViewCategories.setAdapter(adapter);
    }


    @Override
    public void onItemClick(CategoryItem item)
    {
        Toast.makeText(getApplicationContext(), item.getName() + " is clicked", Toast.LENGTH_SHORT).show();

    }
}
