package io.zipcoder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by emaron on 11/27/15.
 */
@Entity
@Table(name = "persons")
public class Persons {

    //Table values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(name="article_id")
    private int articleId;
    @NotNull
    private String name;

    /**
     * Constructor
     *
     * @param article_id
     * @param name
     */
    public Persons(int article_id, String name) {
        this.articleId = article_id;
        this.name = name;
    }

    /**
     * Default Constructor
     */
    public Persons() {
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
    public int getArticleId() {
        return articleId;
    }

    /**
     * Set this person's associated article's id
     *
     * @param article_id sets the persons id
     */
    public void setArticleId(int article_id) {
        this.articleId = article_id;
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
