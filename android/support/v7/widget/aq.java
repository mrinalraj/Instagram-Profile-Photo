package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0714o;
import android.support.v7.widget.RecyclerView.C0721t;
import android.view.View;

class aq {
    boolean f2462a = true;
    int f2463b;
    int f2464c;
    int f2465d;
    int f2466e;
    int f2467f = 0;
    int f2468g = 0;
    boolean f2469h;
    boolean f2470i;

    aq() {
    }

    View m4323a(C0714o c0714o) {
        View c = c0714o.m3750c(this.f2464c);
        this.f2464c += this.f2465d;
        return c;
    }

    boolean m4324a(C0721t c0721t) {
        return this.f2464c >= 0 && this.f2464c < c0721t.m3796e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2463b + ", mCurrentPosition=" + this.f2464c + ", mItemDirection=" + this.f2465d + ", mLayoutDirection=" + this.f2466e + ", mStartLine=" + this.f2467f + ", mEndLine=" + this.f2468g + '}';
    }
}
