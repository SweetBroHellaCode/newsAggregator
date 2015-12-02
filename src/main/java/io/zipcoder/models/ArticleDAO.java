package io.zipcoder.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by emaron on 11/27/15.
 */
@Repository
public interface ArticleDAO extends CrudRepository<Article, Integer> {

    Article findByUrl(String url);
}
