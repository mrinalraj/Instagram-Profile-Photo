package com.mrinalraj.instaprofilephoto.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrinalraj.instaprofilephoto.R;

public class about extends AppCompatActivity {
    CardView cd1,cd2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About");
        TextView tv1=(TextView)findViewById(R.id.tv1);
        TextView tv2=(TextView)findViewById(R.id.textView2);
        String styledText = "This project is on <font color='black'> Github</font>, feel free to check out<br><font color='blue'>https://github.com/mrinalraj/Instagram-Profile-Photo</font>.";
        tv1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mrinalraj/Instagram-Profile-Photo"));
                startActivity(browserIntent);
            }
        });
        tv2.setText(Html.fromHtml("Special thanks to <font color='black'>icon8</font> for these awesome icons."), TextView.BufferType.SPANNABLE);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://icons8.com"));
                startActivity(browserIntent);
            }
        });
        cd1= (CardView) findViewById(R.id.cd1);
        cd2=(CardView) findViewById(R.id.cd2);
        imageView= (ImageView) findViewById(R.id.mail);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"me@mrinalraj.com","ishanjain28@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Regarding the Insta Face app");
                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


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
