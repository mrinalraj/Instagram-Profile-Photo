package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0433u;
import android.support.v4.widget.C0499g;
import android.support.v7.p021a.C0529a.C0519a;
import android.view.MotionEvent;
import android.view.View;

class am extends at {
    private boolean f2440g;
    private boolean f2441h;
    private boolean f2442i;
    private C0433u f2443j;
    private C0499g f2444k;

    public am(Context context, boolean z) {
        super(context, null, C0519a.dropDownListViewStyle);
        this.f2441h = z;
        setCacheColorHint(0);
    }

    private void m4301a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void m4302a(View view, int i, float f, float f2) {
        this.f2442i = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m4295a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void m4303d() {
        this.f2442i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f2443j != null) {
            this.f2443j.m2022b();
            this.f2443j = null;
        }
    }

    protected boolean mo707a() {
        return this.f2442i || super.mo707a();
    }

    public boolean mo713a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m4302a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (actionMasked == 1) {
                    m4301a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m4303d();
        }
        if (z2) {
            if (this.f2444k == null) {
                this.f2444k = new C0499g(this);
            }
            this.f2444k.m2357a(true);
            this.f2444k.onTouch(this, motionEvent);
        } else if (this.f2444k != null) {
            this.f2444k.m2357a(false);
        }
        return z2;
    }

    public boolean hasFocus() {
        return this.f2441h || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f2441h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f2441h || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f2441h && this.f2440g) || super.isInTouchMode();
    }

    void setListSelectionHidden(boolean z) {
        this.f2440g = z;
    }
}
