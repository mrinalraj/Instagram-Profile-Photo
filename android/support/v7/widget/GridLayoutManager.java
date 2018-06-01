package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v4.p008h.p019a.C0369b.C0368k;
import android.support.v7.widget.LinearLayoutManager.C0682a;
import android.support.v7.widget.LinearLayoutManager.C0683b;
import android.support.v7.widget.LinearLayoutManager.C0684c;
import android.support.v7.widget.RecyclerView.C0679i;
import android.support.v7.widget.RecyclerView.C0681h;
import android.support.v7.widget.RecyclerView.C0681h.C0706a;
import android.support.v7.widget.RecyclerView.C0714o;
import android.support.v7.widget.RecyclerView.C0721t;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f2062a = false;
    int f2063b = -1;
    int[] f2064c;
    View[] f2065d;
    final SparseIntArray f2066e = new SparseIntArray();
    final SparseIntArray f2067f = new SparseIntArray();
    C0677c f2068g = new C0678a();
    final Rect f2069h = new Rect();

    public static abstract class C0677c {
        final SparseIntArray f2025a = new SparseIntArray();
        private boolean f2026b = false;

        public abstract int mo604a(int i);

        public int mo605a(int i, int i2) {
            int a = mo604a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f2026b && this.f2025a.size() > 0) {
                b = m3332b(i);
                if (b >= 0) {
                    a2 = this.f2025a.get(b) + mo604a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = mo604a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    return a2 + a > i2 ? a2 : 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = mo604a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
            }
        }

        public void m3331a() {
            this.f2025a.clear();
        }

        int m3332b(int i) {
            int i2 = 0;
            int size = this.f2025a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f2025a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            return (size < 0 || size >= this.f2025a.size()) ? -1 : this.f2025a.keyAt(size);
        }

        int m3333b(int i, int i2) {
            if (!this.f2026b) {
                return mo605a(i, i2);
            }
            int i3 = this.f2025a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = mo605a(i, i2);
            this.f2025a.put(i, i3);
            return i3;
        }

        public int m3334c(int i, int i2) {
            int a = mo604a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = mo604a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            return i5 + a > i2 ? i4 + 1 : i4;
        }
    }

    public static final class C0678a extends C0677c {
        public int mo604a(int i) {
            return 1;
        }

        public int mo605a(int i, int i2) {
            return i % i2;
        }
    }

    public static class C0680b extends C0679i {
        int f2031a = -1;
        int f2032b = 0;

        public C0680b(int i, int i2) {
            super(i, i2);
        }

        public C0680b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0680b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0680b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int m3341a() {
            return this.f2031a;
        }

        public int m3342b() {
            return this.f2032b;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m3571a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m3571a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3571a(C0681h.m3345a(context, attributeSet, i, i2).f2113b);
    }

    private void m3549J() {
        this.f2066e.clear();
        this.f2067f.clear();
    }

    private void m3550K() {
        int u = m3472u();
        for (int i = 0; i < u; i++) {
            C0680b c0680b = (C0680b) m3453h(i).getLayoutParams();
            int f = c0680b.m3340f();
            this.f2066e.put(f, c0680b.m3342b());
            this.f2067f.put(f, c0680b.m3341a());
        }
    }

    private void m3551L() {
        m3562l(m3538f() == 1 ? (m3475x() - m3353B()) - m3477z() : (m3476y() - m3354C()) - m3352A());
    }

    private void m3552M() {
        if (this.f2065d == null || this.f2065d.length != this.f2063b) {
            this.f2065d = new View[this.f2063b];
        }
    }

    private int m3553a(C0714o c0714o, C0721t c0721t, int i) {
        if (!c0721t.m3792a()) {
            return this.f2068g.m3334c(i, this.f2063b);
        }
        int b = c0714o.m3744b(i);
        if (b != -1) {
            return this.f2068g.m3334c(b, this.f2063b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void m3554a(float f, int i) {
        m3562l(Math.max(Math.round(((float) this.f2063b) * f), i));
    }

    private void m3555a(C0714o c0714o, C0721t c0721t, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i3 = i - 1;
            i = -1;
            i4 = i3;
            i3 = -1;
        }
        int i5 = 0;
        for (int i6 = i4; i6 != i; i6 += i3) {
            View view = this.f2065d[i6];
            C0680b c0680b = (C0680b) view.getLayoutParams();
            c0680b.f2032b = m3561c(c0714o, c0721t, m3432d(view));
            c0680b.f2031a = i5;
            i5 += c0680b.f2032b;
        }
    }

    private void m3556a(View view, int i, int i2, boolean z) {
        C0679i c0679i = (C0679i) view.getLayoutParams();
        if (z ? m3404a(view, i, i2, c0679i) : m3418b(view, i, i2, c0679i)) {
            view.measure(i, i2);
        }
    }

    private void m3557a(View view, int i, boolean z) {
        int a;
        C0680b c0680b = (C0680b) view.getLayoutParams();
        Rect rect = c0680b.d;
        int i2 = ((rect.top + rect.bottom) + c0680b.topMargin) + c0680b.bottomMargin;
        int i3 = c0680b.rightMargin + ((rect.right + rect.left) + c0680b.leftMargin);
        int a2 = mo631a(c0680b.f2031a, c0680b.f2032b);
        if (this.i == 1) {
            a2 = C0681h.m3344a(a2, i, i3, c0680b.width, false);
            a = C0681h.m3344a(this.j.mo729f(), m3474w(), i2, c0680b.height, true);
        } else {
            int a3 = C0681h.m3344a(a2, i, i2, c0680b.height, false);
            a2 = C0681h.m3344a(this.j.mo729f(), m3473v(), i3, c0680b.width, true);
            a = a3;
        }
        m3556a(view, a2, a, z);
    }

    static int[] m3558a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int m3559b(C0714o c0714o, C0721t c0721t, int i) {
        if (!c0721t.m3792a()) {
            return this.f2068g.m3333b(i, this.f2063b);
        }
        int i2 = this.f2067f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0714o.m3744b(i);
        if (i2 != -1) {
            return this.f2068g.m3333b(i2, this.f2063b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void m3560b(C0714o c0714o, C0721t c0721t, C0682a c0682a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m3559b(c0714o, c0721t, c0682a.f2070a);
        if (obj != null) {
            while (b > 0 && c0682a.f2070a > 0) {
                c0682a.f2070a--;
                b = m3559b(c0714o, c0721t, c0682a.f2070a);
            }
            return;
        }
        int e = c0721t.m3796e() - 1;
        int i2 = c0682a.f2070a;
        int i3 = b;
        while (i2 < e) {
            b = m3559b(c0714o, c0721t, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c0682a.f2070a = i2;
    }

    private int m3561c(C0714o c0714o, C0721t c0721t, int i) {
        if (!c0721t.m3792a()) {
            return this.f2068g.mo604a(i);
        }
        int i2 = this.f2066e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0714o.m3744b(i);
        if (i2 != -1) {
            return this.f2068g.mo604a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void m3562l(int i) {
        this.f2064c = m3558a(this.f2064c, this.f2063b, i);
    }

    int mo631a(int i, int i2) {
        return (this.i == 1 && m3541g()) ? this.f2064c[this.f2063b - i] - this.f2064c[(this.f2063b - i) - i2] : this.f2064c[i + i2] - this.f2064c[i];
    }

    public int mo606a(int i, C0714o c0714o, C0721t c0721t) {
        m3551L();
        m3552M();
        return super.mo606a(i, c0714o, c0721t);
    }

    public int mo632a(C0714o c0714o, C0721t c0721t) {
        return this.i == 0 ? this.f2063b : c0721t.m3796e() < 1 ? 0 : m3553a(c0714o, c0721t, c0721t.m3796e() - 1) + 1;
    }

    public C0679i mo607a() {
        return this.i == 0 ? new C0680b(-2, -1) : new C0680b(-1, -2);
    }

    public C0679i mo633a(Context context, AttributeSet attributeSet) {
        return new C0680b(context, attributeSet);
    }

    public C0679i mo634a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0680b((MarginLayoutParams) layoutParams) : new C0680b(layoutParams);
    }

    View mo635a(C0714o c0714o, C0721t c0721t, int i, int i2, int i3) {
        View view = null;
        m3543h();
        int c = this.j.mo723c();
        int d = this.j.mo725d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3453h(i);
            int d2 = m3432d(h);
            if (d2 >= 0 && d2 < i3) {
                if (m3559b(c0714o, c0721t, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((C0679i) h.getLayoutParams()).m3338d()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.mo720a(h) < d && this.j.mo722b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View mo608a(View view, int i, C0714o c0714o, C0721t c0721t) {
        View e = m3439e(view);
        if (e == null) {
            return null;
        }
        C0680b c0680b = (C0680b) e.getLayoutParams();
        int i2 = c0680b.f2031a;
        int i3 = c0680b.f2031a + c0680b.f2032b;
        if (super.mo608a(view, i, c0714o, c0721t) == null) {
            return null;
        }
        int u;
        int i4;
        int i5;
        if (((m3535e(i) == 1) != this.k ? 1 : null) != null) {
            u = m3472u() - 1;
            i4 = -1;
            i5 = -1;
        } else {
            u = 0;
            i4 = 1;
            i5 = m3472u();
        }
        Object obj = (this.i == 1 && m3541g()) ? 1 : null;
        View view2 = null;
        int i6 = -1;
        int i7 = 0;
        int i8 = u;
        while (i8 != i5) {
            View h = m3453h(i8);
            if (h == e) {
                break;
            }
            View view3;
            if (h.isFocusable()) {
                c0680b = (C0680b) h.getLayoutParams();
                int i9 = c0680b.f2031a;
                int i10 = c0680b.f2031a + c0680b.f2032b;
                if (i9 == i2 && i10 == i3) {
                    return h;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(i10, i3) - Math.max(i9, i2);
                    if (min > i7) {
                        obj2 = 1;
                    } else if (min == i7) {
                        if (obj == (i9 > i6 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i7 = c0680b.f2031a;
                    u = Math.min(i10, i3) - Math.max(i9, i2);
                    view3 = h;
                } else {
                    u = i7;
                    i7 = i6;
                    view3 = view2;
                }
            } else {
                u = i7;
                i7 = i6;
                view3 = view2;
            }
            i8 += i4;
            view2 = view3;
            i6 = i7;
            i7 = u;
        }
        return view2;
    }

    public void m3571a(int i) {
        if (i != this.f2063b) {
            this.f2062a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f2063b = i;
            this.f2068g.m3331a();
            m3464n();
        }
    }

    public void mo636a(Rect rect, int i, int i2) {
        if (this.f2064c == null) {
            super.mo636a(rect, i, i2);
        }
        int B = m3353B() + m3477z();
        int A = m3352A() + m3354C();
        if (this.i == 1) {
            A = C0681h.m3343a(i2, A + rect.height(), m3357F());
            B = C0681h.m3343a(i, B + this.f2064c[this.f2064c.length - 1], m3356E());
        } else {
            B = C0681h.m3343a(i, B + rect.width(), m3356E());
            A = C0681h.m3343a(i2, A + this.f2064c[this.f2064c.length - 1], m3357F());
        }
        m3440e(B, A);
    }

    void mo637a(C0714o c0714o, C0721t c0721t, C0682a c0682a, int i) {
        super.mo637a(c0714o, c0721t, c0682a, i);
        m3551L();
        if (c0721t.m3796e() > 0 && !c0721t.m3792a()) {
            m3560b(c0714o, c0721t, c0682a, i);
        }
        m3552M();
    }

    void mo638a(C0714o c0714o, C0721t c0721t, C0684c c0684c, C0683b c0683b) {
        int i = this.j.mo733i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m3472u() > 0 ? this.f2064c[this.f2063b] : 0;
        if (obj != null) {
            m3551L();
        }
        boolean z = c0684c.f2083e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f2063b;
        if (!z) {
            i5 = m3559b(c0714o, c0721t, c0684c.f2082d) + m3561c(c0714o, c0721t, c0684c.f2082d);
        }
        while (i3 < this.f2063b && c0684c.m3599a(c0721t) && i5 > 0) {
            int i6 = c0684c.f2082d;
            int c = m3561c(c0714o, c0721t, i6);
            if (c <= this.f2063b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = c0684c.m3596a(c0714o);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f2065d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f2063b + " spans.");
        }
        if (i3 == 0) {
            c0683b.f2076b = true;
            return;
        }
        C0680b c0680b;
        int i7;
        int a2;
        m3555a(c0714o, c0721t, i3, i4, z);
        i4 = 0;
        float f = 0.0f;
        i6 = 0;
        while (i4 < i3) {
            View view = this.f2065d[i4];
            if (c0684c.f2089k == null) {
                if (z) {
                    m3414b(view);
                } else {
                    m3415b(view, 0);
                }
            } else if (z) {
                m3385a(view);
            } else {
                m3386a(view, 0);
            }
            m3416b(view, this.f2069h);
            m3557a(view, i, false);
            i5 = this.j.mo728e(view);
            if (i5 > i6) {
                i6 = i5;
            }
            float f2 = (((float) this.j.mo730f(view)) * 1.0f) / ((float) ((C0680b) view.getLayoutParams()).f2032b);
            if (f2 <= f) {
                f2 = f;
            }
            i4++;
            f = f2;
        }
        if (obj != null) {
            m3554a(f, i2);
            i6 = 0;
            c = 0;
            while (c < i3) {
                View view2 = this.f2065d[c];
                m3557a(view2, 1073741824, true);
                i5 = this.j.mo728e(view2);
                if (i5 <= i6) {
                    i5 = i6;
                }
                c++;
                i6 = i5;
            }
        }
        for (i4 = 0; i4 < i3; i4++) {
            View view3 = this.f2065d[i4];
            if (this.j.mo728e(view3) != i6) {
                c0680b = (C0680b) view3.getLayoutParams();
                Rect rect = c0680b.d;
                i7 = ((rect.top + rect.bottom) + c0680b.topMargin) + c0680b.bottomMargin;
                c = ((rect.right + rect.left) + c0680b.leftMargin) + c0680b.rightMargin;
                a2 = mo631a(c0680b.f2031a, c0680b.f2032b);
                if (this.i == 1) {
                    c = C0681h.m3344a(a2, 1073741824, c, c0680b.width, false);
                    i5 = MeasureSpec.makeMeasureSpec(i6 - i7, 1073741824);
                } else {
                    c = MeasureSpec.makeMeasureSpec(i6 - c, 1073741824);
                    i5 = C0681h.m3344a(a2, 1073741824, i7, c0680b.height, false);
                }
                m3556a(view3, c, i5, true);
            }
        }
        c0683b.f2075a = i6;
        i5 = 0;
        if (this.i == 1) {
            if (c0684c.f2084f == -1) {
                i5 = c0684c.f2080b;
                i6 = i5 - i6;
                c = 0;
                i4 = 0;
            } else {
                c = c0684c.f2080b;
                i5 = c + i6;
                i6 = c;
                c = 0;
                i4 = 0;
            }
        } else if (c0684c.f2084f == -1) {
            i4 = c0684c.f2080b;
            c = i4;
            i4 -= i6;
            i6 = 0;
        } else {
            i4 = c0684c.f2080b;
            c = i6 + i4;
            i6 = 0;
        }
        i2 = i5;
        a2 = i6;
        int i8 = c;
        i7 = i4;
        for (i6 = 0; i6 < i3; i6++) {
            view3 = this.f2065d[i6];
            c0680b = (C0680b) view3.getLayoutParams();
            if (this.i != 1) {
                a2 = m3352A() + this.f2064c[c0680b.f2031a];
                i2 = a2 + this.j.mo730f(view3);
            } else if (m3541g()) {
                i8 = m3477z() + this.f2064c[this.f2063b - c0680b.f2031a];
                i7 = i8 - this.j.mo730f(view3);
            } else {
                i7 = m3477z() + this.f2064c[c0680b.f2031a];
                i8 = i7 + this.j.mo730f(view3);
            }
            m3388a(view3, i7, a2, i8, i2);
            if (c0680b.m3338d() || c0680b.m3339e()) {
                c0683b.f2077c = true;
            }
            c0683b.f2078d |= view3.isFocusable();
        }
        Arrays.fill(this.f2065d, null);
    }

    public void mo639a(C0714o c0714o, C0721t c0721t, View view, C0369b c0369b) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0680b) {
            C0680b c0680b = (C0680b) layoutParams;
            int a = m3553a(c0714o, c0721t, c0680b.m3340f());
            if (this.i == 0) {
                int a2 = c0680b.m3341a();
                int b = c0680b.m3342b();
                boolean z = this.f2063b > 1 && c0680b.m3342b() == this.f2063b;
                c0369b.m1712b(C0368k.m1701a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = c0680b.m3341a();
            int b2 = c0680b.m3342b();
            boolean z2 = this.f2063b > 1 && c0680b.m3342b() == this.f2063b;
            c0369b.m1712b(C0368k.m1701a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m3391a(view, c0369b);
    }

    public void mo612a(C0721t c0721t) {
        super.mo612a(c0721t);
        this.f2062a = false;
    }

    void mo640a(C0721t c0721t, C0684c c0684c, C0706a c0706a) {
        int i = this.f2063b;
        for (int i2 = 0; i2 < this.f2063b && c0684c.m3599a(c0721t) && i > 0; i2++) {
            int i3 = c0684c.f2082d;
            c0706a.mo708b(i3, c0684c.f2085g);
            i -= this.f2068g.mo604a(i3);
            c0684c.f2082d += c0684c.f2083e;
        }
    }

    public void mo641a(RecyclerView recyclerView) {
        this.f2068g.m3331a();
    }

    public void mo642a(RecyclerView recyclerView, int i, int i2) {
        this.f2068g.m3331a();
    }

    public void mo643a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f2068g.m3331a();
    }

    public void mo644a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f2068g.m3331a();
    }

    public void mo645a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo645a(false);
    }

    public boolean mo646a(C0679i c0679i) {
        return c0679i instanceof C0680b;
    }

    public int mo616b(int i, C0714o c0714o, C0721t c0721t) {
        m3551L();
        m3552M();
        return super.mo616b(i, c0714o, c0721t);
    }

    public int mo647b(C0714o c0714o, C0721t c0721t) {
        return this.i == 1 ? this.f2063b : c0721t.m3796e() < 1 ? 0 : m3553a(c0714o, c0721t, c0721t.m3796e() - 1) + 1;
    }

    public void mo648b(RecyclerView recyclerView, int i, int i2) {
        this.f2068g.m3331a();
    }

    public boolean mo617b() {
        return this.n == null && !this.f2062a;
    }

    public void mo621c(C0714o c0714o, C0721t c0721t) {
        if (c0721t.m3792a()) {
            m3550K();
        }
        super.mo621c(c0714o, c0721t);
        m3549J();
    }
}
