package io.zipcoder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by emaron on 12/1/15.
 */
@Entity
@Table(name = "quote")
public class Quote {
    //Table values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Column(name = "article_id")
    private int articleId;
    @NotNull
    private String name;

    /**
     * Constructor
     *
     * @param articleId
     * @param name
     */
    Quote(int articleId, String name) {
        this.articleId = articleId;
        this.name = name;
    }

    /**
     * Default Constructor
     */
    Quote() {
    }

    /**
     * Get id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get corresponding article id
     *
     * @return
     */
    public int getArticleId() {
        return articleId;
    }

    /**
     * Set corresponding article id
     *
     * @param articleId
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    /**
     * Get name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
