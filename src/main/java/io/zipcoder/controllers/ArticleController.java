package io.zipcoder.controllers;

import io.zipcoder.models.Article;
import io.zipcoder.models.ArticleDAO;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by emaron on 11/28/15.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleDAO articleDAO;


    @ResponseBody
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String createArticle() {
/*
String name, String author, String published, String url, String source, String title, String text, String crawled
        Article newArticle = new Article(name, author, published, url, source, title, text, crawled);
        articleDAO.save(newArticle);
*/
        return "Connection established";
    }

}
