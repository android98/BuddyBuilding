package com.example.buddybuilding.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.RecyclerAdapterShowMorabiAdapter;
import com.example.buddybuilding.viewmodel.MorabiViewModel;

import java.util.ArrayList;

public class RecyclerViewMorabiansActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerAdapterShowMorabiAdapter adapter;
    MorabiViewModel morabiViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_morabians);
        Toast.makeText(this, "Doneeeeeeeeeee", Toast.LENGTH_SHORT).show();
        Log.d("looging", "onBindViewHolder: " + "come innnnnnnnnnnnnnnnnnnnnnnnn1111");

        recyclerView = findViewById(R.id.recycler);
        morabiViewModel = ViewModelProviders.of(this).get(MorabiViewModel.class);
        morabiViewModel.getArrayListMutableLiveData().observe(
                this, new Observer<ArrayList<MorabiViewModel>>() {
                    @Override
                    public void onChanged(@Nullable ArrayList<MorabiViewModel> morabiViewModels) {
                        Log.d("looging", "onBindViewHolder: " + morabiViewModels.toString());
                        Log.d("looging", "onBindViewHolder: " + "come innnnnnnnnnnnnnnnnnnnnnnnn222222");

                        adapter = new RecyclerAdapterShowMorabiAdapter(
                                RecyclerViewMorabiansActivity.this, morabiViewModels);
                        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewMorabiansActivity.this));
                        recyclerView.setAdapter(adapter);
                    }
                }
        );

    }
}
