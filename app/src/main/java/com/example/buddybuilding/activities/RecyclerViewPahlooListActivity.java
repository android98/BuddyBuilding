package com.example.buddybuilding.activities;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowPahlooAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewPahlooListBinding;
import com.example.buddybuilding.models.PahlooModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewPahlooListActivity extends AppCompatActivity {


    RealmResults<PahlooModel> pahlooModels;
    private Context context;
    ActivityRecyclerViewPahlooListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pahloo_list);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_pahloo_list);
        Realm realm1 = Realm.getDefaultInstance();
        pahlooModels = realm1.where(PahlooModel.class).findAll();
        for (int j = 0; j < pahlooModels.size(); j++) {
            Log.d("runn", "execute: " + pahlooModels.get(j).getId());
            Log.d("runn", "execute: " + pahlooModels.get(j).getName());
            Log.d("runn", "execute: " + pahlooModels.get(j).getUrl());
            Log.d("runn", "execute: " + pahlooModels.get(j).information);
        }
        RecyclerAdapterShowPahlooAdapter recyclerAdapterShowPahlooAdapter = new RecyclerAdapterShowPahlooAdapter(
                RecyclerViewPahlooListActivity.this, pahlooModels
        );
        binding.setAdapter(recyclerAdapterShowPahlooAdapter);
    }
}
