package com.example.buddybuilding.remote;

import android.support.v7.widget.CardView;

import com.example.buddybuilding.models.MorabiListModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("ReadMorabiNames.php")
    Call<MorabiListModel>getMorabiList() ;

}
