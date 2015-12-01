package io.zipcoder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by emaron on 11/27/15.
 */
@Entity
@Table(name = "organization")
public class Organization {

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
    public Organization(int article_id, String name) {
        this.articleId = article_id;
        this.name = name;
    }

    /**
     * Default Constructor
     */
    public Organization() {
    }

    /**
     * Get id
     *
     * @return the id for a organization
     */
    public int getId() {
        return id;
    }


    /**
     * Set id
     *
     * @param id sets a organizations id
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
     * Set this organization's associated article's id
     *
     * @param article_id sets the organizations id
     */
    public void setArticleId(int article_id) {
        this.articleId = article_id;
    }

    /**
     * Get the name of the organization
     *
     * @return the name of the organization
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a organization
     *
     * @param name sets the name of a organization
     */
    public void setName(String name) {
        this.name = name;
    }
}
