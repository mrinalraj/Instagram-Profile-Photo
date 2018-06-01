package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0398d;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class ar extends ViewGroup {
    private boolean f148a;
    private int f149b;
    private int f150c;
    private int f151d;
    private int f152e;
    private int f153f;
    private float f154g;
    private boolean f155h;
    private int[] f156i;
    private int[] f157j;
    private Drawable f158k;
    private int f159l;
    private int f160m;
    private int f161n;
    private int f162o;

    public static class C0670a extends MarginLayoutParams {
        public float f1962g;
        public int f1963h;

        public C0670a(int i, int i2) {
            super(i, i2);
            this.f1963h = -1;
            this.f1962g = 0.0f;
        }

        public C0670a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1963h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0528j.LinearLayoutCompat_Layout);
            this.f1962g = obtainStyledAttributes.getFloat(C0528j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1963h = obtainStyledAttributes.getInt(C0528j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0670a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1963h = -1;
        }
    }

    public ar(Context context) {
        this(context, null);
    }

    public ar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f148a = true;
        this.f149b = -1;
        this.f150c = 0;
        this.f152e = 8388659;
        bm a = bm.m4513a(context, attributeSet, C0528j.LinearLayoutCompat, i, 0);
        int a2 = a.m4515a(C0528j.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m4515a(C0528j.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m4519a(C0528j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f154g = a.m4514a(C0528j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f149b = a.m4515a(C0528j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f155h = a.m4519a(C0528j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m4517a(C0528j.LinearLayoutCompat_divider));
        this.f161n = a.m4515a(C0528j.LinearLayoutCompat_showDividers, 0);
        this.f162o = a.m4526e(C0528j.LinearLayoutCompat_dividerPadding, 0);
        a.m4518a();
    }

    private void m166a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private void m167c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m179b(i3);
            if (b.getVisibility() != 8) {
                C0670a c0670a = (C0670a) b.getLayoutParams();
                if (c0670a.width == -1) {
                    int i4 = c0670a.height;
                    c0670a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0670a.height = i4;
                }
            }
        }
    }

    private void m168d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m179b(i3);
            if (b.getVisibility() != 8) {
                C0670a c0670a = (C0670a) b.getLayoutParams();
                if (c0670a.height == -1) {
                    int i4 = c0670a.width;
                    c0670a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0670a.width = i4;
                }
            }
        }
    }

    int m169a(View view) {
        return 0;
    }

    int m170a(View view, int i) {
        return 0;
    }

    void m171a(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        int i5;
        View b;
        this.f153f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i10 = this.f149b;
        boolean z = this.f155h;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj5;
            int i13;
            View b2 = m179b(i12);
            if (b2 == null) {
                this.f153f += m185d(i12);
                i3 = i11;
                obj5 = obj4;
                obj = obj2;
                i4 = i7;
                i13 = i6;
            } else if (b2.getVisibility() == 8) {
                i12 += m170a(b2, i12);
                i3 = i11;
                obj5 = obj4;
                obj = obj2;
                i4 = i7;
                i13 = i6;
            } else {
                if (m184c(i12)) {
                    this.f153f += this.f160m;
                }
                C0670a c0670a = (C0670a) b2.getLayoutParams();
                float f2 = f + c0670a.f1962g;
                if (mode2 == 1073741824 && c0670a.height == 0 && c0670a.f1962g > 0.0f) {
                    i3 = this.f153f;
                    this.f153f = Math.max(i3, (c0670a.topMargin + i3) + c0670a.bottomMargin);
                    obj4 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0670a.height == 0 && c0670a.f1962g > 0.0f) {
                        i3 = 0;
                        c0670a.height = -2;
                    }
                    int i14 = i3;
                    m175a(b2, i12, i, 0, i2, f2 == 0.0f ? this.f153f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0670a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f153f;
                    this.f153f = Math.max(i15, (((i15 + i3) + c0670a.topMargin) + c0670a.bottomMargin) + m176b(b2));
                    if (z) {
                        i11 = Math.max(i3, i11);
                    }
                }
                if (i10 >= 0 && i10 == i12 + 1) {
                    this.f150c = this.f153f;
                }
                if (i12 >= i10 || c0670a.f1962g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0670a.width != -1) {
                        obj6 = obj3;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i4 = c0670a.rightMargin + c0670a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i4;
                    i6 = Math.max(i6, i13);
                    int combineMeasuredStates = View.combineMeasuredStates(i7, b2.getMeasuredState());
                    obj = (obj2 == null || c0670a.width != -1) ? null : 1;
                    if (c0670a.f1962g > 0.0f) {
                        i3 = Math.max(i9, obj7 != null ? i4 : i13);
                        i4 = i8;
                    } else {
                        if (obj7 == null) {
                            i4 = i13;
                        }
                        i4 = Math.max(i8, i4);
                        i3 = i9;
                    }
                    i12 += m170a(b2, i12);
                    obj5 = obj4;
                    i9 = i3;
                    i8 = i4;
                    i13 = i6;
                    i3 = i11;
                    i4 = combineMeasuredStates;
                    obj3 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i12++;
            i11 = i3;
            obj4 = obj5;
            obj2 = obj;
            i7 = i4;
            i6 = i13;
        }
        if (this.f153f > 0 && m184c(virtualChildCount)) {
            this.f153f += this.f160m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f153f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                b = m179b(i5);
                if (b == null) {
                    this.f153f += m185d(i5);
                    i3 = i5;
                } else if (b.getVisibility() == 8) {
                    i3 = m170a(b, i5) + i5;
                } else {
                    C0670a c0670a2 = (C0670a) b.getLayoutParams();
                    int i16 = this.f153f;
                    this.f153f = Math.max(i16, (c0670a2.bottomMargin + ((i16 + i11) + c0670a2.topMargin)) + m176b(b));
                    i3 = i5;
                }
                i5 = i3 + 1;
            }
        }
        this.f153f += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f153f, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & resolveSizeAndState) - this.f153f;
        int i17;
        if (obj4 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f154g > 0.0f) {
                f = this.f154g;
            }
            this.f153f = 0;
            i11 = 0;
            float f3 = f;
            Object obj8 = obj2;
            i17 = i8;
            i16 = i7;
            i9 = i6;
            i15 = i5;
            while (i11 < virtualChildCount) {
                View b3 = m179b(i11);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i5 = i16;
                    i4 = i9;
                    obj = obj8;
                } else {
                    float f4;
                    float f5;
                    c0670a2 = (C0670a) b3.getLayoutParams();
                    float f6 = c0670a2.f1962g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i5;
                        i4 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0670a2.leftMargin) + c0670a2.rightMargin, c0670a2.width);
                        if (c0670a2.height == 0 && mode2 == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        } else {
                            i5 += b3.getMeasuredHeight();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        }
                        f4 = f3;
                        i12 = i15;
                        i15 = View.combineMeasuredStates(i16, b3.getMeasuredState() & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i12 = i15;
                        i15 = i16;
                    }
                    i16 = c0670a2.leftMargin + c0670a2.rightMargin;
                    i4 = b3.getMeasuredWidth() + i16;
                    i9 = Math.max(i9, i4);
                    Object obj9 = (mode == 1073741824 || c0670a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj = (obj8 == null || c0670a2.width != -1) ? null : 1;
                    i13 = this.f153f;
                    this.f153f = Math.max(i13, (c0670a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0670a2.topMargin)) + m176b(b3));
                    i3 = i4;
                    i4 = i9;
                    f4 = f5;
                    i5 = i15;
                    i15 = i12;
                    f3 = f4;
                }
                i11++;
                i17 = i3;
                i9 = i4;
                obj8 = obj;
                i16 = i5;
            }
            this.f153f += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i17;
            i7 = i16;
            i5 = i9;
        } else {
            i17 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    b = m179b(i5);
                    if (!(b == null || b.getVisibility() == 8 || ((C0670a) b.getLayoutParams()).f1962g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i3 = i17;
            i5 = i6;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), resolveSizeAndState);
        if (obj3 != null) {
            m167c(virtualChildCount, i2);
        }
    }

    void m172a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f152e & 8388615;
        switch (this.f152e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f153f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f153f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m179b(i7);
            if (b == null) {
                i8 += m185d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0670a c0670a = (C0670a) b.getLayoutParams();
                i5 = c0670a.f1963h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0398d.m1784a(i5, C0425s.m1966f(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0670a.leftMargin) - c0670a.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - c0670a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0670a.leftMargin;
                        break;
                }
                int i10 = (m184c(i7) ? this.f160m + i8 : i8) + c0670a.topMargin;
                m166a(b, i9, i10 + m169a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0670a.bottomMargin + measuredHeight) + m176b(b));
                i5 = m170a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m173a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m179b(i);
            if (!(b == null || b.getVisibility() == 8 || !m184c(i))) {
                m174a(canvas, (b.getTop() - ((C0670a) b.getLayoutParams()).topMargin) - this.f160m);
            }
            i++;
        }
        if (m184c(virtualChildCount)) {
            int height;
            View b2 = m179b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f160m;
            } else {
                C0670a c0670a = (C0670a) b2.getLayoutParams();
                height = c0670a.bottomMargin + b2.getBottom();
            }
            m174a(canvas, height);
        }
    }

    void m174a(Canvas canvas, int i) {
        this.f158k.setBounds(getPaddingLeft() + this.f162o, i, (getWidth() - getPaddingRight()) - this.f162o, this.f160m + i);
        this.f158k.draw(canvas);
    }

    void m175a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m176b(View view) {
        return 0;
    }

    public C0670a mo588b(AttributeSet attributeSet) {
        return new C0670a(getContext(), attributeSet);
    }

    protected C0670a mo589b(LayoutParams layoutParams) {
        return new C0670a(layoutParams);
    }

    View m179b(int i) {
        return getChildAt(i);
    }

    void m180b(int i, int i2) {
        int i3;
        Object obj;
        int i4;
        int i5;
        C0670a c0670a;
        this.f153f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.f156i == null || this.f157j == null) {
            this.f156i = new int[4];
            this.f157j = new int[4];
        }
        int[] iArr = this.f156i;
        int[] iArr2 = this.f157j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f148a;
        boolean z2 = this.f155h;
        Object obj5 = mode == 1073741824 ? 1 : null;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj6;
            int i12;
            View b = m179b(i11);
            if (b == null) {
                this.f153f += m185d(i11);
                i3 = i10;
                obj = obj4;
                obj6 = obj2;
                i4 = i7;
                i12 = i6;
            } else if (b.getVisibility() == 8) {
                i11 += m170a(b, i11);
                i3 = i10;
                obj = obj4;
                obj6 = obj2;
                i4 = i7;
                i12 = i6;
            } else {
                Object obj7;
                if (m184c(i11)) {
                    this.f153f += this.f159l;
                }
                C0670a c0670a2 = (C0670a) b.getLayoutParams();
                float f2 = f + c0670a2.f1962g;
                if (mode == 1073741824 && c0670a2.width == 0 && c0670a2.f1962g > 0.0f) {
                    if (obj5 != null) {
                        this.f153f += c0670a2.leftMargin + c0670a2.rightMargin;
                    } else {
                        i3 = this.f153f;
                        this.f153f = Math.max(i3, (c0670a2.leftMargin + i3) + c0670a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj4 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0670a2.width == 0 && c0670a2.f1962g > 0.0f) {
                        i3 = 0;
                        c0670a2.width = -2;
                    }
                    int i13 = i3;
                    m175a(b, i11, i, f2 == 0.0f ? this.f153f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0670a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj5 != null) {
                        this.f153f += ((c0670a2.leftMargin + i3) + c0670a2.rightMargin) + m176b(b);
                    } else {
                        int i14 = this.f153f;
                        this.f153f = Math.max(i14, (((i14 + i3) + c0670a2.leftMargin) + c0670a2.rightMargin) + m176b(b));
                    }
                    if (z2) {
                        i10 = Math.max(i3, i10);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0670a2.height != -1) {
                    obj7 = obj3;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i4 = c0670a2.bottomMargin + c0670a2.topMargin;
                i12 = b.getMeasuredHeight() + i4;
                int combineMeasuredStates = View.combineMeasuredStates(i7, b.getMeasuredState());
                if (z) {
                    i7 = b.getBaseline();
                    if (i7 != -1) {
                        int i15 = ((((c0670a2.f1963h < 0 ? this.f152e : c0670a2.f1963h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i7);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i7);
                    }
                }
                i7 = Math.max(i6, i12);
                obj6 = (obj2 == null || c0670a2.height != -1) ? null : 1;
                if (c0670a2.f1962g > 0.0f) {
                    i3 = Math.max(i9, obj8 != null ? i4 : i12);
                    i4 = i8;
                } else {
                    if (obj8 == null) {
                        i4 = i12;
                    }
                    i4 = Math.max(i8, i4);
                    i3 = i9;
                }
                i11 += m170a(b, i11);
                obj = obj4;
                i9 = i3;
                i8 = i4;
                i12 = i7;
                i3 = i10;
                i4 = combineMeasuredStates;
                obj3 = obj7;
                f = f2;
            }
            i11++;
            i10 = i3;
            obj4 = obj;
            obj2 = obj6;
            i7 = i4;
            i6 = i12;
        }
        if (this.f153f > 0 && m184c(virtualChildCount)) {
            this.f153f += this.f159l;
        }
        i11 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i6 : Math.max(i6, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f153f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                View b2 = m179b(i5);
                if (b2 == null) {
                    this.f153f += m185d(i5);
                    i3 = i5;
                } else if (b2.getVisibility() == 8) {
                    i3 = m170a(b2, i5) + i5;
                } else {
                    c0670a = (C0670a) b2.getLayoutParams();
                    if (obj5 != null) {
                        this.f153f = ((c0670a.rightMargin + (c0670a.leftMargin + i10)) + m176b(b2)) + this.f153f;
                        i3 = i5;
                    } else {
                        i4 = this.f153f;
                        this.f153f = Math.max(i4, (c0670a.rightMargin + ((i4 + i10) + c0670a.leftMargin)) + m176b(b2));
                        i3 = i5;
                    }
                }
                i5 = i3 + 1;
            }
        }
        this.f153f += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.f153f, getSuggestedMinimumWidth()), i, 0);
        i5 = (16777215 & resolveSizeAndState) - this.f153f;
        int i16;
        if (obj4 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f154g > 0.0f) {
                f = this.f154g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f153f = 0;
            i10 = 0;
            float f3 = f;
            Object obj9 = obj2;
            i16 = i8;
            i15 = i7;
            i14 = i5;
            i8 = -1;
            while (i10 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m179b(i10);
                if (b3 == null) {
                    f4 = f3;
                    i5 = i14;
                    i4 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i5 = i14;
                    i4 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0670a = (C0670a) b3.getLayoutParams();
                    float f6 = c0670a.f1962g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i4 = i14 - i5;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0670a.topMargin) + c0670a.bottomMargin, c0670a.height);
                        if (c0670a.width == 0 && mode == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        } else {
                            i5 += b3.getMeasuredWidth();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        }
                        i9 = View.combineMeasuredStates(i15, b3.getMeasuredState() & -16777216);
                        f5 = f3;
                    } else {
                        i4 = i14;
                        i9 = i15;
                        f5 = f3;
                    }
                    if (obj5 != null) {
                        this.f153f += ((b3.getMeasuredWidth() + c0670a.leftMargin) + c0670a.rightMargin) + m176b(b3);
                    } else {
                        i5 = this.f153f;
                        this.f153f = Math.max(i5, (((b3.getMeasuredWidth() + i5) + c0670a.leftMargin) + c0670a.rightMargin) + m176b(b3));
                    }
                    obj = (mode2 == 1073741824 || c0670a.height != -1) ? null : 1;
                    i11 = c0670a.topMargin + c0670a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i11;
                    i8 = Math.max(i8, i14);
                    i11 = Math.max(i16, obj != null ? i11 : i14);
                    obj = (obj9 == null || c0670a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0670a.f1963h < 0 ? this.f152e : c0670a.f1963h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i11;
                    obj10 = obj;
                    i15 = i9;
                    i5 = i4;
                    i4 = i8;
                }
                i10++;
                i16 = i14;
                i8 = i4;
                obj9 = obj10;
                i14 = i5;
                f3 = f4;
            }
            this.f153f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i8 = Math.max(i8, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i16;
            i7 = i15;
            i5 = i8;
        } else {
            i16 = Math.max(i8, i9);
            if (z2 && mode != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    View b4 = m179b(i5);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0670a) b4.getLayoutParams()).f1962g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i5 = i11;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension((-16777216 & i7) | resolveSizeAndState, View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i7 << 16));
        if (obj3 != null) {
            m168d(virtualChildCount, i);
        }
    }

    void m181b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bt.m4615a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f152e & 8388615;
        int i8 = this.f152e & 112;
        boolean z = this.f148a;
        int[] iArr = this.f156i;
        int[] iArr2 = this.f157j;
        switch (C0398d.m1784a(i7, C0425s.m1966f(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f153f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f153f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m179b(i10);
            if (b == null) {
                paddingLeft += m185d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0670a c0670a = (C0670a) b.getLayoutParams();
                i7 = (!z || c0670a.height == -1) ? -1 : b.getBaseline();
                int i12 = c0670a.f1963h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0670a.topMargin) - c0670a.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + c0670a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - c0670a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                paddingLeft = (m184c(i10) ? this.f159l + paddingLeft : paddingLeft) + c0670a.leftMargin;
                m166a(b, paddingLeft + m169a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0670a.rightMargin + measuredWidth) + m176b(b);
                i7 = m170a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    void m182b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bt.m4615a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = m179b(i);
            if (!(b == null || b.getVisibility() == 8 || !m184c(i))) {
                C0670a c0670a = (C0670a) b.getLayoutParams();
                m183b(canvas, a ? c0670a.rightMargin + b.getRight() : (b.getLeft() - c0670a.leftMargin) - this.f159l);
            }
            i++;
        }
        if (m184c(virtualChildCount)) {
            int paddingLeft;
            View b2 = m179b(virtualChildCount - 1);
            if (b2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f159l;
            } else {
                c0670a = (C0670a) b2.getLayoutParams();
                paddingLeft = a ? (b2.getLeft() - c0670a.leftMargin) - this.f159l : c0670a.rightMargin + b2.getRight();
            }
            m183b(canvas, paddingLeft);
        }
    }

    void m183b(Canvas canvas, int i) {
        this.f158k.setBounds(i, getPaddingTop() + this.f162o, this.f159l + i, (getHeight() - getPaddingBottom()) - this.f162o);
        this.f158k.draw(canvas);
    }

    protected boolean m184c(int i) {
        if (i == 0) {
            return (this.f161n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.f161n & 4) != 0;
            } else {
                if ((this.f161n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0670a;
    }

    int m185d(int i) {
        return 0;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo594j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo588b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo589b(layoutParams);
    }

    public int getBaseline() {
        if (this.f149b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f149b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f149b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f150c;
            if (this.f151d == 1) {
                i = this.f152e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f153f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f153f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0670a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f149b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f149b;
    }

    public Drawable getDividerDrawable() {
        return this.f158k;
    }

    public int getDividerPadding() {
        return this.f162o;
    }

    public int getDividerWidth() {
        return this.f159l;
    }

    public int getGravity() {
        return this.f152e;
    }

    public int getOrientation() {
        return this.f151d;
    }

    public int getShowDividers() {
        return this.f161n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f154g;
    }

    protected C0670a mo594j() {
        return this.f151d == 0 ? new C0670a(-2, -2) : this.f151d == 1 ? new C0670a(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f158k != null) {
            if (this.f151d == 1) {
                m173a(canvas);
            } else {
                m182b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ar.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ar.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f151d == 1) {
            m172a(i, i2, i3, i4);
        } else {
            m181b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f151d == 1) {
            m171a(i, i2);
        } else {
            m180b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f148a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f149b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f158k) {
            this.f158k = drawable;
            if (drawable != null) {
                this.f159l = drawable.getIntrinsicWidth();
                this.f160m = drawable.getIntrinsicHeight();
            } else {
                this.f159l = 0;
                this.f160m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f162o = i;
    }

    public void setGravity(int i) {
        if (this.f152e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f152e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f152e & 8388615) != i2) {
            this.f152e = i2 | (this.f152e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f155h = z;
    }

    public void setOrientation(int i) {
        if (this.f151d != i) {
            this.f151d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f161n) {
            requestLayout();
        }
        this.f161n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f152e & 112) != i2) {
            this.f152e = i2 | (this.f152e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f154g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
