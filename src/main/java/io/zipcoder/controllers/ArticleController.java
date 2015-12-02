package io.zipcoder.controllers;

import com.google.common.collect.Lists;
import io.zipcoder.models.Article;
import io.zipcoder.models.ArticleDAO;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emaron on 11/28/15.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleDAO articleDAO;


    @ResponseBody
    @RequestMapping(value = "/article/create", method = RequestMethod.GET)
    public void createArticle(Article newArticle) {
        articleDAO.save(newArticle);
    }

    @ResponseBody
    @RequestMapping(value = "/article/readsingle", method = RequestMethod.GET)
    public Article readSingleArticle(int id) {
        return articleDAO.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/article/findbyterm", method = RequestMethod.GET)
    public ArrayList<Article> readAllWithTerm(String searchTerm) {
        ArrayList<Article> allArticlesWithTerm = new ArrayList<>();
        Iterator<Article> articles = articleDAO.findAll().iterator();

        Pattern patternSearchTerm = Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE);

        while (articles.hasNext()) {
            Article article = articles.next();
            Matcher patternSearchTermMatcher = patternSearchTerm.matcher(article.getText());
            if (patternSearchTermMatcher.find()) {
                allArticlesWithTerm.add(article);
            }
        }


        return allArticlesWithTerm;

    }

    @ResponseBody
    @RequestMapping(value = "/article/update", method = RequestMethod.GET)
    public Article updateArticle(int id, String name, String author, String published, String url, String source, String title, String text, String crawled) {
        Article oldArticle = articleDAO.findOne(id);
        Article newArticle;

        if (oldArticle != null) {
            newArticle = oldArticle;

            newArticle.setName(name);
            newArticle.setAuthor(author);
            newArticle.setPublished(published);
            newArticle.setUrl(url);
            newArticle.setSource(source);
            newArticle.setTitle(title);
            newArticle.setText(text);
            newArticle.setCrawled(crawled);

            articleDAO.save(newArticle);
        } else {
            return null;
        }
        return newArticle;
    }

    @ResponseBody
    @RequestMapping(value = "/article/delete", method = RequestMethod.GET)
    public void deleteArticle(int id) {
        Article tempArticle = articleDAO.findOne(id);
        if (tempArticle != null) {
            articleDAO.delete(tempArticle);
        }
    }
}
