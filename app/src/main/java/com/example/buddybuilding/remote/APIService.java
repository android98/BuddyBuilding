package com.example.buddybuilding.remote;

import com.example.buddybuilding.models.MorabiListModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("ReadMorabiNames.php")
    Call<MorabiListModel>getMorabiList() ;

}
