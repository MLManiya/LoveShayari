package com.example.shyari_app;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ClipboardManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Shayari_show_view extends AppCompatActivity {
TextView textView,countplus,counttotal;
Button button1,copy,backward,edit,forward,share,zoom,refresh;
GridView gridView;
ViewPager viewPager;
int cnt=0,i=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari_show_view);
        textView = findViewById(R.id.activity_shayari_show_view_textview_shayari);
        countplus = findViewById(R.id.activity_shayari_show_view_textview_count);
        viewPager = findViewById(R.id.viewPager);
      //  counttotal = findViewById(R.id.activity_shayari_show_view_textview_totalcount);
        backward = findViewById(R.id.activity_shayari_show_view_downbutton);
        forward = findViewById(R.id.activity_shayari_show_view_upbutton);
        zoom = findViewById(R.id.activity_shayari_show_view_Graddlebutton);
        edit = findViewById(R.id.activity_shayari_show_view_editbutton);
        refresh = findViewById(R.id.activity_shayari_show_view_RefreshColourbutton);
        copy = findViewById(R.id.activity_shayari_show_view_copybutton);
        share = findViewById(R.id.activity_shayari_show_view_sharebutton);
        final int[] position = {getIntent().getIntExtra("Position", 0)};
        String[] Shayarittile = getIntent().getStringArrayExtra("shyarilist");

        textView.setText(Shayarittile[position[0]]);
        countplus.setText(""+(position[0]+1+ "/" +Shayarittile.length));
        System.out.println(""+position[0]);
        button1 = findViewById(R.id.activity_shayari_show_view_copybutton);
      //  counttotal.setText(""+Shayarittile.length);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position[0]>0)
                {
                    position[0]--;
                    textView.setText(Shayarittile[position[0]]);
                    countplus.setText(""+(position[0]+1+ "/" +Shayarittile.length));
                }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(position[0] < Shayarittile.length-1)
              {
                  position[0]++;
                  textView.setText(""+Shayarittile[position[0]]);
                  countplus.setText(""+(position[0]+1+ "/" +Shayarittile.length));
              }
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(textView.getText());
                Toast.makeText(Shayari_show_view.this, "Copied to clipboard", Toast.LENGTH_LONG).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareBody = "Here is the share content body";
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.app_name)));
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cnt<10)
                {
                    textView.setBackgroundResource(Config.Gradle_Color_Array[i]);
                    cnt++;
                    i++;
                }
                else {
                    cnt=0;
                    i=0;
                }
            }
        });
        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Shayari_show_view.this,GradleColorActivity.class);
                intent.putExtra("Position",position[0]);
                startActivity(intent);
                textView.setText(""+Shayarittile[position[0]]);*/

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_show_view.this);
                bottomSheetDialog.setContentView(R.layout.activity_gradle_color);

                GradientAdapter gradientAdapter = new GradientAdapter(Shayari_show_view.this,Config.Gradle_Color_Array);
                gridView =bottomSheetDialog.findViewById(R.id.activity_gradle_color_gridview);
                gridView.setAdapter(gradientAdapter);
                bottomSheetDialog.show();
                int position = getIntent().getIntExtra("Position",0);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Config.Gradle_Color_Array[i]);
                        bottomSheetDialog.dismiss();
                      /*  Intent intent = new Intent(Shayari_show_view.this,Shayari_show_view.class);
                        startActivity(intent);*/
                    }
                });
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shayari_show_view.this,Shayari_Details_Edit_Activity.class);
                intent.putExtra("Position",position[0]);
                intent.putExtra("Shayrititle",Shayarittile);
                startActivity(intent);
            }
        });
        ShayariPagerAdapter pagerAdapter = new ShayariPagerAdapter(Shayari_show_view.this,Shayarittile,textView);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                textView.setText(""+Shayarittile[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}