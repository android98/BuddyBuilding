package com.example.buddybuilding.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PoshtbazooModel extends RealmObject {


    @PrimaryKey
    public int id;
    public String name, url,information;

    public PoshtbazooModel(int id, String name, String url, String information) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.information = information;
    }

    public PoshtbazooModel(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public PoshtbazooModel() {
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
