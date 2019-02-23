package com.domenicportuesi.materialcraigslist.craigslistScraper;


import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public class PostsData extends AsyncTask<String, Void, PostsData.PostDataCategory> {
    private final String TAG = "PostsDataAyncTask";
    Document doc = null;



    public static class PostDataCategory {

        String urlRef = "";
        String postedTime = "";
        String title = "";
        ArrayList<String> photoUrlList = new ArrayList<>();
        String condition = "";
        String location = "";
        String price = "";

        public ArrayList<String> getPhotoUrlList() {
            return photoUrlList;
        }

        public void setPhotoUrlList(ArrayList<String> photoUrlList) {
            this.photoUrlList = photoUrlList;
        }


        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }


        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }


        public PostDataCategory() {
        }

        public String getUrlRef() {
            return urlRef;
        }

        public void setUrlRef(String urlRef) {
            this.urlRef = urlRef;
        }

        public String getPostedTime() {
            return postedTime;
        }

        public void setPostedTime(String postedTime) {
            this.postedTime = postedTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }





    }

    @Override
    protected PostDataCategory doInBackground(String... url) {
        PostDataCategory post = new PostDataCategory();


        try {
            doc = Jsoup.connect(url[0]).get();

            post.setUrlRef(url[0]);

            for (Element ele : doc.getAllElements()) {
                if( ele.select("span").text().contains("condition")){
                    post.setCondition(ele.select("b").text());
                }

                if( ele.className().equals("date timeago")){
                    post.setPostedTime(ele.text());
                }

                if(ele.id().equals("titletextonly")){
                    post.setTitle(ele.text());
                }
                if(ele.className().equals("thumb")){
                    post.getPhotoUrlList().add(ele.attr("href"));

                }
                if(ele.className().equals("postingtitletext")){
                    post.setLocation(ele.select("small").text());
                }
                if(ele.className().equals("price")){
                    post.setPrice(ele.text());
                }



            }


            }catch(Exception e) {

        }


//            doc = Jsoup.connect("https://www.craigslist.org/about/sites").get();

//            for (Element ele : doc.getElementsByClass("colmack"))

//            for(PostDataCategory cat : CraigslistData.getCategoriesArrayList()){
//                Log.d(TAG, cat.getStateName() + "," + cat.getUrlRef());
//                for(PostDataCategory subCat : cat.stateCategories){
//                    Log.d(TAG, subCat.getStateName() + "," + subCat.getUrlRef());
//                }
//            }

        return post;
    }

    protected void onPostExecute(Void result){

    }


    private String getHTML() {
        return doc.title();
    }

    private ArrayList<PostDataCategory> getMainCatagories() {

        ArrayList<PostDataCategory> postDataCategoryArrayList = new ArrayList<>();



        return postDataCategoryArrayList;

    }


}
