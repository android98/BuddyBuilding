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
import com.example.buddybuilding.activities.PlayVideoSaedActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerPaaBinding;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerSaedBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.PaModel;
import com.example.buddybuilding.models.SaedModel;
import com.example.buddybuilding.tools.SaedClickListener;

import java.util.List;

public class RecyclerAdapterShowSaedAdapter extends RecyclerView.Adapter
<RecyclerAdapterShowSaedAdapter.CustomView> implements SaedClickListener {

    Context context;
    List<SaedModel> saedModels;


    public RecyclerAdapterShowSaedAdapter(Context context, List<SaedModel> saedModels) {
        this.context = context;
        this.saedModels = saedModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowSaedAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        ActivityInnerRecyclerSaedBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_saed, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowSaedAdapter.CustomView customView, int i) {
        final SaedModel saedModel = saedModels.get(i);
        customView.bind(saedModel);
        customView.binding.setSaedClickListener(this);
    }

    @Override
    public int getItemCount() {
        return saedModels.size();
    }

    @Override
    public void Clicked(SaedModel saedModel) {
        Intent intent = new Intent(context, PlayVideoSaedActivity.class);
        intent.putExtra("id", saedModel.id);
        intent.putExtra("name", saedModel.name);
        context.startActivity(intent);


    }
    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerSaedBinding binding;

        public CustomView(ActivityInnerRecyclerSaedBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }
}
