package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowSaedAdapter;
import com.example.buddybuilding.adapters.RecyclerAdapterShowSarshooneAdapter;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerSarshooneBinding;
import com.example.buddybuilding.databinding.ActivityRecyclerViewSarShooneListBinding;
import com.example.buddybuilding.models.SaedModel;
import com.example.buddybuilding.models.SarshooneModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewSarShooneListActivity extends AppCompatActivity {


    private Context context;
    ActivityRecyclerViewSarShooneListBinding binding;
    RealmResults<SarshooneModel> sarshooneModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_sar_shoone_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_sar_shoone_list);

        Realm realm = Realm.getDefaultInstance();
        sarshooneModels = realm.where(SarshooneModel.class)
                .findAll();
        for (int i = 0; i < sarshooneModels.size(); i++) {
            Log.d("runn", "execute: " + sarshooneModels.get(i).getId());
            Log.d("runn", "execute: " + sarshooneModels.get(i).getName());
            Log.d("runn", "execute: " + sarshooneModels.get(i).getUrl());
            Log.d("runn", "execute: " + sarshooneModels.get(i).information);
        }
        RecyclerAdapterShowSarshooneAdapter adapterShowSarshooneAdapter =
                new RecyclerAdapterShowSarshooneAdapter(RecyclerViewSarShooneListActivity.this, sarshooneModels);

        binding.setAdapter(adapterShowSarshooneAdapter);

    }
}
