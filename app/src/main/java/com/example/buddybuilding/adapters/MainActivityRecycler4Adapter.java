package com.example.buddybuilding.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.BR;
import com.example.buddybuilding.R;
import com.example.buddybuilding.activities.ShowInformationsSelectedActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecycler2Binding;
import com.example.buddybuilding.models.MokamelPishrafteModel;
import com.example.buddybuilding.tools.MokamelPIshrafteClickListener;

import java.util.List;

public class MainActivityRecycler4Adapter extends RecyclerView.Adapter<MainActivityRecycler4Adapter.CustomView> implements MokamelPIshrafteClickListener {

    public List<MokamelPishrafteModel> mokamelPishrafteModels;
    public Context context;


    public MainActivityRecycler4Adapter(List<MokamelPishrafteModel> mokamelPishrafteModels, Context context) {
        this.mokamelPishrafteModels = mokamelPishrafteModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MainActivityRecycler4Adapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ActivityInnerRecycler2Binding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler2, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityRecycler4Adapter.CustomView customView, int i) {
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
        Log.d("ttt", "execute: " + mokamelPishrafteModel.getInformations());

        Intent intent = new Intent(context, ShowInformationsSelectedActivity.class);
        intent.putExtra("id", mokamelPishrafteModel.getId());
        context.startActivity(intent);
    }


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
