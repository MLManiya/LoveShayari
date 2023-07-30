package com.example.shyari_app;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class MyAdapater extends BaseAdapter {
    MainActivity mainActivity;
    int[] imgArr;
    String[] shayriTitle;
    public MyAdapater(MainActivity mainActivity, int[] imgArr, String[] shayriTitle) {
        this.mainActivity = mainActivity;
        this.imgArr = imgArr;
        this.shayriTitle = shayriTitle;
    }

    @Override
    public int getCount() {
        return imgArr.length;
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
        view = LayoutInflater.from(mainActivity).inflate(R.layout.activity_main_item_file,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.activity_main_item_file_imageview);
        TextView textView = view.findViewById(R.id.activity_main_item_file_textview);

        imageView.setImageResource(imgArr[i]);
        textView.setText(shayriTitle[i]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
                builder.setTitle("!...Alert...!");
                builder.setMessage("Are You Sure To Show The Image!");
                builder.setPositiveButton("Open", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        return view;
    }
}
