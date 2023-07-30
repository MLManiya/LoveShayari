package com.example.shyari_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BackgroundTextColorAdapter extends BaseAdapter {
    Activity activity;
    int[] backgroud_color;
    public BackgroundTextColorAdapter(Activity activity, int[] backgroud_color, String color) {
        this.activity = activity;
        this.backgroud_color = backgroud_color;
    }



    @Override
    public int getCount() {
        return backgroud_color.length;
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
        convertView = LayoutInflater.from(activity).inflate(R.layout.activity_background_text_color_item_file,parent,false);
        TextView textView = convertView.findViewById(R.id.activity_gridview_background_text_color_textview);

        textView.setBackgroundResource(backgroud_color[position]);
      //  textView.setTextColor(backgroud_color[position]);
        return convertView;
    }
}
