package com.example.buddybuilding.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.buddybuilding.R;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.models.MokamelPishrafteModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowInformationsSelected2Activity extends AppCompatActivity {


    public TextView textViewname, textViewtozihat;
    public ImageView imageViewax;

    public RealmResults<MokamelAvaliehModel> mokamelAvaliehModels;


    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_informations_selected2);

        bind();


        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        Log.d("runn", "execute: " + id);

        Realm realm = Realm.getDefaultInstance();
        mokamelAvaliehModels = realm.where(MokamelAvaliehModel.class).equalTo("id", id)
                .findAll();
        for (int i = 0; i < mokamelAvaliehModels.size(); i++) {
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getId());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getName());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).image_url);
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).informations);
            textViewname.setText(mokamelAvaliehModels.get(i).getName());
            textViewtozihat.setText(mokamelAvaliehModels.get(i).getInformations());
            Glide.with(this).load(mokamelAvaliehModels
                    .get(i).getImage_url()).into(imageViewax);
        }
    }

    private void bind() {
        textViewname = findViewById(R.id.txtname);
        textViewtozihat = findViewById(R.id.txttozihat);
        imageViewax = findViewById(R.id.imgax);
    }


}
