package com.example.buddybuilding.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.buddybuilding.R;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.PahlooModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class PlayVideoPahlooActivity extends AppCompatActivity {

    public int id = -1;
    public String name;
    public VideoView videoView;
    private TextView txtname, txtinf;
    public RealmResults<PahlooModel> pahlooModels;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_pahloo);


        Bind();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        name = intent.getStringExtra("name");


        AlertDialogLoding();
        PahlooQueryDB();



    }


    private void PahlooQueryDB() {
        Realm realm = Realm.getDefaultInstance();
        pahlooModels = realm.where(PahlooModel.class)
                .equalTo("id", id).findAll();
        for (int i = 0; i < pahlooModels.size(); i++) {
            Log.d("testts", "QueryDB: " + pahlooModels);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse(pahlooModels.get(i).getUrl());
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
            txtname.setText(pahlooModels.get(i).getName());
            txtinf.setText(pahlooModels.get(i).getInformation());
            //Toast.makeText(this, ""+duration, Toast.LENGTH_SHORT).show();




        }
    }

    private void Bind() {
        txtname = findViewById(R.id.txt_name);
        txtinf = findViewById(R.id.txt_inf);
        videoView = findViewById(R.id.vdVw);
    }

    public void AlertDialogLoding() {
        progressDialog = new ProgressDialog(PlayVideoPahlooActivity.this);
        progressDialog.setTitle("در حال بارگذاری");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("صبر کنید");
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDialog.getProgress() <= progressDialog.getMax()) {

                        Thread.sleep(60);

                        handler.sendMessage(handler.obtainMessage());
                        if (progressDialog.getProgress() == progressDialog.getMax()) {
                            progressDialog.dismiss();

                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.incrementProgressBy(1);

        }
    };


}
