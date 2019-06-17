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
import com.example.buddybuilding.activities.PlayVideoSarShooneActivity;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerMokamelKaramadBinding;
import com.example.buddybuilding.databinding.ActivityInnerRecyclerMokamelMobtadianBinding;
import com.example.buddybuilding.models.MokamelAvaliehModel;
import com.example.buddybuilding.models.MokamelPishrafteModel;
import com.example.buddybuilding.tools.MokamelPIshrafteClickListener;

import java.util.List;

public class RecyclerAdapterMokamelPishrafteAdapter extends RecyclerView.Adapter<RecyclerAdapterMokamelPishrafteAdapter.CustomView>
implements MokamelPIshrafteClickListener {


    public Context context;
    public List<MokamelPishrafteModel> mokamelPishrafteModels;

    public RecyclerAdapterMokamelPishrafteAdapter(Context context, List<MokamelPishrafteModel> mokamelPishrafteModels) {
        this.context = context;
        this.mokamelPishrafteModels = mokamelPishrafteModels;
    }

    @NonNull
    @Override
    public RecyclerAdapterMokamelPishrafteAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ActivityInnerRecyclerMokamelKaramadBinding binding = DataBindingUtil.inflate(LayoutInflater.
                        from(viewGroup.getContext())
                , R.layout.activity_inner_recycler_mokamel_karamad, viewGroup, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterMokamelPishrafteAdapter.CustomView customView, int i) {
        final MokamelPishrafteModel mokamelPishrafteModel= mokamelPishrafteModels.get(i);
        customView.bind(mokamelPishrafteModel);
        customView.binding.setMokamelPIshrafteClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mokamelPishrafteModels.size();
    }

    @Override
    public void Clicked(MokamelPishrafteModel mokamelPishrafteModel) {
        Log.d("tests", "Clicked: " + mokamelPishrafteModel.getId());
        Log.d("tests", "Clicked: " + mokamelPishrafteModel.getParentid());
        Log.d("tests", "Clicked: " + mokamelPishrafteModel.getName());
        Log.d("tests", "Clicked: " + mokamelPishrafteModel.getInformations());
        Log.d("tests", "Clicked: " + mokamelPishrafteModel.getImage_url());
        Log.d("tests", "Clicked: " + mokamelPishrafteModel.getRotbe_bandi());




    }



    public class CustomView extends RecyclerView.ViewHolder {

        private ActivityInnerRecyclerMokamelKaramadBinding binding;

        public CustomView(ActivityInnerRecyclerMokamelKaramadBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object o) {
            binding.setVariable(BR.model, o);
            binding.executePendingBindings();
        }
    }


}
