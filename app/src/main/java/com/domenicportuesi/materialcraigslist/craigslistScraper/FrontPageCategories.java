package com.domenicportuesi.materialcraigslist.craigslistScraper;


import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class FrontPageCategories extends AsyncTask<Void, Void, ArrayList<FrontPageCategories.Category>> {
    private final String TAG = "CraigsListAPIAsyncTask";
    Document doc = null;
    public static ArrayList<FrontPageCategories.Category> categoriesArrayList = new ArrayList<>();


    public static class Category {

        String urlRef = "";
        String categoryName = "";
        ArrayList<Category> subCategories = new ArrayList<>();

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
    protected ArrayList<Category> doInBackground(Void... Void) {
        Category subCategory;
        Category category;
        try {
            doc = Jsoup.connect("https://www.craigslist.org/").get();
            for (Element ele : doc.getElementsByClass("col")) {
                category = new Category(ele.selectFirst("a").select("span").text(), ele.selectFirst("a").attr("href"));
                for(Element subEle : ele.select("li")){
                    subCategory = new Category(subEle.select("a").select("span").text(), subEle.select("a").attr("href"));
                    category.getSubCategories().add(subCategory);
                }
                categoriesArrayList.add(category);
            }

//            doc = Jsoup.connect("https://www.craigslist.org/about/sites").get();

//            for (Element ele : doc.getElementsByClass("colmack"))

//            for(LocationsCategory cat : CraigslistData.getCategoriesArrayList()){
//                Log.d(TAG, cat.getStateName() + "," + cat.getUrlRef());
//                for(LocationsCategory subCat : cat.stateCategories){
//                    Log.d(TAG, subCat.getStateName() + "," + subCat.getUrlRef());
//                }
//            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return categoriesArrayList;
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
