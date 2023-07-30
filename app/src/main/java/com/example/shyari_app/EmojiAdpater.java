package com.example.shyari_app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EmojiAdpater extends BaseAdapter {
    Activity activity;
    String[] imoji;
    public EmojiAdpater(Activity activity, String[] imoji) {
        this.activity = activity;
        this.imoji = imoji;
    }



    @Override
    public int getCount() {
        return imoji.length;
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
        convertView = LayoutInflater.from(activity).inflate(R.layout.activity_emoji_sticker_item_file,parent,false);
        TextView textView = convertView.findViewById(R.id.activity_emoji_sticker_item_textview);
        textView.setText(""+imoji[position]);
        return convertView;
    }
}
