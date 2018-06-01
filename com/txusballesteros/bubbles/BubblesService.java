package com.txusballesteros.bubbles;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.txusballesteros.bubbles.C1036c.C1035a;
import java.util.ArrayList;
import java.util.List;

public class BubblesService extends Service {
    private C1033a f3379a = new C1033a(this);
    private List<BubbleLayout> f3380b = new ArrayList();
    private C1034b f3381c;
    private WindowManager f3382d;
    private C1036c f3383e;

    public class C1033a extends Binder {
        final /* synthetic */ BubblesService f3378a;

        public C1033a(BubblesService bubblesService) {
            this.f3378a = bubblesService;
        }

        public BubblesService m5319a() {
            return this.f3378a;
        }
    }

    private LayoutParams m5320a(int i, int i2) {
        LayoutParams layoutParams = new LayoutParams(-2, -2, 2002, 8, -2);
        layoutParams.gravity = 8388659;
        layoutParams.x = i;
        layoutParams.y = i2;
        return layoutParams;
    }

    private WindowManager m5321a() {
        if (this.f3382d == null) {
            this.f3382d = (WindowManager) getSystemService("window");
        }
        return this.f3382d;
    }

    private void m5323a(final C1030a c1030a) {
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ BubblesService f3377b;

            public void run() {
                this.f3377b.m5321a().addView(c1030a, c1030a.getViewParams());
            }
        });
    }

    private void m5325b() {
        this.f3383e = new C1035a(this).m5335a(m5321a()).m5336a(this.f3381c).m5337a();
    }

    private void m5326b(final BubbleLayout bubbleLayout) {
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ BubblesService f3375b;

            public void run() {
                this.f3375b.m5321a().removeView(bubbleLayout);
                for (BubbleLayout bubbleLayout : this.f3375b.f3380b) {
                    if (bubbleLayout == bubbleLayout) {
                        bubbleLayout.m5317a();
                        this.f3375b.f3380b.remove(bubbleLayout);
                        return;
                    }
                }
            }
        });
    }

    private LayoutParams m5327c() {
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2006, 8, -2);
        layoutParams.x = 0;
        layoutParams.y = 0;
        return layoutParams;
    }

    void m5328a(int i) {
        if (i != 0) {
            this.f3381c = new C1034b(this);
            this.f3381c.setWindowManager(this.f3382d);
            this.f3381c.setViewParams(m5327c());
            this.f3381c.setVisibility(8);
            LayoutInflater.from(this).inflate(i, this.f3381c, true);
            m5323a(this.f3381c);
            m5325b();
        }
    }

    public void m5329a(BubbleLayout bubbleLayout) {
        m5326b(bubbleLayout);
    }

    public void m5330a(BubbleLayout bubbleLayout, int i, int i2) {
        LayoutParams a = m5320a(i, i2);
        bubbleLayout.setWindowManager(m5321a());
        bubbleLayout.setViewParams(a);
        bubbleLayout.setLayoutCoordinator(this.f3383e);
        this.f3380b.add(bubbleLayout);
        m5323a((C1030a) bubbleLayout);
    }

    public IBinder onBind(Intent intent) {
        return this.f3379a;
    }

    public boolean onUnbind(Intent intent) {
        for (BubbleLayout b : this.f3380b) {
            m5326b(b);
        }
        this.f3380b.clear();
        return super.onUnbind(intent);
    }
}
