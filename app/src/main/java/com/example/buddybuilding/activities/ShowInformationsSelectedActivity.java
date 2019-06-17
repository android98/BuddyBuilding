package com.example.buddybuilding.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowZirBaqalAdapter;
import com.example.buddybuilding.models.MokamelPishrafteModel;
import com.example.buddybuilding.models.ZirbaqalModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowInformationsSelectedActivity extends AppCompatActivity {

    public TextView textViewname, textViewtozihat, textViewrotbebandi;
    public ImageView imageViewax;


    public RealmResults<MokamelPishrafteModel> mokamelPishrafteModels;


    public int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_informations_selected);

        bind();


        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        Log.d("runn", "execute: " + id);

        Realm realm = Realm.getDefaultInstance();
        mokamelPishrafteModels = realm.where(MokamelPishrafteModel.class).equalTo("id",id)
                .findAll();
        for (int i = 0; i < mokamelPishrafteModels.size(); i++) {
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getId());
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).getName());
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).image_url);
            Log.d("runn", "execute: " + mokamelPishrafteModels.get(i).informations);
            textViewname.setText(mokamelPishrafteModels.get(i).getName());
            textViewtozihat.setText(mokamelPishrafteModels.get(i).getInformations());
            textViewrotbebandi.setText(mokamelPishrafteModels.get(i).getRotbe_bandi());
            Glide.with(this).load(mokamelPishrafteModels
            .get(i).getImage_url()).into(imageViewax);
        }
    }

    private void bind() {
        textViewname = findViewById(R.id.txtname);
        textViewtozihat = findViewById(R.id.txttozihat);
        textViewrotbebandi = findViewById(R.id.txtrotbe);
        imageViewax = findViewById(R.id.imgax);
    }

}
