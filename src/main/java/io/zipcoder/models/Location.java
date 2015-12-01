package io.zipcoder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by emaron on 11/27/15.
 */
@Entity
@Table(name="location")
public class Location {

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
     * @param articleId
     * @param name
     */
   public Location(int articleId, String name) {
        this.articleId = articleId;
        this.name = name;
    }

    /**
     * Default Constructor
     */
    public Location(){}

    /**
     * Get id
     *
     * @return the id for a location
     */
    public int getId() {
        return id;
    }


    /**
     * Set id
     *
     * @param id sets a locations id
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
     * Set this location's associated article's id
     *
     * @param articleId sets the location id
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    /**
     * Get the name of the location
     *
     * @return the name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a location
     *
     * @param name sets the name of a location
     */
    public void setName(String name) {
        this.name = name;
    }
}
