package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class C0507k {
    OverScroller f1253a;

    C0507k(Context context, Interpolator interpolator) {
        this.f1253a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static C0507k m2434a(Context context) {
        return C0507k.m2435a(context, null);
    }

    @Deprecated
    public static C0507k m2435a(Context context, Interpolator interpolator) {
        return new C0507k(context, interpolator);
    }

    @Deprecated
    public void m2436a(int i, int i2, int i3, int i4, int i5) {
        this.f1253a.startScroll(i, i2, i3, i4, i5);
    }

    @Deprecated
    public void m2437a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1253a.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Deprecated
    public boolean m2438a() {
        return this.f1253a.isFinished();
    }

    @Deprecated
    public int m2439b() {
        return this.f1253a.getCurrX();
    }

    @Deprecated
    public int m2440c() {
        return this.f1253a.getCurrY();
    }

    @Deprecated
    public int m2441d() {
        return this.f1253a.getFinalX();
    }

    @Deprecated
    public int m2442e() {
        return this.f1253a.getFinalY();
    }

    @Deprecated
    public float m2443f() {
        return this.f1253a.getCurrVelocity();
    }

    @Deprecated
    public boolean m2444g() {
        return this.f1253a.computeScrollOffset();
    }

    @Deprecated
    public void m2445h() {
        this.f1253a.abortAnimation();
    }
}
