package io.zipcoder.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by emaron on 11/25/15.
 */
@Entity
@Table(name= "article")
public class Article {

    // Table values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String author;
    @NotNull
    private String published;
    @NotNull
    private String url;
    @NotNull
    private String source;
    @NotNull
    private String title;
    @NotNull
    private String text;
    @NotNull
    private String crawled;


    /**
     * Constructor
     *
     * @param name
     * @param author
     * @param published
     * @param url
     * @param source
     * @param title
     * @param text
     * @param crawled
     */
    public Article(String name, String author, String published, String url, String source, String title, String text, String crawled) {
        this.name = name;
        this.author = author;
        this.published = published;
        this.url = url;
        this.source = source;
        this.title = title;
        this.text = text;
        this.crawled = crawled;
    }

    /**
     * Default constructor
     */
   public Article(){}

    /**
     * Get id
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * Get author
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get published
     *
     * @return
     */
    public String getPublished() {
        return published;
    }

    /**
     * Set published
     *
     * @param published
     */
    public void setPublished(String published) {
        this.published = published;
    }

    /**
     * Get url
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set url
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get source
     *
     * @return
     */
    public String getSource() {
        return source;
    }

    /**
     * Set source
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Get title
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get text
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Set text
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get crawled
     *
     * @return
     */
    public String getCrawled() {
        return crawled;
    }

    /**
     * Set crawled
     *
     * @param crawled
     */
    public void setCrawled(String crawled) {
        this.crawled = crawled;
    }


}