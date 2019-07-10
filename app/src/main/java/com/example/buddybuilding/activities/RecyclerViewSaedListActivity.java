package com.example.buddybuilding.activities;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowSaedAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewSaedListBinding;
import com.example.buddybuilding.models.SaedModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewSaedListActivity extends AppCompatActivity {


    ActivityRecyclerViewSaedListBinding binding;


    private Context context;
    RealmResults<SaedModel> saedModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_saed_list);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_saed_list    );

        Realm realm = Realm.getDefaultInstance();
        saedModels = realm.where(SaedModel.class)
                .findAll();
        for (int i = 0; i < saedModels.size(); i++) {
            Log.d("runn", "execute: " + saedModels.get(i).getId());
            Log.d("runn", "execute: " + saedModels.get(i).getName());
            Log.d("runn", "execute: " + saedModels.get(i).getUrl());
            Log.d("runn", "execute: " + saedModels.get(i).information);
        }
        RecyclerAdapterShowSaedAdapter adapterShowSaedAdapter =
                new RecyclerAdapterShowSaedAdapter(RecyclerViewSaedListActivity.this,saedModels);
        binding.setAdapter(adapterShowSaedAdapter);

    }
}
