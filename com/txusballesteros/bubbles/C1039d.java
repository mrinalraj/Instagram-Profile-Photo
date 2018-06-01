package com.txusballesteros.bubbles;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.txusballesteros.bubbles.BubblesService.C1033a;

public class C1039d {
    private static C1039d f3393a;
    private Context f3394b;
    private boolean f3395c;
    private BubblesService f3396d;
    private int f3397e;
    private C1040e f3398f;
    private ServiceConnection f3399g = new C10371(this);

    class C10371 implements ServiceConnection {
        final /* synthetic */ C1039d f3391a;

        C10371(C1039d c1039d) {
            this.f3391a = c1039d;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f3391a.f3396d = ((C1033a) iBinder).m5319a();
            this.f3391a.m5357b();
            this.f3391a.f3395c = true;
            if (this.f3391a.f3398f != null) {
                this.f3391a.f3398f.m5361a();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f3391a.f3395c = false;
        }
    }

    public static class C1038a {
        private C1039d f3392a;

        public C1038a(Context context) {
            this.f3392a = C1039d.m5355b(context);
        }

        public C1038a m5348a(int i) {
            this.f3392a.f3397e = i;
            return this;
        }

        public C1039d m5349a() {
            return this.f3392a;
        }
    }

    private C1039d(Context context) {
        this.f3394b = context;
    }

    private static C1039d m5355b(Context context) {
        if (f3393a == null) {
            f3393a = new C1039d(context);
        }
        return f3393a;
    }

    private void m5357b() {
        this.f3396d.m5328a(this.f3397e);
    }

    public void m5358a() {
        this.f3394b.bindService(new Intent(this.f3394b, BubblesService.class), this.f3399g, 1);
    }

    public void m5359a(BubbleLayout bubbleLayout) {
        if (this.f3395c) {
            this.f3396d.m5329a(bubbleLayout);
        }
    }

    public void m5360a(BubbleLayout bubbleLayout, int i, int i2) {
        if (this.f3395c) {
            this.f3396d.m5330a(bubbleLayout, i, i2);
        }
    }
}
