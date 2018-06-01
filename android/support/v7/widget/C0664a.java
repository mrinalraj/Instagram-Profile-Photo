package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.p008h.C0119v;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0433u;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class C0664a extends ViewGroup {
    protected final C0752a f1911a;
    protected final Context f1912b;
    protected ActionMenuView f1913c;
    protected C0809d f1914d;
    protected int f1915e;
    protected C0433u f1916f;
    private boolean f1917g;
    private boolean f1918h;

    protected class C0752a implements C0119v {
        int f2359a;
        final /* synthetic */ C0664a f2360b;
        private boolean f2361c = false;

        protected C0752a(C0664a c0664a) {
            this.f2360b = c0664a;
        }

        public C0752a m4090a(C0433u c0433u, int i) {
            this.f2360b.f1916f = c0433u;
            this.f2359a = i;
            return this;
        }

        public void mo100a(View view) {
            super.setVisibility(0);
            this.f2361c = false;
        }

        public void mo101b(View view) {
            if (!this.f2361c) {
                this.f2360b.f1916f = null;
                super.setVisibility(this.f2359a);
            }
        }

        public void mo102c(View view) {
            this.f2361c = true;
        }
    }

    C0664a(Context context) {
        this(context, null);
    }

    C0664a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0664a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1911a = new C0752a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0519a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1912b = context;
        } else {
            this.f1912b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int m3221a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3224a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int m3225a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public C0433u mo569a(int i, long j) {
        if (this.f1916f != null) {
            this.f1916f.m2022b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            C0433u a = C0425s.m1976o(this).m2014a(1.0f);
            a.m2015a(j);
            a.m2016a(this.f1911a.m4090a(a, i));
            return a;
        }
        a = C0425s.m1976o(this).m2014a(0.0f);
        a.m2015a(j);
        a.m2016a(this.f1911a.m4090a(a, i));
        return a;
    }

    public boolean mo570a() {
        return this.f1914d != null ? this.f1914d.m4651d() : false;
    }

    public int getAnimatedVisibility() {
        return this.f1916f != null ? this.f1911a.f2359a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1915e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0528j.ActionBar, C0519a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0528j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1914d != null) {
            this.f1914d.m4637a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1918h = false;
        }
        if (!this.f1918h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1918h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1918h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1917g = false;
        }
        if (!this.f1917g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1917g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1917g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1915e = i;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1916f != null) {
                this.f1916f.m2022b();
            }
            super.setVisibility(i);
        }
    }
}
