package com.example.buddybuilding.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.BR;
import com.example.buddybuilding.R;
import com.example.buddybuilding.databinding.ActivityInnerRecycler2Binding;
import com.example.buddybuilding.models.MokamelPishrafteModel;
import com.example.buddybuilding.tools.MokamelPIshrafteClickListener;

import java.util.List;

public class MainActivityRecycler5Adapter extends RecyclerView.Adapter<MainActivityRecycler5Adapter.CustomView> implements MokamelPIshrafteClickListener {

    public List<MokamelPishrafteModel> mokamelPishrafteModels;
    public Context context;


    public MainActivityRecycler5Adapter(List<MokamelPishrafteModel> mokamelPishrafteModels, Context context) {
        this.mokamelPishrafteModels = mokamelPishrafteModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MainActivityRecycler5Adapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ActivityInnerRecycler2Binding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler2, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityRecycler5Adapter.CustomView customView, int i) {
        final MokamelPishrafteModel mokamelPishrafteModel = mokamelPishrafteModels.get(i);
        customView.bind(mokamelPishrafteModel);
        customView.binding.setMokamelPIshrafteClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mokamelPishrafteModels.size();
    }

    @Override
    public void Clicked(MokamelPishrafteModel mokamelPishrafteModel) {
        Log.d("ttt", "execute: " + mokamelPishrafteModel.getId());
        Log.d("ttt", "execute: " + mokamelPishrafteModel.getName());
        Log.d("ttt", "execute: " + mokamelPishrafteModel.getImage_url());
        Log.d("ttt", "execute: " + mokamelPishrafteModel.getInformations());    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecycler2Binding binding;


        public CustomView(ActivityInnerRecycler2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }



}
