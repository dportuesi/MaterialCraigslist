package com.domenicportuesi.materialcraigslist.craigslistScraper;


import android.graphics.Picture;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URL;
import java.util.ArrayList;

public class Posts extends AsyncTask<String, Void, ArrayList<Posts.PostsCategory>> {
    private final String TAG = "PostsAyncTask";
    Document doc = null;
    Document doc1 = null;
    public static ArrayList<PostsCategory> postsCategoryArrayList = new ArrayList<>();



    public static class PostsCategory {

        String urlRef = "";
        String date = "";
        String title = "";
        String photoUrl = "";

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        String price = "";

        public PostsCategory() {
        }

        public String getUrlRef() {
            return urlRef;
        }

        public void setUrlRef(String urlRef) {
            this.urlRef = urlRef;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photo) {
            this.photoUrl = photo;
        }




    }

    @Override
    protected ArrayList<PostsCategory> doInBackground(String... url) {
        PostsCategory post;
        try {
            doc = Jsoup.connect(url[0]).get();


            for (Element ele : doc.getElementsByClass("result-row")) {
                    post = new PostsCategory();
                    post.setPrice(ele.getElementsByClass("result-price").first().text());
                    post.setUrlRef(ele.getElementsByClass("result-title hdrlnk").attr("href"));
                    post.setTitle(ele.getElementsByClass("result-title hdrlnk").text());

                    doc1 = Jsoup.connect(post.getUrlRef()).get();
                    post.setPhotoUrl(doc1.select("img").first().absUrl("src"));

                    postsCategoryArrayList.add(post);

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

        return postsCategoryArrayList;
    }

    protected void onPostExecute(Void result){

    }


    private String getHTML() {
        return doc.title();
    }

    private ArrayList<PostsCategory> getMainCatagories() {

        ArrayList<PostsCategory> postsCategoryArrayList = new ArrayList<>();



        return postsCategoryArrayList;

    }


}
