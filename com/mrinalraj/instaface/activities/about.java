package com.mrinalraj.instaface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.C0551c;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.mrinalraj.instaface.R;

public class about extends C0551c {
    CardView f3303m;
    CardView f3304n;
    ImageView f3305o;

    class C10071 implements OnClickListener {
        final /* synthetic */ about f3298a;

        C10071(about com_mrinalraj_instaface_activities_about) {
            this.f3298a = com_mrinalraj_instaface_activities_about;
        }

        public void onClick(View view) {
            this.f3298a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/mrinalraj/Instagram-Profile-Photo")));
        }
    }

    class C10082 implements OnClickListener {
        final /* synthetic */ about f3299a;

        C10082(about com_mrinalraj_instaface_activities_about) {
            this.f3299a = com_mrinalraj_instaface_activities_about;
        }

        public void onClick(View view) {
            this.f3299a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://icons8.com")));
        }
    }

    class C10093 implements OnClickListener {
        final /* synthetic */ about f3300a;

        C10093(about com_mrinalraj_instaface_activities_about) {
            this.f3300a = com_mrinalraj_instaface_activities_about;
        }

        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"me@mrinalraj.com", "ishanjain28@gmail.com"});
            intent.putExtra("android.intent.extra.SUBJECT", "Regarding the Insta Face app");
            intent.setType("message/rfc822");
            this.f3300a.startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        }
    }

    class C10104 implements OnClickListener {
        final /* synthetic */ about f3301a;

        C10104(about com_mrinalraj_instaface_activities_about) {
            this.f3301a = com_mrinalraj_instaface_activities_about;
        }

        public void onClick(View view) {
            this.f3301a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.mrinalraj.com")));
        }
    }

    class C10115 implements OnClickListener {
        final /* synthetic */ about f3302a;

        C10115(about com_mrinalraj_instaface_activities_about) {
            this.f3302a = com_mrinalraj_instaface_activities_about;
        }

        public void onClick(View view) {
            this.f3302a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ishanjain.me")));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_about);
        setTitle("About");
        TextView textView = (TextView) findViewById(R.id.tv1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView.setText(Html.fromHtml("This project is on <font color='black'> Github</font>, feel free to check out<br><font color='blue'>https://github.com/mrinalraj/Instagram-Profile-Photo</font>."), BufferType.SPANNABLE);
        textView.setOnClickListener(new C10071(this));
        textView2.setText(Html.fromHtml("Special thanks to <font color='black'>icons8</font> for these awesome icons."), BufferType.SPANNABLE);
        textView2.setOnClickListener(new C10082(this));
        this.f3303m = (CardView) findViewById(R.id.cd1);
        this.f3304n = (CardView) findViewById(R.id.cd2);
        this.f3305o = (ImageView) findViewById(R.id.mail);
        this.f3305o.setOnClickListener(new C10093(this));
        this.f3303m.setOnClickListener(new C10104(this));
        this.f3304n.setOnClickListener(new C10115(this));
    }
}
