package com.example.buddybuilding.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.R;
import com.example.buddybuilding.databinding.MorabiBinding;
import com.example.buddybuilding.viewmodel.MorabiViewModel;

import java.util.ArrayList;

public class RecyclerAdapterShowMorabiAdapter extends RecyclerView.Adapter<RecyclerAdapterShowMorabiAdapter
        .CustomView>  {


    Context context;
    ArrayList<MorabiViewModel> arrayList;
    LayoutInflater layoutInflater;





    public RecyclerAdapterShowMorabiAdapter() {
    }

    public RecyclerAdapterShowMorabiAdapter(Context context, ArrayList<MorabiViewModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());

        }
        MorabiBinding binding = DataBindingUtil.inflate(
                layoutInflater,
                R.layout
                        .activity_inner_recycler_morabians
                , viewGroup, false);
        Log.d("looging", "onBindViewHolder: " + arrayList.get(i).name);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView customView, int i) {
        MorabiViewModel morabiViewModel = arrayList.get(i);
        customView.bind(morabiViewModel);


        //Toast.makeText(context, ""+morabiViewModel.name, Toast.LENGTH_SHORT).show();
        Log.d("looging", "onBindViewHolder: " + "come innnnnnnnnnnnnnnnnnnnnnnnn33333333333");

        Log.d("looging", "onBindViewHolder: " + arrayList.get(i).name);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    class CustomView extends RecyclerView.ViewHolder {

        MorabiBinding morabiBinding;
        public CustomView(MorabiBinding morabiBinding) {
            super(morabiBinding.getRoot());
            this.morabiBinding = morabiBinding;
        }

        public void bind(MorabiViewModel morabiViewModel) {
            this.morabiBinding.setMorabimodel(morabiViewModel);
            morabiBinding.executePendingBindings();
        }


        public MorabiBinding getMorabiBinding() {
            return morabiBinding;
        }
    }



}
