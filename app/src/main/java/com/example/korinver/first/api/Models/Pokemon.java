package com.example.korinver.first.api.Models;

public class Pokemon {
    private Integer id;
    private String name;
    private String url;

    public Pokemon() {
    }

    public Pokemon(String name, String url, Integer id) {
        this.name = name;
        this.url = url;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length-1]);
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
