package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f2354a;
    private int f2355b;
    private WeakReference<View> f2356c;
    private LayoutInflater f2357d;
    private C0751a f2358e;

    public interface C0751a {
        void m4088a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2354a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.ViewStubCompat, i, 0);
        this.f2355b = obtainStyledAttributes.getResourceId(C0528j.ViewStubCompat_android_inflatedId, -1);
        this.f2354a = obtainStyledAttributes.getResourceId(C0528j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0528j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View m4089a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2354a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f2357d != null ? this.f2357d : LayoutInflater.from(getContext())).inflate(this.f2354a, viewGroup, false);
            if (this.f2355b != -1) {
                inflate.setId(this.f2355b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2356c = new WeakReference(inflate);
            if (this.f2358e != null) {
                this.f2358e.m4088a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f2355b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2357d;
    }

    public int getLayoutResource() {
        return this.f2354a;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f2355b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2357d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f2354a = i;
    }

    public void setOnInflateListener(C0751a c0751a) {
        this.f2358e = c0751a;
    }

    public void setVisibility(int i) {
        if (this.f2356c != null) {
            View view = (View) this.f2356c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m4089a();
        }
    }
}
