package com.example.buddybuilding.activities;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowZirBaqalAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewZirBaqalListBinding;
import com.example.buddybuilding.models.ZirbaqalModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewZirBaqalListActivity extends AppCompatActivity {

    private Context context;
    private RealmResults<ZirbaqalModel> zirbaqalModels;
    ActivityRecyclerViewZirBaqalListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_zir_baqal_list);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_zir_baqal_list);

        Realm realm = Realm.getDefaultInstance();
        zirbaqalModels = realm.where(ZirbaqalModel.class)
                .findAll();
        for (int i = 0; i < zirbaqalModels.size(); i++) {
            Log.d("runn", "execute: " + zirbaqalModels.get(i).getId());
            Log.d("runn", "execute: " + zirbaqalModels.get(i).getName());
            Log.d("runn", "execute: " + zirbaqalModels.get(i).getUrl());
            Log.d("runn", "execute: " + zirbaqalModels.get(i).information);
        }
        RecyclerAdapterShowZirBaqalAdapter adapterShowZirBaqalAdapter=
                new RecyclerAdapterShowZirBaqalAdapter(RecyclerViewZirBaqalListActivity.this, zirbaqalModels);

        binding.setAdapter(adapterShowZirBaqalAdapter);

    }
}
