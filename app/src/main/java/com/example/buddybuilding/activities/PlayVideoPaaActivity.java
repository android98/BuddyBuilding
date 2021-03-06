package com.example.buddybuilding.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.buddybuilding.R;
import com.example.buddybuilding.models.PaModel;

import io.realm.Realm;
import io.realm.RealmResults;

public class PlayVideoPaaActivity extends AppCompatActivity {


    public int id = -1;
    public String name;
    public VideoView videoView;
    private TextView txtname, txtinf;
    public RealmResults<PaModel> paModels;
    public ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video_paa);


        Bind();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        name = intent.getStringExtra("name");


        //AlertDialogLoding();
        PaQueryDB();


    }


    private void PaQueryDB() {
        Realm realm = Realm.getDefaultInstance();
        paModels = realm.where(PaModel.class)
                .equalTo("id", id).findAll();
        for (int i = 0; i < paModels.size(); i++) {
            Log.d("testts", "QueryDB: " + paModels);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            Uri uri = Uri.parse(paModels.get(i).getUrl());
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
            txtname.setText(paModels.get(i).getName());
            txtinf.setText(paModels.get(i).getInformation());
            //Toast.makeText(this, ""+duration, Toast.LENGTH_SHORT).show();




        }
    }

    private void Bind() {
        txtname = findViewById(R.id.txt_name);
        txtinf = findViewById(R.id.txt_inf);
        videoView = findViewById(R.id.vdVw);
    }

    public void AlertDialogLoding() {
        progressDialog = new ProgressDialog(PlayVideoPaaActivity.this);
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



