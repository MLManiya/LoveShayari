package com.example.shyari_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    int ImgArr[] = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,R.drawable.img_11,R.drawable.img_12,R.drawable.img_13,R.drawable.img_14,R.drawable.img_15,R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19};
    String ShayariTitle[] = {"शुभकामनाए  शायरी","मित्रता शायरी","मजेदार शायरी","भगवान शायरी","भाजपा शायरी","प्रेरणा स्त्रोत शायरी","जीवन शायरी","महोब्बत शायरी","यादें शायरी","अन्य शायरी","राजनीति शायरी","प्रेम शायरी","दर्द शायरी","शराबी शायरी","बेवफा शायरी","जन्मदीन शायरी","होली शायरी","दीवापावली शायरी","नववर्ष शायरी"};
    MyAdapater adapater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.activity_main_listview);
        adapater = new MyAdapater(MainActivity.this,ImgArr,ShayariTitle);
        listView.setAdapter(adapater);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,Shayri_Title_detail_view.class);
                intent.putExtra("Position",i);
                intent.putExtra("Image",ImgArr);
                intent.putExtra("Shayarititle",ShayariTitle);
                startActivity(intent);
            }
        });
    }
}

