package com.example.buddybuilding.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.buddybuilding.BR;
import com.example.buddybuilding.R;
import com.example.buddybuilding.activities.PlayVideoZirBaqalActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerZirBaqalBinding;
import com.example.buddybuilding.models.ZirbaqalModel;
import com.example.buddybuilding.tools.ZirbaqalClickListener;

import java.util.List;

public class RecyclerAdapterShowZirBaqalAdapter extends RecyclerView.Adapter<RecyclerAdapterShowZirBaqalAdapter.CustomView>
        implements ZirbaqalClickListener {

    private Context context;
    List<ZirbaqalModel> zirbaqalModels;

    public RecyclerAdapterShowZirBaqalAdapter(Context context, List<ZirbaqalModel> zirbaqalModels) {
        this.context = context;
        this.zirbaqalModels = zirbaqalModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowZirBaqalAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecyclerZirBaqalBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_zir_baqal, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowZirBaqalAdapter.CustomView customView, int i) {

        final ZirbaqalModel zirbaqalModel= zirbaqalModels.get(i);
        customView.bind(zirbaqalModel);
        customView.binding.setZirbaqalClickListener(this);
    }

    @Override
    public int getItemCount() {
        return zirbaqalModels.size();
    }

    @Override
    public void Clicked(ZirbaqalModel zirbaqalModel) {
        Intent intent = new Intent(context, PlayVideoZirBaqalActivity.class);
        intent.putExtra("id", zirbaqalModel.id);
        intent.putExtra("name", zirbaqalModel.name);
        context.startActivity(intent);

    }

    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerZirBaqalBinding binding;

        public CustomView(ActivityInnerRecyclerZirBaqalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }

}
