package io.zipcoder.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by emaron on 11/27/15.
 */
public interface PersonsDAO extends CrudRepository<Persons, Integer> {
    Persons findByName(String name);

    List findAllByName(String name);

    Persons findByArticleId(int id);
}
