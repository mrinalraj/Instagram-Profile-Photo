package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p008h.C0071i;
import android.support.v4.p008h.C0079a;
import android.support.v4.p008h.C0407h;
import android.support.v4.p008h.C0409k;
import android.support.v4.p008h.C0413r;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.p019a.C0357a;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v4.p008h.p019a.C0369b.C0367j;
import android.support.v4.p008h.p019a.C0369b.C0368k;
import android.support.v4.p008h.p019a.C0386f;
import android.support.v4.p009e.C0077c;
import android.support.v4.p009e.C0309b;
import android.support.v4.p009e.C0314e;
import android.support.v4.widget.C0494e;
import android.support.v4.widget.C0507k;
import android.support.v7.p025e.C0611a.C0610a;
import android.support.v7.widget.C0817f.C0694a;
import android.support.v7.widget.C0817f.C0816b;
import android.support.v7.widget.ah.C0692b;
import android.support.v7.widget.ap.C0771a;
import android.support.v7.widget.bs.C0690b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements C0071i {
    static final Interpolator f180G = new C06893();
    private static final int[] f181H = new int[]{16843830};
    private static final int[] f182I = new int[]{16842987};
    private static final boolean f183J = (VERSION.SDK_INT >= 21);
    private static final boolean f184K = (VERSION.SDK_INT <= 15);
    private static final Class<?>[] f185L = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final boolean f186a;
    static final boolean f187b = (VERSION.SDK_INT >= 23);
    static final boolean f188c = (VERSION.SDK_INT >= 16);
    final C0721t f189A;
    boolean f190B;
    boolean f191C;
    boolean f192D;
    ay f193E;
    final List<C0724w> f194F;
    private final C0716q f195M;
    private C0718r f196N;
    private final Rect f197O;
    private final ArrayList<C0710l> f198P;
    private C0710l f199Q;
    private int f200R;
    private boolean f201S;
    private int f202T;
    private final AccessibilityManager f203U;
    private List<C0708j> f204V;
    private int f205W;
    private final int[] aA;
    private Runnable aB;
    private final C0690b aC;
    private int aa;
    private C0494e ab;
    private C0494e ac;
    private C0494e ad;
    private C0494e ae;
    private int af;
    private int ag;
    private VelocityTracker ah;
    private int ai;
    private int aj;
    private int ak;
    private int al;
    private int am;
    private C0709k an;
    private final int ao;
    private final int ap;
    private float aq;
    private boolean ar;
    private C0711m as;
    private List<C0711m> at;
    private C0701b au;
    private C0699d av;
    private final int[] aw;
    private C0409k ax;
    private final int[] ay;
    private final int[] az;
    final C0714o f206d;
    C0817f f207e;
    ah f208f;
    final bs f209g;
    boolean f210h;
    final Runnable f211i;
    final Rect f212j;
    final RectF f213k;
    C0696a f214l;
    C0681h f215m;
    C0715p f216n;
    final ArrayList<C0705g> f217o;
    boolean f218p;
    boolean f219q;
    boolean f220r;
    boolean f221s;
    boolean f222t;
    boolean f223u;
    boolean f224v;
    C0703e f225w;
    final C0723v f226x;
    ap f227y;
    C0771a f228z;

    public static class C0679i extends MarginLayoutParams {
        C0724w f2027c;
        final Rect f2028d = new Rect();
        boolean f2029e = true;
        boolean f2030f = false;

        public C0679i(int i, int i2) {
            super(i, i2);
        }

        public C0679i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0679i(C0679i c0679i) {
            super(c0679i);
        }

        public C0679i(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0679i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean m3337c() {
            return this.f2027c.m3844n();
        }

        public boolean m3338d() {
            return this.f2027c.m3847q();
        }

        public boolean m3339e() {
            return this.f2027c.m3854x();
        }

        public int m3340f() {
            return this.f2027c.m3834d();
        }
    }

    public static abstract class C0681h {
        private boolean f2033a = true;
        private boolean f2034b = true;
        private int f2035c;
        private int f2036d;
        private int f2037e;
        private int f2038f;
        ah f2039p;
        RecyclerView f2040q;
        C0720s f2041r;
        boolean f2042s = false;
        boolean f2043t = false;
        boolean f2044u = false;
        int f2045v;
        boolean f2046w;

        public interface C0706a {
            void mo708b(int i, int i2);
        }

        public static class C0707b {
            public int f2112a;
            public int f2113b;
            public boolean f2114c;
            public boolean f2115d;
        }

        public static int m3343a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public static int m3344a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static C0707b m3345a(Context context, AttributeSet attributeSet, int i, int i2) {
            C0707b c0707b = new C0707b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0610a.RecyclerView, i, i2);
            c0707b.f2112a = obtainStyledAttributes.getInt(C0610a.RecyclerView_android_orientation, 1);
            c0707b.f2113b = obtainStyledAttributes.getInt(C0610a.RecyclerView_spanCount, 1);
            c0707b.f2114c = obtainStyledAttributes.getBoolean(C0610a.RecyclerView_reverseLayout, false);
            c0707b.f2115d = obtainStyledAttributes.getBoolean(C0610a.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return c0707b;
        }

        private void m3346a(int i, View view) {
            this.f2039p.m4197e(i);
        }

        private void m3348a(C0714o c0714o, int i, View view) {
            C0724w e = RecyclerView.m227e(view);
            if (!e.m3833c()) {
                if (!e.m3844n() || e.m3847q() || this.f2040q.f214l.m3665b()) {
                    m3450g(i);
                    c0714o.m3754c(view);
                    this.f2040q.f209g.m4613h(e);
                    return;
                }
                m3446f(i);
                c0714o.m3748b(e);
            }
        }

        private void m3349a(C0720s c0720s) {
            if (this.f2041r == c0720s) {
                this.f2041r = null;
            }
        }

        private void m3350a(View view, int i, boolean z) {
            C0724w e = RecyclerView.m227e(view);
            if (z || e.m3847q()) {
                this.f2040q.f209g.m4610e(e);
            } else {
                this.f2040q.f209g.m4611f(e);
            }
            C0679i c0679i = (C0679i) view.getLayoutParams();
            if (e.m3841k() || e.m3839i()) {
                if (e.m3839i()) {
                    e.m3840j();
                } else {
                    e.m3842l();
                }
                this.f2039p.m4186a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f2040q) {
                int b = this.f2039p.m4190b(view);
                if (i == -1) {
                    i = this.f2039p.m4189b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2040q.indexOfChild(view));
                } else if (b != i) {
                    this.f2040q.f215m.m3435d(b, i);
                }
            } else {
                this.f2039p.m4187a(view, i, false);
                c0679i.f2029e = true;
                if (this.f2041r != null && this.f2041r.m3786c()) {
                    this.f2041r.m3784b(view);
                }
            }
            if (c0679i.f2030f) {
                e.f2170a.invalidate();
                c0679i.f2030f = false;
            }
        }

        private static boolean m3351b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }

        public int m3352A() {
            return this.f2040q != null ? this.f2040q.getPaddingTop() : 0;
        }

        public int m3353B() {
            return this.f2040q != null ? this.f2040q.getPaddingRight() : 0;
        }

        public int m3354C() {
            return this.f2040q != null ? this.f2040q.getPaddingBottom() : 0;
        }

        public View m3355D() {
            if (this.f2040q == null) {
                return null;
            }
            View focusedChild = this.f2040q.getFocusedChild();
            return (focusedChild == null || this.f2039p.m4194c(focusedChild)) ? null : focusedChild;
        }

        public int m3356E() {
            return C0425s.m1974m(this.f2040q);
        }

        public int m3357F() {
            return C0425s.m1975n(this.f2040q);
        }

        void m3358G() {
            if (this.f2041r != null) {
                this.f2041r.m3780a();
            }
        }

        public void m3359H() {
            this.f2042s = true;
        }

        boolean m3360I() {
            int u = m3472u();
            for (int i = 0; i < u; i++) {
                LayoutParams layoutParams = m3453h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int mo606a(int i, C0714o c0714o, C0721t c0721t) {
            return 0;
        }

        public int mo632a(C0714o c0714o, C0721t c0721t) {
            return (this.f2040q == null || this.f2040q.f214l == null || !mo626e()) ? 1 : this.f2040q.f214l.mo839a();
        }

        public abstract C0679i mo607a();

        public C0679i mo633a(Context context, AttributeSet attributeSet) {
            return new C0679i(context, attributeSet);
        }

        public C0679i mo634a(LayoutParams layoutParams) {
            return layoutParams instanceof C0679i ? new C0679i((C0679i) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0679i((MarginLayoutParams) layoutParams) : new C0679i(layoutParams);
        }

        public View mo608a(View view, int i, C0714o c0714o, C0721t c0721t) {
            return null;
        }

        public void mo609a(int i, int i2, C0721t c0721t, C0706a c0706a) {
        }

        public void mo610a(int i, C0706a c0706a) {
        }

        public void m3369a(int i, C0714o c0714o) {
            View h = m3453h(i);
            m3446f(i);
            c0714o.m3742a(h);
        }

        public void mo636a(Rect rect, int i, int i2) {
            m3440e(C0681h.m3343a(i, (rect.width() + m3477z()) + m3353B(), m3356E()), C0681h.m3343a(i2, (rect.height() + m3352A()) + m3354C(), m3357F()));
        }

        public void mo611a(Parcelable parcelable) {
        }

        void m3372a(C0369b c0369b) {
            m3376a(this.f2040q.f206d, this.f2040q.f189A, c0369b);
        }

        public void m3373a(C0696a c0696a, C0696a c0696a2) {
        }

        public void m3374a(C0714o c0714o) {
            for (int u = m3472u() - 1; u >= 0; u--) {
                m3348a(c0714o, u, m3453h(u));
            }
        }

        public void m3375a(C0714o c0714o, C0721t c0721t, int i, int i2) {
            this.f2040q.m270e(i, i2);
        }

        public void m3376a(C0714o c0714o, C0721t c0721t, C0369b c0369b) {
            if (C0425s.m1957b(this.f2040q, -1) || C0425s.m1954a(this.f2040q, -1)) {
                c0369b.m1705a(8192);
                c0369b.m1714c(true);
            }
            if (C0425s.m1957b(this.f2040q, 1) || C0425s.m1954a(this.f2040q, 1)) {
                c0369b.m1705a(4096);
                c0369b.m1714c(true);
            }
            c0369b.m1708a(C0367j.m1700a(mo632a(c0714o, c0721t), mo647b(c0714o, c0721t), m3443e(c0714o, c0721t), m3430d(c0714o, c0721t)));
        }

        public void mo639a(C0714o c0714o, C0721t c0721t, View view, C0369b c0369b) {
            c0369b.m1712b(C0368k.m1701a(mo626e() ? m3432d(view) : 0, 1, mo624d() ? m3432d(view) : 0, 1, false, false));
        }

        public void m3378a(C0714o c0714o, C0721t c0721t, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            C0386f a = C0357a.m1685a(accessibilityEvent);
            if (this.f2040q != null && a != null) {
                if (!(C0425s.m1957b(this.f2040q, 1) || C0425s.m1957b(this.f2040q, -1) || C0425s.m1954a(this.f2040q, -1) || C0425s.m1954a(this.f2040q, 1))) {
                    z = false;
                }
                a.m1762a(z);
                if (this.f2040q.f214l != null) {
                    a.m1761a(this.f2040q.f214l.mo839a());
                }
            }
        }

        public void mo612a(C0721t c0721t) {
        }

        public void mo641a(RecyclerView recyclerView) {
        }

        public void mo642a(RecyclerView recyclerView, int i, int i2) {
        }

        public void mo643a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void mo644a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m3426c(recyclerView, i, i2);
        }

        public void mo613a(RecyclerView recyclerView, C0714o c0714o) {
            m3441e(recyclerView);
        }

        public void m3385a(View view) {
            m3386a(view, -1);
        }

        public void m3386a(View view, int i) {
            m3350a(view, i, true);
        }

        public void m3387a(View view, int i, int i2) {
            C0679i c0679i = (C0679i) view.getLayoutParams();
            Rect k = this.f2040q.m286k(view);
            int i3 = (k.left + k.right) + i;
            int i4 = (k.bottom + k.top) + i2;
            i3 = C0681h.m3344a(m3475x(), m3473v(), i3 + (((m3477z() + m3353B()) + c0679i.leftMargin) + c0679i.rightMargin), c0679i.width, mo624d());
            i4 = C0681h.m3344a(m3476y(), m3474w(), i4 + (((m3352A() + m3354C()) + c0679i.topMargin) + c0679i.bottomMargin), c0679i.height, mo626e());
            if (m3418b(view, i3, i4, c0679i)) {
                view.measure(i3, i4);
            }
        }

        public void m3388a(View view, int i, int i2, int i3, int i4) {
            C0679i c0679i = (C0679i) view.getLayoutParams();
            Rect rect = c0679i.f2028d;
            view.layout((rect.left + i) + c0679i.leftMargin, (rect.top + i2) + c0679i.topMargin, (i3 - rect.right) - c0679i.rightMargin, (i4 - rect.bottom) - c0679i.bottomMargin);
        }

        public void m3389a(View view, int i, C0679i c0679i) {
            C0724w e = RecyclerView.m227e(view);
            if (e.m3847q()) {
                this.f2040q.f209g.m4610e(e);
            } else {
                this.f2040q.f209g.m4611f(e);
            }
            this.f2039p.m4186a(view, i, c0679i, e.m3847q());
        }

        public void m3390a(View view, Rect rect) {
            RecyclerView.m218a(view, rect);
        }

        void m3391a(View view, C0369b c0369b) {
            C0724w e = RecyclerView.m227e(view);
            if (e != null && !e.m3847q() && !this.f2039p.m4194c(e.f2170a)) {
                mo639a(this.f2040q.f206d, this.f2040q.f189A, view, c0369b);
            }
        }

        public void m3392a(View view, C0714o c0714o) {
            m3427c(view);
            c0714o.m3742a(view);
        }

        public void m3393a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((C0679i) view.getLayoutParams()).f2028d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f2040q != null) {
                Matrix l = C0425s.m1973l(view);
                if (!(l == null || l.isIdentity())) {
                    RectF rectF = this.f2040q.f213k;
                    rectF.set(rect);
                    l.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void mo614a(AccessibilityEvent accessibilityEvent) {
            m3378a(this.f2040q.f206d, this.f2040q.f189A, accessibilityEvent);
        }

        public void mo615a(String str) {
            if (this.f2040q != null) {
                this.f2040q.m247a(str);
            }
        }

        boolean m3396a(int i, Bundle bundle) {
            return m3398a(this.f2040q.f206d, this.f2040q.f189A, i, bundle);
        }

        public boolean mo646a(C0679i c0679i) {
            return c0679i != null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m3398a(android.support.v7.widget.RecyclerView.C0714o r7, android.support.v7.widget.RecyclerView.C0721t r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.f2040q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.f2040q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.f2040q;
            r0 = android.support.v4.p008h.C0425s.m1957b(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.m3476y();
            r3 = r6.m3352A();
            r0 = r0 - r3;
            r3 = r6.m3354C();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.f2040q;
            r3 = android.support.v4.p008h.C0425s.m1954a(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.m3475x();
            r4 = r6.m3477z();
            r3 = r3 - r4;
            r4 = r6.m3353B();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.f2040q;
            r0 = android.support.v4.p008h.C0425s.m1957b(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.m3476y();
            r3 = r6.m3352A();
            r0 = r0 - r3;
            r3 = r6.m3354C();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.f2040q;
            r3 = android.support.v4.p008h.C0425s.m1954a(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.m3475x();
            r4 = r6.m3477z();
            r3 = r3 - r4;
            r4 = r6.m3353B();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$t, int, android.os.Bundle):boolean");
        }

        public boolean m3399a(C0714o c0714o, C0721t c0721t, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean m3400a(RecyclerView recyclerView, C0721t c0721t, View view, View view2) {
            return m3402a(recyclerView, view, view2);
        }

        public boolean m3401a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int z2 = m3477z();
            int A = m3352A();
            int x = m3475x() - m3353B();
            int y = m3476y() - m3354C();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - z2);
            int min2 = Math.min(0, top - A);
            int max = Math.max(0, width - x);
            y = Math.max(0, height - y);
            if (m3470s() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - x);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - z2, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - A, y);
            if (min == 0 && max == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.m240a(min, max);
            }
            return true;
        }

        @Deprecated
        public boolean m3402a(RecyclerView recyclerView, View view, View view2) {
            return m3469r() || recyclerView.m292n();
        }

        public boolean m3403a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        boolean m3404a(View view, int i, int i2, C0679i c0679i) {
            return (this.f2033a && C0681h.m3351b(view.getMeasuredWidth(), i, c0679i.width) && C0681h.m3351b(view.getMeasuredHeight(), i2, c0679i.height)) ? false : true;
        }

        boolean m3405a(View view, int i, Bundle bundle) {
            return m3399a(this.f2040q.f206d, this.f2040q.f189A, view, i, bundle);
        }

        public boolean m3406a(Runnable runnable) {
            return this.f2040q != null ? this.f2040q.removeCallbacks(runnable) : false;
        }

        public int mo616b(int i, C0714o c0714o, C0721t c0721t) {
            return 0;
        }

        public int mo647b(C0714o c0714o, C0721t c0721t) {
            return (this.f2040q == null || this.f2040q.f214l == null || !mo624d()) ? 1 : this.f2040q.f214l.mo839a();
        }

        void m3409b(int i, int i2) {
            this.f2037e = MeasureSpec.getSize(i);
            this.f2035c = MeasureSpec.getMode(i);
            if (this.f2035c == 0 && !RecyclerView.f187b) {
                this.f2037e = 0;
            }
            this.f2038f = MeasureSpec.getSize(i2);
            this.f2036d = MeasureSpec.getMode(i2);
            if (this.f2036d == 0 && !RecyclerView.f187b) {
                this.f2038f = 0;
            }
        }

        void m3410b(C0714o c0714o) {
            int e = c0714o.m3758e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = c0714o.m3759e(i);
                C0724w e3 = RecyclerView.m227e(e2);
                if (!e3.m3833c()) {
                    e3.m3829a(false);
                    if (e3.m3848r()) {
                        this.f2040q.removeDetachedView(e2, false);
                    }
                    if (this.f2040q.f225w != null) {
                        this.f2040q.f225w.mo706d(e3);
                    }
                    e3.m3829a(true);
                    c0714o.m3749b(e2);
                }
            }
            c0714o.m3761f();
            if (e > 0) {
                this.f2040q.invalidate();
            }
        }

        void m3411b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2040q = null;
                this.f2039p = null;
                this.f2037e = 0;
                this.f2038f = 0;
            } else {
                this.f2040q = recyclerView;
                this.f2039p = recyclerView.f208f;
                this.f2037e = recyclerView.getWidth();
                this.f2038f = recyclerView.getHeight();
            }
            this.f2035c = 1073741824;
            this.f2036d = 1073741824;
        }

        public void mo648b(RecyclerView recyclerView, int i, int i2) {
        }

        void m3413b(RecyclerView recyclerView, C0714o c0714o) {
            this.f2043t = false;
            mo613a(recyclerView, c0714o);
        }

        public void m3414b(View view) {
            m3415b(view, -1);
        }

        public void m3415b(View view, int i) {
            m3350a(view, i, false);
        }

        public void m3416b(View view, Rect rect) {
            if (this.f2040q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f2040q.m286k(view));
            }
        }

        public boolean mo617b() {
            return false;
        }

        boolean m3418b(View view, int i, int i2, C0679i c0679i) {
            return (!view.isLayoutRequested() && this.f2033a && C0681h.m3351b(view.getWidth(), i, c0679i.width) && C0681h.m3351b(view.getHeight(), i2, c0679i.height)) ? false : true;
        }

        public int mo618c(C0721t c0721t) {
            return 0;
        }

        public Parcelable mo619c() {
            return null;
        }

        public View mo620c(int i) {
            int u = m3472u();
            for (int i2 = 0; i2 < u; i2++) {
                View h = m3453h(i2);
                C0724w e = RecyclerView.m227e(h);
                if (e != null && e.m3834d() == i && !e.m3833c() && (this.f2040q.f189A.m3792a() || !e.m3847q())) {
                    return h;
                }
            }
            return null;
        }

        void m3422c(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int u = m3472u();
            if (u == 0) {
                this.f2040q.m270e(i, i2);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < u; i7++) {
                View h = m3453h(i7);
                Rect rect = this.f2040q.f212j;
                m3390a(h, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i3) {
                    i3 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.f2040q.f212j.set(i6, i3, i5, i4);
            mo636a(this.f2040q.f212j, i, i2);
        }

        public void m3423c(C0714o c0714o) {
            for (int u = m3472u() - 1; u >= 0; u--) {
                if (!RecyclerView.m227e(m3453h(u)).m3833c()) {
                    m3369a(u, c0714o);
                }
            }
        }

        public void mo621c(C0714o c0714o, C0721t c0721t) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void m3425c(RecyclerView recyclerView) {
            this.f2043t = true;
            m3436d(recyclerView);
        }

        public void m3426c(RecyclerView recyclerView, int i, int i2) {
        }

        public void m3427c(View view) {
            this.f2039p.m4185a(view);
        }

        public void m3428c(View view, int i) {
            m3389a(view, i, (C0679i) view.getLayoutParams());
        }

        public void m3429c(boolean z) {
            this.f2044u = z;
        }

        public int m3430d(C0714o c0714o, C0721t c0721t) {
            return 0;
        }

        public int mo622d(C0721t c0721t) {
            return 0;
        }

        public int m3432d(View view) {
            return ((C0679i) view.getLayoutParams()).m3340f();
        }

        public View m3433d(View view, int i) {
            return null;
        }

        public void mo623d(int i) {
        }

        public void m3435d(int i, int i2) {
            View h = m3453h(i);
            if (h == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            m3450g(i);
            m3428c(h, i2);
        }

        public void m3436d(RecyclerView recyclerView) {
        }

        public boolean mo624d() {
            return false;
        }

        public int mo625e(C0721t c0721t) {
            return 0;
        }

        public View m3439e(View view) {
            if (this.f2040q == null) {
                return null;
            }
            View c = this.f2040q.m259c(view);
            return (c == null || this.f2039p.m4194c(c)) ? null : c;
        }

        public void m3440e(int i, int i2) {
            this.f2040q.setMeasuredDimension(i, i2);
        }

        @Deprecated
        public void m3441e(RecyclerView recyclerView) {
        }

        public boolean mo626e() {
            return false;
        }

        public boolean m3443e(C0714o c0714o, C0721t c0721t) {
            return false;
        }

        public int mo627f(C0721t c0721t) {
            return 0;
        }

        public int m3445f(View view) {
            Rect rect = ((C0679i) view.getLayoutParams()).f2028d;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public void m3446f(int i) {
            if (m3453h(i) != null) {
                this.f2039p.m4184a(i);
            }
        }

        void m3447f(RecyclerView recyclerView) {
            m3409b(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int mo628g(C0721t c0721t) {
            return 0;
        }

        public int m3449g(View view) {
            Rect rect = ((C0679i) view.getLayoutParams()).f2028d;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void m3450g(int i) {
            m3346a(i, m3453h(i));
        }

        public int mo629h(C0721t c0721t) {
            return 0;
        }

        public int m3452h(View view) {
            return view.getLeft() - m3463n(view);
        }

        public View m3453h(int i) {
            return this.f2039p != null ? this.f2039p.m4191b(i) : null;
        }

        public int m3454i(View view) {
            return view.getTop() - m3461l(view);
        }

        public void mo674i(int i) {
            if (this.f2040q != null) {
                this.f2040q.m266d(i);
            }
        }

        public int m3456j(View view) {
            return view.getRight() + m3465o(view);
        }

        public void mo675j(int i) {
            if (this.f2040q != null) {
                this.f2040q.m261c(i);
            }
        }

        public int m3458k(View view) {
            return view.getBottom() + m3462m(view);
        }

        public void mo676k(int i) {
        }

        boolean mo630k() {
            return false;
        }

        public int m3461l(View view) {
            return ((C0679i) view.getLayoutParams()).f2028d.top;
        }

        public int m3462m(View view) {
            return ((C0679i) view.getLayoutParams()).f2028d.bottom;
        }

        public int m3463n(View view) {
            return ((C0679i) view.getLayoutParams()).f2028d.left;
        }

        public void m3464n() {
            if (this.f2040q != null) {
                this.f2040q.requestLayout();
            }
        }

        public int m3465o(View view) {
            return ((C0679i) view.getLayoutParams()).f2028d.right;
        }

        public final boolean m3466o() {
            return this.f2034b;
        }

        public boolean m3467p() {
            return this.f2043t;
        }

        public boolean m3468q() {
            return this.f2040q != null && this.f2040q.f210h;
        }

        public boolean m3469r() {
            return this.f2041r != null && this.f2041r.m3786c();
        }

        public int m3470s() {
            return C0425s.m1966f(this.f2040q);
        }

        public int m3471t() {
            return -1;
        }

        public int m3472u() {
            return this.f2039p != null ? this.f2039p.m4189b() : 0;
        }

        public int m3473v() {
            return this.f2035c;
        }

        public int m3474w() {
            return this.f2036d;
        }

        public int m3475x() {
            return this.f2037e;
        }

        public int m3476y() {
            return this.f2038f;
        }

        public int m3477z() {
            return this.f2040q != null ? this.f2040q.getPaddingLeft() : 0;
        }
    }

    class C06871 implements Runnable {
        final /* synthetic */ RecyclerView f2094a;

        C06871(RecyclerView recyclerView) {
            this.f2094a = recyclerView;
        }

        public void run() {
            if (this.f2094a.f220r && !this.f2094a.isLayoutRequested()) {
                if (!this.f2094a.f218p) {
                    this.f2094a.requestLayout();
                } else if (this.f2094a.f222t) {
                    this.f2094a.f221s = true;
                } else {
                    this.f2094a.m260c();
                }
            }
        }
    }

    class C06882 implements Runnable {
        final /* synthetic */ RecyclerView f2095a;

        C06882(RecyclerView recyclerView) {
            this.f2095a = recyclerView;
        }

        public void run() {
            if (this.f2095a.f225w != null) {
                this.f2095a.f225w.mo698a();
            }
            this.f2095a.f192D = false;
        }
    }

    static class C06893 implements Interpolator {
        C06893() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C06914 implements C0690b {
        final /* synthetic */ RecyclerView f2096a;

        C06914(RecyclerView recyclerView) {
            this.f2096a = recyclerView;
        }

        public void mo649a(C0724w c0724w) {
            this.f2096a.f215m.m3392a(c0724w.f2170a, this.f2096a.f206d);
        }

        public void mo650a(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
            this.f2096a.f206d.m3753c(c0724w);
            this.f2096a.m256b(c0724w, c0702c, c0702c2);
        }

        public void mo651b(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
            this.f2096a.m246a(c0724w, c0702c, c0702c2);
        }

        public void mo652c(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
            c0724w.m3829a(false);
            if (this.f2096a.f224v) {
                if (this.f2096a.f225w.mo694a(c0724w, c0724w, c0702c, c0702c2)) {
                    this.f2096a.m293o();
                }
            } else if (this.f2096a.f225w.mo696c(c0724w, c0702c, c0702c2)) {
                this.f2096a.m293o();
            }
        }
    }

    class C06935 implements C0692b {
        final /* synthetic */ RecyclerView f2097a;

        C06935(RecyclerView recyclerView) {
            this.f2097a = recyclerView;
        }

        public int mo653a() {
            return this.f2097a.getChildCount();
        }

        public int mo654a(View view) {
            return this.f2097a.indexOfChild(view);
        }

        public void mo655a(int i) {
            View childAt = this.f2097a.getChildAt(i);
            if (childAt != null) {
                this.f2097a.m289m(childAt);
            }
            this.f2097a.removeViewAt(i);
        }

        public void mo656a(View view, int i) {
            this.f2097a.addView(view, i);
            this.f2097a.m291n(view);
        }

        public void mo657a(View view, int i, LayoutParams layoutParams) {
            C0724w e = RecyclerView.m227e(view);
            if (e != null) {
                if (e.m3848r() || e.m3833c()) {
                    e.m3843m();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + e);
                }
            }
            this.f2097a.attachViewToParent(view, i, layoutParams);
        }

        public C0724w mo658b(View view) {
            return RecyclerView.m227e(view);
        }

        public View mo659b(int i) {
            return this.f2097a.getChildAt(i);
        }

        public void mo660b() {
            int a = mo653a();
            for (int i = 0; i < a; i++) {
                this.f2097a.m289m(mo659b(i));
            }
            this.f2097a.removeAllViews();
        }

        public void mo661c(int i) {
            View b = mo659b(i);
            if (b != null) {
                C0724w e = RecyclerView.m227e(b);
                if (e != null) {
                    if (!e.m3848r() || e.m3833c()) {
                        e.m3832b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + e);
                    }
                }
            }
            this.f2097a.detachViewFromParent(i);
        }

        public void mo662c(View view) {
            C0724w e = RecyclerView.m227e(view);
            if (e != null) {
                e.m3813a(this.f2097a);
            }
        }

        public void mo663d(View view) {
            C0724w e = RecyclerView.m227e(view);
            if (e != null) {
                e.m3817b(this.f2097a);
            }
        }
    }

    class C06956 implements C0694a {
        final /* synthetic */ RecyclerView f2098a;

        C06956(RecyclerView recyclerView) {
            this.f2098a = recyclerView;
        }

        public C0724w mo664a(int i) {
            C0724w a = this.f2098a.m235a(i, true);
            return (a == null || this.f2098a.f208f.m4194c(a.f2170a)) ? null : a;
        }

        public void mo665a(int i, int i2) {
            this.f2098a.m243a(i, i2, true);
            this.f2098a.f190B = true;
            C0721t c0721t = this.f2098a.f189A;
            c0721t.f2148b += i2;
        }

        public void mo666a(int i, int i2, Object obj) {
            this.f2098a.m242a(i, i2, obj);
            this.f2098a.f191C = true;
        }

        public void mo667a(C0816b c0816b) {
            m3650c(c0816b);
        }

        public void mo668b(int i, int i2) {
            this.f2098a.m243a(i, i2, false);
            this.f2098a.f190B = true;
        }

        public void mo669b(C0816b c0816b) {
            m3650c(c0816b);
        }

        public void mo670c(int i, int i2) {
            this.f2098a.m277g(i, i2);
            this.f2098a.f190B = true;
        }

        void m3650c(C0816b c0816b) {
            switch (c0816b.f2731a) {
                case 1:
                    this.f2098a.f215m.mo642a(this.f2098a, c0816b.f2732b, c0816b.f2734d);
                    return;
                case 2:
                    this.f2098a.f215m.mo648b(this.f2098a, c0816b.f2732b, c0816b.f2734d);
                    return;
                case 4:
                    this.f2098a.f215m.mo644a(this.f2098a, c0816b.f2732b, c0816b.f2734d, c0816b.f2733c);
                    return;
                case 8:
                    this.f2098a.f215m.mo643a(this.f2098a, c0816b.f2732b, c0816b.f2734d, 1);
                    return;
                default:
                    return;
            }
        }

        public void mo671d(int i, int i2) {
            this.f2098a.m274f(i, i2);
            this.f2098a.f190B = true;
        }
    }

    public static abstract class C0696a<VH extends C0724w> {
        private final C0697b f2099a = new C0697b();
        private boolean f2100b = false;

        public abstract int mo839a();

        public int m3653a(int i) {
            return 0;
        }

        public abstract VH mo840a(ViewGroup viewGroup, int i);

        public void m3655a(C0698c c0698c) {
            this.f2099a.registerObserver(c0698c);
        }

        public void m3656a(VH vh) {
        }

        public abstract void mo841a(VH vh, int i);

        public void m3658a(VH vh, int i, List<Object> list) {
            mo841a((C0724w) vh, i);
        }

        public void m3659a(RecyclerView recyclerView) {
        }

        public long m3660b(int i) {
            return -1;
        }

        public final VH m3661b(ViewGroup viewGroup, int i) {
            C0314e.m1529a("RV CreateView");
            VH a = mo840a(viewGroup, i);
            a.f2175f = i;
            C0314e.m1528a();
            return a;
        }

        public void m3662b(C0698c c0698c) {
            this.f2099a.unregisterObserver(c0698c);
        }

        public final void m3663b(VH vh, int i) {
            vh.f2172c = i;
            if (m3665b()) {
                vh.f2174e = m3660b(i);
            }
            vh.m3824a(1, 519);
            C0314e.m1529a("RV OnBindView");
            m3658a(vh, i, vh.m3851u());
            vh.m3850t();
            LayoutParams layoutParams = vh.f2170a.getLayoutParams();
            if (layoutParams instanceof C0679i) {
                ((C0679i) layoutParams).f2029e = true;
            }
            C0314e.m1528a();
        }

        public void m3664b(RecyclerView recyclerView) {
        }

        public final boolean m3665b() {
            return this.f2100b;
        }

        public boolean m3666b(VH vh) {
            return false;
        }

        public final void m3667c() {
            this.f2099a.m3670a();
        }

        public void m3668c(VH vh) {
        }

        public void m3669d(VH vh) {
        }
    }

    static class C0697b extends Observable<C0698c> {
        C0697b() {
        }

        public void m3670a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0698c) this.mObservers.get(size)).mo673a();
            }
        }
    }

    public static abstract class C0698c {
        public void mo673a() {
        }
    }

    public interface C0699d {
        int m3672a(int i, int i2);
    }

    public static abstract class C0703e {
        private C0701b f2105a = null;
        private ArrayList<C0700a> f2106b = new ArrayList();
        private long f2107c = 120;
        private long f2108d = 120;
        private long f2109e = 250;
        private long f2110f = 250;

        public interface C0700a {
            void m3673a();
        }

        interface C0701b {
            void mo672a(C0724w c0724w);
        }

        public static class C0702c {
            public int f2101a;
            public int f2102b;
            public int f2103c;
            public int f2104d;

            public C0702c m3675a(C0724w c0724w) {
                return m3676a(c0724w, 0);
            }

            public C0702c m3676a(C0724w c0724w, int i) {
                View view = c0724w.f2170a;
                this.f2101a = view.getLeft();
                this.f2102b = view.getTop();
                this.f2103c = view.getRight();
                this.f2104d = view.getBottom();
                return this;
            }
        }

        static int m3677e(C0724w c0724w) {
            int d = c0724w.f2183n & 14;
            if (c0724w.m3844n()) {
                return 4;
            }
            if ((d & 4) != 0) {
                return d;
            }
            int f = c0724w.m3836f();
            int e = c0724w.m3835e();
            return (f == -1 || e == -1 || f == e) ? d : d | 2048;
        }

        public C0702c m3678a(C0721t c0721t, C0724w c0724w) {
            return m3698j().m3675a(c0724w);
        }

        public C0702c m3679a(C0721t c0721t, C0724w c0724w, int i, List<Object> list) {
            return m3698j().m3675a(c0724w);
        }

        public abstract void mo698a();

        void m3681a(C0701b c0701b) {
            this.f2105a = c0701b;
        }

        public abstract boolean mo693a(C0724w c0724w, C0702c c0702c, C0702c c0702c2);

        public abstract boolean mo694a(C0724w c0724w, C0724w c0724w2, C0702c c0702c, C0702c c0702c2);

        public boolean mo702a(C0724w c0724w, List<Object> list) {
            return mo697h(c0724w);
        }

        public abstract boolean mo703b();

        public abstract boolean mo695b(C0724w c0724w, C0702c c0702c, C0702c c0702c2);

        public abstract boolean mo696c(C0724w c0724w, C0702c c0702c, C0702c c0702c2);

        public abstract void mo705d();

        public abstract void mo706d(C0724w c0724w);

        public long m3690e() {
            return this.f2109e;
        }

        public long m3691f() {
            return this.f2107c;
        }

        public final void m3692f(C0724w c0724w) {
            m3694g(c0724w);
            if (this.f2105a != null) {
                this.f2105a.mo672a(c0724w);
            }
        }

        public long m3693g() {
            return this.f2108d;
        }

        public void m3694g(C0724w c0724w) {
        }

        public long m3695h() {
            return this.f2110f;
        }

        public boolean mo697h(C0724w c0724w) {
            return true;
        }

        public final void m3697i() {
            int size = this.f2106b.size();
            for (int i = 0; i < size; i++) {
                ((C0700a) this.f2106b.get(i)).m3673a();
            }
            this.f2106b.clear();
        }

        public C0702c m3698j() {
            return new C0702c();
        }
    }

    private class C0704f implements C0701b {
        final /* synthetic */ RecyclerView f2111a;

        C0704f(RecyclerView recyclerView) {
            this.f2111a = recyclerView;
        }

        public void mo672a(C0724w c0724w) {
            c0724w.m3829a(true);
            if (c0724w.f2177h != null && c0724w.f2178i == null) {
                c0724w.f2177h = null;
            }
            c0724w.f2178i = null;
            if (!c0724w.m3822z() && !this.f2111a.m251a(c0724w.f2170a) && c0724w.m3848r()) {
                this.f2111a.removeDetachedView(c0724w.f2170a, false);
            }
        }
    }

    public static abstract class C0705g {
        @Deprecated
        public void m3700a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m3701a(Canvas canvas, RecyclerView recyclerView, C0721t c0721t) {
            m3700a(canvas, recyclerView);
        }

        @Deprecated
        public void m3702a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void m3703a(Rect rect, View view, RecyclerView recyclerView, C0721t c0721t) {
            m3702a(rect, ((C0679i) view.getLayoutParams()).m3340f(), recyclerView);
        }

        @Deprecated
        public void m3704b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m3705b(Canvas canvas, RecyclerView recyclerView, C0721t c0721t) {
            m3704b(canvas, recyclerView);
        }
    }

    public interface C0708j {
        void m3707a(View view);

        void m3708b(View view);
    }

    public static abstract class C0709k {
        public abstract boolean m3709a(int i, int i2);
    }

    public interface C0710l {
        void mo842a(boolean z);

        boolean mo843a(RecyclerView recyclerView, MotionEvent motionEvent);

        void mo844b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class C0711m {
        public void m3713a(RecyclerView recyclerView, int i) {
        }

        public void m3714a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class C0713n {
        SparseArray<C0712a> f2120a = new SparseArray();
        private int f2121b = 0;

        static class C0712a {
            ArrayList<C0724w> f2116a = new ArrayList();
            int f2117b = 5;
            long f2118c = 0;
            long f2119d = 0;

            C0712a() {
            }
        }

        private C0712a m3715b(int i) {
            C0712a c0712a = (C0712a) this.f2120a.get(i);
            if (c0712a != null) {
                return c0712a;
            }
            c0712a = new C0712a();
            this.f2120a.put(i, c0712a);
            return c0712a;
        }

        long m3716a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public C0724w m3717a(int i) {
            C0712a c0712a = (C0712a) this.f2120a.get(i);
            if (c0712a == null || c0712a.f2116a.isEmpty()) {
                return null;
            }
            ArrayList arrayList = c0712a.f2116a;
            return (C0724w) arrayList.remove(arrayList.size() - 1);
        }

        public void m3718a() {
            for (int i = 0; i < this.f2120a.size(); i++) {
                ((C0712a) this.f2120a.valueAt(i)).f2116a.clear();
            }
        }

        void m3719a(int i, long j) {
            C0712a b = m3715b(i);
            b.f2118c = m3716a(b.f2118c, j);
        }

        void m3720a(C0696a c0696a) {
            this.f2121b++;
        }

        void m3721a(C0696a c0696a, C0696a c0696a2, boolean z) {
            if (c0696a != null) {
                m3724b();
            }
            if (!z && this.f2121b == 0) {
                m3718a();
            }
            if (c0696a2 != null) {
                m3720a(c0696a2);
            }
        }

        public void m3722a(C0724w c0724w) {
            int h = c0724w.m3838h();
            ArrayList arrayList = m3715b(h).f2116a;
            if (((C0712a) this.f2120a.get(h)).f2117b > arrayList.size()) {
                c0724w.m3852v();
                arrayList.add(c0724w);
            }
        }

        boolean m3723a(int i, long j, long j2) {
            long j3 = m3715b(i).f2118c;
            return j3 == 0 || j3 + j < j2;
        }

        void m3724b() {
            this.f2121b--;
        }

        void m3725b(int i, long j) {
            C0712a b = m3715b(i);
            b.f2119d = m3716a(b.f2119d, j);
        }

        boolean m3726b(int i, long j, long j2) {
            long j3 = m3715b(i).f2119d;
            return j3 == 0 || j3 + j < j2;
        }
    }

    public final class C0714o {
        final ArrayList<C0724w> f2122a = new ArrayList();
        ArrayList<C0724w> f2123b = null;
        final ArrayList<C0724w> f2124c = new ArrayList();
        int f2125d = 2;
        C0713n f2126e;
        final /* synthetic */ RecyclerView f2127f;
        private final List<C0724w> f2128g = Collections.unmodifiableList(this.f2122a);
        private int f2129h = 2;
        private C0722u f2130i;

        public C0714o(RecyclerView recyclerView) {
            this.f2127f = recyclerView;
        }

        private void m3727a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m3727a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private boolean m3728a(C0724w c0724w, int i, int i2, long j) {
            c0724w.f2182m = this.f2127f;
            int h = c0724w.m3838h();
            long nanoTime = this.f2127f.getNanoTime();
            if (j != Long.MAX_VALUE && !this.f2126e.m3726b(h, nanoTime, j)) {
                return false;
            }
            this.f2127f.f214l.m3663b(c0724w, i);
            this.f2126e.m3725b(c0724w.m3838h(), this.f2127f.getNanoTime() - nanoTime);
            m3729d(c0724w.f2170a);
            if (this.f2127f.f189A.m3792a()) {
                c0724w.f2176g = i2;
            }
            return true;
        }

        private void m3729d(View view) {
            if (this.f2127f.m290m()) {
                if (C0425s.m1961d(view) == 0) {
                    C0425s.m1960c(view, 1);
                }
                if (!C0425s.m1953a(view)) {
                    C0425s.m1948a(view, this.f2127f.f193E.m4429c());
                }
            }
        }

        private void m3730e(C0724w c0724w) {
            if (c0724w.f2170a instanceof ViewGroup) {
                m3727a((ViewGroup) c0724w.f2170a, false);
            }
        }

        C0724w m3731a(int i, boolean z, long j) {
            boolean z2 = true;
            if (i < 0 || i >= this.f2127f.f189A.m3796e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f2127f.f189A.m3796e());
            }
            C0724w f;
            boolean z3;
            C0724w c0724w;
            boolean z4;
            C0679i c0679i;
            if (this.f2127f.f189A.m3792a()) {
                f = m3760f(i);
                z3 = f != null;
                c0724w = f;
            } else {
                c0724w = null;
                z3 = false;
            }
            if (c0724w == null) {
                c0724w = m3745b(i, z);
                if (c0724w != null) {
                    if (m3743a(c0724w)) {
                        z3 = true;
                    } else {
                        if (!z) {
                            c0724w.m3832b(4);
                            if (c0724w.m3839i()) {
                                this.f2127f.removeDetachedView(c0724w.f2170a, false);
                                c0724w.m3840j();
                            } else if (c0724w.m3841k()) {
                                c0724w.m3842l();
                            }
                            m3748b(c0724w);
                        }
                        c0724w = null;
                    }
                }
            }
            if (c0724w == null) {
                int b = this.f2127f.f207e.m4691b(i);
                if (b < 0 || b >= this.f2127f.f214l.mo839a()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2127f.f189A.m3796e());
                }
                boolean z5;
                View a;
                long nanoTime;
                RecyclerView l;
                int a2 = this.f2127f.f214l.m3653a(b);
                if (this.f2127f.f214l.m3665b()) {
                    c0724w = m3732a(this.f2127f.f214l.m3660b(b), a2, z);
                    if (c0724w != null) {
                        c0724w.f2172c = b;
                        z5 = true;
                        if (c0724w == null && this.f2130i != null) {
                            a = this.f2130i.m3797a(this, i, a2);
                            if (a != null) {
                                c0724w = this.f2127f.m254b(a);
                                if (c0724w == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (c0724w.m3833c()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (c0724w == null) {
                            c0724w = m3762g().m3717a(a2);
                            if (c0724w != null) {
                                c0724w.m3852v();
                                if (RecyclerView.f186a) {
                                    m3730e(c0724w);
                                }
                            }
                        }
                        if (c0724w == null) {
                            nanoTime = this.f2127f.getNanoTime();
                            if (j == Long.MAX_VALUE && !this.f2126e.m3723a(a2, nanoTime, j)) {
                                return null;
                            }
                            c0724w = this.f2127f.f214l.m3661b(this.f2127f, a2);
                            if (RecyclerView.f183J) {
                                l = RecyclerView.m230l(c0724w.f2170a);
                                if (l != null) {
                                    c0724w.f2171b = new WeakReference(l);
                                }
                            }
                            this.f2126e.m3719a(a2, this.f2127f.getNanoTime() - nanoTime);
                        }
                        f = c0724w;
                        z4 = z5;
                    }
                }
                z5 = z3;
                a = this.f2130i.m3797a(this, i, a2);
                if (a != null) {
                    c0724w = this.f2127f.m254b(a);
                    if (c0724w == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    } else if (c0724w.m3833c()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                    }
                }
                if (c0724w == null) {
                    c0724w = m3762g().m3717a(a2);
                    if (c0724w != null) {
                        c0724w.m3852v();
                        if (RecyclerView.f186a) {
                            m3730e(c0724w);
                        }
                    }
                }
                if (c0724w == null) {
                    nanoTime = this.f2127f.getNanoTime();
                    if (j == Long.MAX_VALUE) {
                    }
                    c0724w = this.f2127f.f214l.m3661b(this.f2127f, a2);
                    if (RecyclerView.f183J) {
                        l = RecyclerView.m230l(c0724w.f2170a);
                        if (l != null) {
                            c0724w.f2171b = new WeakReference(l);
                        }
                    }
                    this.f2126e.m3719a(a2, this.f2127f.getNanoTime() - nanoTime);
                }
                f = c0724w;
                z4 = z5;
            } else {
                f = c0724w;
                z4 = z3;
            }
            if (z4 && !this.f2127f.f189A.m3792a() && f.m3830a(8192)) {
                f.m3824a(0, 8192);
                if (this.f2127f.f189A.f2155i) {
                    this.f2127f.m245a(f, this.f2127f.f225w.m3679a(this.f2127f.f189A, f, C0703e.m3677e(f) | 4096, f.m3851u()));
                }
            }
            int i2;
            if (this.f2127f.f189A.m3792a() && f.m3846p()) {
                f.f2176g = i;
                i2 = 0;
            } else if (!f.m3846p() || f.m3845o() || f.m3844n()) {
                z3 = m3728a(f, this.f2127f.f207e.m4691b(i), i, j);
            } else {
                i2 = 0;
            }
            LayoutParams layoutParams = f.f2170a.getLayoutParams();
            if (layoutParams == null) {
                c0679i = (C0679i) this.f2127f.generateDefaultLayoutParams();
                f.f2170a.setLayoutParams(c0679i);
            } else if (this.f2127f.checkLayoutParams(layoutParams)) {
                c0679i = (C0679i) layoutParams;
            } else {
                c0679i = (C0679i) this.f2127f.generateLayoutParams(layoutParams);
                f.f2170a.setLayoutParams(c0679i);
            }
            c0679i.f2027c = f;
            if (!z4 || r2 == 0) {
                z2 = false;
            }
            c0679i.f2030f = z2;
            return f;
        }

        C0724w m3732a(long j, int i, boolean z) {
            int size;
            for (size = this.f2122a.size() - 1; size >= 0; size--) {
                C0724w c0724w = (C0724w) this.f2122a.get(size);
                if (c0724w.m3837g() == j && !c0724w.m3841k()) {
                    if (i == c0724w.m3838h()) {
                        c0724w.m3832b(32);
                        if (!c0724w.m3847q() || this.f2127f.f189A.m3792a()) {
                            return c0724w;
                        }
                        c0724w.m3824a(2, 14);
                        return c0724w;
                    } else if (!z) {
                        this.f2122a.remove(size);
                        this.f2127f.removeDetachedView(c0724w.f2170a, false);
                        m3749b(c0724w.f2170a);
                    }
                }
            }
            for (size = this.f2124c.size() - 1; size >= 0; size--) {
                c0724w = (C0724w) this.f2124c.get(size);
                if (c0724w.m3837g() == j) {
                    if (i == c0724w.m3838h()) {
                        if (z) {
                            return c0724w;
                        }
                        this.f2124c.remove(size);
                        return c0724w;
                    } else if (!z) {
                        m3756d(size);
                        return null;
                    }
                }
            }
            return null;
        }

        View m3733a(int i, boolean z) {
            return m3731a(i, z, Long.MAX_VALUE).f2170a;
        }

        public void m3734a() {
            this.f2122a.clear();
            m3755d();
        }

        public void m3735a(int i) {
            this.f2129h = i;
            m3746b();
        }

        void m3736a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f2124c.size();
            for (int i6 = 0; i6 < size; i6++) {
                C0724w c0724w = (C0724w) this.f2124c.get(i6);
                if (c0724w != null && c0724w.f2172c >= r3 && c0724w.f2172c <= r2) {
                    if (c0724w.f2172c == i) {
                        c0724w.m3826a(i2 - i, false);
                    } else {
                        c0724w.m3826a(i3, false);
                    }
                }
            }
        }

        void m3737a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f2124c.size() - 1; size >= 0; size--) {
                C0724w c0724w = (C0724w) this.f2124c.get(size);
                if (c0724w != null) {
                    if (c0724w.f2172c >= i3) {
                        c0724w.m3826a(-i2, z);
                    } else if (c0724w.f2172c >= i) {
                        c0724w.m3832b(8);
                        m3756d(size);
                    }
                }
            }
        }

        void m3738a(C0696a c0696a, C0696a c0696a2, boolean z) {
            m3734a();
            m3762g().m3721a(c0696a, c0696a2, z);
        }

        void m3739a(C0713n c0713n) {
            if (this.f2126e != null) {
                this.f2126e.m3724b();
            }
            this.f2126e = c0713n;
            if (c0713n != null) {
                this.f2126e.m3720a(this.f2127f.getAdapter());
            }
        }

        void m3740a(C0722u c0722u) {
            this.f2130i = c0722u;
        }

        void m3741a(C0724w c0724w, boolean z) {
            RecyclerView.m225c(c0724w);
            C0425s.m1948a(c0724w.f2170a, null);
            if (z) {
                m3757d(c0724w);
            }
            c0724w.f2182m = null;
            m3762g().m3722a(c0724w);
        }

        public void m3742a(View view) {
            C0724w e = RecyclerView.m227e(view);
            if (e.m3848r()) {
                this.f2127f.removeDetachedView(view, false);
            }
            if (e.m3839i()) {
                e.m3840j();
            } else if (e.m3841k()) {
                e.m3842l();
            }
            m3748b(e);
        }

        boolean m3743a(C0724w c0724w) {
            if (c0724w.m3847q()) {
                return this.f2127f.f189A.m3792a();
            }
            if (c0724w.f2172c >= 0 && c0724w.f2172c < this.f2127f.f214l.mo839a()) {
                return (this.f2127f.f189A.m3792a() || this.f2127f.f214l.m3653a(c0724w.f2172c) == c0724w.m3838h()) ? !this.f2127f.f214l.m3665b() || c0724w.m3837g() == this.f2127f.f214l.m3660b(c0724w.f2172c) : false;
            } else {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0724w);
            }
        }

        public int m3744b(int i) {
            if (i >= 0 && i < this.f2127f.f189A.m3796e()) {
                return !this.f2127f.f189A.m3792a() ? i : this.f2127f.f207e.m4691b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f2127f.f189A.m3796e());
            }
        }

        C0724w m3745b(int i, boolean z) {
            int i2 = 0;
            int size = this.f2122a.size();
            int i3 = 0;
            while (i3 < size) {
                C0724w c0724w = (C0724w) this.f2122a.get(i3);
                if (c0724w.m3841k() || c0724w.m3834d() != i || c0724w.m3844n() || (!this.f2127f.f189A.f2152f && c0724w.m3847q())) {
                    i3++;
                } else {
                    c0724w.m3832b(32);
                    return c0724w;
                }
            }
            if (!z) {
                View c = this.f2127f.f208f.m4193c(i);
                if (c != null) {
                    c0724w = RecyclerView.m227e(c);
                    this.f2127f.f208f.m4198e(c);
                    i2 = this.f2127f.f208f.m4190b(c);
                    if (i2 == -1) {
                        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0724w);
                    }
                    this.f2127f.f208f.m4197e(i2);
                    m3754c(c);
                    c0724w.m3832b(8224);
                    return c0724w;
                }
            }
            i3 = this.f2124c.size();
            while (i2 < i3) {
                c0724w = (C0724w) this.f2124c.get(i2);
                if (c0724w.m3844n() || c0724w.m3834d() != i) {
                    i2++;
                } else if (z) {
                    return c0724w;
                } else {
                    this.f2124c.remove(i2);
                    return c0724w;
                }
            }
            return null;
        }

        void m3746b() {
            this.f2125d = (this.f2127f.f215m != null ? this.f2127f.f215m.f2045v : 0) + this.f2129h;
            for (int size = this.f2124c.size() - 1; size >= 0 && this.f2124c.size() > this.f2125d; size--) {
                m3756d(size);
            }
        }

        void m3747b(int i, int i2) {
            int size = this.f2124c.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0724w c0724w = (C0724w) this.f2124c.get(i3);
                if (c0724w != null && c0724w.f2172c >= i) {
                    c0724w.m3826a(i2, true);
                }
            }
        }

        void m3748b(C0724w c0724w) {
            int i = 0;
            if (c0724w.m3839i() || c0724w.f2170a.getParent() != null) {
                throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + c0724w.m3839i() + " isAttached:" + (c0724w.f2170a.getParent() != null));
            } else if (c0724w.m3848r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0724w);
            } else if (c0724w.m3833c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int size;
                boolean a = c0724w.m3810A();
                boolean z = this.f2127f.f214l != null && a && this.f2127f.f214l.m3666b(c0724w);
                if (z || c0724w.m3853w()) {
                    if (this.f2125d <= 0 || c0724w.m3830a(526)) {
                        z = false;
                    } else {
                        size = this.f2124c.size();
                        if (size >= this.f2125d && size > 0) {
                            m3756d(0);
                            size--;
                        }
                        if (RecyclerView.f183J && size > 0 && !this.f2127f.f228z.m4310a(c0724w.f2172c)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!this.f2127f.f228z.m4310a(((C0724w) this.f2124c.get(i2)).f2172c)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f2124c.add(size, c0724w);
                        size = true;
                    }
                    if (!size != false) {
                        m3741a(c0724w, true);
                        i = 1;
                    }
                } else {
                    size = 0;
                }
                this.f2127f.f209g.m4612g(c0724w);
                if (size == 0 && r2 == 0 && a) {
                    c0724w.f2182m = null;
                }
            }
        }

        void m3749b(View view) {
            C0724w e = RecyclerView.m227e(view);
            e.f2185q = null;
            e.f2186r = false;
            e.m3842l();
            m3748b(e);
        }

        public View m3750c(int i) {
            return m3733a(i, false);
        }

        public List<C0724w> m3751c() {
            return this.f2128g;
        }

        void m3752c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.f2124c.size() - 1; size >= 0; size--) {
                C0724w c0724w = (C0724w) this.f2124c.get(size);
                if (c0724w != null) {
                    int d = c0724w.m3834d();
                    if (d >= i && d < i3) {
                        c0724w.m3832b(2);
                        m3756d(size);
                    }
                }
            }
        }

        void m3753c(C0724w c0724w) {
            if (c0724w.f2186r) {
                this.f2123b.remove(c0724w);
            } else {
                this.f2122a.remove(c0724w);
            }
            c0724w.f2185q = null;
            c0724w.f2186r = false;
            c0724w.m3842l();
        }

        void m3754c(View view) {
            C0724w e = RecyclerView.m227e(view);
            if (!e.m3830a(12) && e.m3854x() && !this.f2127f.m258b(e)) {
                if (this.f2123b == null) {
                    this.f2123b = new ArrayList();
                }
                e.m3827a(this, true);
                this.f2123b.add(e);
            } else if (!e.m3844n() || e.m3847q() || this.f2127f.f214l.m3665b()) {
                e.m3827a(this, false);
                this.f2122a.add(e);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        void m3755d() {
            for (int size = this.f2124c.size() - 1; size >= 0; size--) {
                m3756d(size);
            }
            this.f2124c.clear();
            if (RecyclerView.f183J) {
                this.f2127f.f228z.m4307a();
            }
        }

        void m3756d(int i) {
            m3741a((C0724w) this.f2124c.get(i), true);
            this.f2124c.remove(i);
        }

        void m3757d(C0724w c0724w) {
            if (this.f2127f.f216n != null) {
                this.f2127f.f216n.m3767a(c0724w);
            }
            if (this.f2127f.f214l != null) {
                this.f2127f.f214l.m3656a(c0724w);
            }
            if (this.f2127f.f189A != null) {
                this.f2127f.f209g.m4612g(c0724w);
            }
        }

        int m3758e() {
            return this.f2122a.size();
        }

        View m3759e(int i) {
            return ((C0724w) this.f2122a.get(i)).f2170a;
        }

        C0724w m3760f(int i) {
            int i2 = 0;
            if (this.f2123b != null) {
                int size = this.f2123b.size();
                if (size != 0) {
                    C0724w c0724w;
                    int i3 = 0;
                    while (i3 < size) {
                        c0724w = (C0724w) this.f2123b.get(i3);
                        if (c0724w.m3841k() || c0724w.m3834d() != i) {
                            i3++;
                        } else {
                            c0724w.m3832b(32);
                            return c0724w;
                        }
                    }
                    if (this.f2127f.f214l.m3665b()) {
                        int b = this.f2127f.f207e.m4691b(i);
                        if (b > 0 && b < this.f2127f.f214l.mo839a()) {
                            long b2 = this.f2127f.f214l.m3660b(b);
                            while (i2 < size) {
                                c0724w = (C0724w) this.f2123b.get(i2);
                                if (c0724w.m3841k() || c0724w.m3837g() != b2) {
                                    i2++;
                                } else {
                                    c0724w.m3832b(32);
                                    return c0724w;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        void m3761f() {
            this.f2122a.clear();
            if (this.f2123b != null) {
                this.f2123b.clear();
            }
        }

        C0713n m3762g() {
            if (this.f2126e == null) {
                this.f2126e = new C0713n();
            }
            return this.f2126e;
        }

        void m3763h() {
            int size = this.f2124c.size();
            for (int i = 0; i < size; i++) {
                C0724w c0724w = (C0724w) this.f2124c.get(i);
                if (c0724w != null) {
                    c0724w.m3832b(512);
                }
            }
        }

        void m3764i() {
            if (this.f2127f.f214l == null || !this.f2127f.f214l.m3665b()) {
                m3755d();
                return;
            }
            int size = this.f2124c.size();
            for (int i = 0; i < size; i++) {
                C0724w c0724w = (C0724w) this.f2124c.get(i);
                if (c0724w != null) {
                    c0724w.m3832b(6);
                    c0724w.m3828a(null);
                }
            }
        }

        void m3765j() {
            int i;
            int i2 = 0;
            int size = this.f2124c.size();
            for (i = 0; i < size; i++) {
                ((C0724w) this.f2124c.get(i)).m3823a();
            }
            size = this.f2122a.size();
            for (i = 0; i < size; i++) {
                ((C0724w) this.f2122a.get(i)).m3823a();
            }
            if (this.f2123b != null) {
                i = this.f2123b.size();
                while (i2 < i) {
                    ((C0724w) this.f2123b.get(i2)).m3823a();
                    i2++;
                }
            }
        }

        void m3766k() {
            int size = this.f2124c.size();
            for (int i = 0; i < size; i++) {
                C0679i c0679i = (C0679i) ((C0724w) this.f2124c.get(i)).f2170a.getLayoutParams();
                if (c0679i != null) {
                    c0679i.f2029e = true;
                }
            }
        }
    }

    public interface C0715p {
        void m3767a(C0724w c0724w);
    }

    private class C0716q extends C0698c {
        final /* synthetic */ RecyclerView f2131a;

        C0716q(RecyclerView recyclerView) {
            this.f2131a = recyclerView;
        }

        public void mo673a() {
            this.f2131a.m247a(null);
            this.f2131a.f189A.f2151e = true;
            this.f2131a.m298t();
            if (!this.f2131a.f207e.m4695d()) {
                this.f2131a.requestLayout();
            }
        }
    }

    public static class C0718r extends C0079a {
        public static final Creator<C0718r> CREATOR = C0309b.m1523a(new C07171());
        Parcelable f2132a;

        static class C07171 implements C0077c<C0718r> {
            C07171() {
            }

            public C0718r m3769a(Parcel parcel, ClassLoader classLoader) {
                return new C0718r(parcel, classLoader);
            }

            public C0718r[] m3770a(int i) {
                return new C0718r[i];
            }

            public /* synthetic */ Object mo35b(Parcel parcel, ClassLoader classLoader) {
                return m3769a(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo36b(int i) {
                return m3770a(i);
            }
        }

        C0718r(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = C0681h.class.getClassLoader();
            }
            this.f2132a = parcel.readParcelable(classLoader);
        }

        C0718r(Parcelable parcelable) {
            super(parcelable);
        }

        void m3773a(C0718r c0718r) {
            this.f2132a = c0718r.f2132a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2132a, 0);
        }
    }

    public static abstract class C0720s {
        private int f2140a;
        private RecyclerView f2141b;
        private C0681h f2142c;
        private boolean f2143d;
        private boolean f2144e;
        private View f2145f;
        private final C0719a f2146g;

        public static class C0719a {
            private int f2133a;
            private int f2134b;
            private int f2135c;
            private int f2136d;
            private Interpolator f2137e;
            private boolean f2138f;
            private int f2139g;

            private void m3774b() {
                if (this.f2137e != null && this.f2135c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f2135c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            void m3775a(RecyclerView recyclerView) {
                if (this.f2136d >= 0) {
                    int i = this.f2136d;
                    this.f2136d = -1;
                    recyclerView.m239a(i);
                    this.f2138f = false;
                } else if (this.f2138f) {
                    m3774b();
                    if (this.f2137e != null) {
                        recyclerView.f226x.m3806a(this.f2133a, this.f2134b, this.f2135c, this.f2137e);
                    } else if (this.f2135c == Integer.MIN_VALUE) {
                        recyclerView.f226x.m3809b(this.f2133a, this.f2134b);
                    } else {
                        recyclerView.f226x.m3804a(this.f2133a, this.f2134b, this.f2135c);
                    }
                    this.f2139g++;
                    if (this.f2139g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2138f = false;
                } else {
                    this.f2139g = 0;
                }
            }

            boolean m3776a() {
                return this.f2136d >= 0;
            }
        }

        private void m3777a(int i, int i2) {
            RecyclerView recyclerView = this.f2141b;
            if (!this.f2144e || this.f2140a == -1 || recyclerView == null) {
                m3780a();
            }
            this.f2143d = false;
            if (this.f2145f != null) {
                if (m3779a(this.f2145f) == this.f2140a) {
                    m3783a(this.f2145f, recyclerView.f189A, this.f2146g);
                    this.f2146g.m3775a(recyclerView);
                    m3780a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2145f = null;
                }
            }
            if (this.f2144e) {
                m3782a(i, i2, recyclerView.f189A, this.f2146g);
                boolean a = this.f2146g.m3776a();
                this.f2146g.m3775a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f2144e) {
                    this.f2143d = true;
                    recyclerView.f226x.m3802a();
                    return;
                }
                m3780a();
            }
        }

        public int m3779a(View view) {
            return this.f2141b.m278h(view);
        }

        protected final void m3780a() {
            if (this.f2144e) {
                m3788e();
                this.f2141b.f189A.f2160n = -1;
                this.f2145f = null;
                this.f2140a = -1;
                this.f2143d = false;
                this.f2144e = false;
                this.f2142c.m3349a(this);
                this.f2142c = null;
                this.f2141b = null;
            }
        }

        public void m3781a(int i) {
            this.f2140a = i;
        }

        protected abstract void m3782a(int i, int i2, C0721t c0721t, C0719a c0719a);

        protected abstract void m3783a(View view, C0721t c0721t, C0719a c0719a);

        protected void m3784b(View view) {
            if (m3779a(view) == m3787d()) {
                this.f2145f = view;
            }
        }

        public boolean m3785b() {
            return this.f2143d;
        }

        public boolean m3786c() {
            return this.f2144e;
        }

        public int m3787d() {
            return this.f2140a;
        }

        protected abstract void m3788e();
    }

    public static class C0721t {
        int f2147a = 0;
        int f2148b = 0;
        int f2149c = 1;
        int f2150d = 0;
        boolean f2151e = false;
        boolean f2152f = false;
        boolean f2153g = false;
        boolean f2154h = false;
        boolean f2155i = false;
        boolean f2156j = false;
        int f2157k;
        long f2158l;
        int f2159m;
        private int f2160n = -1;
        private SparseArray<Object> f2161o;

        void m3790a(int i) {
            if ((this.f2149c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2149c));
            }
        }

        void m3791a(C0696a c0696a) {
            this.f2149c = 1;
            this.f2150d = c0696a.mo839a();
            this.f2151e = false;
            this.f2152f = false;
            this.f2153g = false;
            this.f2154h = false;
        }

        public boolean m3792a() {
            return this.f2152f;
        }

        public boolean m3793b() {
            return this.f2156j;
        }

        public int m3794c() {
            return this.f2160n;
        }

        public boolean m3795d() {
            return this.f2160n != -1;
        }

        public int m3796e() {
            return this.f2152f ? this.f2147a - this.f2148b : this.f2150d;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2160n + ", mData=" + this.f2161o + ", mItemCount=" + this.f2150d + ", mPreviousLayoutItemCount=" + this.f2147a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2148b + ", mStructureChanged=" + this.f2151e + ", mInPreLayout=" + this.f2152f + ", mRunSimpleAnimations=" + this.f2155i + ", mRunPredictiveAnimations=" + this.f2156j + '}';
        }
    }

    public static abstract class C0722u {
        public abstract View m3797a(C0714o c0714o, int i, int i2);
    }

    class C0723v implements Runnable {
        Interpolator f2162a = RecyclerView.f180G;
        final /* synthetic */ RecyclerView f2163b;
        private int f2164c;
        private int f2165d;
        private C0507k f2166e;
        private boolean f2167f = false;
        private boolean f2168g = false;

        public C0723v(RecyclerView recyclerView) {
            this.f2163b = recyclerView;
            this.f2166e = C0507k.m2435a(recyclerView.getContext(), RecyclerView.f180G);
        }

        private float m3798a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m3799b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.f2163b.getWidth() : this.f2163b.getHeight();
            int i5 = width / 2;
            float a = (m3798a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        private void m3800c() {
            this.f2168g = false;
            this.f2167f = true;
        }

        private void m3801d() {
            this.f2167f = false;
            if (this.f2168g) {
                m3802a();
            }
        }

        void m3802a() {
            if (this.f2167f) {
                this.f2168g = true;
                return;
            }
            this.f2163b.removeCallbacks(this);
            C0425s.m1950a(this.f2163b, (Runnable) this);
        }

        public void m3803a(int i, int i2) {
            this.f2163b.setScrollState(2);
            this.f2165d = 0;
            this.f2164c = 0;
            this.f2166e.m2437a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m3802a();
        }

        public void m3804a(int i, int i2, int i3) {
            m3806a(i, i2, i3, RecyclerView.f180G);
        }

        public void m3805a(int i, int i2, int i3, int i4) {
            m3804a(i, i2, m3799b(i, i2, i3, i4));
        }

        public void m3806a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f2162a != interpolator) {
                this.f2162a = interpolator;
                this.f2166e = C0507k.m2435a(this.f2163b.getContext(), interpolator);
            }
            this.f2163b.setScrollState(2);
            this.f2165d = 0;
            this.f2164c = 0;
            this.f2166e.m2436a(0, 0, i, i2, i3);
            m3802a();
        }

        public void m3807a(int i, int i2, Interpolator interpolator) {
            int b = m3799b(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f180G;
            }
            m3806a(i, i2, b, interpolator);
        }

        public void m3808b() {
            this.f2163b.removeCallbacks(this);
            this.f2166e.m2445h();
        }

        public void m3809b(int i, int i2) {
            m3805a(i, i2, 0, 0);
        }

        public void run() {
            if (this.f2163b.f215m == null) {
                m3808b();
                return;
            }
            m3800c();
            this.f2163b.m260c();
            C0507k c0507k = this.f2166e;
            C0720s c0720s = this.f2163b.f215m.f2041r;
            if (c0507k.m2444g()) {
                int e;
                int i;
                int f;
                int i2;
                Object obj;
                Object obj2;
                int b = c0507k.m2439b();
                int c = c0507k.m2440c();
                int i3 = b - this.f2164c;
                int i4 = c - this.f2165d;
                int i5 = 0;
                int i6 = 0;
                this.f2164c = b;
                this.f2165d = c;
                int i7 = 0;
                int i8 = 0;
                if (this.f2163b.f214l != null) {
                    this.f2163b.m265d();
                    this.f2163b.m287k();
                    C0314e.m1529a("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.f2163b.f215m.mo606a(i3, this.f2163b.f206d, this.f2163b.f189A);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.f2163b.f215m.mo616b(i4, this.f2163b.f206d, this.f2163b.f189A);
                        i8 = i4 - i6;
                    }
                    C0314e.m1528a();
                    this.f2163b.m301w();
                    this.f2163b.m288l();
                    this.f2163b.m248a(false);
                    if (!(c0720s == null || c0720s.m3785b() || !c0720s.m3786c())) {
                        e = this.f2163b.f189A.m3796e();
                        if (e == 0) {
                            c0720s.m3780a();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (c0720s.m3787d() >= e) {
                            c0720s.m3781a(e - 1);
                            c0720s.m3777a(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            c0720s.m3777a(i3 - i7, i4 - i8);
                        }
                        if (!this.f2163b.f217o.isEmpty()) {
                            this.f2163b.invalidate();
                        }
                        if (this.f2163b.getOverScrollMode() != 2) {
                            this.f2163b.m262c(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) c0507k.m2443f();
                            if (i6 == b) {
                                e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                                i2 = e;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                f = 0;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = 0;
                            }
                            if (this.f2163b.getOverScrollMode() != 2) {
                                this.f2163b.m267d(i2, f);
                            }
                            if ((i2 != 0 || i6 == b || c0507k.m2441d() == 0) && (f != 0 || i8 == c || c0507k.m2442e() == 0)) {
                                c0507k.m2445h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.f2163b.m282i(i5, i7);
                        }
                        if (!this.f2163b.awakenScrollBars()) {
                            this.f2163b.invalidate();
                        }
                        obj = (i4 == 0 && this.f2163b.f215m.mo626e() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.f2163b.f215m.mo624d() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!c0507k.m2438a() || obj2 == null) {
                            this.f2163b.setScrollState(0);
                            if (RecyclerView.f183J) {
                                this.f2163b.f228z.m4307a();
                            }
                        } else {
                            m3802a();
                            if (this.f2163b.f227y != null) {
                                this.f2163b.f227y.m4321a(this.f2163b, i3, i4);
                            }
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.f2163b.f217o.isEmpty()) {
                    this.f2163b.invalidate();
                }
                if (this.f2163b.getOverScrollMode() != 2) {
                    this.f2163b.m262c(i3, i4);
                }
                f = (int) c0507k.m2443f();
                if (i6 == b) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = e;
                }
                if (i8 != c) {
                    f = 0;
                } else if (i8 < 0) {
                    f = -f;
                } else if (i8 <= 0) {
                    f = 0;
                }
                if (this.f2163b.getOverScrollMode() != 2) {
                    this.f2163b.m267d(i2, f);
                }
                c0507k.m2445h();
                this.f2163b.m282i(i5, i7);
                if (this.f2163b.awakenScrollBars()) {
                    this.f2163b.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (c0507k.m2438a()) {
                }
                this.f2163b.setScrollState(0);
                if (RecyclerView.f183J) {
                    this.f2163b.f228z.m4307a();
                }
            }
            if (c0720s != null) {
                if (c0720s.m3785b()) {
                    c0720s.m3777a(0, 0);
                }
                if (!this.f2168g) {
                    c0720s.m3780a();
                }
            }
            m3801d();
        }
    }

    public static abstract class C0724w {
        private static final List<Object> f2169o = Collections.EMPTY_LIST;
        public final View f2170a;
        WeakReference<RecyclerView> f2171b;
        int f2172c = -1;
        int f2173d = -1;
        long f2174e = -1;
        int f2175f = -1;
        int f2176g = -1;
        C0724w f2177h = null;
        C0724w f2178i = null;
        List<Object> f2179j = null;
        List<Object> f2180k = null;
        int f2181l = -1;
        RecyclerView f2182m;
        private int f2183n;
        private int f2184p = 0;
        private C0714o f2185q = null;
        private boolean f2186r = false;
        private int f2187s = 0;

        public C0724w(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f2170a = view;
        }

        private boolean m3810A() {
            return (this.f2183n & 16) == 0 && C0425s.m1956b(this.f2170a);
        }

        private void m3813a(RecyclerView recyclerView) {
            this.f2187s = C0425s.m1961d(this.f2170a);
            recyclerView.m250a(this, 4);
        }

        private void m3817b(RecyclerView recyclerView) {
            recyclerView.m250a(this, this.f2187s);
            this.f2187s = 0;
        }

        private void m3821y() {
            if (this.f2179j == null) {
                this.f2179j = new ArrayList();
                this.f2180k = Collections.unmodifiableList(this.f2179j);
            }
        }

        private boolean m3822z() {
            return (this.f2183n & 16) != 0;
        }

        void m3823a() {
            this.f2173d = -1;
            this.f2176g = -1;
        }

        void m3824a(int i, int i2) {
            this.f2183n = (this.f2183n & (i2 ^ -1)) | (i & i2);
        }

        void m3825a(int i, int i2, boolean z) {
            m3832b(8);
            m3826a(i2, z);
            this.f2172c = i;
        }

        void m3826a(int i, boolean z) {
            if (this.f2173d == -1) {
                this.f2173d = this.f2172c;
            }
            if (this.f2176g == -1) {
                this.f2176g = this.f2172c;
            }
            if (z) {
                this.f2176g += i;
            }
            this.f2172c += i;
            if (this.f2170a.getLayoutParams() != null) {
                ((C0679i) this.f2170a.getLayoutParams()).f2029e = true;
            }
        }

        void m3827a(C0714o c0714o, boolean z) {
            this.f2185q = c0714o;
            this.f2186r = z;
        }

        void m3828a(Object obj) {
            if (obj == null) {
                m3832b(1024);
            } else if ((this.f2183n & 1024) == 0) {
                m3821y();
                this.f2179j.add(obj);
            }
        }

        public final void m3829a(boolean z) {
            this.f2184p = z ? this.f2184p - 1 : this.f2184p + 1;
            if (this.f2184p < 0) {
                this.f2184p = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.f2184p == 1) {
                this.f2183n |= 16;
            } else if (z && this.f2184p == 0) {
                this.f2183n &= -17;
            }
        }

        boolean m3830a(int i) {
            return (this.f2183n & i) != 0;
        }

        void m3831b() {
            if (this.f2173d == -1) {
                this.f2173d = this.f2172c;
            }
        }

        void m3832b(int i) {
            this.f2183n |= i;
        }

        boolean m3833c() {
            return (this.f2183n & 128) != 0;
        }

        public final int m3834d() {
            return this.f2176g == -1 ? this.f2172c : this.f2176g;
        }

        public final int m3835e() {
            return this.f2182m == null ? -1 : this.f2182m.m263d(this);
        }

        public final int m3836f() {
            return this.f2173d;
        }

        public final long m3837g() {
            return this.f2174e;
        }

        public final int m3838h() {
            return this.f2175f;
        }

        boolean m3839i() {
            return this.f2185q != null;
        }

        void m3840j() {
            this.f2185q.m3753c(this);
        }

        boolean m3841k() {
            return (this.f2183n & 32) != 0;
        }

        void m3842l() {
            this.f2183n &= -33;
        }

        void m3843m() {
            this.f2183n &= -257;
        }

        boolean m3844n() {
            return (this.f2183n & 4) != 0;
        }

        boolean m3845o() {
            return (this.f2183n & 2) != 0;
        }

        boolean m3846p() {
            return (this.f2183n & 1) != 0;
        }

        boolean m3847q() {
            return (this.f2183n & 8) != 0;
        }

        boolean m3848r() {
            return (this.f2183n & 256) != 0;
        }

        boolean m3849s() {
            return (this.f2183n & 512) != 0 || m3844n();
        }

        void m3850t() {
            if (this.f2179j != null) {
                this.f2179j.clear();
            }
            this.f2183n &= -1025;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2172c + " id=" + this.f2174e + ", oldPos=" + this.f2173d + ", pLpos:" + this.f2176g);
            if (m3839i()) {
                stringBuilder.append(" scrap ").append(this.f2186r ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m3844n()) {
                stringBuilder.append(" invalid");
            }
            if (!m3846p()) {
                stringBuilder.append(" unbound");
            }
            if (m3845o()) {
                stringBuilder.append(" update");
            }
            if (m3847q()) {
                stringBuilder.append(" removed");
            }
            if (m3833c()) {
                stringBuilder.append(" ignored");
            }
            if (m3848r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!m3853w()) {
                stringBuilder.append(" not recyclable(" + this.f2184p + ")");
            }
            if (m3849s()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.f2170a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        List<Object> m3851u() {
            return (this.f2183n & 1024) == 0 ? (this.f2179j == null || this.f2179j.size() == 0) ? f2169o : this.f2180k : f2169o;
        }

        void m3852v() {
            this.f2183n = 0;
            this.f2172c = -1;
            this.f2173d = -1;
            this.f2174e = -1;
            this.f2176g = -1;
            this.f2184p = 0;
            this.f2177h = null;
            this.f2178i = null;
            m3850t();
            this.f2187s = 0;
            this.f2181l = -1;
            RecyclerView.m225c(this);
        }

        public final boolean m3853w() {
            return (this.f2183n & 16) == 0 && !C0425s.m1956b(this.f2170a);
        }

        boolean m3854x() {
            return (this.f2183n & 2) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        f186a = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.f195M = new C0716q(this);
        this.f206d = new C0714o(this);
        this.f209g = new bs();
        this.f211i = new C06871(this);
        this.f212j = new Rect();
        this.f197O = new Rect();
        this.f213k = new RectF();
        this.f217o = new ArrayList();
        this.f198P = new ArrayList();
        this.f200R = 0;
        this.f224v = false;
        this.f205W = 0;
        this.aa = 0;
        this.f225w = new ak();
        this.af = 0;
        this.ag = -1;
        this.aq = Float.MIN_VALUE;
        this.ar = true;
        this.f226x = new C0723v(this);
        this.f228z = f183J ? new C0771a() : null;
        this.f189A = new C0721t();
        this.f190B = false;
        this.f191C = false;
        this.au = new C0704f(this);
        this.f192D = false;
        this.aw = new int[2];
        this.ay = new int[2];
        this.az = new int[2];
        this.aA = new int[2];
        this.f194F = new ArrayList();
        this.aB = new C06882(this);
        this.aC = new C06914(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f182I, i, 0);
            this.f210h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.f210h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.am = viewConfiguration.getScaledTouchSlop();
        this.ao = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ap = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.f225w.m3681a(this.au);
        m238a();
        m233z();
        if (C0425s.m1961d(this) == 0) {
            C0425s.m1960c((View) this, 1);
        }
        this.f203U = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ay(this));
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0610a.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0610a.RecyclerView_layoutManager);
            if (obtainStyledAttributes.getInt(C0610a.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            obtainStyledAttributes.recycle();
            m212a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f181H, i, 0);
                z = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    private boolean m194A() {
        int b = this.f208f.m4189b();
        for (int i = 0; i < b; i++) {
            C0724w e = m227e(this.f208f.m4191b(i));
            if (e != null && !e.m3833c() && e.m3854x()) {
                return true;
            }
        }
        return false;
    }

    private void m195B() {
        this.f226x.m3808b();
        if (this.f215m != null) {
            this.f215m.m3358G();
        }
    }

    private void m196C() {
        int i = 0;
        if (this.ab != null) {
            i = this.ab.m2401b();
        }
        if (this.ac != null) {
            i |= this.ac.m2401b();
        }
        if (this.ad != null) {
            i |= this.ad.m2401b();
        }
        if (this.ae != null) {
            i |= this.ae.m2401b();
        }
        if (i != 0) {
            C0425s.m1958c(this);
        }
    }

    private void m197D() {
        if (this.ah != null) {
            this.ah.clear();
        }
        stopNestedScroll();
        m196C();
    }

    private void m198E() {
        m197D();
        setScrollState(0);
    }

    private void m199F() {
        int i = this.f202T;
        this.f202T = 0;
        if (i != 0 && m290m()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0357a.m1686a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean m200G() {
        return this.f225w != null && this.f215m.mo617b();
    }

    private void m201H() {
        boolean z = true;
        if (this.f224v) {
            this.f207e.m4686a();
            this.f215m.mo641a(this);
        }
        if (m200G()) {
            this.f207e.m4692b();
        } else {
            this.f207e.m4696e();
        }
        boolean z2 = this.f190B || this.f191C;
        C0721t c0721t = this.f189A;
        boolean z3 = this.f220r && this.f225w != null && ((this.f224v || z2 || this.f215m.f2042s) && (!this.f224v || this.f214l.m3665b()));
        c0721t.f2155i = z3;
        C0721t c0721t2 = this.f189A;
        if (!(this.f189A.f2155i && z2 && !this.f224v && m200G())) {
            z = false;
        }
        c0721t2.f2156j = z;
    }

    private void m202I() {
        View focusedChild = (this.ar && hasFocus() && this.f214l != null) ? getFocusedChild() : null;
        C0724w d = focusedChild == null ? null : m264d(focusedChild);
        if (d == null) {
            m203J();
            return;
        }
        this.f189A.f2158l = this.f214l.m3665b() ? d.m3837g() : -1;
        C0721t c0721t = this.f189A;
        int e = this.f224v ? -1 : d.m3847q() ? d.f2173d : d.m3835e();
        c0721t.f2157k = e;
        this.f189A.f2159m = m231o(d.f2170a);
    }

    private void m203J() {
        this.f189A.f2158l = -1;
        this.f189A.f2157k = -1;
        this.f189A.f2159m = -1;
    }

    private View m204K() {
        int i = this.f189A.f2157k != -1 ? this.f189A.f2157k : 0;
        int e = this.f189A.m3796e();
        int i2 = i;
        while (i2 < e) {
            C0724w b = m253b(i2);
            if (b == null) {
                break;
            } else if (b.f2170a.hasFocusable()) {
                return b.f2170a;
            } else {
                i2++;
            }
        }
        for (i = Math.min(e, i) - 1; i >= 0; i--) {
            C0724w b2 = m253b(i);
            if (b2 == null) {
                return null;
            }
            if (b2.f2170a.hasFocusable()) {
                return b2.f2170a;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m205L() {
        /*
        r6 = this;
        r4 = -1;
        r1 = 0;
        r0 = r6.ar;
        if (r0 == 0) goto L_0x0027;
    L_0x0007:
        r0 = r6.f214l;
        if (r0 == 0) goto L_0x0027;
    L_0x000b:
        r0 = r6.hasFocus();
        if (r0 == 0) goto L_0x0027;
    L_0x0011:
        r0 = r6.getDescendantFocusability();
        r2 = 393216; // 0x60000 float:5.51013E-40 double:1.942745E-318;
        if (r0 == r2) goto L_0x0027;
    L_0x0019:
        r0 = r6.getDescendantFocusability();
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r0 != r2) goto L_0x0028;
    L_0x0021:
        r0 = r6.isFocused();
        if (r0 == 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0046;
    L_0x002e:
        r0 = r6.getFocusedChild();
        r2 = r6.f208f;
        r2 = r2.m4194c(r0);
        if (r2 != 0) goto L_0x0046;
    L_0x003a:
        r2 = r0.getParent();
        if (r2 != r6) goto L_0x0046;
    L_0x0040:
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x0027;
    L_0x0046:
        r0 = r6.f189A;
        r2 = r0.f2158l;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00a2;
    L_0x004e:
        r0 = r6.f214l;
        r0 = r0.m3665b();
        if (r0 == 0) goto L_0x00a2;
    L_0x0056:
        r0 = r6.f189A;
        r2 = r0.f2158l;
        r0 = r6.m236a(r2);
    L_0x005e:
        if (r0 == 0) goto L_0x0072;
    L_0x0060:
        r2 = r6.f208f;
        r3 = r0.f2170a;
        r2 = r2.m4194c(r3);
        if (r2 != 0) goto L_0x0072;
    L_0x006a:
        r2 = r0.f2170a;
        r2 = r2.hasFocusable();
        if (r2 != 0) goto L_0x009d;
    L_0x0072:
        r0 = r6.f208f;
        r0 = r0.m4189b();
        if (r0 <= 0) goto L_0x007e;
    L_0x007a:
        r1 = r6.m204K();
    L_0x007e:
        if (r1 == 0) goto L_0x0027;
    L_0x0080:
        r0 = r6.f189A;
        r0 = r0.f2159m;
        r2 = (long) r0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00a0;
    L_0x0089:
        r0 = r6.f189A;
        r0 = r0.f2159m;
        r0 = r1.findViewById(r0);
        if (r0 == 0) goto L_0x00a0;
    L_0x0093:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x00a0;
    L_0x0099:
        r0.requestFocus();
        goto L_0x0027;
    L_0x009d:
        r1 = r0.f2170a;
        goto L_0x007e;
    L_0x00a0:
        r0 = r1;
        goto L_0x0099;
    L_0x00a2:
        r0 = r1;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.L():void");
    }

    private void m206M() {
        int b;
        int i;
        C0724w e;
        boolean z = true;
        this.f189A.m3790a(1);
        this.f189A.f2154h = false;
        m265d();
        this.f209g.m4599a();
        m287k();
        m201H();
        m202I();
        C0721t c0721t = this.f189A;
        if (!(this.f189A.f2155i && this.f191C)) {
            z = false;
        }
        c0721t.f2153g = z;
        this.f191C = false;
        this.f190B = false;
        this.f189A.f2152f = this.f189A.f2156j;
        this.f189A.f2150d = this.f214l.mo839a();
        m219a(this.aw);
        if (this.f189A.f2155i) {
            b = this.f208f.m4189b();
            for (i = 0; i < b; i++) {
                e = m227e(this.f208f.m4191b(i));
                if (!e.m3833c() && (!e.m3844n() || this.f214l.m3665b())) {
                    this.f209g.m4601a(e, this.f225w.m3679a(this.f189A, e, C0703e.m3677e(e), e.m3851u()));
                    if (!(!this.f189A.f2153g || !e.m3854x() || e.m3847q() || e.m3833c() || e.m3844n())) {
                        this.f209g.m4600a(m234a(e), e);
                    }
                }
            }
        }
        if (this.f189A.f2156j) {
            m296r();
            z = this.f189A.f2151e;
            this.f189A.f2151e = false;
            this.f215m.mo621c(this.f206d, this.f189A);
            this.f189A.f2151e = z;
            for (i = 0; i < this.f208f.m4189b(); i++) {
                e = m227e(this.f208f.m4191b(i));
                if (!(e.m3833c() || this.f209g.m4609d(e))) {
                    b = C0703e.m3677e(e);
                    boolean a = e.m3830a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    C0702c a2 = this.f225w.m3679a(this.f189A, e, b, e.m3851u());
                    if (a) {
                        m245a(e, a2);
                    } else {
                        this.f209g.m4606b(e, a2);
                    }
                }
            }
            m297s();
        } else {
            m297s();
        }
        m288l();
        m248a(false);
        this.f189A.f2149c = 2;
    }

    private void m207N() {
        m265d();
        m287k();
        this.f189A.m3790a(6);
        this.f207e.m4696e();
        this.f189A.f2150d = this.f214l.mo839a();
        this.f189A.f2148b = 0;
        this.f189A.f2152f = false;
        this.f215m.mo621c(this.f206d, this.f189A);
        this.f189A.f2151e = false;
        this.f196N = null;
        C0721t c0721t = this.f189A;
        boolean z = this.f189A.f2155i && this.f225w != null;
        c0721t.f2155i = z;
        this.f189A.f2149c = 4;
        m288l();
        m248a(false);
    }

    private void m208O() {
        this.f189A.m3790a(4);
        m265d();
        m287k();
        this.f189A.f2149c = 1;
        if (this.f189A.f2155i) {
            for (int b = this.f208f.m4189b() - 1; b >= 0; b--) {
                C0724w e = m227e(this.f208f.m4191b(b));
                if (!e.m3833c()) {
                    long a = m234a(e);
                    C0702c a2 = this.f225w.m3678a(this.f189A, e);
                    C0724w a3 = this.f209g.m4598a(a);
                    if (a3 == null || a3.m3833c()) {
                        this.f209g.m4608c(e, a2);
                    } else {
                        boolean a4 = this.f209g.m4603a(a3);
                        boolean a5 = this.f209g.m4603a(e);
                        if (a4 && a3 == e) {
                            this.f209g.m4608c(e, a2);
                        } else {
                            C0702c b2 = this.f209g.m4604b(a3);
                            this.f209g.m4608c(e, a2);
                            C0702c c = this.f209g.m4607c(e);
                            if (b2 == null) {
                                m211a(a, e, a3);
                            } else {
                                m214a(a3, e, b2, c, a4, a5);
                            }
                        }
                    }
                }
            }
            this.f209g.m4602a(this.aC);
        }
        this.f215m.m3410b(this.f206d);
        this.f189A.f2147a = this.f189A.f2150d;
        this.f224v = false;
        this.f189A.f2155i = false;
        this.f189A.f2156j = false;
        this.f215m.f2042s = false;
        if (this.f206d.f2123b != null) {
            this.f206d.f2123b.clear();
        }
        if (this.f215m.f2046w) {
            this.f215m.f2045v = 0;
            this.f215m.f2046w = false;
            this.f206d.m3746b();
        }
        this.f215m.mo612a(this.f189A);
        m288l();
        m248a(false);
        this.f209g.m4599a();
        if (m229j(this.aw[0], this.aw[1])) {
            m282i(0, 0);
        }
        m205L();
        m203J();
    }

    private String m209a(Context context, String str) {
        return str.charAt(0) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m210a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.m272f();
        r2 = r7.ab;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m2398a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.m279h();
        r2 = r7.ac;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m2398a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.p008h.C0425s.m1958c(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.m276g();
        r2 = r7.ad;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m2398a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.m281i();
        r2 = r7.ae;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m2398a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void m211a(long j, C0724w c0724w, C0724w c0724w2) {
        int b = this.f208f.m4189b();
        int i = 0;
        while (i < b) {
            C0724w e = m227e(this.f208f.m4191b(i));
            if (e == c0724w || m234a(e) != j) {
                i++;
            } else if (this.f214l == null || !this.f214l.m3665b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e + " \n View Holder 2:" + c0724w);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e + " \n View Holder 2:" + c0724w);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0724w2 + " cannot be found but it is necessary for " + c0724w);
    }

    private void m212a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m209a(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(a).asSubclass(C0681h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(f185L);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0681h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private void m213a(C0696a c0696a, boolean z, boolean z2) {
        if (this.f214l != null) {
            this.f214l.m3662b(this.f195M);
            this.f214l.m3664b(this);
        }
        if (!z || z2) {
            m255b();
        }
        this.f207e.m4686a();
        C0696a c0696a2 = this.f214l;
        this.f214l = c0696a;
        if (c0696a != null) {
            c0696a.m3655a(this.f195M);
            c0696a.m3659a(this);
        }
        if (this.f215m != null) {
            this.f215m.m3373a(c0696a2, this.f214l);
        }
        this.f206d.m3738a(c0696a2, this.f214l, z);
        this.f189A.f2151e = true;
        m299u();
    }

    private void m214a(C0724w c0724w, C0724w c0724w2, C0702c c0702c, C0702c c0702c2, boolean z, boolean z2) {
        c0724w.m3829a(false);
        if (z) {
            m228e(c0724w);
        }
        if (c0724w != c0724w2) {
            if (z2) {
                m228e(c0724w2);
            }
            c0724w.f2177h = c0724w2;
            m228e(c0724w);
            this.f206d.m3753c(c0724w);
            c0724w2.m3829a(false);
            c0724w2.f2178i = c0724w;
        }
        if (this.f225w.mo694a(c0724w, c0724w2, c0702c, c0702c2)) {
            m293o();
        }
    }

    static void m218a(View view, Rect rect) {
        C0679i c0679i = (C0679i) view.getLayoutParams();
        Rect rect2 = c0679i.f2028d;
        rect.set((view.getLeft() - rect2.left) - c0679i.leftMargin, (view.getTop() - rect2.top) - c0679i.topMargin, (view.getRight() + rect2.right) + c0679i.rightMargin, c0679i.bottomMargin + (rect2.bottom + view.getBottom()));
    }

    private void m219a(int[] iArr) {
        int b = this.f208f.m4189b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            C0724w e = m227e(this.f208f.m4191b(i3));
            if (e.m3833c()) {
                i4 = i;
            } else {
                i4 = e.m3834d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean m221a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f199Q = null;
        }
        int size = this.f198P.size();
        int i = 0;
        while (i < size) {
            C0710l c0710l = (C0710l) this.f198P.get(i);
            if (!c0710l.mo843a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f199Q = c0710l;
                return true;
            }
        }
        return false;
    }

    private boolean m222a(View view, View view2, int i) {
        int i2 = 0;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i != 2 && i != 1) {
            return m224b(view, view2, i);
        }
        int i3 = this.f215m.m3470s() == 1 ? 1 : 0;
        if (i == 2) {
            i2 = 1;
        }
        return m224b(view, view2, (i2 ^ i3) != 0 ? 66 : 17) ? true : i == 2 ? m224b(view, view2, 130) : m224b(view, view2, 33);
    }

    private boolean m223b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f199Q != null) {
            if (action == 0) {
                this.f199Q = null;
            } else {
                this.f199Q.mo844b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f199Q = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f198P.size();
            for (int i = 0; i < size; i++) {
                C0710l c0710l = (C0710l) this.f198P.get(i);
                if (c0710l.mo843a(this, motionEvent)) {
                    this.f199Q = c0710l;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m224b(View view, View view2, int i) {
        this.f212j.set(0, 0, view.getWidth(), view.getHeight());
        this.f197O.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f212j);
        offsetDescendantRectToMyCoords(view2, this.f197O);
        switch (i) {
            case 17:
                return (this.f212j.right > this.f197O.right || this.f212j.left >= this.f197O.right) && this.f212j.left > this.f197O.left;
            case 33:
                return (this.f212j.bottom > this.f197O.bottom || this.f212j.top >= this.f197O.bottom) && this.f212j.top > this.f197O.top;
            case 66:
                return (this.f212j.left < this.f197O.left || this.f212j.right <= this.f197O.left) && this.f212j.right < this.f197O.right;
            case 130:
                return (this.f212j.top < this.f197O.top || this.f212j.bottom <= this.f197O.top) && this.f212j.bottom < this.f197O.bottom;
            default:
                throw new IllegalArgumentException("direction must be absolute. received:" + i);
        }
    }

    static void m225c(C0724w c0724w) {
        if (c0724w.f2171b != null) {
            View view = (View) c0724w.f2171b.get();
            while (view != null) {
                if (view != c0724w.f2170a) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            c0724w.f2171b = null;
        }
    }

    private void m226c(MotionEvent motionEvent) {
        int b = C0407h.m1819b(motionEvent);
        if (motionEvent.getPointerId(b) == this.ag) {
            b = b == 0 ? 1 : 0;
            this.ag = motionEvent.getPointerId(b);
            int x = (int) (motionEvent.getX(b) + 0.5f);
            this.ak = x;
            this.ai = x;
            b = (int) (motionEvent.getY(b) + 0.5f);
            this.al = b;
            this.aj = b;
        }
    }

    static C0724w m227e(View view) {
        return view == null ? null : ((C0679i) view.getLayoutParams()).f2027c;
    }

    private void m228e(C0724w c0724w) {
        View view = c0724w.f2170a;
        boolean z = view.getParent() == this;
        this.f206d.m3753c(m254b(view));
        if (c0724w.m3848r()) {
            this.f208f.m4186a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f208f.m4196d(view);
        } else {
            this.f208f.m4188a(view, true);
        }
    }

    private float getScrollFactor() {
        if (this.aq == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.aq = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.aq;
    }

    private C0409k getScrollingChildHelper() {
        if (this.ax == null) {
            this.ax = new C0409k(this);
        }
        return this.ax;
    }

    private boolean m229j(int i, int i2) {
        m219a(this.aw);
        return (this.aw[0] == i && this.aw[1] == i2) ? false : true;
    }

    static RecyclerView m230l(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView l = m230l(viewGroup.getChildAt(i));
            if (l != null) {
                return l;
            }
        }
        return null;
    }

    private int m231o(View view) {
        int id = view.getId();
        View view2 = view;
        while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
            view = ((ViewGroup) view2).getFocusedChild();
            id = view.getId() != -1 ? view.getId() : id;
            view2 = view;
        }
        return id;
    }

    private void m233z() {
        this.f208f = new ah(new C06935(this));
    }

    long m234a(C0724w c0724w) {
        return this.f214l.m3665b() ? c0724w.m3837g() : (long) c0724w.f2172c;
    }

    C0724w m235a(int i, boolean z) {
        int c = this.f208f.m4192c();
        C0724w c0724w = null;
        for (int i2 = 0; i2 < c; i2++) {
            C0724w e = m227e(this.f208f.m4195d(i2));
            if (!(e == null || e.m3847q())) {
                if (z) {
                    if (e.f2172c != i) {
                        continue;
                    }
                } else if (e.m3834d() != i) {
                    continue;
                }
                if (!this.f208f.m4194c(e.f2170a)) {
                    return e;
                }
                c0724w = e;
            }
        }
        return c0724w;
    }

    public C0724w m236a(long j) {
        if (this.f214l == null || !this.f214l.m3665b()) {
            return null;
        }
        int c = this.f208f.m4192c();
        int i = 0;
        C0724w c0724w = null;
        while (i < c) {
            C0724w e = m227e(this.f208f.m4195d(i));
            if (e == null || e.m3847q() || e.m3837g() != j) {
                e = c0724w;
            } else if (!this.f208f.m4194c(e.f2170a)) {
                return e;
            }
            i++;
            c0724w = e;
        }
        return c0724w;
    }

    public View m237a(float f, float f2) {
        for (int b = this.f208f.m4189b() - 1; b >= 0; b--) {
            View b2 = this.f208f.m4191b(b);
            float j = C0425s.m1971j(b2);
            float k = C0425s.m1972k(b2);
            if (f >= ((float) b2.getLeft()) + j && f <= j + ((float) b2.getRight()) && f2 >= ((float) b2.getTop()) + k && f2 <= ((float) b2.getBottom()) + k) {
                return b2;
            }
        }
        return null;
    }

    void m238a() {
        this.f207e = new C0817f(new C06956(this));
    }

    void m239a(int i) {
        if (this.f215m != null) {
            this.f215m.mo623d(i);
            awakenScrollBars();
        }
    }

    public void m240a(int i, int i2) {
        m241a(i, i2, null);
    }

    public void m241a(int i, int i2, Interpolator interpolator) {
        int i3 = 0;
        if (this.f215m == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f222t) {
            if (!this.f215m.mo624d()) {
                i = 0;
            }
            if (this.f215m.mo626e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.f226x.m3807a(i, i3, interpolator);
            }
        }
    }

    void m242a(int i, int i2, Object obj) {
        int c = this.f208f.m4192c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.f208f.m4195d(i4);
            C0724w e = m227e(d);
            if (e != null && !e.m3833c() && e.f2172c >= i && e.f2172c < i3) {
                e.m3832b(2);
                e.m3828a(obj);
                ((C0679i) d.getLayoutParams()).f2029e = true;
            }
        }
        this.f206d.m3752c(i, i2);
    }

    void m243a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f208f.m4192c();
        for (int i4 = 0; i4 < c; i4++) {
            C0724w e = m227e(this.f208f.m4195d(i4));
            if (!(e == null || e.m3833c())) {
                if (e.f2172c >= i3) {
                    e.m3826a(-i2, z);
                    this.f189A.f2151e = true;
                } else if (e.f2172c >= i) {
                    e.m3825a(i - 1, -i2, z);
                    this.f189A.f2151e = true;
                }
            }
        }
        this.f206d.m3737a(i, i2, z);
        requestLayout();
    }

    public void m244a(C0710l c0710l) {
        this.f198P.add(c0710l);
    }

    void m245a(C0724w c0724w, C0702c c0702c) {
        c0724w.m3824a(0, 8192);
        if (this.f189A.f2153g && c0724w.m3854x() && !c0724w.m3847q() && !c0724w.m3833c()) {
            this.f209g.m4600a(m234a(c0724w), c0724w);
        }
        this.f209g.m4601a(c0724w, c0702c);
    }

    void m246a(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
        c0724w.m3829a(false);
        if (this.f225w.mo695b(c0724w, c0702c, c0702c2)) {
            m293o();
        }
    }

    void m247a(String str) {
        if (m292n()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            }
            throw new IllegalStateException(str);
        } else if (this.aa > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks might be run during a measure & layout pass where you cannot change the RecyclerView data. Any method call that might change the structure of the RecyclerView or the adapter contents should be postponed to the next frame.", new IllegalStateException(""));
        }
    }

    void m248a(boolean z) {
        if (this.f200R < 1) {
            this.f200R = 1;
        }
        if (!z) {
            this.f221s = false;
        }
        if (this.f200R == 1) {
            if (!(!z || !this.f221s || this.f222t || this.f215m == null || this.f214l == null)) {
                m294p();
            }
            if (!this.f222t) {
                this.f221s = false;
            }
        }
        this.f200R--;
    }

    boolean m249a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        m260c();
        if (this.f214l != null) {
            int b;
            m265d();
            m287k();
            C0314e.m1529a("RV Scroll");
            if (i != 0) {
                a = this.f215m.mo606a(i, this.f206d, this.f189A);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.f215m.mo616b(i2, this.f206d, this.f189A);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            C0314e.m1528a();
            m301w();
            m288l();
            m248a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.f217o.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.ay)) {
            this.ak -= this.ay[0];
            this.al -= this.ay[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.ay[0], (float) this.ay[1]);
            }
            int[] iArr = this.aA;
            iArr[0] = iArr[0] + this.ay[0];
            iArr = this.aA;
            iArr[1] = iArr[1] + this.ay[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                m210a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            m262c(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            m282i(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && a == 0) ? false : true;
    }

    boolean m250a(C0724w c0724w, int i) {
        if (m292n()) {
            c0724w.f2181l = i;
            this.f194F.add(c0724w);
            return false;
        }
        C0425s.m1960c(c0724w.f2170a, i);
        return true;
    }

    boolean m251a(View view) {
        m265d();
        boolean f = this.f208f.m4199f(view);
        if (f) {
            C0724w e = m227e(view);
            this.f206d.m3753c(e);
            this.f206d.m3748b(e);
        }
        m248a(!f);
        return f;
    }

    boolean m252a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!m292n()) {
            return false;
        }
        int b = accessibilityEvent != null ? C0357a.m1687b(accessibilityEvent) : 0;
        if (b != 0) {
            i = b;
        }
        this.f202T = i | this.f202T;
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f215m == null || !this.f215m.m3403a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public C0724w m253b(int i) {
        if (this.f224v) {
            return null;
        }
        int c = this.f208f.m4192c();
        int i2 = 0;
        C0724w c0724w = null;
        while (i2 < c) {
            C0724w e = m227e(this.f208f.m4195d(i2));
            if (e == null || e.m3847q() || m263d(e) != i) {
                e = c0724w;
            } else if (!this.f208f.m4194c(e.f2170a)) {
                return e;
            }
            i2++;
            c0724w = e;
        }
        return c0724w;
    }

    public C0724w m254b(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return m227e(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void m255b() {
        if (this.f225w != null) {
            this.f225w.mo705d();
        }
        if (this.f215m != null) {
            this.f215m.m3423c(this.f206d);
            this.f215m.m3410b(this.f206d);
        }
        this.f206d.m3734a();
    }

    void m256b(C0724w c0724w, C0702c c0702c, C0702c c0702c2) {
        m228e(c0724w);
        c0724w.m3829a(false);
        if (this.f225w.mo693a(c0724w, c0702c, c0702c2)) {
            m293o();
        }
    }

    public boolean m257b(int i, int i2) {
        if (this.f215m == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f222t) {
            return false;
        } else {
            boolean d = this.f215m.mo624d();
            boolean e = this.f215m.mo626e();
            if (!d || Math.abs(i) < this.ao) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.ao) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            d = d || e;
            dispatchNestedFling((float) i, (float) i2, d);
            if (this.an != null && this.an.m3709a(i, i2)) {
                return true;
            }
            if (!d) {
                return false;
            }
            this.f226x.m3803a(Math.max(-this.ap, Math.min(i, this.ap)), Math.max(-this.ap, Math.min(i2, this.ap)));
            return true;
        }
    }

    boolean m258b(C0724w c0724w) {
        return this.f225w == null || this.f225w.mo702a(c0724w, c0724w.m3851u());
    }

    public View m259c(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    void m260c() {
        if (!this.f220r || this.f224v) {
            C0314e.m1529a("RV FullInvalidate");
            m294p();
            C0314e.m1528a();
        } else if (!this.f207e.m4695d()) {
        } else {
            if (this.f207e.m4690a(4) && !this.f207e.m4690a(11)) {
                C0314e.m1529a("RV PartialInvalidate");
                m265d();
                m287k();
                this.f207e.m4692b();
                if (!this.f221s) {
                    if (m194A()) {
                        m294p();
                    } else {
                        this.f207e.m4694c();
                    }
                }
                m248a(true);
                m288l();
                C0314e.m1528a();
            } else if (this.f207e.m4695d()) {
                C0314e.m1529a("RV FullInvalidate");
                m294p();
                C0314e.m1528a();
            }
        }
    }

    public void m261c(int i) {
        int b = this.f208f.m4189b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f208f.m4191b(i2).offsetTopAndBottom(i);
        }
    }

    void m262c(int i, int i2) {
        int i3 = 0;
        if (!(this.ab == null || this.ab.m2397a() || i <= 0)) {
            i3 = this.ab.m2401b();
        }
        if (!(this.ad == null || this.ad.m2397a() || i >= 0)) {
            i3 |= this.ad.m2401b();
        }
        if (!(this.ac == null || this.ac.m2397a() || i2 <= 0)) {
            i3 |= this.ac.m2401b();
        }
        if (!(this.ae == null || this.ae.m2397a() || i2 >= 0)) {
            i3 |= this.ae.m2401b();
        }
        if (i3 != 0) {
            C0425s.m1958c(this);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0679i) && this.f215m.mo646a((C0679i) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return (this.f215m != null && this.f215m.mo624d()) ? this.f215m.mo625e(this.f189A) : 0;
    }

    public int computeHorizontalScrollOffset() {
        return (this.f215m != null && this.f215m.mo624d()) ? this.f215m.mo618c(this.f189A) : 0;
    }

    public int computeHorizontalScrollRange() {
        return (this.f215m != null && this.f215m.mo624d()) ? this.f215m.mo628g(this.f189A) : 0;
    }

    public int computeVerticalScrollExtent() {
        return (this.f215m != null && this.f215m.mo626e()) ? this.f215m.mo627f(this.f189A) : 0;
    }

    public int computeVerticalScrollOffset() {
        return (this.f215m != null && this.f215m.mo626e()) ? this.f215m.mo622d(this.f189A) : 0;
    }

    public int computeVerticalScrollRange() {
        return (this.f215m != null && this.f215m.mo626e()) ? this.f215m.mo629h(this.f189A) : 0;
    }

    int m263d(C0724w c0724w) {
        return (c0724w.m3830a(524) || !c0724w.m3846p()) ? -1 : this.f207e.m4693c(c0724w.f2172c);
    }

    public C0724w m264d(View view) {
        View c = m259c(view);
        return c == null ? null : m254b(c);
    }

    void m265d() {
        this.f200R++;
        if (this.f200R == 1 && !this.f222t) {
            this.f221s = false;
        }
    }

    public void m266d(int i) {
        int b = this.f208f.m4189b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f208f.m4191b(i2).offsetLeftAndRight(i);
        }
    }

    void m267d(int i, int i2) {
        if (i < 0) {
            m272f();
            this.ab.m2399a(-i);
        } else if (i > 0) {
            m276g();
            this.ad.m2399a(i);
        }
        if (i2 < 0) {
            m279h();
            this.ac.m2399a(-i2);
        } else if (i2 > 0) {
            m281i();
            this.ae.m2399a(i2);
        }
        if (i != 0 || i2 != 0) {
            C0425s.m1958c(this);
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m1825a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m1824a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m1830a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m1828a(i, i2, i3, i4, iArr);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.f217o.size();
        for (i = 0; i < size; i++) {
            ((C0705g) this.f217o.get(i)).m3705b(canvas, this, this.f189A);
        }
        if (this.ab == null || this.ab.m2397a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.f210h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.ab == null || !this.ab.m2400a(canvas)) ? 0 : 1;
            canvas.restoreToCount(i);
        }
        if (!(this.ac == null || this.ac.m2397a())) {
            size = canvas.save();
            if (this.f210h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.ac == null || !this.ac.m2400a(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.ad == null || this.ad.m2397a())) {
            size = canvas.save();
            int width = getWidth();
            i = this.f210h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.ad == null || !this.ad.m2400a(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.ae == null || this.ae.m2397a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.f210h) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.ae != null && this.ae.m2400a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.f225w == null || this.f217o.size() <= 0 || !this.f225w.mo703b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            C0425s.m1958c(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void m268e() {
        setScrollState(0);
        m195B();
    }

    public void m269e(int i) {
    }

    void m270e(int i, int i2) {
        setMeasuredDimension(C0681h.m3343a(i, getPaddingLeft() + getPaddingRight(), C0425s.m1974m(this)), C0681h.m3343a(i2, getPaddingTop() + getPaddingBottom(), C0425s.m1975n(this)));
    }

    @Deprecated
    public int m271f(View view) {
        return m275g(view);
    }

    void m272f() {
        if (this.ab == null) {
            this.ab = new C0494e(getContext());
            if (this.f210h) {
                this.ab.m2396a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ab.m2396a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m273f(int i) {
        if (this.f215m != null) {
            this.f215m.mo676k(i);
        }
        m269e(i);
        if (this.as != null) {
            this.as.m3713a(this, i);
        }
        if (this.at != null) {
            for (int size = this.at.size() - 1; size >= 0; size--) {
                ((C0711m) this.at.get(size)).m3713a(this, i);
            }
        }
    }

    void m274f(int i, int i2) {
        int i3;
        int c = this.f208f.m4192c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C0724w e = m227e(this.f208f.m4195d(i6));
            if (e != null && e.f2172c >= r3 && e.f2172c <= r2) {
                if (e.f2172c == i) {
                    e.m3826a(i2 - i, false);
                } else {
                    e.m3826a(i3, false);
                }
                this.f189A.f2151e = true;
            }
        }
        this.f206d.m3736a(i, i2);
        requestLayout();
    }

    public View focusSearch(View view, int i) {
        boolean z = true;
        View d = this.f215m.m3433d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = (this.f214l == null || this.f215m == null || m292n() || this.f222t) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            int i2;
            if (this.f215m.mo626e()) {
                i2 = i == 2 ? 130 : 33;
                boolean z3 = instance.findNextFocus(this, view, i2) == null;
                if (f184K) {
                    i = i2;
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                z2 = false;
            }
            if (z2 || !this.f215m.mo624d()) {
                z = z2;
            } else {
                i2 = ((i == 2 ? 1 : 0) ^ (this.f215m.m3470s() == 1 ? 1 : 0)) != 0 ? 66 : 17;
                if (instance.findNextFocus(this, view, i2) != null) {
                    z = false;
                }
                if (f184K) {
                    i = i2;
                }
            }
            if (z) {
                m260c();
                if (m259c(view) == null) {
                    return null;
                }
                m265d();
                this.f215m.mo608a(view, i, this.f206d, this.f189A);
                m248a(false);
            }
            d = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                m260c();
                if (m259c(view) == null) {
                    return null;
                }
                m265d();
                d = this.f215m.mo608a(view, i, this.f206d, this.f189A);
                m248a(false);
            } else {
                d = findNextFocus;
            }
        }
        return !m222a(view, d, i) ? super.focusSearch(view, i) : d;
    }

    public int m275g(View view) {
        C0724w e = m227e(view);
        return e != null ? e.m3835e() : -1;
    }

    void m276g() {
        if (this.ad == null) {
            this.ad = new C0494e(getContext());
            if (this.f210h) {
                this.ad.m2396a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ad.m2396a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m277g(int i, int i2) {
        int c = this.f208f.m4192c();
        for (int i3 = 0; i3 < c; i3++) {
            C0724w e = m227e(this.f208f.m4195d(i3));
            if (!(e == null || e.m3833c() || e.f2172c < i)) {
                e.m3826a(i2, false);
                this.f189A.f2151e = true;
            }
        }
        this.f206d.m3747b(i, i2);
        requestLayout();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.f215m != null) {
            return this.f215m.mo607a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f215m != null) {
            return this.f215m.mo633a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.f215m != null) {
            return this.f215m.mo634a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public C0696a getAdapter() {
        return this.f214l;
    }

    public int getBaseline() {
        return this.f215m != null ? this.f215m.m3471t() : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.av == null ? super.getChildDrawingOrder(i, i2) : this.av.m3672a(i, i2);
    }

    public boolean getClipToPadding() {
        return this.f210h;
    }

    public ay getCompatAccessibilityDelegate() {
        return this.f193E;
    }

    public C0703e getItemAnimator() {
        return this.f225w;
    }

    public C0681h getLayoutManager() {
        return this.f215m;
    }

    public int getMaxFlingVelocity() {
        return this.ap;
    }

    public int getMinFlingVelocity() {
        return this.ao;
    }

    long getNanoTime() {
        return f183J ? System.nanoTime() : 0;
    }

    public C0709k getOnFlingListener() {
        return this.an;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ar;
    }

    public C0713n getRecycledViewPool() {
        return this.f206d.m3762g();
    }

    public int getScrollState() {
        return this.af;
    }

    public int m278h(View view) {
        C0724w e = m227e(view);
        return e != null ? e.m3834d() : -1;
    }

    void m279h() {
        if (this.ac == null) {
            this.ac = new C0494e(getContext());
            if (this.f210h) {
                this.ac.m2396a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ac.m2396a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void m280h(int i, int i2) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m1832b();
    }

    void m281i() {
        if (this.ae == null) {
            this.ae = new C0494e(getContext());
            if (this.f210h) {
                this.ae.m2396a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ae.m2396a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m282i(int i, int i2) {
        this.aa++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m280h(i, i2);
        if (this.as != null) {
            this.as.m3714a(this, i, i2);
        }
        if (this.at != null) {
            for (scrollY = this.at.size() - 1; scrollY >= 0; scrollY--) {
                ((C0711m) this.at.get(scrollY)).m3714a(this, i, i2);
            }
        }
        this.aa--;
    }

    public void m283i(View view) {
    }

    public boolean isAttachedToWindow() {
        return this.f218p;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m1823a();
    }

    void m284j() {
        this.ae = null;
        this.ac = null;
        this.ad = null;
        this.ab = null;
    }

    public void m285j(View view) {
    }

    Rect m286k(View view) {
        C0679i c0679i = (C0679i) view.getLayoutParams();
        if (!c0679i.f2029e) {
            return c0679i.f2028d;
        }
        if (this.f189A.m3792a() && (c0679i.m3339e() || c0679i.m3337c())) {
            return c0679i.f2028d;
        }
        Rect rect = c0679i.f2028d;
        rect.set(0, 0, 0, 0);
        int size = this.f217o.size();
        for (int i = 0; i < size; i++) {
            this.f212j.set(0, 0, 0, 0);
            ((C0705g) this.f217o.get(i)).m3703a(this.f212j, view, this, this.f189A);
            rect.left += this.f212j.left;
            rect.top += this.f212j.top;
            rect.right += this.f212j.right;
            rect.bottom += this.f212j.bottom;
        }
        c0679i.f2029e = false;
        return rect;
    }

    void m287k() {
        this.f205W++;
    }

    void m288l() {
        this.f205W--;
        if (this.f205W < 1) {
            this.f205W = 0;
            m199F();
            m302x();
        }
    }

    void m289m(View view) {
        C0724w e = m227e(view);
        m285j(view);
        if (!(this.f214l == null || e == null)) {
            this.f214l.m3669d(e);
        }
        if (this.f204V != null) {
            for (int size = this.f204V.size() - 1; size >= 0; size--) {
                ((C0708j) this.f204V.get(size)).m3708b(view);
            }
        }
    }

    boolean m290m() {
        return this.f203U != null && this.f203U.isEnabled();
    }

    void m291n(View view) {
        C0724w e = m227e(view);
        m283i(view);
        if (!(this.f214l == null || e == null)) {
            this.f214l.m3668c(e);
        }
        if (this.f204V != null) {
            for (int size = this.f204V.size() - 1; size >= 0; size--) {
                ((C0708j) this.f204V.get(size)).m3707a(view);
            }
        }
    }

    public boolean m292n() {
        return this.f205W > 0;
    }

    void m293o() {
        if (!this.f192D && this.f218p) {
            C0425s.m1950a((View) this, this.aB);
            this.f192D = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onAttachedToWindow() {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        super.onAttachedToWindow();
        r4.f205W = r1;
        r4.f218p = r0;
        r2 = r4.f220r;
        if (r2 == 0) goto L_0x0068;
    L_0x000d:
        r2 = r4.isLayoutRequested();
        if (r2 != 0) goto L_0x0068;
    L_0x0013:
        r4.f220r = r0;
        r0 = r4.f215m;
        if (r0 == 0) goto L_0x001e;
    L_0x0019:
        r0 = r4.f215m;
        r0.m3425c(r4);
    L_0x001e:
        r4.f192D = r1;
        r0 = f183J;
        if (r0 == 0) goto L_0x0067;
    L_0x0024:
        r0 = android.support.v7.widget.ap.f2456a;
        r0 = r0.get();
        r0 = (android.support.v7.widget.ap) r0;
        r4.f227y = r0;
        r0 = r4.f227y;
        if (r0 != 0) goto L_0x0062;
    L_0x0032:
        r0 = new android.support.v7.widget.ap;
        r0.<init>();
        r4.f227y = r0;
        r0 = android.support.v4.p008h.C0425s.m1938C(r4);
        r1 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r4.isInEditMode();
        if (r2 != 0) goto L_0x006a;
    L_0x0045:
        if (r0 == 0) goto L_0x006a;
    L_0x0047:
        r0 = r0.getRefreshRate();
        r2 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x006a;
    L_0x0051:
        r1 = r4.f227y;
        r2 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r0 = r2 / r0;
        r2 = (long) r0;
        r1.f2460d = r2;
        r0 = android.support.v7.widget.ap.f2456a;
        r1 = r4.f227y;
        r0.set(r1);
    L_0x0062:
        r0 = r4.f227y;
        r0.m4320a(r4);
    L_0x0067:
        return;
    L_0x0068:
        r0 = r1;
        goto L_0x0013;
    L_0x006a:
        r0 = r1;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225w != null) {
            this.f225w.mo705d();
        }
        m268e();
        this.f218p = false;
        if (this.f215m != null) {
            this.f215m.m3413b(this, this.f206d);
        }
        this.f194F.clear();
        removeCallbacks(this.aB);
        this.f209g.m4605b();
        if (f183J) {
            this.f227y.m4322b(this);
            this.f227y = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f217o.size();
        for (int i = 0; i < size; i++) {
            ((C0705g) this.f217o.get(i)).m3701a(canvas, this, this.f189A);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f215m == null || this.f222t || (motionEvent.getSource() & 2) == 0 || motionEvent.getAction() != 8)) {
            float f = this.f215m.mo626e() ? -C0407h.m1817a(motionEvent, 9) : 0.0f;
            float a = this.f215m.mo624d() ? C0407h.m1817a(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && a == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m249a((int) (a * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.f222t) {
            return false;
        }
        if (m221a(motionEvent)) {
            m198E();
            return true;
        } else if (this.f215m == null) {
            return false;
        } else {
            boolean d = this.f215m.mo624d();
            boolean e = this.f215m.mo626e();
            if (this.ah == null) {
                this.ah = VelocityTracker.obtain();
            }
            this.ah.addMovement(motionEvent);
            int a = C0407h.m1818a(motionEvent);
            int b = C0407h.m1819b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.f201S) {
                        this.f201S = false;
                    }
                    this.ag = motionEvent.getPointerId(0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.ak = i;
                    this.ai = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.al = i;
                    this.aj = i;
                    if (this.af == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aA;
                    this.aA[1] = 0;
                    iArr[0] = 0;
                    i2 = d ? 1 : 0;
                    if (e) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.ah.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    a = motionEvent.findPointerIndex(this.ag);
                    if (a >= 0) {
                        b = (int) (motionEvent.getX(a) + 0.5f);
                        a = (int) (motionEvent.getY(a) + 0.5f);
                        if (this.af != 1) {
                            b -= this.ai;
                            a -= this.aj;
                            if (!d || Math.abs(b) <= this.am) {
                                d = false;
                            } else {
                                this.ak = ((b < 0 ? -1 : 1) * this.am) + this.ai;
                                d = true;
                            }
                            if (e && Math.abs(a) > this.am) {
                                i2 = this.aj;
                                int i3 = this.am;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.al = i2 + (i * i3);
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ag + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m198E();
                    break;
                case 5:
                    this.ag = motionEvent.getPointerId(b);
                    i2 = (int) (motionEvent.getX(b) + 0.5f);
                    this.ak = i2;
                    this.ai = i2;
                    i2 = (int) (motionEvent.getY(b) + 0.5f);
                    this.al = i2;
                    this.aj = i2;
                    break;
                case 6:
                    m226c(motionEvent);
                    break;
            }
            if (this.af != 1) {
                z = false;
            }
            return z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0314e.m1529a("RV OnLayout");
        m294p();
        C0314e.m1528a();
        this.f220r = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f215m == null) {
            m270e(i, i2);
        } else if (this.f215m.f2044u) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f215m.m3375a(this.f206d, this.f189A, i, i2);
            if (!z && this.f214l != null) {
                if (this.f189A.f2149c == 1) {
                    m206M();
                }
                this.f215m.m3409b(i, i2);
                this.f189A.f2154h = true;
                m207N();
                this.f215m.m3422c(i, i2);
                if (this.f215m.mo630k()) {
                    this.f215m.m3409b(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f189A.f2154h = true;
                    m207N();
                    this.f215m.m3422c(i, i2);
                }
            }
        } else if (this.f219q) {
            this.f215m.m3375a(this.f206d, this.f189A, i, i2);
        } else {
            if (this.f223u) {
                m265d();
                m201H();
                if (this.f189A.f2156j) {
                    this.f189A.f2152f = true;
                } else {
                    this.f207e.m4696e();
                    this.f189A.f2152f = false;
                }
                this.f223u = false;
                m248a(false);
            }
            if (this.f214l != null) {
                this.f189A.f2150d = this.f214l.mo839a();
            } else {
                this.f189A.f2150d = 0;
            }
            m265d();
            this.f215m.m3375a(this.f206d, this.f189A, i, i2);
            m248a(false);
            this.f189A.f2152f = false;
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        return m292n() ? false : super.onRequestFocusInDescendants(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0718r) {
            this.f196N = (C0718r) parcelable;
            super.onRestoreInstanceState(this.f196N.m320a());
            if (this.f215m != null && this.f196N.f2132a != null) {
                this.f215m.mo611a(this.f196N.f2132a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        C0718r c0718r = new C0718r(super.onSaveInstanceState());
        if (this.f196N != null) {
            c0718r.m3773a(this.f196N);
        } else if (this.f215m != null) {
            c0718r.f2132a = this.f215m.mo619c();
        } else {
            c0718r.f2132a = null;
        }
        return c0718r;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m284j();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f222t || this.f201S) {
            return false;
        }
        if (m223b(motionEvent)) {
            m198E();
            return true;
        } else if (this.f215m == null) {
            return false;
        } else {
            boolean d = this.f215m.mo624d();
            boolean e = this.f215m.mo626e();
            if (this.ah == null) {
                this.ah = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = C0407h.m1818a(motionEvent);
            int b = C0407h.m1819b(motionEvent);
            if (a == 0) {
                int[] iArr = this.aA;
                this.aA[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.aA[0], (float) this.aA[1]);
            switch (a) {
                case 0:
                    this.ag = motionEvent.getPointerId(0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.ak = a;
                    this.ai = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.al = a;
                    this.aj = a;
                    a = d ? 1 : 0;
                    if (e) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case 1:
                    this.ah.addMovement(obtain);
                    this.ah.computeCurrentVelocity(1000, (float) this.ap);
                    float f = d ? -C0413r.m1848a(this.ah, this.ag) : 0.0f;
                    float f2 = e ? -C0413r.m1849b(this.ah, this.ag) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !m257b((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    m197D();
                    z = true;
                    break;
                case 2:
                    a = motionEvent.findPointerIndex(this.ag);
                    if (a >= 0) {
                        int x = (int) (motionEvent.getX(a) + 0.5f);
                        int y = (int) (motionEvent.getY(a) + 0.5f);
                        int i = this.ak - x;
                        a = this.al - y;
                        if (dispatchNestedPreScroll(i, a, this.az, this.ay)) {
                            i -= this.az[0];
                            a -= this.az[1];
                            obtain.offsetLocation((float) this.ay[0], (float) this.ay[1]);
                            int[] iArr2 = this.aA;
                            iArr2[0] = iArr2[0] + this.ay[0];
                            iArr2 = this.aA;
                            iArr2[1] = iArr2[1] + this.ay[1];
                        }
                        if (this.af != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.am) {
                                z2 = false;
                            } else {
                                i = i > 0 ? i - this.am : i + this.am;
                                z2 = true;
                            }
                            if (e && Math.abs(a) > this.am) {
                                a = a > 0 ? a - this.am : a + this.am;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.af == 1) {
                            this.ak = x - this.ay[0];
                            this.al = y - this.ay[1];
                            if (m249a(d ? i : 0, e ? a : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.f227y == null || (i == 0 && a == 0))) {
                                this.f227y.m4321a(this, i, a);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ag + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m198E();
                    break;
                case 5:
                    this.ag = motionEvent.getPointerId(b);
                    a = (int) (motionEvent.getX(b) + 0.5f);
                    this.ak = a;
                    this.ai = a;
                    a = (int) (motionEvent.getY(b) + 0.5f);
                    this.al = a;
                    this.aj = a;
                    break;
                case 6:
                    m226c(motionEvent);
                    break;
            }
            if (!z) {
                this.ah.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    void m294p() {
        if (this.f214l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f215m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f189A.f2154h = false;
            if (this.f189A.f2149c == 1) {
                m206M();
                this.f215m.m3447f(this);
                m207N();
            } else if (!this.f207e.m4697f() && this.f215m.m3475x() == getWidth() && this.f215m.m3476y() == getHeight()) {
                this.f215m.m3447f(this);
            } else {
                this.f215m.m3447f(this);
                m207N();
            }
            m208O();
        }
    }

    void m295q() {
        int c = this.f208f.m4192c();
        for (int i = 0; i < c; i++) {
            ((C0679i) this.f208f.m4195d(i).getLayoutParams()).f2029e = true;
        }
        this.f206d.m3766k();
    }

    void m296r() {
        int c = this.f208f.m4192c();
        for (int i = 0; i < c; i++) {
            C0724w e = m227e(this.f208f.m4195d(i));
            if (!e.m3833c()) {
                e.m3831b();
            }
        }
    }

    protected void removeDetachedView(View view, boolean z) {
        C0724w e = m227e(view);
        if (e != null) {
            if (e.m3848r()) {
                e.m3843m();
            } else if (!e.m3833c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e);
            }
        }
        m289m(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f215m.m3400a(this, this.f189A, view, view2) || view2 == null)) {
            this.f212j.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof C0679i) {
                C0679i c0679i = (C0679i) layoutParams;
                if (!c0679i.f2029e) {
                    Rect rect = c0679i.f2028d;
                    Rect rect2 = this.f212j;
                    rect2.left -= rect.left;
                    rect2 = this.f212j;
                    rect2.right += rect.right;
                    rect2 = this.f212j;
                    rect2.top -= rect.top;
                    rect2 = this.f212j;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f212j);
            offsetRectIntoDescendantCoords(view, this.f212j);
            requestChildRectangleOnScreen(view, this.f212j, !this.f220r);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f215m.m3401a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f198P.size();
        for (int i = 0; i < size; i++) {
            ((C0710l) this.f198P.get(i)).mo842a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.f200R != 0 || this.f222t) {
            this.f221s = true;
        } else {
            super.requestLayout();
        }
    }

    void m297s() {
        int c = this.f208f.m4192c();
        for (int i = 0; i < c; i++) {
            C0724w e = m227e(this.f208f.m4195d(i));
            if (!e.m3833c()) {
                e.m3823a();
            }
        }
        this.f206d.m3765j();
    }

    public void scrollBy(int i, int i2) {
        if (this.f215m == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f222t) {
            boolean d = this.f215m.mo624d();
            boolean e = this.f215m.mo626e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                m249a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m252a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(ay ayVar) {
        this.f193E = ayVar;
        C0425s.m1948a((View) this, this.f193E);
    }

    public void setAdapter(C0696a c0696a) {
        setLayoutFrozen(false);
        m213a(c0696a, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C0699d c0699d) {
        if (c0699d != this.av) {
            this.av = c0699d;
            setChildrenDrawingOrderEnabled(this.av != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f210h) {
            m284j();
        }
        this.f210h = z;
        super.setClipToPadding(z);
        if (this.f220r) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.f219q = z;
    }

    public void setItemAnimator(C0703e c0703e) {
        if (this.f225w != null) {
            this.f225w.mo705d();
            this.f225w.m3681a(null);
        }
        this.f225w = c0703e;
        if (this.f225w != null) {
            this.f225w.m3681a(this.au);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f206d.m3735a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f222t) {
            m247a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f222t = true;
                this.f201S = true;
                m268e();
                return;
            }
            this.f222t = false;
            if (!(!this.f221s || this.f215m == null || this.f214l == null)) {
                requestLayout();
            }
            this.f221s = false;
        }
    }

    public void setLayoutManager(C0681h c0681h) {
        if (c0681h != this.f215m) {
            m268e();
            if (this.f215m != null) {
                if (this.f225w != null) {
                    this.f225w.mo705d();
                }
                this.f215m.m3423c(this.f206d);
                this.f215m.m3410b(this.f206d);
                this.f206d.m3734a();
                if (this.f218p) {
                    this.f215m.m3413b(this, this.f206d);
                }
                this.f215m.m3411b(null);
                this.f215m = null;
            } else {
                this.f206d.m3734a();
            }
            this.f208f.m4183a();
            this.f215m = c0681h;
            if (c0681h != null) {
                if (c0681h.f2040q != null) {
                    throw new IllegalArgumentException("LayoutManager " + c0681h + " is already attached to a RecyclerView: " + c0681h.f2040q);
                }
                this.f215m.m3411b(this);
                if (this.f218p) {
                    this.f215m.m3425c(this);
                }
            }
            this.f206d.m3746b();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m1822a(z);
    }

    public void setOnFlingListener(C0709k c0709k) {
        this.an = c0709k;
    }

    @Deprecated
    public void setOnScrollListener(C0711m c0711m) {
        this.as = c0711m;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ar = z;
    }

    public void setRecycledViewPool(C0713n c0713n) {
        this.f206d.m3739a(c0713n);
    }

    public void setRecyclerListener(C0715p c0715p) {
        this.f216n = c0715p;
    }

    void setScrollState(int i) {
        if (i != this.af) {
            this.af = i;
            if (i != 2) {
                m195B();
            }
            m273f(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.am = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.am = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(C0722u c0722u) {
        this.f206d.m3740a(c0722u);
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m1833b(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().m1834c();
    }

    void m298t() {
        if (!this.f224v) {
            this.f224v = true;
            int c = this.f208f.m4192c();
            for (int i = 0; i < c; i++) {
                C0724w e = m227e(this.f208f.m4195d(i));
                if (!(e == null || e.m3833c())) {
                    e.m3832b(512);
                }
            }
            this.f206d.m3763h();
            m299u();
        }
    }

    void m299u() {
        int c = this.f208f.m4192c();
        for (int i = 0; i < c; i++) {
            C0724w e = m227e(this.f208f.m4195d(i));
            if (!(e == null || e.m3833c())) {
                e.m3832b(6);
            }
        }
        m295q();
        this.f206d.m3764i();
    }

    public boolean m300v() {
        return !this.f220r || this.f224v || this.f207e.m4695d();
    }

    void m301w() {
        int b = this.f208f.m4189b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f208f.m4191b(i);
            C0724w b3 = m254b(b2);
            if (!(b3 == null || b3.f2178i == null)) {
                View view = b3.f2178i.f2170a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void m302x() {
        for (int size = this.f194F.size() - 1; size >= 0; size--) {
            C0724w c0724w = (C0724w) this.f194F.get(size);
            if (c0724w.f2170a.getParent() == this && !c0724w.m3833c()) {
                int i = c0724w.f2181l;
                if (i != -1) {
                    C0425s.m1960c(c0724w.f2170a, i);
                    c0724w.f2181l = -1;
                }
            }
        }
        this.f194F.clear();
    }
}
