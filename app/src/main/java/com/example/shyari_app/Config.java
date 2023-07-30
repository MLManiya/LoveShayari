package com.example.shyari_app;

import android.os.Environment;

import java.io.File;

public class Config {
    static int Gradle_Color_Array[] = {R.drawable.gridview_gradle_1,R.drawable.gridview_gradle_2,R.drawable.gridview_gradle_3,R.drawable.gridview_gradle_4,R.drawable.gridview_gradle_5,R.drawable.gridview_gradle_6,R.drawable.gridview_gradle_7,R.drawable.gridview_gradle_8,R.drawable.gridview_gradle_9,R.drawable.gridview_gradle_10};
    static  int Backgroud_color[] = {R.color.Colour_1,R.color.Colour_2,R.color.Colour_3,R.color.Colour_4,R.color.Colour_5,R.color.Colour_6,R.color.Colour_7,R.color.Colour_8,R.color.Colour_9,R.color.Colour_10,R.color.Colour_11,R.color.Colour_12,R.color.Colour_13,R.color.Colour_14,R.color.Colour_15};
    static  String Imoji[] ={"❤🧡💛💚💙💜🤎","🤍💔❣💕💞💓💗","😀😁😂🤣😃😄😅","😉😊😋😎😍😘🥰","🍕🍔🍟🌭🍿🧂🥓","🍖🍗🥩🍠🥟🥠🥡","🥧🍦🍧🍨🍩🍪🎂","🍈🍉🍊🍋🍌🍍🥭","👩👨🧑👧👦🧒👶","🌺🌻🌼🌷🥀☘🌱"};
    static  String Font[] = {"BAUHS93.TTF","BERNHC.TTF","BRITANIC.TTF","","BRUSHSCI.TTF","COOPBL.TTF","","ENGR.TTF","ITCEDSCR.TTF","JOKERMAN.TTF",};
    static File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
}
