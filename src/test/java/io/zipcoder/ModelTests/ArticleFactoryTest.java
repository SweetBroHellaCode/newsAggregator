package io.zipcoder.ModelTests;

import io.zipcoder.models.Article;
import io.zipcoder.models.ArticleFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by emaron on 12/1/15.
 */
public class ArticleFactoryTest {

    ArticleFactory articleFactory;
    JSONObject jsonObjectResponseBody;
    JSONObject jsonObjectInsideJsonArray;
    JSONObject jsonObjectInsideJsonObjectInsideArray;
    JSONArray jsonArrayInsideResponseBody;
    JSONObject siteName;

    @Before
    public void resourcesNeededToTest(){
        articleFactory = new ArticleFactory();

        //Each JSON object from the
        //response
        jsonObjectResponseBody = new JSONObject();
        jsonArrayInsideResponseBody = new JSONArray();
        jsonObjectInsideJsonArray = new JSONObject();
        jsonObjectInsideJsonObjectInsideArray = new JSONObject();
        siteName = new JSONObject();

        //Composition of the response
        //JSON object
        siteName.put("site_full", "cnn");
        jsonObjectInsideJsonArray.put("title", "Mary Sue");
        jsonObjectInsideJsonArray.put("author", "Mary Sue");
        jsonObjectInsideJsonArray.put("published", "Mary Sue");
        jsonObjectInsideJsonArray.put("url", "Mary Sue");
        jsonObjectInsideJsonArray.put("text", "Mary Sue");
        jsonObjectInsideJsonArray.put("thread", siteName);
        jsonObjectInsideJsonArray.put("crawled", "Mary Sue");
        jsonArrayInsideResponseBody.put(jsonObjectInsideJsonArray);
        jsonObjectResponseBody.put("posts", jsonArrayInsideResponseBody);
    }

    @Test
    public void givenJSONObjectShouldReturnAnObject(){
        assertTrue("Should return an object", articleFactory.constructArticle(jsonObjectResponseBody) != null);
    }

    @Test
    public void givenJSONObjectShouldReturnAnArticle(){
        assertTrue("Should return an Article object", articleFactory.constructArticle(jsonObjectResponseBody).getUrl() != null);
    }

}
