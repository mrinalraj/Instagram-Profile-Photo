package android.support.v7.widget;

import android.content.Context;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0433u;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.p021a.C0529a.C0525g;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.view.C0597b;
import android.support.v7.view.menu.C0643h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0664a {
    private CharSequence f1919g;
    private CharSequence f1920h;
    private View f1921i;
    private View f1922j;
    private LinearLayout f1923k;
    private TextView f1924l;
    private TextView f1925m;
    private int f1926n;
    private int f1927o;
    private boolean f1928p;
    private int f1929q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0519a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bm a = bm.m4513a(context, attributeSet, C0528j.ActionMode, i, 0);
        C0425s.m1947a((View) this, a.m4517a(C0528j.ActionMode_background));
        this.f1926n = a.m4530g(C0528j.ActionMode_titleTextStyle, 0);
        this.f1927o = a.m4530g(C0528j.ActionMode_subtitleTextStyle, 0);
        this.e = a.m4528f(C0528j.ActionMode_height, 0);
        this.f1929q = a.m4530g(C0528j.ActionMode_closeItemLayout, C0525g.abc_action_mode_close_item_material);
        a.m4518a();
    }

    private void m3228e() {
        int i = 8;
        Object obj = 1;
        if (this.f1923k == null) {
            LayoutInflater.from(getContext()).inflate(C0525g.abc_action_bar_title_item, this);
            this.f1923k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1924l = (TextView) this.f1923k.findViewById(C0524f.action_bar_title);
            this.f1925m = (TextView) this.f1923k.findViewById(C0524f.action_bar_subtitle);
            if (this.f1926n != 0) {
                this.f1924l.setTextAppearance(getContext(), this.f1926n);
            }
            if (this.f1927o != 0) {
                this.f1925m.setTextAppearance(getContext(), this.f1927o);
            }
        }
        this.f1924l.setText(this.f1919g);
        this.f1925m.setText(this.f1920h);
        Object obj2 = !TextUtils.isEmpty(this.f1919g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1920h)) {
            obj = null;
        }
        this.f1925m.setVisibility(obj != null ? 0 : 8);
        LinearLayout linearLayout = this.f1923k;
        if (!(obj2 == null && obj == null)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1923k.getParent() == null) {
            addView(this.f1923k);
        }
    }

    public /* bridge */ /* synthetic */ C0433u mo569a(int i, long j) {
        return super.mo569a(i, j);
    }

    public void m3230a(final C0597b c0597b) {
        if (this.f1921i == null) {
            this.f1921i = LayoutInflater.from(getContext()).inflate(this.f1929q, this, false);
            addView(this.f1921i);
        } else if (this.f1921i.getParent() == null) {
            addView(this.f1921i);
        }
        this.f1921i.findViewById(C0524f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView f1910b;

            public void onClick(View view) {
                c0597b.mo483c();
            }
        });
        C0643h c0643h = (C0643h) c0597b.mo480b();
        if (this.d != null) {
            this.d.m4653f();
        }
        this.d = new C0809d(getContext());
        this.d.m4649c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0643h.m3088a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo775a((ViewGroup) this);
        C0425s.m1947a(this.c, null);
        addView(this.c, layoutParams);
    }

    public boolean mo570a() {
        return this.d != null ? this.d.m4651d() : false;
    }

    public void m3232b() {
        if (this.f1921i == null) {
            m3233c();
        }
    }

    public void m3233c() {
        removeAllViews();
        this.f1922j = null;
        this.c = null;
    }

    public boolean m3234d() {
        return this.f1928p;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1920h;
    }

    public CharSequence getTitle() {
        return this.f1919g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m4652e();
            this.d.m4654g();
        }
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1919g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bt.m4615a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1921i == null || this.f1921i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1921i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0664a.m3221a(paddingRight, i5, a);
            i5 = C0664a.m3221a(m3225a(this.f1921i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1923k == null || this.f1922j != null || this.f1923k.getVisibility() == 8)) {
            i5 += m3225a(this.f1923k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1922j != null) {
            int a2 = m3225a(this.f1922j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m3225a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1921i != null) {
                a = m3224a(this.f1921i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1921i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m3224a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1923k != null && this.f1922j == null) {
                if (this.f1928p) {
                    this.f1923k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1923k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1923k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m3224a(this.f1923k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1922j != null) {
                LayoutParams layoutParams = this.f1922j.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                this.f1922j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i5) : i5, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1922j != null) {
            removeView(this.f1922j);
        }
        this.f1922j = view;
        if (!(view == null || this.f1923k == null)) {
            removeView(this.f1923k);
            this.f1923k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1920h = charSequence;
        m3228e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1919g = charSequence;
        m3228e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1928p) {
            requestLayout();
        }
        this.f1928p = z;
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
