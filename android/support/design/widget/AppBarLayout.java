package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0066a.C0057b;
import android.support.design.C0066a.C0065j;
import android.support.design.widget.C0172r.C0074c;
import android.support.design.widget.CoordinatorLayout.C0081a;
import android.support.design.widget.CoordinatorLayout.C0099b;
import android.support.design.widget.CoordinatorLayout.C0101d;
import android.support.v4.p008h.C0079a;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0435y;
import android.support.v4.p009e.C0077c;
import android.support.v4.p009e.C0309b;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.List;

@C0099b(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    private int f266a;
    private int f267b;
    private int f268c;
    private boolean f269d;
    private int f270e;
    private C0435y f271f;
    private List<C0086b> f272g;
    private boolean f273h;
    private boolean f274i;
    private final int[] f275j;

    public static class Behavior extends C0083j<AppBarLayout> {
        private int f251b;
        private boolean f252c;
        private boolean f253d;
        private C0172r f254e;
        private int f255f = -1;
        private boolean f256g;
        private float f257h;
        private WeakReference<View> f258i;
        private C0076a f259j;

        public static abstract class C0076a {
            public abstract boolean m313a(AppBarLayout appBarLayout);
        }

        protected static class C0080b extends C0079a {
            public static final Creator<C0080b> CREATOR = C0309b.m1523a(new C00781());
            int f238a;
            float f239b;
            boolean f240c;

            static class C00781 implements C0077c<C0080b> {
                C00781() {
                }

                public C0080b m316a(Parcel parcel, ClassLoader classLoader) {
                    return new C0080b(parcel, classLoader);
                }

                public C0080b[] m317a(int i) {
                    return new C0080b[i];
                }

                public /* synthetic */ Object mo35b(Parcel parcel, ClassLoader classLoader) {
                    return m316a(parcel, classLoader);
                }

                public /* synthetic */ Object[] mo36b(int i) {
                    return m317a(i);
                }
            }

            public C0080b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f238a = parcel.readInt();
                this.f239b = parcel.readFloat();
                this.f240c = parcel.readByte() != (byte) 0;
            }

            public C0080b(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f238a);
                parcel.writeFloat(this.f239b);
                parcel.writeByte((byte) (this.f240c ? 1 : 0));
            }
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int m361a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private void m362a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int abs = Math.abs(mo41a() - i);
            float abs2 = Math.abs(f);
            m363a(coordinatorLayout, appBarLayout, i, abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f));
        }

        private void m363a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            int a = mo41a();
            if (a != i) {
                if (this.f254e == null) {
                    this.f254e = C0185y.m860a();
                    this.f254e.m810a(C0118a.f404e);
                    this.f254e.m809a(new C0074c(this) {
                        final /* synthetic */ Behavior f235c;

                        public void mo34a(C0172r c0172r) {
                            this.f235c.a_(coordinatorLayout, appBarLayout, c0172r.m812c());
                        }
                    });
                } else {
                    this.f254e.m813d();
                }
                this.f254e.m807a((long) Math.min(i2, 600));
                this.f254e.m806a(a, i);
                this.f254e.m804a();
            } else if (this.f254e != null && this.f254e.m811b()) {
                this.f254e.m813d();
            }
        }

        private static boolean m364a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int m365b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0085a c0085a = (C0085a) childAt.getLayoutParams();
                Interpolator b = c0085a.m425b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0085a.m424a();
                    if ((i2 & 1) != 0) {
                        height = (c0085a.bottomMargin + (childAt.getHeight() + c0085a.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= C0425s.m1975n(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (C0425s.m1980s(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private void m366b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            boolean z = true;
            boolean z2 = false;
            View c = m367c(appBarLayout, i);
            if (c != null) {
                int a = ((C0085a) c.getLayoutParams()).m424a();
                if ((a & 1) != 0) {
                    int n = C0425s.m1975n(c);
                    if (i2 > 0 && (a & 12) != 0) {
                        z2 = (-i) >= (c.getBottom() - n) - appBarLayout.getTopInset();
                    } else if ((a & 2) != 0) {
                        if ((-i) < (c.getBottom() - n) - appBarLayout.getTopInset()) {
                            z = false;
                        }
                        z2 = z;
                    }
                }
                if (appBarLayout.m436a(z2) && VERSION.SDK_INT >= 11 && m369d(coordinatorLayout, appBarLayout)) {
                    appBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        private static View m367c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void m368c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo41a();
            int a2 = m361a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((C0085a) childAt.getLayoutParams()).m424a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (m364a(a3, 2)) {
                        i2 += C0425s.m1975n(childAt);
                        a2 = i;
                    } else if (m364a(a3, 5)) {
                        a2 = C0425s.m1975n(childAt) + i2;
                        if (a >= a2) {
                            i2 = a2;
                            a2 = i;
                        }
                    } else {
                        a2 = i;
                    }
                    if (a >= (i2 + a2) / 2) {
                        i2 = a2;
                    }
                    m362a(coordinatorLayout, appBarLayout, C0156l.m747a(i2, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private boolean m369d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List d = coordinatorLayout.m556d((View) appBarLayout);
            int size = d.size();
            int i = 0;
            while (i < size) {
                C0081a b = ((C0101d) ((View) d.get(i)).getLayoutParams()).m498b();
                if (b instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) b).m410d() != 0;
                } else {
                    i++;
                }
            }
            return false;
        }

        int mo41a() {
            return mo53b() + this.f251b;
        }

        int m371a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo41a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f251b = 0;
                return 0;
            }
            int a2 = C0156l.m747a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m437b() ? m365b(appBarLayout, a2) : a2;
            boolean a3 = mo49a(b);
            int i4 = a - a2;
            this.f251b = a2 - b;
            if (!a3 && appBarLayout.m437b()) {
                coordinatorLayout.m549b((View) appBarLayout);
            }
            appBarLayout.m434a(mo53b());
            m366b(coordinatorLayout, appBarLayout, a2, a2 < a ? -1 : 1);
            return i4;
        }

        /* synthetic */ int mo43a(View view) {
            return m399c((AppBarLayout) view);
        }

        void m374a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m368c(coordinatorLayout, appBarLayout);
        }

        public void m375a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof C0080b) {
                C0080b c0080b = (C0080b) parcelable;
                super.mo45a(coordinatorLayout, (View) appBarLayout, c0080b.m320a());
                this.f255f = c0080b.f238a;
                this.f257h = c0080b.f239b;
                this.f256g = c0080b.f240c;
                return;
            }
            super.mo45a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f255f = -1;
        }

        public void m376a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f253d) {
                m368c(coordinatorLayout, appBarLayout);
            }
            this.f252c = false;
            this.f253d = false;
            this.f258i = new WeakReference(view);
        }

        public void m377a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m356b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f252c = true;
                return;
            }
            this.f252c = false;
        }

        public void m378a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f252c) {
                int i3;
                int downNestedPreScrollRange;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                iArr[1] = m356b(coordinatorLayout, appBarLayout, i2, i3, downNestedPreScrollRange);
            }
        }

        boolean m385a(AppBarLayout appBarLayout) {
            if (this.f259j != null) {
                return this.f259j.m313a(appBarLayout);
            }
            if (this.f258i == null) {
                return true;
            }
            View view = (View) this.f258i.get();
            return (view == null || !view.isShown() || C0425s.m1957b(view, -1)) ? false : true;
        }

        public boolean m386a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.mo38a(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            if (pendingAction != 0) {
                int i2 = (pendingAction & 4) != 0 ? 1 : 0;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        m362a(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (i2 != 0) {
                        m362a(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f255f >= 0) {
                View childAt = appBarLayout.getChildAt(this.f255f);
                pendingAction = -childAt.getBottom();
                mo49a(this.f256g ? C0425s.m1975n(childAt) + pendingAction : Math.round(((float) childAt.getHeight()) * this.f257h) + pendingAction);
            }
            appBarLayout.m439d();
            this.f255f = -1;
            mo49a(C0156l.m747a(mo53b(), -appBarLayout.getTotalScrollRange(), 0));
            appBarLayout.m434a(mo53b());
            return a;
        }

        public boolean m387a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((C0101d) appBarLayout.getLayoutParams()).height != -2) {
                return super.mo50a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m543a(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean m388a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m354a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (mo41a() < r1) {
                    m362a(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (mo41a() > r1) {
                    m362a(coordinatorLayout, appBarLayout, r1, f2);
                    z2 = true;
                }
            }
            this.f253d = z2;
            return z2;
        }

        public boolean m389a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m438c() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f254e != null) {
                this.f254e.m813d();
            }
            this.f258i = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int mo53b() {
            return super.mo53b();
        }

        int m395b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable m397b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.mo55b(coordinatorLayout, appBarLayout);
            int b2 = mo53b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    C0080b c0080b = new C0080b(b);
                    c0080b.f238a = i;
                    if (bottom == C0425s.m1975n(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    c0080b.f240c = z;
                    c0080b.f239b = ((float) bottom) / ((float) childAt.getHeight());
                    return c0080b;
                }
            }
            return b;
        }

        int m399c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean mo56c(View view) {
            return m385a((AppBarLayout) view);
        }
    }

    public static class ScrollingViewBehavior extends C0084k {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.ScrollingViewBehavior_Layout);
            m407b(obtainStyledAttributes.getDimensionPixelSize(C0065j.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int m411a(AppBarLayout appBarLayout) {
            C0081a b = ((C0101d) appBarLayout.getLayoutParams()).m498b();
            return b instanceof Behavior ? ((Behavior) b).mo41a() : 0;
        }

        private void m412e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0081a b = ((C0101d) view2.getLayoutParams()).m498b();
            if (b instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                C0425s.m1965e(view, ((((Behavior) b).f251b + bottom) + m403a()) - m409c(view2));
            }
        }

        float mo58a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            int a = m411a(appBarLayout);
            if (downNestedPreScrollRange != 0 && totalScrollRange + a <= downNestedPreScrollRange) {
                return 0.0f;
            }
            totalScrollRange -= downNestedPreScrollRange;
            return totalScrollRange != 0 ? 1.0f + (((float) a) / ((float) totalScrollRange)) : 0.0f;
        }

        AppBarLayout m414a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean mo38a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo38a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean mo50a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo50a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public boolean mo59a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a = m414a(coordinatorLayout.m552c(view));
            if (a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a.m435a(false, !z);
                    return true;
                }
            }
            return false;
        }

        public /* bridge */ /* synthetic */ int mo53b() {
            return super.mo53b();
        }

        int mo60b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.mo60b(view);
        }

        /* synthetic */ View mo61b(List list) {
            return m414a(list);
        }

        public boolean mo62b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean mo63c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m412e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public static class C0085a extends LayoutParams {
        int f264a = 1;
        Interpolator f265b;

        public C0085a(int i, int i2) {
            super(i, i2);
        }

        public C0085a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0065j.AppBarLayout_Layout);
            this.f264a = obtainStyledAttributes.getInt(C0065j.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C0065j.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f265b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0065j.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C0085a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0085a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @TargetApi(19)
        public C0085a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m424a() {
            return this.f264a;
        }

        public Interpolator m425b() {
            return this.f265b;
        }

        boolean m426c() {
            return (this.f264a & 1) == 1 && (this.f264a & 10) != 0;
        }
    }

    public interface C0086b {
        void m427a(AppBarLayout appBarLayout, int i);
    }

    private boolean m428b(boolean z) {
        if (this.f273h == z) {
            return false;
        }
        this.f273h = z;
        refreshDrawableState();
        return true;
    }

    private void m429e() {
        boolean z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0085a) getChildAt(i).getLayoutParams()).m426c()) {
                z = true;
                break;
            }
        }
        z = false;
        m428b(z);
    }

    private void m430f() {
        this.f266a = -1;
        this.f267b = -1;
        this.f268c = -1;
    }

    protected C0085a m431a() {
        return new C0085a(-1, -2);
    }

    public C0085a m432a(AttributeSet attributeSet) {
        return new C0085a(getContext(), attributeSet);
    }

    protected C0085a m433a(ViewGroup.LayoutParams layoutParams) {
        return (VERSION.SDK_INT < 19 || !(layoutParams instanceof LayoutParams)) ? layoutParams instanceof MarginLayoutParams ? new C0085a((MarginLayoutParams) layoutParams) : new C0085a(layoutParams) : new C0085a((LayoutParams) layoutParams);
    }

    void m434a(int i) {
        if (this.f272g != null) {
            int size = this.f272g.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0086b c0086b = (C0086b) this.f272g.get(i2);
                if (c0086b != null) {
                    c0086b.m427a(this, i);
                }
            }
        }
    }

    public void m435a(boolean z, boolean z2) {
        this.f270e = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    boolean m436a(boolean z) {
        if (this.f274i == z) {
            return false;
        }
        this.f274i = z;
        refreshDrawableState();
        return true;
    }

    boolean m437b() {
        return this.f269d;
    }

    boolean m438c() {
        return getTotalScrollRange() != 0;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0085a;
    }

    void m439d() {
        this.f270e = 0;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m431a();
    }

    protected /* synthetic */ LayoutParams m5362generateDefaultLayoutParams() {
        return m431a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m432a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m433a(layoutParams);
    }

    public /* synthetic */ LayoutParams m5363generateLayoutParams(AttributeSet attributeSet) {
        return m432a(attributeSet);
    }

    protected /* synthetic */ LayoutParams m5364generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m433a(layoutParams);
    }

    int getDownNestedPreScrollRange() {
        if (this.f267b != -1) {
            return this.f267b;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0085a c0085a = (C0085a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0085a.f264a;
            if ((i3 & 5) == 5) {
                i = (c0085a.bottomMargin + c0085a.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + C0425s.m1975n(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - C0425s.m1975n(childAt)) : i + measuredHeight;
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        this.f267b = i;
        return i;
    }

    int getDownNestedScrollRange() {
        if (this.f268c != -1) {
            return this.f268c;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0085a c0085a = (C0085a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0085a.topMargin + c0085a.bottomMargin);
            i = c0085a.f264a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (C0425s.m1975n(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f268c = i;
        return i;
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int n = C0425s.m1975n(this);
        if (n != 0) {
            return (n * 2) + topInset;
        }
        n = getChildCount();
        n = n >= 1 ? C0425s.m1975n(getChildAt(n - 1)) : 0;
        return n != 0 ? (n * 2) + topInset : getHeight() / 3;
    }

    int getPendingAction() {
        return this.f270e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        return this.f271f != null ? this.f271f.m2030b() : 0;
    }

    public final int getTotalScrollRange() {
        if (this.f266a != -1) {
            return this.f266a;
        }
        int n;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0085a c0085a = (C0085a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0085a.f264a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0085a.bottomMargin + (measuredHeight + c0085a.topMargin);
            if ((i3 & 2) != 0) {
                n = i - C0425s.m1975n(childAt);
                break;
            }
        }
        n = i;
        n = Math.max(0, n - getTopInset());
        this.f266a = n;
        return n;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected int[] onCreateDrawableState(int i) {
        int[] iArr = this.f275j;
        int[] onCreateDrawableState = super.onCreateDrawableState(iArr.length + i);
        iArr[0] = this.f273h ? C0057b.state_collapsible : -C0057b.state_collapsible;
        int i2 = (this.f273h && this.f274i) ? C0057b.state_collapsed : -C0057b.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m430f();
        this.f269d = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0085a) getChildAt(i5).getLayoutParams()).m425b() != null) {
                this.f269d = true;
                break;
            }
        }
        m429e();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m430f();
    }

    public void setExpanded(boolean z) {
        m435a(z, C0425s.m1986y(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            C0186z.m862a(this, f);
        }
    }
}
