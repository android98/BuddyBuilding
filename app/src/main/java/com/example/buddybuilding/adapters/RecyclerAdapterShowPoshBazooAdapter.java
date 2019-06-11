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
import com.example.buddybuilding.activities.PlayVideoPoshBazoActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerPoshBazooBinding;
import com.example.buddybuilding.models.PoshtbazooModel;
import com.example.buddybuilding.tools.PoshBazooClickListener;

import java.util.List;

public class RecyclerAdapterShowPoshBazooAdapter extends
        RecyclerView.Adapter<RecyclerAdapterShowPoshBazooAdapter.CustomView> implements PoshBazooClickListener {

    private Context context;

    private List<PoshtbazooModel> poshtbazooModels;

    public RecyclerAdapterShowPoshBazooAdapter(Context context, List<PoshtbazooModel> poshtbazooModels) {
        this.context = context;
        this.poshtbazooModels = poshtbazooModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowPoshBazooAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecyclerPoshBazooBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.activity_inner_recycler_posh_bazoo,
                viewGroup, false);

        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowPoshBazooAdapter.CustomView customView, int i) {
        final PoshtbazooModel poshtbazooModel = poshtbazooModels.get(i);
        customView.bind(poshtbazooModel);
        customView.binding.setPoshBazooClickListener(this);
    }

    @Override
    public int getItemCount() {
        return poshtbazooModels.size();
    }

    @Override
    public void Clicked(PoshtbazooModel poshtbazooModel) {
        Intent intent = new Intent(context, PlayVideoPoshBazoActivity.class);
        intent.putExtra("id", poshtbazooModel.id);
        intent.putExtra("name", poshtbazooModel.name);
        context.startActivity(intent);


    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerPoshBazooBinding binding;

        public CustomView(ActivityInnerRecyclerPoshBazooBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }


}
