package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarContainer extends FrameLayout {
    Drawable f1899a;
    Drawable f1900b;
    Drawable f1901c;
    boolean f1902d;
    boolean f1903e;
    private boolean f1904f;
    private View f1905g;
    private View f1906h;
    private View f1907i;
    private int f1908j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0425s.m1947a((View) this, VERSION.SDK_INT >= 21 ? new C0801c(this) : new C0786b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.ActionBar);
        this.f1899a = obtainStyledAttributes.getDrawable(C0528j.ActionBar_background);
        this.f1900b = obtainStyledAttributes.getDrawable(C0528j.ActionBar_backgroundStacked);
        this.f1908j = obtainStyledAttributes.getDimensionPixelSize(C0528j.ActionBar_height, -1);
        if (getId() == C0524f.split_action_bar) {
            this.f1902d = true;
            this.f1901c = obtainStyledAttributes.getDrawable(C0528j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1902d ? this.f1901c == null : this.f1899a == null && this.f1900b == null;
        setWillNotDraw(z);
    }

    private boolean m3219a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3220b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1899a != null && this.f1899a.isStateful()) {
            this.f1899a.setState(getDrawableState());
        }
        if (this.f1900b != null && this.f1900b.isStateful()) {
            this.f1900b.setState(getDrawableState());
        }
        if (this.f1901c != null && this.f1901c.isStateful()) {
            this.f1901c.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1905g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f1899a != null) {
            this.f1899a.jumpToCurrentState();
        }
        if (this.f1900b != null) {
            this.f1900b.jumpToCurrentState();
        }
        if (this.f1901c != null) {
            this.f1901c.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1906h = findViewById(C0524f.action_bar);
        this.f1907i = findViewById(C0524f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1904f || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1905g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1902d) {
            int i6;
            if (this.f1899a != null) {
                if (this.f1906h.getVisibility() == 0) {
                    this.f1899a.setBounds(this.f1906h.getLeft(), this.f1906h.getTop(), this.f1906h.getRight(), this.f1906h.getBottom());
                } else if (this.f1907i == null || this.f1907i.getVisibility() != 0) {
                    this.f1899a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1899a.setBounds(this.f1907i.getLeft(), this.f1907i.getTop(), this.f1907i.getRight(), this.f1907i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1903e = z2;
            if (!z2 || this.f1900b == null) {
                i5 = i6;
            } else {
                this.f1900b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1901c != null) {
            this.f1901c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }

    public void onMeasure(int i, int i2) {
        if (this.f1906h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1908j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1908j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1906h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1905g != null && this.f1905g.getVisibility() != 8 && mode != 1073741824) {
                int b = !m3219a(this.f1906h) ? m3220b(this.f1906h) : !m3219a(this.f1907i) ? m3220b(this.f1907i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3220b(this.f1905g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1899a != null) {
            this.f1899a.setCallback(null);
            unscheduleDrawable(this.f1899a);
        }
        this.f1899a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1906h != null) {
                this.f1899a.setBounds(this.f1906h.getLeft(), this.f1906h.getTop(), this.f1906h.getRight(), this.f1906h.getBottom());
            }
        }
        if (this.f1902d) {
            if (this.f1901c != null) {
                z = false;
            }
        } else if (!(this.f1899a == null && this.f1900b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1901c != null) {
            this.f1901c.setCallback(null);
            unscheduleDrawable(this.f1901c);
        }
        this.f1901c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1902d && this.f1901c != null) {
                this.f1901c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1902d) {
            if (this.f1901c != null) {
                z = false;
            }
        } else if (!(this.f1899a == null && this.f1900b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1900b != null) {
            this.f1900b.setCallback(null);
            unscheduleDrawable(this.f1900b);
        }
        this.f1900b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1903e && this.f1900b != null) {
                this.f1900b.setBounds(this.f1905g.getLeft(), this.f1905g.getTop(), this.f1905g.getRight(), this.f1905g.getBottom());
            }
        }
        if (this.f1902d) {
            if (this.f1901c != null) {
                z = false;
            }
        } else if (!(this.f1899a == null && this.f1900b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(be beVar) {
        if (this.f1905g != null) {
            removeView(this.f1905g);
        }
        this.f1905g = beVar;
        if (beVar != null) {
            addView(beVar);
            ViewGroup.LayoutParams layoutParams = beVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            beVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1904f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1899a != null) {
            this.f1899a.setVisible(z, false);
        }
        if (this.f1900b != null) {
            this.f1900b.setVisible(z, false);
        }
        if (this.f1901c != null) {
            this.f1901c.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        return i != 0 ? super.startActionModeForChild(view, callback, i) : null;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1899a && !this.f1902d) || ((drawable == this.f1900b && this.f1903e) || ((drawable == this.f1901c && this.f1902d) || super.verifyDrawable(drawable)));
    }
}
