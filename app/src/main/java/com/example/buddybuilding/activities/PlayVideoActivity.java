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

import io.realm.Realm;
import io.realm.RealmResults;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;


public class PlayVideoActivity extends AppCompatActivity {

    int id = -1;
    VideoView videoView;
    private TextView txtname, txtinf;
    public RealmResults<JolobazooModel> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        Bind();



        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Toast.makeText(this, "id : " + id, Toast.LENGTH_SHORT).show();



        QueryDB();


    }

    private void QueryDB() {
        Realm realm = Realm.getDefaultInstance();
        results = realm.where(JolobazooModel.class)
                .equalTo("id", id).findAll();
        for (int i = 0; i < results.size(); i++) {
            Log.d("testts", "QueryDB: "+results);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse(results.get(i).getUrl());
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();

            txtname.setText(results.get(i).getName());
            txtinf.setText(results.get(i).getInformation());

        }
    }

    private void Bind() {
        txtname = findViewById(R.id.txt_name);
        txtinf = findViewById(R.id.txt_inf);
        videoView = findViewById(R.id.vdVw);

    }


}
