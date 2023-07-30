package com.example.shyari_app;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FontAdapter extends BaseAdapter {
    Shayari_Details_Edit_Activity shayari_details_edit_activity;
    String[] font;
    public FontAdapter(Shayari_Details_Edit_Activity shayari_details_edit_activity, String[] font) {
        this.shayari_details_edit_activity = shayari_details_edit_activity;
        this.font = font;
    }




    @Override
    public int getCount() {
        return font.length;
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
        view = LayoutInflater.from(shayari_details_edit_activity).inflate(R.layout.activity_emoji_sticker_item_file,viewGroup,false);
        TextView textView = view.findViewById(R.id.activity_emoji_sticker_item_textview);
        textView.setText("ShayariApp");
        /*Typeface typeface = Typeface.createFromAsset(shayari_details_edit_activity.getAssets(),font[i]);
        textView.setTypeface(typeface);*/
        return view;
    }
}
