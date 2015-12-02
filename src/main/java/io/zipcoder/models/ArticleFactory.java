package io.zipcoder.models;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by emaron on 12/1/15.
 */
public class ArticleFactory {

    public Article constructArticle(JSONObject object) {
        Article result;
        //Convert CNN's response to an Array
        JSONArray newsCNNArticles = object.getJSONArray("posts");

            //Make new Article for each CNN story
            result = new Article(
                    newsCNNArticles.getJSONObject(0).get("title").toString(),
                    newsCNNArticles.getJSONObject(0).get("author").toString(),
                    newsCNNArticles.getJSONObject(0).get("published").toString(),
                    newsCNNArticles.getJSONObject(0).get("url").toString(),
                    newsCNNArticles.getJSONObject(0).getJSONObject("thread").get("site_full").toString(),
                    newsCNNArticles.getJSONObject(0).get("title").toString(),
                    newsCNNArticles.getJSONObject(0).get("text").toString(),
                    newsCNNArticles.getJSONObject(0).get("crawled").toString()
            );

        return result;
    }
}
