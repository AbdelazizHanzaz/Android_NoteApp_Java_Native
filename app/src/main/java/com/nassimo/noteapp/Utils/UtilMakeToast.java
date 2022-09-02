package com.nassimo.noteapp.Utils;

import android.content.Context;
import android.widget.Toast;

public class UtilMakeToast  {

    public static void longToast(final Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    public static void shortToast(final Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


}
