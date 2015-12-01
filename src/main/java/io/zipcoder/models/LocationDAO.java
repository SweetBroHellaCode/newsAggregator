package io.zipcoder.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by emaron on 11/27/15.
 */
public interface LocationDAO extends CrudRepository<Location, Integer> {

    Location findByName(String name);

    List findAllByName(String name);

    Location findByArticleId(int id);
}
