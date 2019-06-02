package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowJoloBazooAdapter;
import com.example.buddybuilding.adapters.RecyclerAdapterShowPahlooAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewJoloBazooListBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.PahlooModel;
import com.example.buddybuilding.models.SarshooneModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewJoloBazooListActivity extends AppCompatActivity {

    ActivityRecyclerViewJoloBazooListBinding binding;


    private Context context;
    RealmResults<JolobazooModel> jolobazooModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_jolo_bazoo_list);


        // Bindign JoloBazoo
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_jolo_bazoo_list);

        Realm realm = Realm.getDefaultInstance();
        jolobazooModels = realm.where(JolobazooModel.class)
                .findAll();
        for (int i = 0; i < jolobazooModels.size(); i++) {
            Log.d("runn", "execute: " + jolobazooModels.get(i).getId());
            Log.d("runn", "execute: " + jolobazooModels.get(i).getName());
            Log.d("runn", "execute: " + jolobazooModels.get(i).getUrl());
            Log.d("runn", "execute: " + jolobazooModels.get(i).information);
        }
        RecyclerAdapterShowJoloBazooAdapter adapterShowJoloBazooAdapter =
                new RecyclerAdapterShowJoloBazooAdapter(jolobazooModels, RecyclerViewJoloBazooListActivity.this);
        binding.setAdapter(adapterShowJoloBazooAdapter);


    }


}
