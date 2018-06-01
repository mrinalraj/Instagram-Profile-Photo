package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.p008h.C0425s;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ContentFrameLayout extends FrameLayout {
    private TypedValue f1469a;
    private TypedValue f1470b;
    private TypedValue f1471c;
    private TypedValue f1472d;
    private TypedValue f1473e;
    private TypedValue f1474f;
    private final Rect f1475g;
    private C0572a f1476h;

    public interface C0572a {
        void mo450a();

        void mo451b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1475g = new Rect();
    }

    public void m2729a(int i, int i2, int i3, int i4) {
        this.f1475g.set(i, i2, i3, i4);
        if (C0425s.m1986y(this)) {
            requestLayout();
        }
    }

    public void m2730a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1473e == null) {
            this.f1473e = new TypedValue();
        }
        return this.f1473e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1474f == null) {
            this.f1474f = new TypedValue();
        }
        return this.f1474f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1471c == null) {
            this.f1471c = new TypedValue();
        }
        return this.f1471c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1472d == null) {
            this.f1472d = new TypedValue();
        }
        return this.f1472d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1469a == null) {
            this.f1469a = new TypedValue();
        }
        return this.f1469a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1470b == null) {
            this.f1470b = new TypedValue();
        }
        return this.f1470b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1476h != null) {
            this.f1476h.mo450a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1476h != null) {
            this.f1476h.mo451b();
        }
    }

    protected void onMeasure(int i, int i2) {
        TypedValue typedValue;
        int dimension;
        Object obj;
        TypedValue typedValue2;
        int dimension2;
        Object obj2 = null;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        Object obj3 = displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            typedValue = obj3 != null ? this.f1472d : this.f1471c;
            if (!(typedValue == null || typedValue.type == 0)) {
                dimension = typedValue.type == 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type == 6 ? (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                if (dimension > 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1475g.left + this.f1475g.right), MeasureSpec.getSize(i)), 1073741824);
                    obj = 1;
                    if (mode2 == Integer.MIN_VALUE) {
                        typedValue = obj3 == null ? this.f1473e : this.f1474f;
                        if (!(typedValue == null || typedValue.type == 0)) {
                            dimension = typedValue.type != 5 ? (int) typedValue.getDimension(displayMetrics) : typedValue.type != 6 ? (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels) : 0;
                            if (dimension > 0) {
                                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1475g.top + this.f1475g.bottom), MeasureSpec.getSize(i2)), 1073741824);
                            }
                        }
                    }
                    super.onMeasure(i, i2);
                    mode2 = getMeasuredWidth();
                    dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
                    if (obj == null && mode == Integer.MIN_VALUE) {
                        typedValue2 = obj3 == null ? this.f1470b : this.f1469a;
                        if (!(typedValue2 == null || typedValue2.type == 0)) {
                            dimension2 = typedValue2.type != 5 ? (int) typedValue2.getDimension(displayMetrics) : typedValue2.type != 6 ? (int) typedValue2.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels) : 0;
                            if (dimension2 > 0) {
                                dimension2 -= this.f1475g.left + this.f1475g.right;
                            }
                            if (mode2 < dimension2) {
                                dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
                                obj2 = 1;
                                if (obj2 == null) {
                                    super.onMeasure(dimension2, i2);
                                }
                            }
                        }
                    }
                    dimension2 = dimension;
                    if (obj2 == null) {
                        super.onMeasure(dimension2, i2);
                    }
                }
            }
        }
        obj = null;
        if (mode2 == Integer.MIN_VALUE) {
            if (obj3 == null) {
            }
            if (typedValue.type != 5) {
                if (typedValue.type != 6) {
                }
            }
            if (dimension > 0) {
                i2 = MeasureSpec.makeMeasureSpec(Math.min(dimension - (this.f1475g.top + this.f1475g.bottom), MeasureSpec.getSize(i2)), 1073741824);
            }
        }
        super.onMeasure(i, i2);
        mode2 = getMeasuredWidth();
        dimension = MeasureSpec.makeMeasureSpec(mode2, 1073741824);
        if (obj3 == null) {
        }
        if (typedValue2.type != 5) {
            if (typedValue2.type != 6) {
            }
        }
        if (dimension2 > 0) {
            dimension2 -= this.f1475g.left + this.f1475g.right;
        }
        if (mode2 < dimension2) {
            dimension2 = MeasureSpec.makeMeasureSpec(dimension2, 1073741824);
            obj2 = 1;
            if (obj2 == null) {
                super.onMeasure(dimension2, i2);
            }
        }
        dimension2 = dimension;
        if (obj2 == null) {
            super.onMeasure(dimension2, i2);
        }
    }

    public void setAttachListener(C0572a c0572a) {
        this.f1476h = c0572a;
    }
}
