package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p008h.C0067b;
import android.support.v4.p008h.C0106l;
import android.support.v4.p008h.C0408j;
import android.support.v4.p008h.C0409k;
import android.support.v4.p008h.C0411n;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v4.p008h.p019a.C0386f;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements C0408j, C0106l {
    private static final C0476a f1169w = new C0476a();
    private static final int[] f1170x = new int[]{16843130};
    private float f1171A;
    private C0477b f1172B;
    private long f1173a;
    private final Rect f1174b;
    private OverScroller f1175c;
    private EdgeEffect f1176d;
    private EdgeEffect f1177e;
    private int f1178f;
    private boolean f1179g;
    private boolean f1180h;
    private View f1181i;
    private boolean f1182j;
    private VelocityTracker f1183k;
    private boolean f1184l;
    private boolean f1185m;
    private int f1186n;
    private int f1187o;
    private int f1188p;
    private int f1189q;
    private final int[] f1190r;
    private final int[] f1191s;
    private int f1192t;
    private int f1193u;
    private C0479c f1194v;
    private final C0411n f1195y;
    private final C0409k f1196z;

    static class C0476a extends C0067b {
        C0476a() {
        }

        public void mo25a(View view, C0369b c0369b) {
            super.mo25a(view, c0369b);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0369b.m1707a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    c0369b.m1714c(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0369b.m1705a(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        c0369b.m1705a(4096);
                    }
                }
            }
        }

        public void mo72a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo72a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0386f.m1759a(accessibilityEvent, nestedScrollView.getScrollX());
            C0386f.m1760b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        public boolean mo368a(View view, int i, Bundle bundle) {
            if (super.mo368a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2329c(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2329c(0, min);
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface C0477b {
        void mo391a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class C0479c extends BaseSavedState {
        public static final Creator<C0479c> CREATOR = new C04781();
        public int f1168a;

        static class C04781 implements Creator<C0479c> {
            C04781() {
            }

            public C0479c m2299a(Parcel parcel) {
                return new C0479c(parcel);
            }

            public C0479c[] m2300a(int i) {
                return new C0479c[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2299a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2300a(i);
            }
        }

        C0479c(Parcel parcel) {
            super(parcel);
            this.f1168a = parcel.readInt();
        }

        C0479c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1168a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1168a);
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1174b = new Rect();
        this.f1179g = true;
        this.f1180h = false;
        this.f1181i = null;
        this.f1182j = false;
        this.f1185m = true;
        this.f1189q = -1;
        this.f1190r = new int[2];
        this.f1191s = new int[2];
        m2302a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1170x, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1195y = new C0411n(this);
        this.f1196z = new C0409k(this);
        setNestedScrollingEnabled(true);
        C0425s.m1948a((View) this, f1169w);
    }

    private View m2301a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private void m2302a() {
        this.f1175c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1186n = viewConfiguration.getScaledTouchSlop();
        this.f1187o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1188p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m2303a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1189q) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.f1178f = (int) motionEvent.getY(actionIndex);
            this.f1189q = motionEvent.getPointerId(actionIndex);
            if (this.f1183k != null) {
                this.f1183k.clear();
            }
        }
    }

    private boolean m2304a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2301a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2318g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m2305a(Rect rect, boolean z) {
        int a = m2320a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2327b(0, a);
            }
        }
        return z2;
    }

    private boolean m2306a(View view) {
        return !m2307a(view, 0, getHeight());
    }

    private boolean m2307a(View view, int i, int i2) {
        view.getDrawingRect(this.f1174b);
        offsetDescendantRectToMyCoords(view, this.f1174b);
        return this.f1174b.bottom + i >= getScrollY() && this.f1174b.top - i <= getScrollY() + i2;
    }

    private static boolean m2308a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2308a((View) parent, view2);
        return z;
    }

    private static int m2309b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void m2310b(View view) {
        view.getDrawingRect(this.f1174b);
        offsetDescendantRectToMyCoords(view, this.f1174b);
        int a = m2320a(this.f1174b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2311b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    private void m2312c() {
        if (this.f1183k == null) {
            this.f1183k = VelocityTracker.obtain();
        } else {
            this.f1183k.clear();
        }
    }

    private void m2313d() {
        if (this.f1183k == null) {
            this.f1183k = VelocityTracker.obtain();
        }
    }

    private boolean m2314d(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void m2315e() {
        if (this.f1183k != null) {
            this.f1183k.recycle();
            this.f1183k = null;
        }
    }

    private void m2316f() {
        this.f1182j = false;
        m2315e();
        m2321a(0);
        if (this.f1176d != null) {
            this.f1176d.onRelease();
            this.f1177e.onRelease();
        }
    }

    private void m2317g() {
        if (getOverScrollMode() == 2) {
            this.f1176d = null;
            this.f1177e = null;
        } else if (this.f1176d == null) {
            Context context = getContext();
            this.f1176d = new EdgeEffect(context);
            this.f1177e = new EdgeEffect(context);
        }
    }

    private void m2318g(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1185m) {
            m2327b(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1171A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1171A = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1171A;
    }

    private void m2319h(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            m2333f(i);
        }
    }

    protected int m2320a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    public void m2321a(int i) {
        this.f1196z.m1835c(i);
    }

    public boolean m2322a(int i, int i2) {
        return this.f1196z.m1827a(i, i2);
    }

    boolean m2323a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (overScrollMode == 0 || (overScrollMode == 1 && obj != null)) ? 1 : null;
        obj = (overScrollMode == 0 || (overScrollMode == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        overScrollMode = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < overScrollMode) {
            z3 = true;
            i13 = overScrollMode;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3 && !m2328b(1)) {
            this.f1175c.springBack(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        return z2 || z3;
    }

    public boolean m2324a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.f1196z.m1829a(i, i2, i3, i4, iArr, i5);
    }

    public boolean m2325a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f1196z.m1831a(i, i2, iArr, iArr2, i3);
    }

    public boolean m2326a(KeyEvent keyEvent) {
        int i = 33;
        this.f1174b.setEmpty();
        if (m2311b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    return !keyEvent.isAltPressed() ? m2332e(33) : m2331d(33);
                case 20:
                    return !keyEvent.isAltPressed() ? m2332e(130) : m2331d(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2330c(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            boolean z = (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) ? false : true;
            return z;
        }
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void m2327b(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1173a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1175c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                C0425s.m1958c(this);
            } else {
                if (!this.f1175c.isFinished()) {
                    this.f1175c.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.f1173a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean m2328b(int i) {
        return this.f1196z.m1826a(i);
    }

    public final void m2329c(int i, int i2) {
        m2327b(i - getScrollX(), i2 - getScrollY());
    }

    public boolean m2330c(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1174b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1174b.top + height > childAt.getBottom()) {
                    this.f1174b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1174b.top = getScrollY() - height;
            if (this.f1174b.top < 0) {
                this.f1174b.top = 0;
            }
        }
        this.f1174b.bottom = this.f1174b.top + height;
        return m2304a(i, this.f1174b.top, this.f1174b.bottom);
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f1175c.computeScrollOffset()) {
            this.f1175c.getCurrX();
            int currY = this.f1175c.getCurrY();
            int i = currY - this.f1193u;
            if (m2325a(0, i, this.f1191s, null, 1)) {
                i -= this.f1191s[1];
            }
            if (i != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                m2323a(0, i, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                if (!m2324a(0, scrollY2, 0, i - scrollY2, null, 1)) {
                    int overScrollMode = getOverScrollMode();
                    Object obj = (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) ? 1 : null;
                    if (obj != null) {
                        m2317g();
                        if (currY <= 0 && scrollY > 0) {
                            this.f1176d.onAbsorb((int) this.f1175c.getCurrVelocity());
                        } else if (currY >= scrollRange && scrollY < scrollRange) {
                            this.f1177e.onAbsorb((int) this.f1175c.getCurrVelocity());
                        }
                    }
                }
            }
            this.f1193u = currY;
            C0425s.m1958c(this);
            return;
        }
        if (m2328b(1)) {
            m2321a(1);
        }
        this.f1193u = 0;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public boolean m2331d(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1174b.top = 0;
        this.f1174b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1174b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1174b.top = this.f1174b.bottom - height;
            }
        }
        return m2304a(i, this.f1174b.top, this.f1174b.bottom);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2326a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1196z.m1825a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1196z.m1824a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1196z.m1830a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1196z.m1828a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1176d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1176d.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1176d.setSize(width, getHeight());
                if (this.f1176d.draw(canvas)) {
                    C0425s.m1958c(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1177e.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f1177e.setSize(width, height);
                if (this.f1177e.draw(canvas)) {
                    C0425s.m1958c(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public boolean m2332e(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2307a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2318g(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1174b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1174b);
            m2318g(m2320a(this.f1174b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2306a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public void m2333f(int i) {
        if (getChildCount() > 0) {
            m2322a(2, 1);
            this.f1175c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.f1193u = getScrollY();
            C0425s.m1958c(this);
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.f1195y.m1841a();
    }

    int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1196z.m1832b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1196z.m1823a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1180h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1182j) {
                    return false;
                }
                float axisValue = motionEvent.getAxisValue(9);
                if (axisValue == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1182j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m2314d((int) motionEvent.getX(), action)) {
                    this.f1182j = false;
                    m2315e();
                    break;
                }
                this.f1178f = action;
                this.f1189q = motionEvent.getPointerId(0);
                m2312c();
                this.f1183k.addMovement(motionEvent);
                this.f1175c.computeScrollOffset();
                if (this.f1175c.isFinished()) {
                    z = false;
                }
                this.f1182j = z;
                m2322a(2, 0);
                break;
            case 1:
            case 3:
                this.f1182j = false;
                this.f1189q = -1;
                m2315e();
                if (this.f1175c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0425s.m1958c(this);
                }
                m2321a(0);
                break;
            case 2:
                action = this.f1189q;
                if (action != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(action);
                    if (findPointerIndex != -1) {
                        action = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(action - this.f1178f) > this.f1186n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1182j = true;
                            this.f1178f = action;
                            m2313d();
                            this.f1183k.addMovement(motionEvent);
                            this.f1192t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m2303a(motionEvent);
                break;
        }
        return this.f1182j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1179g = false;
        if (this.f1181i != null && m2308a(this.f1181i, (View) this)) {
            m2310b(this.f1181i);
        }
        this.f1181i = null;
        if (!this.f1180h) {
            if (this.f1194v != null) {
                scrollTo(getScrollX(), this.f1194v.f1168a);
                this.f1194v = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1180h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1184l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2319h((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1195y.m1844a(view, view2, i);
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || m2306a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0479c) {
            C0479c c0479c = (C0479c) parcelable;
            super.onRestoreInstanceState(c0479c.getSuperState());
            this.f1194v = c0479c;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0479c = new C0479c(super.onSaveInstanceState());
        c0479c.f1168a = getScrollY();
        return c0479c;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1172B != null) {
            this.f1172B.mo391a(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2307a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1174b);
            offsetDescendantRectToMyCoords(findFocus, this.f1174b);
            m2318g(m2320a(this.f1174b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f1195y.m1842a(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2313d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1192t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1192t);
        ViewParent parent;
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f1175c.isFinished();
                    this.f1182j = z;
                    if (z) {
                        parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1175c.isFinished()) {
                        this.f1175c.abortAnimation();
                    }
                    this.f1178f = (int) motionEvent.getY();
                    this.f1189q = motionEvent.getPointerId(0);
                    m2322a(2, 0);
                    break;
                }
                return false;
            case 1:
                VelocityTracker velocityTracker = this.f1183k;
                velocityTracker.computeCurrentVelocity(1000, (float) this.f1188p);
                actionMasked = (int) velocityTracker.getYVelocity(this.f1189q);
                if (Math.abs(actionMasked) > this.f1187o) {
                    m2319h(-actionMasked);
                } else if (this.f1175c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0425s.m1958c(this);
                }
                this.f1189q = -1;
                m2316f();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f1189q);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f1178f - y;
                    if (m2325a(0, i, this.f1191s, this.f1190r, 0)) {
                        i -= this.f1191s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1190r[1]);
                        this.f1192t += this.f1190r[1];
                    }
                    if (!this.f1182j && Math.abs(i) > this.f1186n) {
                        parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1182j = true;
                        i = i > 0 ? i - this.f1186n : i + this.f1186n;
                    }
                    if (this.f1182j) {
                        this.f1178f = y - this.f1190r[1];
                        int scrollY = getScrollY();
                        y = getScrollRange();
                        actionMasked = getOverScrollMode();
                        Object obj = (actionMasked == 0 || (actionMasked == 1 && y > 0)) ? 1 : null;
                        if (m2323a(0, i, 0, getScrollY(), 0, y, 0, 0, true) && !m2328b(0)) {
                            this.f1183k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!m2324a(0, scrollY2, 0, i - scrollY2, this.f1190r, 0)) {
                            if (obj != null) {
                                m2317g();
                                actionMasked = scrollY + i;
                                if (actionMasked < 0) {
                                    C0494e.m2395a(this.f1176d, ((float) i) / ((float) getHeight()), motionEvent.getX(findPointerIndex) / ((float) getWidth()));
                                    if (!this.f1177e.isFinished()) {
                                        this.f1177e.onRelease();
                                    }
                                } else if (actionMasked > y) {
                                    C0494e.m2395a(this.f1177e, ((float) i) / ((float) getHeight()), 1.0f - (motionEvent.getX(findPointerIndex) / ((float) getWidth())));
                                    if (!this.f1176d.isFinished()) {
                                        this.f1176d.onRelease();
                                    }
                                }
                                if (!(this.f1176d == null || (this.f1176d.isFinished() && this.f1177e.isFinished()))) {
                                    C0425s.m1958c(this);
                                    break;
                                }
                            }
                        }
                        this.f1178f -= this.f1190r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1190r[1]);
                        this.f1192t += this.f1190r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1189q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f1182j && getChildCount() > 0 && this.f1175c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0425s.m1958c(this);
                }
                this.f1189q = -1;
                m2316f();
                break;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                this.f1178f = (int) motionEvent.getY(actionMasked);
                this.f1189q = motionEvent.getPointerId(actionMasked);
                break;
            case 6:
                m2303a(motionEvent);
                this.f1178f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1189q));
                break;
        }
        if (this.f1183k != null) {
            this.f1183k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1179g) {
            this.f1181i = view2;
        } else {
            m2310b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2305a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2315e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f1179g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2309b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2309b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1184l) {
            this.f1184l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1196z.m1822a(z);
    }

    public void setOnScrollChangeListener(C0477b c0477b) {
        this.f1172B = c0477b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1185m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f1196z.m1833b(i);
    }

    public void stopNestedScroll() {
        this.f1196z.m1834c();
    }
}
