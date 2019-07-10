package com.example.buddybuilding.models;

import androidx.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MokamelAvaliehModel extends RealmObject {

    @PrimaryKey
    public int id;

    public int parentid;
    public String name,informations, image_url;


    public MokamelAvaliehModel() {
    }

    public MokamelAvaliehModel(int id, int parentid, String name, String informations, String image_url) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.informations = informations;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {

        this.image_url = image_url;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
