package com.example.buddybuilding.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.BR;
import com.example.buddybuilding.R;
import com.example.buddybuilding.activities.PlayVideoJoloBazooActivity;
import com.example.buddybuilding.activities.PlayVideoSarShooneActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerSaedBinding;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerSarshooneBinding;
import com.example.buddybuilding.models.SaedModel;
import com.example.buddybuilding.models.SarshooneModel;
import com.example.buddybuilding.tools.SarshooneCLickListener;

import java.util.List;

public class RecyclerAdapterShowSarshooneAdapter extends RecyclerView.Adapter
        <RecyclerAdapterShowSarshooneAdapter.CustomView> implements SarshooneCLickListener {


    private Context context;
    List<SarshooneModel> sarshooneModels;

    public RecyclerAdapterShowSarshooneAdapter(Context context, List<SarshooneModel> sarshooneModels) {
        this.context = context;
        this.sarshooneModels = sarshooneModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowSarshooneAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ActivityInnerRecyclerSarshooneBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_sarshoone, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowSarshooneAdapter.CustomView customView, int i) {
        final SarshooneModel sarshooneModel = sarshooneModels.get(i);
        customView.bind(sarshooneModel);
        customView.binding.setSarshooneCLickListener(this);
    }

    @Override
    public int getItemCount() {
        return sarshooneModels.size();
    }

    @Override
    public void Clicked(SarshooneModel sarshooneModel) {
        Intent intent = new Intent(context, PlayVideoSarShooneActivity.class);
        intent.putExtra("id", sarshooneModel.id);
        intent.putExtra("name", sarshooneModel.name);
        context.startActivity(intent);


    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerSarshooneBinding binding;

        public CustomView(ActivityInnerRecyclerSarshooneBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }
}
