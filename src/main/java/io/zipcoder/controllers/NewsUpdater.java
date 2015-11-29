package io.zipcoder.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.zipcoder.models.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.bus.Event;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;


/**
 * Created by emaron on 11/29/15.
 */
@Service
public class NewsUpdater {
    //Controllers for each new object
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    LocationDAO locationDAO;
    @Autowired
    OrganizationDAO organizationDAO;
    @Autowired
    PersonsDAO personsDAO;

    @Scheduled(fixedRate = 1000 * 60 * 2)
    public void updateCNN() {

        //Objects to be created from response
        Article newsArticle;
        Location newsArticleLocations;
        Organization newsArticleOrganizations;
        Persons newsArticlePersons;

        try {
            //Go to CNN and pull all articles listed as news
            HttpResponse<JsonNode> response = Unirest.get("https://webhose.io/search?token=a600ee1f-6b6f-4c11-9ae4-42835aa5b3cc&format=json&q=news&site=cnn.com&site_type=news")
                    .header("Accept", "application/json")
                    .asJson();

            //Convert CNN's response to an Array
            JSONArray newsCNNArticles = response.getBody().getObject().getJSONArray("posts");

            //Convert each entry in the array to
            //corresponding article, location, persons,
            //and organization object
            for (int i = 1; i < newsCNNArticles.length(); i++) {

                System.out.println(i + ":");

                //Make new Article for each CNN story
                newsArticle = new Article(
                        newsCNNArticles.getJSONObject(i).get("title").toString(),
                        newsCNNArticles.getJSONObject(i).get("author").toString(),
                        newsCNNArticles.getJSONObject(i).get("published").toString(),
                        newsCNNArticles.getJSONObject(i).get("url").toString(),
                        newsCNNArticles.getJSONObject(i).getJSONObject("thread").get("site_full").toString(),
                        newsCNNArticles.getJSONObject(i).get("title").toString(),
                        newsCNNArticles.getJSONObject(i).get("text").toString(),
                        newsCNNArticles.getJSONObject(i).get("crawled").toString()
                );

                System.out.println(newsArticle.getText());

                //If text is not null and is not
                //already present in database, then
                //save to database


                //Make new Location article if applicable
                if (newsCNNArticles.getJSONObject(i).getJSONArray("locations").length() != 0 && newsCNNArticles.getJSONObject(i).getJSONArray("locations") != null) {
                    for (int j = 0; j < newsCNNArticles.getJSONObject(i).getJSONArray("locations").length(); j++) {
                        newsArticleLocations = new Location(
                                articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                newsCNNArticles.getJSONObject(i).getJSONArray("locations").get(i).toString()
                        );

                        System.out.println(newsArticleLocations);
                    }
                }


            }
        } catch (UnirestException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}