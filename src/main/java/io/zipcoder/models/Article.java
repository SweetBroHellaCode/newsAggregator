package io.zipcoder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 * Created by emaron on 11/25/15.
 */
@Entity
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
    @NotNull
    private String[] persons;
    @NotNull
    private String[] locations;
    @NotNull
    private String[] organizations;

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
     * @param persons
     * @param locations
     * @param organizations
     */
    public Article(String name, String author, String published, String url, String source, String title, String text, String crawled, String[] persons, String[] locations, String[] organizations) {
        this.name = name;
        this.author = author;
        this.published = published;
        this.url = url;
        this.source = source;
        this.title = title;
        this.text = text;
        this.crawled = crawled;
        this.persons = persons;
        this.locations = locations;
        this.organizations = organizations;
    }


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

    /**
     * Get persons
     *
     * @return
     */
    public String[] getPersons() {
        return persons;
    }

    /**
     * Set persons
     *
     * @param persons
     */
    public void setPersons(String[] persons) {
        this.persons = persons;
    }

    /**
     * Get location
     *
     * @return
     */
    public String[] getLocations() {
        return locations;
    }

    /**
     * Set location
     *
     * @param locations
     */
    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    /**
     * Get organizations
     *
     * @return
     */
    public String[] getOrganizations() {
        return organizations;
    }

    /**
     * Set organizations
     *
     * @param organizations
     */
    public void setOrganizations(String[] organizations) {
        this.organizations = organizations;
    }
}