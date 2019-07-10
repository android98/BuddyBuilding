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
import com.example.buddybuilding.databinding.ActivityInnerRecyclerMokamelMobtadianBinding;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.tools.MokamelMobtadiClickListener;

import java.util.List;

public class RecyclerAdapterShowMokamelMobtadiAdapter extends
        RecyclerView.Adapter<RecyclerAdapterShowMokamelMobtadiAdapter.CustomView>
implements MokamelMobtadiClickListener {


    public Context context;
    public List<MokamelAvaliehModel> mokamelAvaliehModels;


    public RecyclerAdapterShowMokamelMobtadiAdapter(Context context, List<MokamelAvaliehModel> mokamelAvaliehModels) {
        this.context = context;
        this.mokamelAvaliehModels = mokamelAvaliehModels;
    }





    @NonNull
    @Override
    public RecyclerAdapterShowMokamelMobtadiAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecyclerMokamelMobtadianBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_mokamel_mobtadian, viewGroup, false);
        return new CustomView(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterShowMokamelMobtadiAdapter.CustomView customView, int i) {
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
        Log.d("tests", "Clicked: " + mokamelAvaliehModel.getId());
        Log.d("tests", "Clicked: " + mokamelAvaliehModel.getParentid());
        Log.d("tests", "Clicked: " + mokamelAvaliehModel.getName());
        Log.d("tests", "Clicked: " + mokamelAvaliehModel.getInformations());
        Log.d("tests", "Clicked: " + mokamelAvaliehModel.getImage_url());
        Intent intent = new Intent(context, ShowInformationsSelected2Activity.class);
        intent.putExtra("id", mokamelAvaliehModel.id);
        context.startActivity(intent);
    }


    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerMokamelMobtadianBinding binding;

        public CustomView(ActivityInnerRecyclerMokamelMobtadianBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }



}
