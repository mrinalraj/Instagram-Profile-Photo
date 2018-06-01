package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0072p;
import android.support.v7.view.menu.C0628o.C0577a;
import android.support.v7.view.menu.C0643h;
import android.support.v7.view.menu.C0643h.C0560a;
import android.support.v7.view.menu.C0643h.C0626b;
import android.support.v7.view.menu.C0646j;
import android.support.v7.widget.ar.C0670a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends ar implements C0626b, C0072p {
    C0560a f1971a;
    C0673e f1972b;
    private C0643h f1973c;
    private Context f1974d;
    private int f1975e;
    private boolean f1976f;
    private C0809d f1977g;
    private C0577a f1978h;
    private boolean f1979i;
    private int f1980j;
    private int f1981k;
    private int f1982l;

    public interface C0625a {
        boolean mo499c();

        boolean mo500d();
    }

    private static class C0669b implements C0577a {
        C0669b() {
        }

        public void mo452a(C0643h c0643h, boolean z) {
        }

        public boolean mo453a(C0643h c0643h) {
            return false;
        }
    }

    public static class C0671c extends C0670a {
        @ExportedProperty
        public boolean f1964a;
        @ExportedProperty
        public int f1965b;
        @ExportedProperty
        public int f1966c;
        @ExportedProperty
        public boolean f1967d;
        @ExportedProperty
        public boolean f1968e;
        boolean f1969f;

        public C0671c(int i, int i2) {
            super(i, i2);
            this.f1964a = false;
        }

        public C0671c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0671c(C0671c c0671c) {
            super(c0671c);
            this.f1964a = c0671c.f1964a;
        }

        public C0671c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class C0672d implements C0560a {
        final /* synthetic */ ActionMenuView f1970a;

        C0672d(ActionMenuView actionMenuView) {
            this.f1970a = actionMenuView;
        }

        public void mo429a(C0643h c0643h) {
            if (this.f1970a.f1971a != null) {
                this.f1970a.f1971a.mo429a(c0643h);
            }
        }

        public boolean mo433a(C0643h c0643h, MenuItem menuItem) {
            return this.f1970a.f1972b != null && this.f1970a.f1972b.mo677a(menuItem);
        }
    }

    public interface C0673e {
        boolean mo677a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1981k = (int) (56.0f * f);
        this.f1982l = (int) (f * 4.0f);
        this.f1974d = context;
        this.f1975e = 0;
    }

    static int m3271a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0671c c0671c = (C0671c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m2948b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0671c.f1964a && z2) {
            z = true;
        }
        c0671c.f1967d = z;
        c0671c.f1965b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void m3272c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1981k;
        size = i3 % this.f1981k;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        Object obj;
        int i6 = this.f1981k + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1982l, 0, this.f1982l, 0);
                }
                C0671c c0671c = (C0671c) childAt.getLayoutParams();
                c0671c.f1969f = false;
                c0671c.f1966c = 0;
                c0671c.f1965b = 0;
                c0671c.f1967d = false;
                c0671c.leftMargin = 0;
                c0671c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m2948b();
                c0671c.f1968e = z2;
                int a = m3271a(childAt, i6, c0671c.f1964a ? 1 : i4, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                paddingLeft = c0671c.f1967d ? i9 + 1 : i9;
                obj = c0671c.f1964a ? 1 : obj2;
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj2 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0671c = (C0671c) getChildAt(i15).getLayoutParams();
                if (!c0671c.f1967d) {
                    size = i4;
                    i4 = i5;
                } else if (c0671c.f1965b < i5) {
                    i4 = c0671c.f1965b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0671c.f1965b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0671c = (C0671c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj3 != null && c0671c.f1968e && i4 == 1) {
                        childAt2.setPadding(this.f1982l + i6, 0, this.f1982l, 0);
                    }
                    c0671c.f1965b++;
                    c0671c.f1969f = true;
                    size = i4 - 1;
                } else if (c0671c.f1965b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0671c) getChildAt(0).getLayoutParams()).f1968e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0671c) getChildAt(childCount - 1).getLayoutParams()).f1968e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0671c = (C0671c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0671c.f1966c = paddingLeft;
                                c0671c.f1969f = true;
                                if (i4 == 0 && !c0671c.f1968e) {
                                    c0671c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0671c.f1964a) {
                                if (i4 != 0) {
                                    c0671c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0671c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                c0671c.f1966c = paddingLeft;
                                c0671c.f1969f = true;
                                c0671c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0671c = (C0671c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0671c.f1966c = paddingLeft;
                        c0671c.f1969f = true;
                        c0671c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0671c.f1964a) {
                        if (i4 != 0) {
                            c0671c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0671c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        c0671c.f1966c = paddingLeft;
                        c0671c.f1969f = true;
                        c0671c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0671c = (C0671c) childAt.getLayoutParams();
                if (c0671c.f1969f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0671c.f1966c + (c0671c.f1965b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    public C0671c m3273a(AttributeSet attributeSet) {
        return new C0671c(getContext(), attributeSet);
    }

    protected C0671c m3274a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m3280b();
        }
        C0671c c0671c = layoutParams instanceof C0671c ? new C0671c((C0671c) layoutParams) : new C0671c(layoutParams);
        if (c0671c.h > 0) {
            return c0671c;
        }
        c0671c.h = 16;
        return c0671c;
    }

    public void mo31a(C0643h c0643h) {
        this.f1973c = c0643h;
    }

    public void m3276a(C0577a c0577a, C0560a c0560a) {
        this.f1978h = c0577a;
        this.f1971a = c0560a;
    }

    public boolean m3277a() {
        return this.f1976f;
    }

    protected boolean m3278a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0625a)) {
            z = 0 | ((C0625a) childAt).mo500d();
        }
        return (i <= 0 || !(childAt2 instanceof C0625a)) ? z : ((C0625a) childAt2).mo499c() | z;
    }

    public boolean mo501a(C0646j c0646j) {
        return this.f1973c.m3093a((MenuItem) c0646j, 0);
    }

    protected C0671c m3280b() {
        C0671c c0671c = new C0671c(-2, -2);
        c0671c.h = 16;
        return c0671c;
    }

    public /* synthetic */ C0670a mo588b(AttributeSet attributeSet) {
        return m3273a(attributeSet);
    }

    protected /* synthetic */ C0670a mo589b(LayoutParams layoutParams) {
        return m3274a(layoutParams);
    }

    public C0671c m3283c() {
        C0671c b = m3280b();
        b.f1964a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0671c);
    }

    public C0643h m3284d() {
        return this.f1973c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m3285e() {
        return this.f1977g != null && this.f1977g.m4651d();
    }

    public boolean m3286f() {
        return this.f1977g != null && this.f1977g.m4652e();
    }

    public boolean m3287g() {
        return this.f1977g != null && this.f1977g.m4655h();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3280b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3273a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3274a(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1973c == null) {
            Context context = getContext();
            this.f1973c = new C0643h(context);
            this.f1973c.mo561a(new C0672d(this));
            this.f1977g = new C0809d(context);
            this.f1977g.m4649c(true);
            this.f1977g.mo527a(this.f1978h != null ? this.f1978h : new C0669b());
            this.f1973c.m3088a(this.f1977g, this.f1974d);
            this.f1977g.m4641a(this);
        }
        return this.f1973c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1977g.m4648c();
    }

    public int getPopupTheme() {
        return this.f1975e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean m3288h() {
        return this.f1977g != null && this.f1977g.m4656i();
    }

    public void m3289i() {
        if (this.f1977g != null) {
            this.f1977g.m4653f();
        }
    }

    protected /* synthetic */ C0670a mo594j() {
        return m3280b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1977g != null) {
            this.f1977g.mo530b(false);
            if (this.f1977g.m4655h()) {
                this.f1977g.m4652e();
                this.f1977g.m4651d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3289i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1979i) {
            int i5;
            int i6;
            C0671c c0671c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bt.m4615a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0671c = (C0671c) childAt.getLayoutParams();
                    if (c0671c.f1964a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m3278a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0671c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0671c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0671c.leftMargin) + c0671c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m3278a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0671c = (C0671c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0671c.f1964a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0671c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0671c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0671c = (C0671c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0671c.f1964a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0671c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0671c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1979i;
        this.f1979i = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1979i) {
            this.f1980j = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1979i || this.f1973c == null || size == this.f1980j)) {
            this.f1980j = size;
            this.f1973c.m3099b(true);
        }
        int childCount = getChildCount();
        if (!this.f1979i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0671c c0671c = (C0671c) getChildAt(i3).getLayoutParams();
                c0671c.rightMargin = 0;
                c0671c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m3272c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1977g.m4650d(z);
    }

    public void setOnMenuItemClickListener(C0673e c0673e) {
        this.f1972b = c0673e;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1977g.m4638a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1976f = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1975e != i) {
            this.f1975e = i;
            if (i == 0) {
                this.f1974d = getContext();
            } else {
                this.f1974d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0809d c0809d) {
        this.f1977g = c0809d;
        this.f1977g.m4641a(this);
    }
}
