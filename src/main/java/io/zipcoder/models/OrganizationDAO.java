package io.zipcoder.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by emaron on 11/27/15.
 */
public interface OrganizationDAO extends CrudRepository<Organization, Integer> {

    Organization findByName(String name);

    List findAllByName(String name);

    Organization findByArticleId(int id);
}
