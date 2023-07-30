package com.example.shyari_app;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Shayari_Details_Edit_Activity extends AppCompatActivity {
TextView textView;
GridView gridView;
ListView listView;
int cnt=0,i=0;
private File downloadFile;

Button refresh,zoom,background,textcolor,share,font,emoji,textsize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari_details_edit);
        textView = findViewById(R.id.activity_shayari_details_edit_textview_shayari);
        refresh = findViewById(R.id.activity_shayari_details_edit_RefreshColourbutton);
        zoom = findViewById(R.id.activity_shayari_details_edit_Graddlebutton);
        background = findViewById(R.id.activity_shayari_details_edit_background_button);
        textcolor = findViewById(R.id.activity_shayari_details_edit_text_color_button);
        emoji = findViewById(R.id.activity_shayari_details_edit_emoji_button);
        font = findViewById(R.id.activity_shayari_details_edit_font_button);
        share = findViewById(R.id.activity_shayari_details_edit_share_button);
        textsize = findViewById(R.id.activity_shayari_details_edit_text_size_button);
        int position = getIntent().getIntExtra("Position",0);
        String[] Shayri = getIntent().getStringArrayExtra("Shayrititle");
        textView.setText(Shayri[position]);

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
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_Details_Edit_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_gradle_color);

                GradientAdapter gradientAdapter = new GradientAdapter(Shayari_Details_Edit_Activity.this,Config.Gradle_Color_Array);
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

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_Details_Edit_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_background_text_color);

                BackgroundTextColorAdapter backgroundTextColorAdapter = new BackgroundTextColorAdapter(Shayari_Details_Edit_Activity.this,Config.Backgroud_color, "Color");
                gridView =bottomSheetDialog.findViewById(R.id.activity_background_text_color_gridview);
                gridView.setAdapter(backgroundTextColorAdapter);
                bottomSheetDialog.show();
                int position = getIntent().getIntExtra("Position",0);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Config.Backgroud_color[i]);
                        bottomSheetDialog.dismiss();
                      /*  Intent intent = new Intent(Shayari_show_view.this,Shayari_show_view.class);
                        startActivity(intent);*/
                    }
                });
            }
        });
        textcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_Details_Edit_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_background_text_color);

                BackgroundTextColorAdapter backgroundTextColorAdapter = new BackgroundTextColorAdapter(Shayari_Details_Edit_Activity.this,Config.Backgroud_color,"Color");
                gridView =bottomSheetDialog.findViewById(R.id.activity_background_text_color_gridview);
                gridView.setAdapter(backgroundTextColorAdapter);
                bottomSheetDialog.show();
                int position = getIntent().getIntExtra("Position",0);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setTextColor(getResources().getColor(Config.Backgroud_color[i]));
                        bottomSheetDialog.dismiss();
                      /*  Intent intent = new Intent(Shayari_show_view.this,Shayari_show_view.class);
                        startActivity(intent);*/
                    }
                });
            }
        });
        emoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_Details_Edit_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_emoji_sticker);

                EmojiAdpater emojiAdpater = new EmojiAdpater(Shayari_Details_Edit_Activity.this,Config.Imoji);
                listView = bottomSheetDialog.findViewById(R.id.activity_emoji_sticker_listview);
                listView.setAdapter(emojiAdpater);
                bottomSheetDialog.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        textView.setText(Config.Imoji[position]+"\n"+""+Shayri[position]+"\n"+""+Config.Imoji[position]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
        font.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_Details_Edit_Activity.this);
                bottomSheetDialog.setContentView(R.layout.activity_font_string_type);

                FontAdapter fontAdapter = new FontAdapter(Shayari_Details_Edit_Activity.this,Config.Font);
                listView = bottomSheetDialog.findViewById(R.id.activity_font_string_listview);
                listView.setAdapter(fontAdapter);
                bottomSheetDialog.show();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Typeface typeface = Typeface.createFromAsset(Shayari_Details_Edit_Activity.this.getAssets(),Config.Font[position]);
                        textView.setTypeface(typeface);
                    }
                });
            }
        });

        textsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog4 = new BottomSheetDialog(Shayari_Details_Edit_Activity.this);
                bottomSheetDialog4.setContentView(R.layout.activity_text_size);
                SeekBar seekBar= bottomSheetDialog4.findViewById(R.id.activity_seekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        textView.setTextSize(2,20+i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                bottomSheetDialog4.show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap icon = getBitmapFromView(textView);
                //Intent share = new Intent(Intent.ACTION_SEND);
                Intent share =new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                int num=new Random().nextInt(2000);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                String currentDateandTime = sdf.format(new Date());

                downloadFile= new File(Config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
                try
                {
                    downloadFile.createNewFile();
                    FileOutputStream fo = new FileOutputStream(downloadFile);
                    fo.write(bytes.toByteArray());
                    Toast.makeText(Shayari_Details_Edit_Activity.this,"File Downloaded",Toast.LENGTH_LONG).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(downloadFile.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share Image"));

            }

            private Bitmap getBitmapFromView(TextView textView) {
                //Define a bitmap with the same size as the view
                Bitmap returnedBitmap = Bitmap.createBitmap(textView.getWidth(), textView.getHeight(), Bitmap.Config.ARGB_8888);
                //Bind a canvas to it
                Canvas canvas = new Canvas(returnedBitmap);
                //Get the view's background
                Drawable bgDrawable = textView.getBackground();
                if (bgDrawable != null)
                {
                    //has background drawable, then draw it on the canvas
                    bgDrawable.draw(canvas);
                }
                else
                {
                    //does not have background drawable, then draw white background on the canvas
                    canvas.drawColor(Color.WHITE);
                }
                // draw the view on the canvas
                textView.draw(canvas);
                //return the bitmap
                return returnedBitmap;
            }
        });
    }
}