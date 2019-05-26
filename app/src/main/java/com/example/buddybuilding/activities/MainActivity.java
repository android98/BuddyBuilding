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
import com.example.buddybuilding.models.PaModel;
import com.example.buddybuilding.models.SarshooneModel;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    GridView gridView;

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
                SarshooneModel model = realm.
                        createObject(SarshooneModel.class, id);
                model.setName("عجیبببب");
                model.setUrl("https://as7.cdn.asset.aparat.com/aparat-video/a912805435ca815f5d1ea52fadd026ca8259796-144p__83669.mp4");
                Log.d("abdc", "execute: " + "ok");

                PaModel paModel = realm.createObject(PaModel.class, id);
                paModel.setName("سیبیسسیلیس ");
                paModel.setUrl("https://as7.cdn.asset.aparat.com/aparat-video/a912805435ca815f5d1ea52fadd026ca8259796-144p__83669.mp4" +
                        "");

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
