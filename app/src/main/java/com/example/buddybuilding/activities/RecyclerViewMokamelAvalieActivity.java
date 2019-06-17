package com.example.buddybuilding.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowJoloBazooAdapter;
import com.example.buddybuilding.adapters.RecyclerAdapterShowMokamelMobtadiAdapter;
import com.example.buddybuilding.databinding.ActivityRecyclerViewJoloBazooListBinding;
import com.example.buddybuilding.databinding.ActivityRecyclerViewMokamelAvalieBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.models.MokamelPishrafteModel;

import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import io.realm.RealmResults;

public class RecyclerViewMokamelAvalieActivity extends AppCompatActivity {

    ActivityRecyclerViewMokamelAvalieBinding binding;

    private Context context;
    RealmResults<MokamelAvaliehModel> mokamelAvaliehModels;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_mokamel_avalie);



        // Read Inf in Recycler
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_mokamel_avalie);

        Realm realm = Realm.getDefaultInstance();
        mokamelAvaliehModels = realm.where(MokamelAvaliehModel.class)
                .findAll();
        for (int i = 0; i < mokamelAvaliehModels.size(); i++) {
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getId());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getName());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getImage_url());
            Log.d("runn", "execute: " + mokamelAvaliehModels.get(i).getParentid());
        }
        RecyclerAdapterShowMokamelMobtadiAdapter adapterShowMokamelMobtadiAdapter =
                new RecyclerAdapterShowMokamelMobtadiAdapter(RecyclerViewMokamelAvalieActivity.this, mokamelAvaliehModels);

        binding.setAdapter(adapterShowMokamelMobtadiAdapter);



/*        //Insert Dates
        Realm realm = Realm.getDefaultInstance();
        final int id = getNextKey(realm);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MokamelPishrafteModel mokamelPishrafteModel =
                        realm.createObject(MokamelPishrafteModel.class, id);


                mokamelPishrafteModel.setName("کورستین (QUERCETIN)");


                mokamelPishrafteModel.setImage_url("data:image/jpeg;base64,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");


                mokamelPishrafteModel.setInformations("کارکرد : آنتی اکسیدان، آنتی آتروژنیک، ضد سرطان\n" +
                        "دوز رایج : ۱۲.۵-۲۵ میلی\u200Cگرم به ازای هر کیلوگرم از وزن بدن در روز\n" +
                        "زمان مصرف : آزاد");

                mokamelPishrafteModel.setRotbe_bandi("عالی\u200C");


                mokamelPishrafteModel.setParentid(6);


                Toast.makeText(RecyclerViewMokamelAvalieActivity.this, "Saved", Toast.LENGTH_SHORT).show();




            }
        });*/

      /*  // Read dates

        Realm realm = Realm.getDefaultInstance();
        RealmResults<MokamelPishrafteModel> mokamelPishrafteModels = realm
                .where(MokamelPishrafteModel.class).equalTo("parentid",6).findAll();


        for (int i = 0; i < mokamelPishrafteModels.size(); i++) {
            Log.d("logging", "onCreate: "+mokamelPishrafteModels.get(i).getId());
            Log.d("logging", "onCreate: "+mokamelPishrafteModels.get(i).getName());
            Log.d("logging", "onCreate: "+mokamelPishrafteModels.get(i).getInformations());
            Log.d("logging", "onCreate: "+mokamelPishrafteModels.get(i).getImage_url());
            Log.d("logging", "onCreate: "+mokamelPishrafteModels.get(i).getParentid());
        }
*/

     /*// Delete Row

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                mokamelPishrafteModels = realm.where(MokamelPishrafteModel.class)
                        .equalTo("id",51).findAll();
                mokamelPishrafteModels.deleteAllFromRealm();
                Toast.makeText(RecyclerViewMokamelAvalieActivity.this, "Sved", Toast.LENGTH_SHORT).show();

            }
        });
*/



    }
    private int getNextKey(Realm realm) {
        try {

            Number number = realm.where(MokamelPishrafteModel.class).max("id");
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
