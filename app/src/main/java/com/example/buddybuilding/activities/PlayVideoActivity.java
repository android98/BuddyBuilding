package com.example.buddybuilding.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.buddybuilding.R;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.PaModel;
import com.example.buddybuilding.models.PahlooModel;
import com.example.buddybuilding.models.PoshtbazooModel;
import com.example.buddybuilding.models.SaedModel;
import com.example.buddybuilding.models.SarshooneModel;
import com.example.buddybuilding.models.ShekamModel;
import com.example.buddybuilding.models.ZirbaqalModel;

import io.realm.Realm;
import io.realm.RealmResults;



public class PlayVideoActivity extends AppCompatActivity {

    int id = -1;
    String name;
    VideoView videoView;
    private TextView txtname, txtinf;
    public RealmResults<JolobazooModel> jolobazooModels;
    public RealmResults<PahlooModel> pahlooModels;
    public RealmResults<PaModel> paModels;
    public RealmResults<PoshtbazooModel> poshtbazooModels;
    public RealmResults<SaedModel> saedModels;
    public RealmResults<SarshooneModel> sarshooneModels;
    public RealmResults<ShekamModel> shekamModels;
    public RealmResults<ZirbaqalModel> zirbaqalModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Bind();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        name = intent.getStringExtra("name");
        Toast.makeText(this, "id : " + id + " name : "+ name, Toast.LENGTH_SHORT).show();
        JoloBazooQueryDB();
        /* if (name == "حرکات جلو بازو") {
            JoloBazooQueryDB();
        }*/
        /*if (name == "حرکات پهلو") {
            PahlooQueryDB();
        }*/


    }

    private void findTabe() {
        if (name == "حرکات جلو بازو") {
            JoloBazooQueryDB();
            return;
        }
        if (name == "حرکات پهلو") {
            PahlooQueryDB();
            return;
        }
        /*if (name == "حرکات پا") {
            Intent intent = new Intent(MainActivity.this, RecyclerViewPahlooListActivity.class);
            startActivity(intent);
        }
        if (name== "حرکات سرشانه") {
            Intent intent = new Intent(MainActivity.this, RecyclerViewSarShooneListActivity.class);
            startActivity(intent);
        }
        if (name == "حرکات زیر بقل") {
            Intent intent = new Intent(MainActivity.this, RecyclerViewZirBaqalListActivity.class);
            startActivity(intent);
        }
        if (name == "حرکات پشت بازو") {
            Intent intent = new Intent(MainActivity.this, RecyclerViewPoshBazooListActivity.class);
            startActivity(intent);
        }
        if (name == "حرکات شکم ") {
            Intent intent = new Intent(MainActivity.this, RecyclerViewShekamListActivity.class);
            startActivity(intent);
        }
        if (name == "حرکات ساعد") {
            Intent intent = new Intent(MainActivity.this, RecyclerViewSaedListActivity.class);
            startActivity(intent);
        }*/
    }

    private void JoloBazooQueryDB() {
        Realm realm = Realm.getDefaultInstance();
        jolobazooModels = realm.where(JolobazooModel.class)
                .equalTo("id", id).findAll();
        for (int i = 0; i < jolobazooModels.size(); i++) {
            Log.d("testts", "QueryDB: "+jolobazooModels);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse(jolobazooModels.get(i).getUrl());
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
            txtname.setText(jolobazooModels.get(i).getName());
            txtinf.setText(jolobazooModels.get(i).getInformation());

        }
    }

    private void PahlooQueryDB() {
        Realm realm = Realm.getDefaultInstance();
        pahlooModels = realm.where(PahlooModel.class)
                .equalTo("id", id).findAll();
        for (int i = 0; i < pahlooModels.size(); i++) {
            Log.d("testts", "QueryDB: "+pahlooModels);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse(pahlooModels.get(i).getUrl());
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
            txtname.setText(pahlooModels.get(i).getName());
            txtinf.setText(pahlooModels.get(i).getInformation());

        }
    }

    private void Bind() {
        txtname = findViewById(R.id.txt_name);
        txtinf = findViewById(R.id.txt_inf);
        videoView = findViewById(R.id.vdVw);

    }


}
