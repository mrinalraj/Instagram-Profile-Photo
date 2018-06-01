package android.support.design.widget;

import android.content.Context;
import android.support.v4.p008h.C0407h;
import android.support.v4.p008h.C0413r;
import android.support.v4.p008h.C0425s;
import android.support.v4.widget.C0507k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class C0083j<V extends View> extends C0082w<V> {
    C0507k f244a;
    private Runnable f245b;
    private boolean f246c;
    private int f247d = -1;
    private int f248e;
    private int f249f = -1;
    private VelocityTracker f250g;

    private class C0155a implements Runnable {
        final /* synthetic */ C0083j f475a;
        private final CoordinatorLayout f476b;
        private final V f477c;

        C0155a(C0083j c0083j, CoordinatorLayout coordinatorLayout, V v) {
            this.f475a = c0083j;
            this.f476b = coordinatorLayout;
            this.f477c = v;
        }

        public void run() {
            if (this.f477c != null && this.f475a.f244a != null) {
                if (this.f475a.f244a.m2444g()) {
                    this.f475a.a_(this.f476b, this.f477c, this.f475a.f244a.m2440c());
                    C0425s.m1950a(this.f477c, (Runnable) this);
                    return;
                }
                this.f475a.mo44a(this.f476b, this.f477c);
            }
        }
    }

    public C0083j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m349d() {
        if (this.f250g == null) {
            this.f250g = VelocityTracker.obtain();
        }
    }

    int mo41a() {
        return mo53b();
    }

    int mo42a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b = mo53b();
        if (i2 == 0 || b < i2 || b > i3) {
            return 0;
        }
        int a = C0156l.m747a(i, i2, i3);
        if (b == a) {
            return 0;
        }
        mo49a(a);
        return b - a;
    }

    int mo43a(V v) {
        return v.getHeight();
    }

    void mo44a(CoordinatorLayout coordinatorLayout, V v) {
    }

    final boolean m354a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f245b != null) {
            v.removeCallbacks(this.f245b);
            this.f245b = null;
        }
        if (this.f244a == null) {
            this.f244a = C0507k.m2434a(v.getContext());
        }
        this.f244a.m2437a(0, mo53b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f244a.m2444g()) {
            this.f245b = new C0155a(this, coordinatorLayout, v);
            C0425s.m1950a((View) v, this.f245b);
            return true;
        }
        mo44a(coordinatorLayout, v);
        return false;
    }

    public boolean mo39a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f249f < 0) {
            this.f249f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f246c) {
            return true;
        }
        int y;
        switch (C0407h.m1818a(motionEvent)) {
            case 0:
                this.f246c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (mo56c(v) && coordinatorLayout.m547a((View) v, x, y)) {
                    this.f248e = y;
                    this.f247d = motionEvent.getPointerId(0);
                    m349d();
                    break;
                }
            case 1:
            case 3:
                this.f246c = false;
                this.f247d = -1;
                if (this.f250g != null) {
                    this.f250g.recycle();
                    this.f250g = null;
                    break;
                }
                break;
            case 2:
                y = this.f247d;
                if (y != -1) {
                    y = motionEvent.findPointerIndex(y);
                    if (y != -1) {
                        y = (int) motionEvent.getY(y);
                        if (Math.abs(y - this.f248e) > this.f249f) {
                            this.f246c = true;
                            this.f248e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f250g != null) {
            this.f250g.addMovement(motionEvent);
        }
        return this.f246c;
    }

    int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo42a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    final int m356b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo42a(coordinatorLayout, (View) v, mo41a() - i, i2, i3);
    }

    int mo54b(V v) {
        return -v.getHeight();
    }

    public boolean mo40b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f249f < 0) {
            this.f249f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (C0407h.m1818a(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m547a((View) v, (int) motionEvent.getX(), y) && mo56c(v)) {
                    this.f248e = y;
                    this.f247d = motionEvent.getPointerId(0);
                    m349d();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.f250g != null) {
                    this.f250g.addMovement(motionEvent);
                    this.f250g.computeCurrentVelocity(1000);
                    m354a(coordinatorLayout, (View) v, -mo43a(v), 0, C0413r.m1849b(this.f250g, this.f247d));
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f247d);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f248e - findPointerIndex;
                    if (!this.f246c && Math.abs(i) > this.f249f) {
                        this.f246c = true;
                        i = i > 0 ? i - this.f249f : i + this.f249f;
                    }
                    if (this.f246c) {
                        this.f248e = findPointerIndex;
                        m356b(coordinatorLayout, v, i, mo54b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.f246c = false;
        this.f247d = -1;
        if (this.f250g != null) {
            this.f250g.recycle();
            this.f250g = null;
        }
        if (this.f250g != null) {
            this.f250g.addMovement(motionEvent);
        }
        return true;
    }

    boolean mo56c(V v) {
        return false;
    }
}
