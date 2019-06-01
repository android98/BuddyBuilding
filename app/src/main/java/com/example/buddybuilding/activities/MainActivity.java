package com.example.buddybuilding.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.MainGridViewAdapter;
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


public class MainActivity extends AppCompatActivity {

    GridView gridView;

    public RealmResults<JolobazooModel> results;

    public String[] names = {"حرکات سرشانه", "حرکات زیر بقل",
            "حرکات پشت بازو", "حرکات جلو بازو",
            "حرکات شکم ", "حرکات هوازی", "حرکات پهلو",
            "حرکات پا", "حرکات ساعد",};


    public int[] images = {R.drawable.sarshane, R.drawable.zirbaqal, R.drawable.poshtbazoo,
            R.drawable.jolobazo, R.drawable.shekam, R.drawable.havazi, R.drawable.pahloo,
            R.drawable.paaa, R.drawable.saeed};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view_);
        MainGridViewAdapter adapter =
                new MainGridViewAdapter(this, images, names);
        gridView.setAdapter(adapter);

        Realm realm = Realm.getDefaultInstance();
        final int id = getNextKey(realm);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                results = realm.where(JolobazooModel.class)
                        .findAll();

                for (int i = 0; i < results.size(); i++) {
                    Log.d("runn", "execute: "+results.get(i).getId());
                    Log.d("runn", "execute: "+results.get(i).getName());
                    Log.d("runn", "execute: "+results.get(i).getUrl());
                    Log.d("runn", "execute: "+results.get(i).information);
                }


            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" +
                        names[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    private int getNextKey(Realm realm) {
        try {

            Number number = realm.where(SarshooneModel.class).max("id");
            if (number != null) {
                return number.intValue() + 1;
            } else {
                return 0;
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return 0;
    }
}
