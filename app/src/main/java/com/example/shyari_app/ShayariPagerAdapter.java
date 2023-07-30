package com.example.shyari_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ShayariPagerAdapter extends PagerAdapter {
    Context context;
    String[] shayarittile;
    TextView textView;

    public ShayariPagerAdapter(Context context, String[] shayarittile, TextView textView) {
       this.context = context;
        this.shayarittile = shayarittile;
        this.textView = textView;
    }

    @Override
    public int getCount() {
        return shayarittile.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager_item,container,false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
