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
import com.example.buddybuilding.activities.ShowInformationsSelected2Activity;
import com.example.buddybuilding.databinding.ActivityInnerRecycler1Binding;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.models.MokamelPishrafteModel;
import com.example.buddybuilding.tools.MokamelMobtadiClickListener;
import com.example.buddybuilding.tools.MokamelPIshrafteClickListener;

import java.util.List;

public class MainActivityRecycler1Adapter extends RecyclerView.Adapter<MainActivityRecycler1Adapter.CustomView> implements MokamelMobtadiClickListener, MokamelPIshrafteClickListener {


    public List<MokamelAvaliehModel> mokamelAvaliehModels;
    public Context context;


    public MainActivityRecycler1Adapter(List<MokamelAvaliehModel> mokamelAvaliehModels, Context context) {
        this.mokamelAvaliehModels = mokamelAvaliehModels;
        this.context = context;
    }


    @NonNull
    @Override
    public MainActivityRecycler1Adapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecycler1Binding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler1, viewGroup, false);
        return new CustomView(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull MainActivityRecycler1Adapter.CustomView customView, int i) {
        final MokamelAvaliehModel mokamelAvaliehModel = mokamelAvaliehModels.get(i);
        customView.bind(mokamelAvaliehModel);
        customView.binding.setMokamelMobtadiClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mokamelAvaliehModels.size();
    }

    @Override
    public void Clicked(MokamelAvaliehModel mokamelAvaliehModel) {
        Log.d("ttt", "execute: " + mokamelAvaliehModel.getId());
        Log.d("ttt", "execute: " + mokamelAvaliehModel.getName());
        Log.d("ttt", "execute: " + mokamelAvaliehModel.getImage_url());
        Log.d("ttt", "execute: " + mokamelAvaliehModel.getInformations());

        Intent intent = new Intent(context, ShowInformationsSelected2Activity.class);
        intent.putExtra("id", mokamelAvaliehModel.id);
        context.startActivity(intent);


    }

    @Override
    public void Clicked(MokamelPishrafteModel mokamelPishrafteModel) {

    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecycler1Binding binding;


        public CustomView(ActivityInnerRecycler1Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }


}
