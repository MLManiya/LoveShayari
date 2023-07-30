package com.example.shyari_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GradientAdapter extends BaseAdapter {
    Activity activity;
    int[] gradle_color_array;

    public GradientAdapter(Activity activity, int[] gradle_color_array) {
        this.activity = activity;
        this.gradle_color_array = gradle_color_array;

    }


    @Override
    public int getCount() {
        return gradle_color_array.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(activity).inflate(R.layout.activity_gradle_color_item_file,parent,false);
        TextView textView = convertView.findViewById(R.id.activity_gridview_gradle_color_textview);

        textView.setBackgroundResource(gradle_color_array[position]);
        return convertView;
    }
}
