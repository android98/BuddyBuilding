package com.example.buddybuilding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.buddybuilding.R;

public class MainGridViewAdapter extends BaseAdapter {

    public Context context;
    public final int[] gridImages;
    public final String[] gridNames;


    public MainGridViewAdapter(Context context, int[] gridImages, String[] gridNames) {
        this.context = context;
        this.gridImages = gridImages;
        this.gridNames = gridNames;
    }

    @Override
    public int getCount() {
        return gridImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View  view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = new View(context);
            view = inflater.inflate(R.layout.main_grid_view, null);
            ImageView imageView = view.findViewById(R.id.img);
            TextView textView = view.findViewById(R.id.txt_name);
            imageView.setImageResource(gridImages[position]);
            textView.setText(gridNames[position]);
        }
        else {
            view = (View) convertView;
        }

        return view;
    }
}
