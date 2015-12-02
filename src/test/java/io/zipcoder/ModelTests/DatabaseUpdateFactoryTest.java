package io.zipcoder.ModelTests;

import io.zipcoder.models.Article;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by emaron on 12/1/15.
 */
public class DatabaseUpdateFactoryTest {

    Article article;
    JSONObject jsonResponseBody;
    JSONObject siteName;
    JSONArray jsonLocationArray;

    @Before
    public void resourcesNeededToTest() {
        article = new Article();

        siteName = new JSONObject();
        jsonResponseBody = new JSONObject();
        jsonLocationArray = new JSONArray();

        //Composition of the response
        siteName.put("site_full", "cnn");
        jsonResponseBody.put("title", "Unit Test For Life");
        jsonResponseBody.put("author", "Mary Sue");
        jsonResponseBody.put("published", "soon");
        jsonResponseBody.put("url", "comcast.net");
        jsonResponseBody.put("text", "blah blah");
        jsonResponseBody.put("thread", siteName);
        jsonResponseBody.put("crawled", "crawledTest");
        jsonLocationArray.put("location test");
        jsonResponseBody.put("location", jsonLocationArray);

    }

    @Test
    public void givenJSONObjectShouldReturnAnObject() {
        assertTrue("Should return an object", article.convertArticleFromJsonObject(jsonResponseBody) != null);
    }

    @Test
    public void givenJSONObjectShouldReturnAnArticle() {

        assertTrue("Should return an Article object", article.convertArticleFromJsonObject(jsonResponseBody).getUrl() == jsonResponseBody.getString("url"));
    }

}
