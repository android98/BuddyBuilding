package com.example.buddybuilding.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.BR;
import com.example.buddybuilding.R;
import com.example.buddybuilding.activities.PlayVideoJoloBazooActivity;
import com.example.buddybuilding.activities.PlayVideoPaaActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerPaaBinding;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerPahlooBinding;
import com.example.buddybuilding.models.PaModel;
import com.example.buddybuilding.models.PahlooModel;
import com.example.buddybuilding.tools.PaaClickListener;

import java.util.List;

public class RecyclerAdapterShowPaaAdapter extends RecyclerView.Adapter<RecyclerAdapterShowPaaAdapter.CustomView> implements PaaClickListener {

    private Context context;
    private List<PaModel> paModels;


    public RecyclerAdapterShowPaaAdapter(Context context, List<PaModel> paModels) {
        this.context = context;
        this.paModels = paModels;
    }




    @NonNull
    @Override
    public RecyclerAdapterShowPaaAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecyclerPaaBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_paa, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowPaaAdapter.CustomView customView, int i) {
        final PaModel paModel = paModels.get(i);
        customView.bind(paModel);
        customView.binding.setPaaClickListener(this);
    }

    @Override
    public int getItemCount() {
        return paModels.size();
    }

    @Override
    public void Clicked(PaModel paModel) {
        Log.d("Clicked", "Clicked: "+paModel);

        Intent intent = new Intent(context, PlayVideoPaaActivity.class);
        intent.putExtra("id", paModel.id);
        intent.putExtra("name", paModel.name);
        context.startActivity(intent);

    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerPaaBinding binding;

        public CustomView(ActivityInnerRecyclerPaaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }


}
