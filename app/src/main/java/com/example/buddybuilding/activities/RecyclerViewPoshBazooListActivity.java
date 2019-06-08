package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowPoshBazooAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewPoshBazooListBinding;
import com.example.buddybuilding.models.PoshtbazooModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewPoshBazooListActivity extends AppCompatActivity {

    ActivityRecyclerViewPoshBazooListBinding binding;

    private Context context;
    RealmResults<PoshtbazooModel> poshtbazooModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_posh_bazoo_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_posh_bazoo_list);
        Realm realm = Realm.getDefaultInstance();
        poshtbazooModels = realm.where(PoshtbazooModel.class).findAll();


        for (int i = 0; i < poshtbazooModels.size(); i++) {
            Log.d("runn", "execute: " + poshtbazooModels.get(i).getId());
            Log.d("runn", "execute: " + poshtbazooModels.get(i).getName());
            Log.d("runn", "execute: " + poshtbazooModels.get(i).getUrl());
            Log.d("runn", "execute: " + poshtbazooModels.get(i).information);
        }

        RecyclerAdapterShowPoshBazooAdapter adapterShowPoshBazooAdapter =
                new RecyclerAdapterShowPoshBazooAdapter(RecyclerViewPoshBazooListActivity.this,
                        poshtbazooModels);
        binding.setAdapter(adapterShowPoshBazooAdapter);


    }
}
