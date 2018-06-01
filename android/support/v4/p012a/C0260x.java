package android.support.v4.p012a;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class C0260x implements OnAttachStateChangeListener, OnPreDrawListener {
    private final View f841a;
    private ViewTreeObserver f842b;
    private final Runnable f843c;

    private C0260x(View view, Runnable runnable) {
        this.f841a = view;
        this.f842b = view.getViewTreeObserver();
        this.f843c = runnable;
    }

    public static C0260x m1332a(View view, Runnable runnable) {
        C0260x c0260x = new C0260x(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(c0260x);
        view.addOnAttachStateChangeListener(c0260x);
        return c0260x;
    }

    public void m1333a() {
        if (this.f842b.isAlive()) {
            this.f842b.removeOnPreDrawListener(this);
        } else {
            this.f841a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f841a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        m1333a();
        this.f843c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f842b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        m1333a();
    }
}
