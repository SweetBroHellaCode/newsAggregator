package io.zipcoder.services;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.zipcoder.models.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


/**
 * Created by emaron on 11/29/15.
 */
@Service
public class CNNNewsUpdater {
    //Controllers for each new object
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    LocationDAO locationDAO;
    @Autowired
    OrganizationDAO organizationDAO;
    @Autowired
    PersonsDAO personsDAO;

    @Scheduled(fixedRate = 1000 * 60 * 60)
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


                //If text is not null and is not
                //already present in database, then
                //save to database
                if (articleDAO.findByUrl(newsArticle.getUrl()) == null) {
                    articleDAO.save(newsArticle);
                }


                //If a story has a location object, then
                //for each object, see if it exists in
                //the database to determine whether or not
                //to add it to the database
                if (newsCNNArticles.getJSONObject(i).getJSONArray("locations").length() != 0) {

                    for (int j = 0; j < newsCNNArticles.getJSONObject(i).getJSONArray("locations").length(); j++) {
                        if (locationDAO.findByArticleId(articleDAO.findByUrl(newsArticle.getUrl()).getId()) == null) {
                            newsArticleLocations = new Location(
                                    articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                    newsCNNArticles.getJSONObject(i).getJSONArray("locations").get(j).toString()
                            );

                            locationDAO.save(newsArticleLocations);
                        }
                    }

                }

                //If a story has a organization object, then
                //for each object, see if it exists in
                //the database to determine whether or not
                //to add it to the database
                if (newsCNNArticles.getJSONObject(i).getJSONArray("organizations").length() != 0) {

                    for (int j = 0; j < newsCNNArticles.getJSONObject(i).getJSONArray("organizations").length(); j++) {
                        if (organizationDAO.findByArticleId(articleDAO.findByUrl(newsArticle.getUrl()).getId()) == null) {
                            newsArticleOrganizations = new Organization(
                                    articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                    newsCNNArticles.getJSONObject(i).getJSONArray("organizations").get(j).toString()
                            );

                            organizationDAO.save(newsArticleOrganizations);
                        }
                    }

                }

                //If a story has a persons object, then
                //for each object, see if it exists in
                //the database to determine whether or not
                //to add it to the database
                if (newsCNNArticles.getJSONObject(i).getJSONArray("persons").length() != 0) {

                    for (int j = 0; j < newsCNNArticles.getJSONObject(i).getJSONArray("persons").length(); j++) {
                        if (personsDAO.findByArticleId(articleDAO.findByUrl(newsArticle.getUrl()).getId()) == null) {
                            newsArticlePersons = new Persons(
                                    articleDAO.findByUrl(newsArticle.getUrl()).getId(),
                                    newsCNNArticles.getJSONObject(i).getJSONArray("persons").get(j).toString()
                            );

                            personsDAO.save(newsArticlePersons);

                        }
                    }

                }

            }
        } catch (UnirestException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}