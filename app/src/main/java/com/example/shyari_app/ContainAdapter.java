package com.example.shyari_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContainAdapter extends BaseAdapter {
    Shayri_Title_detail_view shayri_title_detail_view;
    int imgArr;
    String[] shayaricategory;


    public ContainAdapter(Shayri_Title_detail_view shayri_title_detail_view, int shayariimg, String[] shayaricategory) {
        this.shayri_title_detail_view = shayri_title_detail_view;
        this.imgArr = shayariimg;
        this.shayaricategory = shayaricategory;
    }

    @Override
    public int getCount() {
        return shayaricategory.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(shayri_title_detail_view).inflate(R.layout.activity_shayri_title_detail_view_item_view,viewGroup,false);
        ImageView titleimage = view.findViewById(R.id.activity_shayri_title_detail_view_item_imageview);
        TextView textview= view.findViewById(R.id.activity_shayri_title_detail_view_item_textview);

        titleimage.setImageResource(imgArr);
        textview.setText(""+shayaricategory[i]);

        return view;
    }
}
