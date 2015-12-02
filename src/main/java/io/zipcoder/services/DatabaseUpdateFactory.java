package io.zipcoder.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.zipcoder.models.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * Created by emaron on 11/29/15.
 */
@Service
public class DatabaseUpdateFactory {
    //Controllers for each new object

    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    LocationDAO locationDAO;
    @Autowired
    OrganizationDAO organizationDAO;
    @Autowired
    PersonsDAO personsDAO;

    @Async
    public void updateNews(String url) {

        //Request object variable
        HttpResponse<JsonNode> response = null;

        //Objects to be created from response
        Article article = new Article();
        Location newsArticleLocations;
        Organization newsArticleOrganizations;
        Persons newsArticlePersons;

        //Go to news site and pull all articles listed as news
        try {
            response = Unirest.get(url)
                    .header("Accept", "application/json")
                    .asJson();
        } catch (UnirestException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        //Convert new site's response to an Array
        JSONArray newsStoryArticles = response.getBody().getObject().getJSONArray("posts");

        //Convert each entry in the array to
        //corresponding article, location, persons,
        //and organization object

        for (int i = 1; i < newsStoryArticles.length(); i++) {

            //Make new Article for each story
            Article newsArticle = article.convertArticleFromJsonObject(newsStoryArticles.getJSONObject(i));

            //If url is not already
            //present in database, then
            //save article to database
            if (null == articleDAO.findByUrl(newsArticle.getUrl())) {
                articleDAO.save(newsArticle);
            }
            //If a story has a location object, then
            //for each object, see if it exists in
            //the database to determine whether or not
            //to add it to the database
            if (newsStoryArticles.getJSONObject(i).getJSONArray("locations").length() != 0) {
                for (int j = 0; j < newsStoryArticles.getJSONObject(i).getJSONArray("locations").length(); j++) {
                    if (locationDAO.findByArticleId(articleDAO.findByUrl(newsArticle.getUrl()).getId()) == null) {
                        newsArticleLocations = new Location(
                                articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                newsStoryArticles.getJSONObject(i).getJSONArray("locations").get(j).toString()
                        );
                        locationDAO.save(newsArticleLocations);
                    }
                }
            }
            //If a story has a organization object, then
            //for each object, see if it exists in
            //the database to determine whether or not
            //to add it to the database
            if (newsStoryArticles.getJSONObject(i).getJSONArray("organizations").length() != 0) {

                for (int j = 0; j < newsStoryArticles.getJSONObject(i).getJSONArray("organizations").length(); j++) {
                    if (organizationDAO.findByArticleId(articleDAO.findByUrl(newsArticle.getUrl()).getId()) == null) {
                        newsArticleOrganizations = new Organization(
                                articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                newsStoryArticles.getJSONObject(i).getJSONArray("organizations").get(j).toString()
                        );
                        if (newsArticleOrganizations.getName().length() <= 255) {
                            organizationDAO.save(newsArticleOrganizations);
                        }
                    }
                }
            }
            //If a story has a persons object, then
            //for each object, see if it exists in
            //the database to determine whether or not
            //to add it to the database
            if (newsStoryArticles.getJSONObject(i).getJSONArray("persons").length() != 0) {
                for (int j = 0; j < newsStoryArticles.getJSONObject(i).getJSONArray("persons").length(); j++) {
                    if (personsDAO.findByArticleId(articleDAO.findByUrl(newsArticle.getUrl()).getId()) == null) {
                        newsArticlePersons = new Persons(
                                articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                newsStoryArticles.getJSONObject(i).getJSONArray("persons").get(j).toString()
                        );
                        personsDAO.save(newsArticlePersons);
                    }
                }
            }
        }
    }
}