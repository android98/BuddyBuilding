package com.example.buddybuilding.models;

import android.arch.lifecycle.ViewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import javax.crypto.interfaces.PBEKey;

public class MorabiListModel extends ViewModel {

    @SerializedName("records")
    @Expose
    public ArrayList<MorabiModel> records = new ArrayList<>();

    public ArrayList<MorabiModel> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<MorabiModel> records) {
        this.records = records;
    }
}
