package io.zipcoder.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by emaron on 12/1/15.
 */
public interface QuoteDAO extends CrudRepository<Quote, Integer> {
    Quote findByName(String name);

    List findAllByName(String name);

    Quote findByArticleId(int id);

}
