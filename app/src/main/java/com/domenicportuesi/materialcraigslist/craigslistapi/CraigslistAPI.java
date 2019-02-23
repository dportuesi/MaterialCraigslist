package com.domenicportuesi.materialcraigslist.craigslistapi;


import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CraigslistAPI extends AsyncTask<Void, Void, Void> {
    private final String TAG = "CraigsListAPIAsyncTask";
    Document doc = null;


    protected static class Category {

        String urlRef;
        String categoryName;
        ArrayList<Category> subCategories = CraigslistData.getCategoriesArrayList();

        public ArrayList<Category> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(ArrayList<Category> subCategories) {
            this.subCategories = subCategories;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getUrlRef() {
            return urlRef;
        }

        public void setUrlRef(String urlRef) {
            this.urlRef = urlRef;
        }


        public Category(String categoryName, String urlRef) {
            this.categoryName = categoryName;
            this.urlRef = urlRef;
        }


    }

    @Override
    protected Void doInBackground(Void... Void) {
        try {
            doc = Jsoup.connect("https://www.craigslist.org/").get();
            for (Element ele : doc.getElementsByClass("col")) {
                Category category = new Category(ele.selectFirst("a").select("span").text(), ele.selectFirst("a").attr("href"));
                for(Element subEle : ele.getElementsByAttribute("cats")){
                    Category subCategory = new Category(subEle.select("a").select("span").text(), subEle.select("a").attr("href"));
                    category.getSubCategories().add(subCategory);
                }
                CraigslistData.getCategoriesArrayList().add(category);


            }

            for(Category cat : CraigslistData.getCategoriesArrayList()){
                Log.d(TAG, cat.getCategoryName() + "," + cat.getUrlRef());
                for(Category subCat : cat.subCategories){
                    Log.d(TAG, subCat.getCategoryName() + "," + subCat.getUrlRef());
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result){

    }


    private String getHTML() {
        return doc.title();
    }

    private ArrayList<Category> getMainCatagories() {

        ArrayList<Category> categoryArrayList = new ArrayList<>();



        return categoryArrayList;

    }


}
