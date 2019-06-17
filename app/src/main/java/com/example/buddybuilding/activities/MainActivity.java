package com.example.buddybuilding.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.MainActivityRecycler1Adapter;
import com.example.buddybuilding.adapters.MainActivityRecycler2Adapter;
import com.example.buddybuilding.adapters.MainActivityRecycler4Adapter;
import com.example.buddybuilding.adapters.MainActivityRecycler5Adapter;
import com.example.buddybuilding.adapters.MainActivityRecycler6Adapter;
import com.example.buddybuilding.adapters.MainActivityRecycler7Adapter;
import com.example.buddybuilding.databinding.ActivityMainBinding;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.models.MokamelPishrafteModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    RealmResults<MokamelAvaliehModel> mokamelAvaliehModels;
    RealmResults<MokamelPishrafteModel> mokamelPishrafteModels1;
    RealmResults<MokamelPishrafteModel> mokamelPishrafteModels2;
    RealmResults<MokamelPishrafteModel> mokamelPishrafteModels4;
    RealmResults<MokamelPishrafteModel> mokamelPishrafteModels5;
    RealmResults<MokamelPishrafteModel> mokamelPishrafteModels6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Realm realm = Realm.getDefaultInstance();
        mokamelAvaliehModels = realm.where(MokamelAvaliehModel.class)
                .findAll();
        for (int i = 0; i < mokamelAvaliehModels.size(); i++) {
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getId());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getName());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getInformations());
        }




        Realm realm1 = Realm.getDefaultInstance();
        mokamelPishrafteModels1 = realm1.where(MokamelPishrafteModel.class).equalTo("parentid",2)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels1.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels1.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels1.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels1.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelPishrafteModels1.get(i).getInformations());
        }




        Realm realm2 = Realm.getDefaultInstance();
        mokamelPishrafteModels2 = realm2.where(MokamelPishrafteModel.class).equalTo("parentid",3)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels2.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels2.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels2.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels2.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelPishrafteModels2.get(i).getInformations());
        }


        Realm realm3 = Realm.getDefaultInstance();
        mokamelPishrafteModels4 = realm3.where(MokamelPishrafteModel.class).equalTo("parentid",4)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels4.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels4.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels4.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels4.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelPishrafteModels4.get(i).getInformations());
        }



        Realm realm4 = Realm.getDefaultInstance();
        mokamelPishrafteModels5 = realm4.where(MokamelPishrafteModel.class).equalTo("parentid",5)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels5.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels5.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels5.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels5.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelPishrafteModels5.get(i).getInformations());
        }


        Realm realm5 = Realm.getDefaultInstance();
        mokamelPishrafteModels6 = realm5.where(MokamelPishrafteModel.class).equalTo("parentid",6)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels6.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels6.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels6.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels6.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelPishrafteModels6.get(i).getInformations());
        }






        MainActivityRecycler1Adapter adapter = new MainActivityRecycler1Adapter(mokamelAvaliehModels, MainActivity.this);
        MainActivityRecycler2Adapter adapter2 = new MainActivityRecycler2Adapter(mokamelPishrafteModels1, MainActivity.this);
        MainActivityRecycler4Adapter adapter4 = new MainActivityRecycler4Adapter(mokamelPishrafteModels2, MainActivity.this);
        MainActivityRecycler5Adapter adapter5 = new MainActivityRecycler5Adapter(mokamelPishrafteModels4, MainActivity.this);
        MainActivityRecycler6Adapter adapter6 = new MainActivityRecycler6Adapter(mokamelPishrafteModels5, MainActivity.this);
        MainActivityRecycler7Adapter adapter7 = new MainActivityRecycler7Adapter(mokamelPishrafteModels6, MainActivity.this);


        binding.setAdapter(adapter);
        binding.setAdapter2(adapter2);
        binding.setAdapter4(adapter4);
        binding.setAdapter5(adapter5);
        binding.setAdapter6(adapter6);
        binding.setAdapter7(adapter7);





    }
}
