package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterMokamelPishrafteAdapter;
import com.example.buddybuilding.adapters.RecyclerAdapterShowMokamelMobtadiAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewMokamelAvalieBinding;
import com.example.buddybuilding.databinding.ActivityRecyclerViewMokamelKaramadBinding;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.models.MokamelPishrafteModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewMokamelKaramadActivity extends AppCompatActivity {



    ActivityRecyclerViewMokamelKaramadBinding binding;

    private Context context;
    RealmResults<MokamelPishrafteModel> mokamelPishrafteModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_mokamel_karamad);



        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_mokamel_karamad);

        Realm realm = Realm.getDefaultInstance();
        mokamelPishrafteModels = realm.where(MokamelPishrafteModel.class)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getRotbe_bandi());
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getParentid());
        }
        RecyclerAdapterMokamelPishrafteAdapter adapterMokamelPishrafteAdapter=
                new RecyclerAdapterMokamelPishrafteAdapter(RecyclerViewMokamelKaramadActivity.this, mokamelPishrafteModels);

        binding.setAdapter(adapterMokamelPishrafteAdapter);




    }
}
