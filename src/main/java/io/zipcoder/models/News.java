package io.zipcoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by emaron on 11/29/15.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class News {
    private String title_full;

    private String author;

    private String published;

    private String url;

    private String site_full;

    private String title;

    private String text;

    private String crawled;

    private Object thread;

    public String getTitle_full() {
        return title_full;
    }

    public void setTitle_full(String title_full) {
        this.title_full = title_full;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSite_full() {
        return site_full;
    }

    public void setSite_full(String site_full) {
        this.site_full = site_full;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCrawled() {
        return crawled;
    }

    public void setCrawled(String crawled) {
        this.crawled = crawled;
    }

    public Object getThread() {
        return thread;
    }

    public void setThread(Object thread) {
        this.thread = thread;
    }
}
