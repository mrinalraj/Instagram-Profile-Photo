package com.mrinalraj.instaprofilephoto.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.mrinalraj.instaprofilephoto.R;

public class about extends AppCompatActivity {
    CardView cd1,cd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About");
        TextView tv1=(TextView)findViewById(R.id.tv1);
        String styledText = "This project is on <font color='black'> Github</font><br><font color='blue'>https://github.com/mystiquemilo/Instagram-Profile-Photo</font>.";
        tv1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mystiquemilo/Instagram-Profile-Photo"));
                startActivity(browserIntent);
            }
        });

        cd1= (CardView) findViewById(R.id.cd1);
        cd2=(CardView) findViewById(R.id.cd2);


        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mrinalraj.com"));
                startActivity(browserIntent);
            }
        });


        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ishanjain.me"));
                startActivity(browserIntent);
            }
        });
    }
}
