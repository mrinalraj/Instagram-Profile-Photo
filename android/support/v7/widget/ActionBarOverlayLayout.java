package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0106l;
import android.support.v4.p008h.C0411n;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0519a;
import android.support.v7.p021a.C0529a.C0524f;
import android.support.v7.view.menu.C0628o.C0577a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements C0106l, ai {
    static final int[] f1933e = new int[]{C0519a.actionBarSize, 16842841};
    private final Runnable f1934A;
    private final Runnable f1935B;
    private final C0411n f1936C;
    ActionBarContainer f1937a;
    boolean f1938b;
    ViewPropertyAnimator f1939c;
    final AnimatorListenerAdapter f1940d;
    private int f1941f;
    private int f1942g;
    private ContentFrameLayout f1943h;
    private aj f1944i;
    private Drawable f1945j;
    private boolean f1946k;
    private boolean f1947l;
    private boolean f1948m;
    private boolean f1949n;
    private int f1950o;
    private int f1951p;
    private final Rect f1952q;
    private final Rect f1953r;
    private final Rect f1954s;
    private final Rect f1955t;
    private final Rect f1956u;
    private final Rect f1957v;
    private final Rect f1958w;
    private C0599a f1959x;
    private final int f1960y;
    private OverScroller f1961z;

    public interface C0599a {
        void mo490a(int i);

        void mo492g(boolean z);

        void mo493j();

        void mo494k();

        void mo495l();

        void mo496m();
    }

    class C06651 extends AnimatorListenerAdapter {
        final /* synthetic */ ActionBarOverlayLayout f1930a;

        C06651(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1930a = actionBarOverlayLayout;
        }

        public void onAnimationCancel(Animator animator) {
            this.f1930a.f1939c = null;
            this.f1930a.f1938b = false;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1930a.f1939c = null;
            this.f1930a.f1938b = false;
        }
    }

    class C06662 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1931a;

        C06662(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1931a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1931a.m3258d();
            this.f1931a.f1939c = this.f1931a.f1937a.animate().translationY(0.0f).setListener(this.f1931a.f1940d);
        }
    }

    class C06673 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1932a;

        C06673(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1932a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1932a.m3258d();
            this.f1932a.f1939c = this.f1932a.f1937a.animate().translationY((float) (-this.f1932a.f1937a.getHeight())).setListener(this.f1932a.f1940d);
        }
    }

    public static class C0668b extends MarginLayoutParams {
        public C0668b(int i, int i2) {
            super(i, i2);
        }

        public C0668b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0668b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1942g = 0;
        this.f1952q = new Rect();
        this.f1953r = new Rect();
        this.f1954s = new Rect();
        this.f1955t = new Rect();
        this.f1956u = new Rect();
        this.f1957v = new Rect();
        this.f1958w = new Rect();
        this.f1960y = 600;
        this.f1940d = new C06651(this);
        this.f1934A = new C06662(this);
        this.f1935B = new C06673(this);
        m3245a(context);
        this.f1936C = new C0411n(this);
    }

    private aj m3244a(View view) {
        if (view instanceof aj) {
            return (aj) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void m3245a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1933e);
        this.f1941f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1945j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1945j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1946k = z;
        this.f1961z = new OverScroller(context);
    }

    private boolean m3246a(float f, float f2) {
        this.f1961z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1961z.getFinalY() > this.f1937a.getHeight();
    }

    private boolean m3247a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0668b c0668b = (C0668b) view.getLayoutParams();
        if (z && c0668b.leftMargin != rect.left) {
            c0668b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0668b.topMargin != rect.top) {
            c0668b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0668b.rightMargin != rect.right) {
            c0668b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0668b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0668b.bottomMargin = rect.bottom;
        return true;
    }

    private void m3248l() {
        m3258d();
        postDelayed(this.f1934A, 600);
    }

    private void m3249m() {
        m3258d();
        postDelayed(this.f1935B, 600);
    }

    private void m3250n() {
        m3258d();
        this.f1934A.run();
    }

    private void m3251o() {
        m3258d();
        this.f1935B.run();
    }

    public C0668b m3252a(AttributeSet attributeSet) {
        return new C0668b(getContext(), attributeSet);
    }

    public void mo577a(int i) {
        m3257c();
        switch (i) {
            case 2:
                this.f1944i.mo759f();
                return;
            case 5:
                this.f1944i.mo760g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void mo578a(Menu menu, C0577a c0577a) {
        m3257c();
        this.f1944i.mo747a(menu, c0577a);
    }

    public boolean m3255a() {
        return this.f1947l;
    }

    protected C0668b m3256b() {
        return new C0668b(-1, -1);
    }

    void m3257c() {
        if (this.f1943h == null) {
            this.f1943h = (ContentFrameLayout) findViewById(C0524f.action_bar_activity_content);
            this.f1937a = (ActionBarContainer) findViewById(C0524f.action_bar_container);
            this.f1944i = m3244a(findViewById(C0524f.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0668b;
    }

    void m3258d() {
        removeCallbacks(this.f1934A);
        removeCallbacks(this.f1935B);
        if (this.f1939c != null) {
            this.f1939c.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1945j != null && !this.f1946k) {
            int bottom = this.f1937a.getVisibility() == 0 ? (int) ((((float) this.f1937a.getBottom()) + this.f1937a.getTranslationY()) + 0.5f) : 0;
            this.f1945j.setBounds(0, bottom, getWidth(), this.f1945j.getIntrinsicHeight() + bottom);
            this.f1945j.draw(canvas);
        }
    }

    public boolean mo579e() {
        m3257c();
        return this.f1944i.mo761h();
    }

    public boolean mo580f() {
        m3257c();
        return this.f1944i.mo762i();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m3257c();
        if ((C0425s.m1978q(this) & 256) != 0) {
            a = m3247a(this.f1937a, rect, true, true, false, true);
            this.f1955t.set(rect);
            bt.m4614a(this, this.f1955t, this.f1952q);
        } else {
            a = m3247a(this.f1937a, rect, true, true, false, true);
            this.f1955t.set(rect);
            bt.m4614a(this, this.f1955t, this.f1952q);
        }
        if (!this.f1956u.equals(this.f1955t)) {
            this.f1956u.set(this.f1955t);
            a = true;
        }
        if (!this.f1953r.equals(this.f1952q)) {
            this.f1953r.set(this.f1952q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean mo581g() {
        m3257c();
        return this.f1944i.mo763j();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3256b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3252a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0668b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f1937a != null ? -((int) this.f1937a.getTranslationY()) : 0;
    }

    public int getNestedScrollAxes() {
        return this.f1936C.m1841a();
    }

    public CharSequence getTitle() {
        m3257c();
        return this.f1944i.mo758e();
    }

    public boolean mo582h() {
        m3257c();
        return this.f1944i.mo764k();
    }

    public boolean mo583i() {
        m3257c();
        return this.f1944i.mo765l();
    }

    public void mo584j() {
        m3257c();
        this.f1944i.mo766m();
    }

    public void mo585k() {
        m3257c();
        this.f1944i.mo767n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3245a(getContext());
        C0425s.m1979r(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3258d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0668b c0668b = (C0668b) childAt.getLayoutParams();
                int i6 = c0668b.leftMargin + paddingLeft;
                paddingRight = c0668b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m3257c();
        measureChildWithMargins(this.f1937a, i, 0, i2, 0);
        C0668b c0668b = (C0668b) this.f1937a.getLayoutParams();
        int max = Math.max(0, (this.f1937a.getMeasuredWidth() + c0668b.leftMargin) + c0668b.rightMargin);
        int max2 = Math.max(0, c0668b.bottomMargin + (this.f1937a.getMeasuredHeight() + c0668b.topMargin));
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1937a.getMeasuredState());
        Object obj = (C0425s.m1978q(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f1941f;
            if (this.f1948m && this.f1937a.getTabContainer() != null) {
                i3 += this.f1941f;
            }
        } else {
            i3 = this.f1937a.getVisibility() != 8 ? this.f1937a.getMeasuredHeight() : 0;
        }
        this.f1954s.set(this.f1952q);
        this.f1957v.set(this.f1955t);
        Rect rect;
        Rect rect2;
        if (this.f1947l || obj != null) {
            rect = this.f1957v;
            rect.top = i3 + rect.top;
            rect2 = this.f1957v;
            rect2.bottom += 0;
        } else {
            rect = this.f1954s;
            rect.top = i3 + rect.top;
            rect2 = this.f1954s;
            rect2.bottom += 0;
        }
        m3247a(this.f1943h, this.f1954s, true, true, true, true);
        if (!this.f1958w.equals(this.f1957v)) {
            this.f1958w.set(this.f1957v);
            this.f1943h.m2730a(this.f1957v);
        }
        measureChildWithMargins(this.f1943h, i, 0, i2, 0);
        c0668b = (C0668b) this.f1943h.getLayoutParams();
        int max3 = Math.max(max, (this.f1943h.getMeasuredWidth() + c0668b.leftMargin) + c0668b.rightMargin);
        i3 = Math.max(max2, c0668b.bottomMargin + (this.f1943h.getMeasuredHeight() + c0668b.topMargin));
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1943h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1949n || !z) {
            return false;
        }
        if (m3246a(f, f2)) {
            m3251o();
        } else {
            m3250n();
        }
        this.f1938b = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1950o += i2;
        setActionBarHideOffset(this.f1950o);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1936C.m1844a(view, view2, i);
        this.f1950o = getActionBarHideOffset();
        m3258d();
        if (this.f1959x != null) {
            this.f1959x.mo495l();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f1937a.getVisibility() != 0) ? false : this.f1949n;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1949n && !this.f1938b) {
            if (this.f1950o <= this.f1937a.getHeight()) {
                m3248l();
            } else {
                m3249m();
            }
        }
        if (this.f1959x != null) {
            this.f1959x.mo496m();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3257c();
        int i2 = this.f1951p ^ i;
        this.f1951p = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.f1959x != null) {
            C0599a c0599a = this.f1959x;
            if (z3) {
                z = false;
            }
            c0599a.mo492g(z);
            if (z2 || !z3) {
                this.f1959x.mo493j();
            } else {
                this.f1959x.mo494k();
            }
        }
        if ((i2 & 256) != 0 && this.f1959x != null) {
            C0425s.m1979r(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1942g = i;
        if (this.f1959x != null) {
            this.f1959x.mo490a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m3258d();
        this.f1937a.setTranslationY((float) (-Math.max(0, Math.min(i, this.f1937a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0599a c0599a) {
        this.f1959x = c0599a;
        if (getWindowToken() != null) {
            this.f1959x.mo490a(this.f1942g);
            if (this.f1951p != 0) {
                onWindowSystemUiVisibilityChanged(this.f1951p);
                C0425s.m1979r(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1948m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1949n) {
            this.f1949n = z;
            if (!z) {
                m3258d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        m3257c();
        this.f1944i.mo743a(i);
    }

    public void setIcon(Drawable drawable) {
        m3257c();
        this.f1944i.mo744a(drawable);
    }

    public void setLogo(int i) {
        m3257c();
        this.f1944i.mo752b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1947l = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1946k = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        m3257c();
        this.f1944i.mo748a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m3257c();
        this.f1944i.mo749a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
