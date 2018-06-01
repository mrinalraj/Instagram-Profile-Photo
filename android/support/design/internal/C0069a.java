package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0066a.C0065j;
import android.support.v7.widget.ar;
import android.util.AttributeSet;
import android.view.Gravity;

public class C0069a extends ar {
    protected boolean f163a;
    boolean f164b;
    private Drawable f165c;
    private final Rect f166d;
    private final Rect f167e;
    private int f168f;

    public C0069a(Context context) {
        this(context, null);
    }

    public C0069a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0069a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f166d = new Rect();
        this.f167e = new Rect();
        this.f168f = 119;
        this.f163a = true;
        this.f164b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.ForegroundLinearLayout, i, 0);
        this.f168f = obtainStyledAttributes.getInt(C0065j.ForegroundLinearLayout_android_foregroundGravity, this.f168f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0065j.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f163a = obtainStyledAttributes.getBoolean(C0065j.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f165c != null) {
            Drawable drawable = this.f165c;
            if (this.f164b) {
                this.f164b = false;
                Rect rect = this.f166d;
                Rect rect2 = this.f167e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f163a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f168f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f165c != null) {
            this.f165c.setHotspot(f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f165c != null && this.f165c.isStateful()) {
            this.f165c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f165c;
    }

    public int getForegroundGravity() {
        return this.f168f;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f165c != null) {
            this.f165c.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f164b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f164b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.f165c != drawable) {
            if (this.f165c != null) {
                this.f165c.setCallback(null);
                unscheduleDrawable(this.f165c);
            }
            this.f165c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f168f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f168f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f168f = i2;
            if (this.f168f == 119 && this.f165c != null) {
                this.f165c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f165c;
    }
}
