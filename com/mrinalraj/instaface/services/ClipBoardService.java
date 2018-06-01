package com.mrinalraj.instaface.services;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Intent;
import android.os.IBinder;
import android.view.LayoutInflater;
import com.mrinalraj.instaface.R;
import com.mrinalraj.instaface.activities.Search;
import com.txusballesteros.bubbles.BubbleLayout;
import com.txusballesteros.bubbles.BubbleLayout.C1022b;
import com.txusballesteros.bubbles.C1039d;
import com.txusballesteros.bubbles.C1039d.C1038a;

public class ClipBoardService extends Service {
    ClipboardManager f3329a;
    String[] f3330b;
    private C1039d f3331c;

    class C10211 implements OnPrimaryClipChangedListener {
        final /* synthetic */ ClipBoardService f3327a;

        C10211(ClipBoardService clipBoardService) {
            this.f3327a = clipBoardService;
        }

        public void onPrimaryClipChanged() {
            this.f3327a.m5299a();
        }
    }

    class C10232 implements C1022b {
        final /* synthetic */ ClipBoardService f3328a;

        C10232(ClipBoardService clipBoardService) {
            this.f3328a = clipBoardService;
        }

        public void mo847a(BubbleLayout bubbleLayout) {
            this.f3328a.f3329a.getPrimaryClip();
            this.f3328a.f3329a.setPrimaryClip(ClipData.newPlainText("text", ""));
            this.f3328a.f3331c.m5359a(bubbleLayout);
            this.f3328a.startActivity(new Intent(this.f3328a.getApplicationContext(), Search.class).putExtra("service", this.f3328a.f3330b[3].trim()).setFlags(268468224));
        }
    }

    public void m5299a() {
        try {
            if (this.f3329a.hasPrimaryClip()) {
                String charSequence = this.f3329a.getPrimaryClip().getItemAt(0).getText().toString();
                String str = "http://www.instagram.com/p/";
                this.f3330b = charSequence.split("/");
                if (charSequence.contains("www.instagram.com/") && !this.f3330b[3].equals("p")) {
                    BubbleLayout bubbleLayout = (BubbleLayout) LayoutInflater.from(getApplicationContext()).inflate(R.layout.bubble_layout, null);
                    bubbleLayout.setShouldStickToWall(true);
                    this.f3331c.m5360a(bubbleLayout, 0, 60);
                    bubbleLayout.setOnBubbleClickListener(new C10232(this));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.f3331c = new C1038a(this).m5348a(R.layout.bubble_trash).m5349a();
        this.f3331c.m5358a();
        this.f3329a = (ClipboardManager) getSystemService("clipboard");
        this.f3329a.addPrimaryClipChangedListener(new C10211(this));
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
