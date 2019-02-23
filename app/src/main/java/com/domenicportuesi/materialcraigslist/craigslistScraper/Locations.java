package com.domenicportuesi.materialcraigslist.craigslistScraper;


import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class Locations extends AsyncTask<Void, Void, ArrayList<Locations.LocationsCategory>> {
    private final String TAG = "LocationsAyncTask";
    Document doc = null;
    public static ArrayList<LocationsCategory> locationsCategoryArrayList = new ArrayList<>();


    public static class LocationsCategory {

        String urlRef = "";
        String stateName = "";
        String countryName = "";
        String areaName = "";
        ArrayList<LocationsCategory> stateCategories = new ArrayList<>();
        ArrayList<LocationsCategory> areaCategories = new ArrayList<>();

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public ArrayList<LocationsCategory> getAreaCategories() {
            return areaCategories;
        }

        public void setAreaCategories(ArrayList<LocationsCategory> areaCategories) {
            this.areaCategories = areaCategories;
        }


        public LocationsCategory(){

        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }


        public ArrayList<LocationsCategory> getStateCategories() {
            return stateCategories;
        }

        public void setStateCategories(ArrayList<LocationsCategory> stateCategories) {
            this.stateCategories = stateCategories;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public String getUrlRef() {
            return urlRef;
        }

        public void setUrlRef(String urlRef) {
            this.urlRef = urlRef;
        }


        public LocationsCategory(String stateName, String urlRef) {
            this.stateName = stateName;
            this.urlRef = urlRef;
        }


    }

    @Override
    protected ArrayList<LocationsCategory> doInBackground(Void... Void) {
        LocationsCategory countries;
        LocationsCategory states;
        LocationsCategory area;
        try {
            doc = Jsoup.connect("https://www.craigslist.org/about/sites").get();


            for (Element ele : doc.getAllElements()) {
                if(ele.tagName().equals("h1")){
                    countries = new LocationsCategory();
                    countries.setCountryName(ele.text());
                    locationsCategoryArrayList.add(countries);
                }
                if(ele.tag().toString().equals("h4")){
                    states = new LocationsCategory();
                    states.setStateName(ele.text());
                    locationsCategoryArrayList.get(locationsCategoryArrayList.size() - 1).getStateCategories().add(states);
                }
                if(ele.tag().toString().equals("li")){
                    area = new LocationsCategory();
                    area.setAreaName(ele.select("a").text());
                    area.setUrlRef(ele.select("a").attr("href"));
                    locationsCategoryArrayList.get(locationsCategoryArrayList.size() - 1).getStateCategories().get(locationsCategoryArrayList.get(locationsCategoryArrayList.size() - 1).getStateCategories().size() - 1).getAreaCategories().add(area);
                }
            }

//            doc = Jsoup.connect("https://www.craigslist.org/about/sites").get();

//            for (Element ele : doc.getElementsByClass("colmack"))

//            for(PostDataCategory cat : CraigslistData.getCategoriesArrayList()){
//                Log.d(TAG, cat.getStateName() + "," + cat.getUrlRef());
//                for(PostDataCategory subCat : cat.stateCategories){
//                    Log.d(TAG, subCat.getStateName() + "," + subCat.getUrlRef());
//                }
//            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return locationsCategoryArrayList;
    }

    protected void onPostExecute(Void result){

    }


    private String getHTML() {
        return doc.title();
    }

    private ArrayList<LocationsCategory> getMainCatagories() {

        ArrayList<LocationsCategory> locationsCategoryArrayList = new ArrayList<>();



        return locationsCategoryArrayList;

    }


}
