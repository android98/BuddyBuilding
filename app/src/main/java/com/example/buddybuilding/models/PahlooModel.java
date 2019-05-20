package com.example.buddybuilding.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PahlooModel
        extends RealmObject {


    @PrimaryKey
    public int id;
    public String name, url;

    public PahlooModel(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public PahlooModel(){
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
