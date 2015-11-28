package io.zipcoder.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by emaron on 11/27/15.
 */
public interface ArticleDAO extends CrudRepository<Article, Integer> {

}
