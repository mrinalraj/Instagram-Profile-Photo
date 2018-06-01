package com.p031c.p032a;

import android.app.Activity;
import android.support.v4.p008h.C0425s;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public final class C0968b {
    private static WeakReference<Activity> f3217a;
    private C0965a f3218b;

    class C09672 implements Runnable {
        final /* synthetic */ C0968b f3216a;

        C09672(C0968b c0968b) {
            this.f3216a = c0968b;
        }

        public void run() {
            ViewGroup a = this.f3216a.m5204d();
            if (a != null && this.f3216a.m5198b().getParent() == null) {
                a.addView(this.f3216a.m5198b());
            }
        }
    }

    private C0968b() {
    }

    public static C0968b m5196a(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity cannot be null!");
        }
        C0968b c0968b = new C0968b();
        C0968b.m5200b(activity);
        c0968b.m5203c(activity);
        c0968b.m5201b(new C0965a(activity));
        return c0968b;
    }

    private static Runnable m5197a(final C0965a c0965a) {
        return new Runnable() {
            public void run() {
                try {
                    ((ViewGroup) c0965a.getParent()).removeView(c0965a);
                } catch (Throwable e) {
                    Log.e(getClass().getSimpleName(), Log.getStackTraceString(e));
                }
            }
        };
    }

    private C0965a m5198b() {
        return this.f3218b;
    }

    public static void m5200b(Activity activity) {
        if (activity != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    C0965a c0965a = viewGroup.getChildAt(i) instanceof C0965a ? (C0965a) viewGroup.getChildAt(i) : null;
                    if (!(c0965a == null || c0965a.getWindowToken() == null)) {
                        C0425s.m1976o(c0965a).m2014a(0.0f).m2019a(C0968b.m5197a(c0965a));
                    }
                }
            } catch (Throwable e) {
                Log.e(C0968b.class.getClass().getSimpleName(), Log.getStackTraceString(e));
            }
        }
    }

    private void m5201b(C0965a c0965a) {
        this.f3218b = c0965a;
    }

    private WeakReference<Activity> m5202c() {
        return f3217a;
    }

    private void m5203c(Activity activity) {
        f3217a = new WeakReference(activity);
    }

    private ViewGroup m5204d() {
        return (m5202c() == null || m5202c().get() == null) ? null : (ViewGroup) ((Activity) m5202c().get()).getWindow().getDecorView();
    }

    public C0965a m5205a() {
        if (m5202c() != null) {
            ((Activity) m5202c().get()).runOnUiThread(new C09672(this));
        }
        return m5198b();
    }

    public C0968b m5206a(int i) {
        if (m5198b() != null) {
            m5198b().setProgressColorRes(i);
        }
        return this;
    }

    public C0968b m5207a(String str) {
        if (m5198b() != null) {
            m5198b().setTitle(str);
        }
        return this;
    }

    public C0968b m5208a(boolean z) {
        if (m5198b() != null) {
            m5198b().setEnableProgress(z);
        }
        return this;
    }

    public C0968b m5209b(String str) {
        if (m5198b() != null) {
            m5198b().setText(str);
        }
        return this;
    }
}
