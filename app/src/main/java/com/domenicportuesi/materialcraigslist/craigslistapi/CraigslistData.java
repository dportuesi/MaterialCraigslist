package com.domenicportuesi.materialcraigslist.craigslistapi;

import java.util.ArrayList;

public class CraigslistData
{

    private static ArrayList<CraigslistAPI.Category> categoriesArrayList = new ArrayList<>();

    public static ArrayList<CraigslistAPI.Category> getCategoriesArrayList()
    {
        return categoriesArrayList;
    }

    public void setCategoriesArrayList(ArrayList<CraigslistAPI.Category> categoriesArrayList)
    {
        this.categoriesArrayList = categoriesArrayList;
    }

}
