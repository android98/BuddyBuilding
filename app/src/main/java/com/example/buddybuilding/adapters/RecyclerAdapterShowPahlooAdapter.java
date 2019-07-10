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
import com.example.buddybuilding.activities.PlayVideoPahlooActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerPahlooBinding;
import com.example.buddybuilding.models.PahlooModel;
import com.example.buddybuilding.tools.PahlooClickListener;

import java.util.List;

public class RecyclerAdapterShowPahlooAdapter extends RecyclerView.Adapter
        <RecyclerAdapterShowPahlooAdapter.CustomView>  implements PahlooClickListener {


    private Context context;
    private List<PahlooModel> pahlooModels;

    public RecyclerAdapterShowPahlooAdapter(Context context, List<PahlooModel> pahlooModels) {
        this.context = context;
        this.pahlooModels = pahlooModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterShowPahlooAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ActivityInnerRecyclerPahlooBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_pahloo, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowPahlooAdapter.CustomView customView, int i) {
        final PahlooModel pahlooModel = pahlooModels.get(i);
        customView.bind(pahlooModel);
        customView.binding.setPahlooClickListener(this);
    }

    @Override
    public int getItemCount() {
        return pahlooModels.size();
    }

    @Override
    public void Clicked(PahlooModel pahlooModel) {
        Log.d("Clicked", "Clicked: " + pahlooModel.getName());
        Intent intent = new Intent(context, PlayVideoPahlooActivity.class);
        intent.putExtra("id", pahlooModel.id);
        intent.putExtra("name", pahlooModel.name);
        context.startActivity(intent);
    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerPahlooBinding binding;

        public CustomView(ActivityInnerRecyclerPahlooBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }



}
