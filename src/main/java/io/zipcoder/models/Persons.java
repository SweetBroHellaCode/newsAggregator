package io.zipcoder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by emaron on 11/27/15.
 */
@Entity
public class Persons {

    //Table values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private int article_id;
    @NotNull
    private String name;

    /**
     * Constructor
     *
     * @param article_id
     * @param name
     */
    Persons(int article_id, String name) {
        this.article_id = article_id;
        this.name = name;
    }

    /**
     * Get id
     *
     * @return the id for a person
     */
    public int getId() {
        return id;
    }


    /**
     * Set id
     *
     * @param id sets a person's id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the associated article id
     *
     * @return article id
     */
    public int getArticle_id() {
        return article_id;
    }

    /**
     * Set this person's associated article's id
     *
     * @param article_id sets the persons id
     */
    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    /**
     * Get the name of the persons
     *
     * @return the name of the persons
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a persons
     *
     * @param name sets the name of a persons
     */
    public void setName(String name) {
        this.name = name;
    }
}
