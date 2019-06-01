package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowJoloBazooAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewJoloBazooListBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.SarshooneModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewJoloBazooListActivity extends AppCompatActivity {

    ActivityRecyclerViewJoloBazooListBinding binding;
    private Context context;
    RealmResults<JolobazooModel> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_jolo_bazoo_list);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_jolo_bazoo_list);

        Realm realm = Realm.getDefaultInstance();
                results = realm.where(JolobazooModel.class)
                        .findAll();
                for (int i = 0; i < results.size(); i++) {
                    Log.d("runn", "execute: " + results.get(i).getId());
                    Log.d("runn", "execute: " + results.get(i).getName());
                    Log.d("runn", "execute: " + results.get(i).getUrl());
                    Log.d("runn", "execute: " + results.get(i).information);
                }
        RecyclerAdapterShowJoloBazooAdapter adapterShowJoloBazooAdapter =
                new RecyclerAdapterShowJoloBazooAdapter(results, RecyclerViewJoloBazooListActivity.this);
                binding.setAdapter(adapterShowJoloBazooAdapter);
    }

}
