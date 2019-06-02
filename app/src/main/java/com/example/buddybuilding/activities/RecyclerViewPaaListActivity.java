package com.example.buddybuilding.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowJoloBazooAdapter;
import com.example.buddybuilding.adapters.RecyclerAdapterShowPaaAdapter;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerPaaBinding;
import com.example.buddybuilding.databinding.ActivityRecyclerViewPaaListBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.PaModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewPaaListActivity extends AppCompatActivity {


    ActivityRecyclerViewPaaListBinding binding;
    RealmResults<PaModel> paModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_paa_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_jolo_bazoo_list);

        Realm realm = Realm.getDefaultInstance();
        paModels = realm.where(PaModel.class)
                .findAll();
        for (int i = 0; i < paModels.size(); i++) {
            Log.d("runn", "execute: " + paModels.get(i).getId());
            Log.d("runn", "execute: " + paModels.get(i).getName());
            Log.d("runn", "execute: " + paModels.get(i).getUrl());
            Log.d("runn", "execute: " + paModels.get(i).information);
        }
        RecyclerAdapterShowPaaAdapter showPaaAdapter =
                new RecyclerAdapterShowPaaAdapter( RecyclerViewPaaListActivity.this,paModels);

        binding.setAdapter(showPaaAdapter);


    }
}
