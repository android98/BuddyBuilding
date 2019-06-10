package com.example.buddybuilding.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.BR;
import com.example.buddybuilding.R;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerJoloBazooBinding;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerShekamBinding;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.ShekamModel;
import com.example.buddybuilding.tools.ShekamClickListener;

import java.util.List;

public class RecyclerAdapterShowShekamAdapter extends RecyclerView.Adapter<
        RecyclerAdapterShowShekamAdapter.CustomView> implements ShekamClickListener {

    private Context context;
    List<ShekamModel> shekamModels;

    public RecyclerAdapterShowShekamAdapter(Context context, List<ShekamModel> shekamModels) {
        this.context = context;
        this.shekamModels = shekamModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowShekamAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecyclerShekamBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_shekam, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowShekamAdapter.CustomView customView, int i) {

        final ShekamModel shekamModel = shekamModels.get(i);
        customView.bind(shekamModel);
        customView.binding.setShekamClickListener(this);
    }

    @Override
    public int getItemCount() {
        return shekamModels.size();
    }

    @Override
    public void Clicked(ShekamModel shekamModel) {

    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerShekamBinding binding;

        public CustomView(ActivityInnerRecyclerShekamBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }


}