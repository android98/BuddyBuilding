package com.example.buddybuilding.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MorabiModel {

    @SerializedName("id")
    @Expose
    public Integer id;


    @SerializedName("name")
    @Expose
    public String name;


    @SerializedName("informations")
    @Expose
    public String informations;


    @SerializedName("image")
    @Expose
    public String image;

    public MorabiModel(Integer id, String name, String informations, String image) {
        this.id = id;
        this.name = name;
        this.informations = informations;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformations() {
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MorabiModel() {
    }
}
