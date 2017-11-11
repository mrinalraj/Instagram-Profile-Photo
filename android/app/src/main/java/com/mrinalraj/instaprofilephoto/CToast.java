/*
Author: Mrinal Raj
made for com.mrinalraj.outpasswarden
Disclaimer: Please do not remove this line if you are using this to make custom toasts or i'll eat all your morning toasts
Help: 1. to change the background change to value of DRAWABLE_RESOURCE to a drawbale or color
      2. make any other accordingly
Usage: to use create an object of the class and call the method make() which accepts one or two string inputs
       the default duration for the toast is set to LENGTH_LONG, for making the toast appear for specific time call the method cancel(duration)

*/
package com.mrinalraj.instaprofilephoto;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mrinal on 21-11-2016.
 */

public class CToast{

    Context c;
    Toast toast;
    LinearLayout layout;
    int DRAWABLE_RESOURCE=R.drawable.toast;

    public CToast(Context c){
        this.c=c;
        toast=new Toast(c);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setLayout(){
        layout=new LinearLayout(c);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setBackgroundResource(DRAWABLE_RESOURCE);
        layout.setAlpha(1);
        layout.setPadding(40,18,40,20);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            layout.setElevation(10);
        }
        layout.setOrientation(LinearLayout.VERTICAL);
    }


    public void make(String text){
        setLayout();
        TextView tv=new TextView(c);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(16);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setText(text);
        layout.addView(tv);
        show();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void make(String text, String caption){
        setLayout();
        TextView tv=new TextView(c);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(18);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setText(text);
        TextView tv2 =new TextView(c);
        tv2.setTextColor(Color.LTGRAY);
        tv2.setTextSize(14);
        tv2.setGravity(Gravity.CENTER_VERTICAL);
        tv2.setText(caption);

        layout.addView(tv);
        layout.addView(tv2);
        show();
    }

    public void show(){
        toast.setView(layout);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 110,65);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    public void cancel(int timeToKill){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, timeToKill);
    }
    public void cancel(){
        toast.cancel();
    }

}
