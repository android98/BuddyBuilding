package com.example.buddybuilding.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.buddybuilding.models.MorabiModel;
import com.example.buddybuilding.remote.MorabiRepository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MorabiViewModel extends ViewModel {

    public MorabiRepository morabiRepository;

    public Integer id;
    public String name="",informations = "", image = "";

    public String getImageUrl(){
        return image;
    }

    public MutableLiveData<ArrayList<MorabiViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    public ArrayList<MorabiViewModel> arrayList;

    public MorabiViewModel() {
        morabiRepository = new MorabiRepository();
        arrayListMutableLiveData = morabiRepository.getGetArrayListMutableLi();
    }

    public MorabiViewModel(MorabiModel morabiModel) {
        this.id = morabiModel.id;
        this.name = morabiModel.name;
        this.informations = morabiModel.informations;
        this.image = morabiModel.image;
    }

    public MutableLiveData<ArrayList<MorabiViewModel>> getArrayListMutableLiveData() {
      /*  arrayList = new ArrayList<>();
        MorabiModel morabiModel = new MorabiModel()*/

        return arrayListMutableLiveData;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void getimageurl(ImageView imageView, String imageUrl) {
        //Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
        Picasso.get().load(imageUrl).into(imageView);
    }
}
