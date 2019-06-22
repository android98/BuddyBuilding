package com.example.buddybuilding.remote;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.buddybuilding.models.MorabiListModel;
import com.example.buddybuilding.models.MorabiModel;
import com.example.buddybuilding.viewmodel.MorabiViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MorabiRepository {

    public MutableLiveData<ArrayList<MorabiViewModel>> getArrayListMutableLi = new MutableLiveData<>();
    public ArrayList<MorabiViewModel> arrayList;
    public ArrayList<MorabiModel> items;
    public APIService apiService;
    public Context context;

    public MorabiRepository() {
    }

    public MutableLiveData<ArrayList<MorabiViewModel>> getGetArrayListMutableLi() {

        apiService = RetroClass.getRetroInstance().create(APIService.class);
        Call<MorabiListModel> morabiList = apiService.getMorabiList();
        morabiList.enqueue(new Callback<MorabiListModel>() {
            @Override
            public void onResponse(Call<MorabiListModel> call, Response<MorabiListModel> response) {
                items = response.body().getRecords();
                MorabiModel morabiModel;
                MorabiViewModel morabiViewModel;
                arrayList = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    morabiModel = new MorabiModel(
                            items.get(i).getId(),
                            items.get(i).getName(),
                            items.get(i).getInformations(),
                            items.get(i).getImage());
                    Log.d("response", "onResponse: " + items.get(i).getName());
                    Log.d("response", "onResponse: " + items.get(i).getImage());
                    Log.d("response", "onResponse: " + items.get(i).getInformations());
                    Log.d("looging", "onBindViewHolder: " + "come innnnnnnnnnnnnnnnnnnnnnnnn4444444444");

                    morabiViewModel = new MorabiViewModel(morabiModel);
                    arrayList.add(morabiViewModel);
                }
                getArrayListMutableLi.setValue(arrayList);
            }

            @Override
            public void onFailure(Call<MorabiListModel> call, Throwable t) {
                Log.d("Error", "onFailure: " + t.getMessage().toString());
            }
        });
        return getArrayListMutableLi;
    }
}
