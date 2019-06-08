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
import com.example.buddybuilding.activities.PlayVideoActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerJoloBazooBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.tools.JoloBazooClickListener;

import java.util.List;

public class RecyclerAdapterShowJoloBazooAdapter extends
        RecyclerView.Adapter<RecyclerAdapterShowJoloBazooAdapter.CustomView>
        implements JoloBazooClickListener {

    private List<JolobazooModel> jolobazooModels;
    private Context context;



    public RecyclerAdapterShowJoloBazooAdapter(List<JolobazooModel> jolobazooModels, Context context) {
        this.jolobazooModels = jolobazooModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowJoloBazooAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        ActivityInnerRecyclerJoloBazooBinding binding = DataBindingUtil.inflate(LayoutInflater.
                from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_jolo_bazoo, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowJoloBazooAdapter.CustomView customView, int i) {


        final JolobazooModel jolobazooModel = jolobazooModels.get(i);
        customView.bind(jolobazooModel);
        customView.binding.setJoloBazooClickListener(this);

    }

    @Override
    public int getItemCount() {
        return jolobazooModels.size();
    }

    @Override
    public void Clicked(JolobazooModel jolobazooModel) {
        Log.d("Clicked", "Clicked: " + jolobazooModel.getName());
        Intent intent = new Intent(context, PlayVideoActivity.class);
        intent.putExtra("id", jolobazooModel.id);
        intent.putExtra("name", jolobazooModel.name);
        context.startActivity(intent);

    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerJoloBazooBinding binding;

        public CustomView(ActivityInnerRecyclerJoloBazooBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }


}
