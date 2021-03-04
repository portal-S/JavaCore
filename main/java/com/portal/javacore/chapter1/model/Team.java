package com.portal.javacore.chapter1.model;

import java.util.List;

public class Team {
    private int id;
    private String name;
    private List<Developer> posts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Developer> getPosts() {
        return posts;
    }

    public void setPosts(List<Developer> posts) {
        this.posts = posts;
    }
}
