package org.concepts3060.pa03project;

public class DTO {

    /* Declaration of Public Class Objects  */
    private String name;
    private String category;
    private String location;
    private String url;
    private String tags;
    private String id;

    /* Constructor */
    public DTO(String name, String category, String location, String url, String tags, String id) {
        this.name = name;
        this.category = category;
        this.location = location;
        this.url = url;
        this.tags = tags;
        this.id = id;
    }

    /* Getters */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

    public String getTags() {
        return tags;
    }

    /* Setters */
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}

