package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowShekamAdapter;
import com.example.buddybuilding.adapters.RecyclerAdapterShowZirBaqalAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewShekamListBinding;
import com.example.buddybuilding.databinding.ActivityRecyclerViewZirBaqalListBinding;
import com.example.buddybuilding.models.ShekamModel;
import com.example.buddybuilding.models.ZirbaqalModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewShekamListActivity extends AppCompatActivity {



    private Context context;
    private RealmResults<ShekamModel> shekamModels;
    ActivityRecyclerViewShekamListBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_shekam_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_shekam_list);

        Realm realm = Realm.getDefaultInstance();
        shekamModels = realm.where(ShekamModel.class)
                .findAll();
        for (int i = 0; i < shekamModels.size(); i++) {
            Log.d("runn", "execute: " + shekamModels.get(i).getId());
            Log.d("runn", "execute: " + shekamModels.get(i).getName());
            Log.d("runn", "execute: " + shekamModels.get(i).getUrl());
            Log.d("runn", "execute: " + shekamModels.get(i).information);
        }
        RecyclerAdapterShowShekamAdapter adapterShowShekamAdapter=
                new RecyclerAdapterShowShekamAdapter(RecyclerViewShekamListActivity.this, shekamModels);

        binding.setAdapter(adapterShowShekamAdapter);


    }
}
