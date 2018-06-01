package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.p008h.C0425s;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class C0482a implements OnTouchListener {
    private static final int f1209r = ViewConfiguration.getTapTimeout();
    final C0480a f1210a = new C0480a();
    final View f1211b;
    boolean f1212c;
    boolean f1213d;
    boolean f1214e;
    private final Interpolator f1215f = new AccelerateInterpolator();
    private Runnable f1216g;
    private float[] f1217h = new float[]{0.0f, 0.0f};
    private float[] f1218i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int f1219j;
    private int f1220k;
    private float[] f1221l = new float[]{0.0f, 0.0f};
    private float[] f1222m = new float[]{0.0f, 0.0f};
    private float[] f1223n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean f1224o;
    private boolean f1225p;
    private boolean f1226q;

    private static class C0480a {
        private int f1197a;
        private int f1198b;
        private float f1199c;
        private float f1200d;
        private long f1201e = Long.MIN_VALUE;
        private long f1202f = 0;
        private int f1203g = 0;
        private int f1204h = 0;
        private long f1205i = -1;
        private float f1206j;
        private int f1207k;

        C0480a() {
        }

        private float m2335a(float f) {
            return ((-4.0f * f) * f) + (4.0f * f);
        }

        private float m2336a(long j) {
            if (j < this.f1201e) {
                return 0.0f;
            }
            if (this.f1205i < 0 || j < this.f1205i) {
                return C0482a.m2348a(((float) (j - this.f1201e)) / ((float) this.f1197a), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f1205i;
            return (C0482a.m2348a(((float) j2) / ((float) this.f1207k), 0.0f, 1.0f) * this.f1206j) + (1.0f - this.f1206j);
        }

        public void m2337a() {
            this.f1201e = AnimationUtils.currentAnimationTimeMillis();
            this.f1205i = -1;
            this.f1202f = this.f1201e;
            this.f1206j = 0.5f;
            this.f1203g = 0;
            this.f1204h = 0;
        }

        public void m2338a(float f, float f2) {
            this.f1199c = f;
            this.f1200d = f2;
        }

        public void m2339a(int i) {
            this.f1197a = i;
        }

        public void m2340b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1207k = C0482a.m2351a((int) (currentAnimationTimeMillis - this.f1201e), 0, this.f1198b);
            this.f1206j = m2336a(currentAnimationTimeMillis);
            this.f1205i = currentAnimationTimeMillis;
        }

        public void m2341b(int i) {
            this.f1198b = i;
        }

        public boolean m2342c() {
            return this.f1205i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1205i + ((long) this.f1207k);
        }

        public void m2343d() {
            if (this.f1202f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2335a(m2336a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1202f;
            this.f1202f = currentAnimationTimeMillis;
            this.f1203g = (int) ((((float) j) * a) * this.f1199c);
            this.f1204h = (int) ((((float) j) * a) * this.f1200d);
        }

        public int m2344e() {
            return (int) (this.f1199c / Math.abs(this.f1199c));
        }

        public int m2345f() {
            return (int) (this.f1200d / Math.abs(this.f1200d));
        }

        public int m2346g() {
            return this.f1203g;
        }

        public int m2347h() {
            return this.f1204h;
        }
    }

    private class C0481b implements Runnable {
        final /* synthetic */ C0482a f1208a;

        C0481b(C0482a c0482a) {
            this.f1208a = c0482a;
        }

        public void run() {
            if (this.f1208a.f1214e) {
                if (this.f1208a.f1212c) {
                    this.f1208a.f1212c = false;
                    this.f1208a.f1210a.m2337a();
                }
                C0480a c0480a = this.f1208a.f1210a;
                if (c0480a.m2342c() || !this.f1208a.m2359a()) {
                    this.f1208a.f1214e = false;
                    return;
                }
                if (this.f1208a.f1213d) {
                    this.f1208a.f1213d = false;
                    this.f1208a.m2362b();
                }
                c0480a.m2343d();
                this.f1208a.mo381a(c0480a.m2346g(), c0480a.m2347h());
                C0425s.m1950a(this.f1208a.f1211b, (Runnable) this);
            }
        }
    }

    public C0482a(View view) {
        this.f1211b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2355a((float) i, (float) i);
        m2360b((float) i2, (float) i2);
        m2356a(1);
        m2367e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2365d(0.2f, 0.2f);
        m2363c(1.0f, 1.0f);
        m2361b(f1209r);
        m2364c(500);
        m2366d(500);
    }

    static float m2348a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    private float m2349a(float f, float f2, float f3, float f4) {
        float f5;
        float a = C0482a.m2348a(f * f2, 0.0f, f3);
        a = m2354f(f2 - f4, a) - m2354f(f4, a);
        if (a < 0.0f) {
            f5 = -this.f1215f.getInterpolation(-a);
        } else if (a <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f1215f.getInterpolation(a);
        }
        return C0482a.m2348a(f5, -1.0f, 1.0f);
    }

    private float m2350a(int i, float f, float f2, float f3) {
        float a = m2349a(this.f1217h[i], f2, this.f1218i[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f1221l[i];
        float f5 = this.f1222m[i];
        float f6 = this.f1223n[i];
        f4 *= f3;
        return a > 0.0f ? C0482a.m2348a(a * f4, f5, f6) : -C0482a.m2348a((-a) * f4, f5, f6);
    }

    static int m2351a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    private void m2352c() {
        if (this.f1216g == null) {
            this.f1216g = new C0481b(this);
        }
        this.f1214e = true;
        this.f1212c = true;
        if (this.f1224o || this.f1220k <= 0) {
            this.f1216g.run();
        } else {
            C0425s.m1951a(this.f1211b, this.f1216g, (long) this.f1220k);
        }
        this.f1224o = true;
    }

    private void m2353d() {
        if (this.f1212c) {
            this.f1214e = false;
        } else {
            this.f1210a.m2340b();
        }
    }

    private float m2354f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1219j) {
            case 0:
            case 1:
                return f < f2 ? f >= 0.0f ? 1.0f - (f / f2) : (this.f1214e && this.f1219j == 1) ? 1.0f : 0.0f : 0.0f;
            case 2:
                return f < 0.0f ? f / (-f2) : 0.0f;
            default:
                return 0.0f;
        }
    }

    public C0482a m2355a(float f, float f2) {
        this.f1223n[0] = f / 1000.0f;
        this.f1223n[1] = f2 / 1000.0f;
        return this;
    }

    public C0482a m2356a(int i) {
        this.f1219j = i;
        return this;
    }

    public C0482a m2357a(boolean z) {
        if (this.f1225p && !z) {
            m2353d();
        }
        this.f1225p = z;
        return this;
    }

    public abstract void mo381a(int i, int i2);

    boolean m2359a() {
        C0480a c0480a = this.f1210a;
        int f = c0480a.m2345f();
        int e = c0480a.m2344e();
        return (f != 0 && mo383f(f)) || (e != 0 && mo382e(e));
    }

    public C0482a m2360b(float f, float f2) {
        this.f1222m[0] = f / 1000.0f;
        this.f1222m[1] = f2 / 1000.0f;
        return this;
    }

    public C0482a m2361b(int i) {
        this.f1220k = i;
        return this;
    }

    void m2362b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1211b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public C0482a m2363c(float f, float f2) {
        this.f1221l[0] = f / 1000.0f;
        this.f1221l[1] = f2 / 1000.0f;
        return this;
    }

    public C0482a m2364c(int i) {
        this.f1210a.m2339a(i);
        return this;
    }

    public C0482a m2365d(float f, float f2) {
        this.f1217h[0] = f;
        this.f1217h[1] = f2;
        return this;
    }

    public C0482a m2366d(int i) {
        this.f1210a.m2341b(i);
        return this;
    }

    public C0482a m2367e(float f, float f2) {
        this.f1218i[0] = f;
        this.f1218i[1] = f2;
        return this;
    }

    public abstract boolean mo382e(int i);

    public abstract boolean mo383f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1225p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1213d = true;
                this.f1224o = false;
                break;
            case 1:
            case 3:
                m2353d();
                break;
            case 2:
                break;
        }
        this.f1210a.m2338a(m2350a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1211b.getWidth()), m2350a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1211b.getHeight()));
        if (!this.f1214e && m2359a()) {
            m2352c();
        }
        if (!(this.f1226q && this.f1214e)) {
            z = false;
        }
        return z;
    }
}
