package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p008h.p019a.C0357a;
import android.support.v4.p008h.p019a.C0386f;
import android.support.v7.widget.RecyclerView.C0679i;
import android.support.v7.widget.RecyclerView.C0681h;
import android.support.v7.widget.RecyclerView.C0681h.C0706a;
import android.support.v7.widget.RecyclerView.C0681h.C0707b;
import android.support.v7.widget.RecyclerView.C0714o;
import android.support.v7.widget.RecyclerView.C0721t;
import android.support.v7.widget.RecyclerView.C0724w;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends C0681h {
    private C0684c f2047a;
    private boolean f2048b;
    private boolean f2049c;
    private boolean f2050d;
    private boolean f2051e;
    private boolean f2052f;
    private final C0683b f2053g;
    private int f2054h;
    int f2055i;
    ax f2056j;
    boolean f2057k;
    int f2058l;
    int f2059m;
    C0686d f2060n;
    final C0682a f2061o;

    class C0682a {
        int f2070a;
        int f2071b;
        boolean f2072c;
        boolean f2073d;
        final /* synthetic */ LinearLayoutManager f2074e;

        C0682a(LinearLayoutManager linearLayoutManager) {
            this.f2074e = linearLayoutManager;
            m3589a();
        }

        void m3589a() {
            this.f2070a = -1;
            this.f2071b = Integer.MIN_VALUE;
            this.f2072c = false;
            this.f2073d = false;
        }

        public void m3590a(View view) {
            int b = this.f2074e.f2056j.m4382b();
            if (b >= 0) {
                m3593b(view);
                return;
            }
            this.f2070a = this.f2074e.m3432d(view);
            int e;
            if (this.f2072c) {
                b = (this.f2074e.f2056j.mo725d() - b) - this.f2074e.f2056j.mo722b(view);
                this.f2071b = this.f2074e.f2056j.mo725d() - b;
                if (b > 0) {
                    e = this.f2071b - this.f2074e.f2056j.mo728e(view);
                    int c = this.f2074e.f2056j.mo723c();
                    e -= c + Math.min(this.f2074e.f2056j.mo720a(view) - c, 0);
                    if (e < 0) {
                        this.f2071b = Math.min(b, -e) + this.f2071b;
                        return;
                    }
                    return;
                }
                return;
            }
            e = this.f2074e.f2056j.mo720a(view);
            c = e - this.f2074e.f2056j.mo723c();
            this.f2071b = e;
            if (c > 0) {
                b = (this.f2074e.f2056j.mo725d() - Math.min(0, (this.f2074e.f2056j.mo725d() - b) - this.f2074e.f2056j.mo722b(view))) - (e + this.f2074e.f2056j.mo728e(view));
                if (b < 0) {
                    this.f2071b -= Math.min(c, -b);
                }
            }
        }

        boolean m3591a(View view, C0721t c0721t) {
            C0679i c0679i = (C0679i) view.getLayoutParams();
            return !c0679i.m3338d() && c0679i.m3340f() >= 0 && c0679i.m3340f() < c0721t.m3796e();
        }

        void m3592b() {
            this.f2071b = this.f2072c ? this.f2074e.f2056j.mo725d() : this.f2074e.f2056j.mo723c();
        }

        public void m3593b(View view) {
            if (this.f2072c) {
                this.f2071b = this.f2074e.f2056j.mo722b(view) + this.f2074e.f2056j.m4382b();
            } else {
                this.f2071b = this.f2074e.f2056j.mo720a(view);
            }
            this.f2070a = this.f2074e.m3432d(view);
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2070a + ", mCoordinate=" + this.f2071b + ", mLayoutFromEnd=" + this.f2072c + ", mValid=" + this.f2073d + '}';
        }
    }

    protected static class C0683b {
        public int f2075a;
        public boolean f2076b;
        public boolean f2077c;
        public boolean f2078d;

        protected C0683b() {
        }

        void m3594a() {
            this.f2075a = 0;
            this.f2076b = false;
            this.f2077c = false;
            this.f2078d = false;
        }
    }

    static class C0684c {
        boolean f2079a = true;
        int f2080b;
        int f2081c;
        int f2082d;
        int f2083e;
        int f2084f;
        int f2085g;
        int f2086h = 0;
        boolean f2087i = false;
        int f2088j;
        List<C0724w> f2089k = null;
        boolean f2090l;

        C0684c() {
        }

        private View m3595b() {
            int size = this.f2089k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C0724w) this.f2089k.get(i)).f2170a;
                C0679i c0679i = (C0679i) view.getLayoutParams();
                if (!c0679i.m3338d() && this.f2082d == c0679i.m3340f()) {
                    m3598a(view);
                    return view;
                }
            }
            return null;
        }

        View m3596a(C0714o c0714o) {
            if (this.f2089k != null) {
                return m3595b();
            }
            View c = c0714o.m3750c(this.f2082d);
            this.f2082d += this.f2083e;
            return c;
        }

        public void m3597a() {
            m3598a(null);
        }

        public void m3598a(View view) {
            View b = m3600b(view);
            if (b == null) {
                this.f2082d = -1;
            } else {
                this.f2082d = ((C0679i) b.getLayoutParams()).m3340f();
            }
        }

        boolean m3599a(C0721t c0721t) {
            return this.f2082d >= 0 && this.f2082d < c0721t.m3796e();
        }

        public View m3600b(View view) {
            int size = this.f2089k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((C0724w) this.f2089k.get(i2)).f2170a;
                C0679i c0679i = (C0679i) view4.getLayoutParams();
                if (view4 != view) {
                    if (c0679i.m3338d()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (c0679i.m3340f() - this.f2082d) * this.f2083e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public static class C0686d implements Parcelable {
        public static final Creator<C0686d> CREATOR = new C06851();
        int f2091a;
        int f2092b;
        boolean f2093c;

        static class C06851 implements Creator<C0686d> {
            C06851() {
            }

            public C0686d m3601a(Parcel parcel) {
                return new C0686d(parcel);
            }

            public C0686d[] m3602a(int i) {
                return new C0686d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3601a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3602a(i);
            }
        }

        C0686d(Parcel parcel) {
            boolean z = true;
            this.f2091a = parcel.readInt();
            this.f2092b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2093c = z;
        }

        public C0686d(C0686d c0686d) {
            this.f2091a = c0686d.f2091a;
            this.f2092b = c0686d.f2092b;
            this.f2093c = c0686d.f2093c;
        }

        boolean m3603a() {
            return this.f2091a >= 0;
        }

        void m3604b() {
            this.f2091a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2091a);
            parcel.writeInt(this.f2092b);
            parcel.writeInt(this.f2093c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f2049c = false;
        this.f2057k = false;
        this.f2050d = false;
        this.f2051e = true;
        this.f2058l = -1;
        this.f2059m = Integer.MIN_VALUE;
        this.f2060n = null;
        this.f2061o = new C0682a(this);
        this.f2053g = new C0683b();
        this.f2054h = 2;
        m3524b(i);
        m3525b(z);
        m3429c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2049c = false;
        this.f2057k = false;
        this.f2050d = false;
        this.f2051e = true;
        this.f2058l = -1;
        this.f2059m = Integer.MIN_VALUE;
        this.f2060n = null;
        this.f2061o = new C0682a(this);
        this.f2053g = new C0683b();
        this.f2054h = 2;
        C0707b a = C0681h.m3345a(context, attributeSet, i, i2);
        m3524b(a.f2112a);
        m3525b(a.f2114c);
        mo645a(a.f2115d);
        m3429c(true);
    }

    private void m3478J() {
        boolean z = true;
        if (this.f2055i == 1 || !m3541g()) {
            this.f2057k = this.f2049c;
            return;
        }
        if (this.f2049c) {
            z = false;
        }
        this.f2057k = z;
    }

    private View m3479K() {
        return m3453h(this.f2057k ? m3472u() - 1 : 0);
    }

    private View m3480L() {
        return m3453h(this.f2057k ? 0 : m3472u() - 1);
    }

    private int m3481a(int i, C0714o c0714o, C0721t c0721t, boolean z) {
        int d = this.f2056j.mo725d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m3527c(-d, c0714o, c0721t);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f2056j.mo725d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f2056j.mo721a(i2);
        return d + i2;
    }

    private View m3482a(boolean z, boolean z2) {
        return this.f2057k ? m3508a(m3472u() - 1, -1, z, z2) : m3508a(0, m3472u(), z, z2);
    }

    private void mo631a(int i, int i2) {
        this.f2047a.f2081c = this.f2056j.mo725d() - i2;
        this.f2047a.f2083e = this.f2057k ? -1 : 1;
        this.f2047a.f2082d = i;
        this.f2047a.f2084f = 1;
        this.f2047a.f2080b = i2;
        this.f2047a.f2085g = Integer.MIN_VALUE;
    }

    private void m3484a(int i, int i2, boolean z, C0721t c0721t) {
        int i3 = -1;
        int i4 = 1;
        this.f2047a.f2090l = m3545j();
        this.f2047a.f2086h = m3523b(c0721t);
        this.f2047a.f2084f = i;
        View L;
        C0684c c0684c;
        if (i == 1) {
            C0684c c0684c2 = this.f2047a;
            c0684c2.f2086h += this.f2056j.mo731g();
            L = m3480L();
            c0684c = this.f2047a;
            if (!this.f2057k) {
                i3 = 1;
            }
            c0684c.f2083e = i3;
            this.f2047a.f2082d = m3432d(L) + this.f2047a.f2083e;
            this.f2047a.f2080b = this.f2056j.mo722b(L);
            i3 = this.f2056j.mo722b(L) - this.f2056j.mo725d();
        } else {
            L = m3479K();
            c0684c = this.f2047a;
            c0684c.f2086h += this.f2056j.mo723c();
            c0684c = this.f2047a;
            if (!this.f2057k) {
                i4 = -1;
            }
            c0684c.f2083e = i4;
            this.f2047a.f2082d = m3432d(L) + this.f2047a.f2083e;
            this.f2047a.f2080b = this.f2056j.mo720a(L);
            i3 = (-this.f2056j.mo720a(L)) + this.f2056j.mo723c();
        }
        this.f2047a.f2081c = i2;
        if (z) {
            C0684c c0684c3 = this.f2047a;
            c0684c3.f2081c -= i3;
        }
        this.f2047a.f2085g = i3;
    }

    private void m3485a(C0682a c0682a) {
        mo631a(c0682a.f2070a, c0682a.f2071b);
    }

    private void m3486a(C0714o c0714o, int i) {
        if (i >= 0) {
            int u = m3472u();
            int i2;
            if (this.f2057k) {
                for (i2 = u - 1; i2 >= 0; i2--) {
                    View h = m3453h(i2);
                    if (this.f2056j.mo722b(h) > i || this.f2056j.mo724c(h) > i) {
                        m3487a(c0714o, u - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < u; i2++) {
                View h2 = m3453h(i2);
                if (this.f2056j.mo722b(h2) > i || this.f2056j.mo724c(h2) > i) {
                    m3487a(c0714o, 0, i2);
                    return;
                }
            }
        }
    }

    private void m3487a(C0714o c0714o, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m3369a(i3, c0714o);
                }
                return;
            }
            while (i > i2) {
                m3369a(i, c0714o);
                i--;
            }
        }
    }

    private void m3488a(C0714o c0714o, C0684c c0684c) {
        if (c0684c.f2079a && !c0684c.f2090l) {
            if (c0684c.f2084f == -1) {
                m3494b(c0714o, c0684c.f2085g);
            } else {
                m3486a(c0714o, c0684c.f2085g);
            }
        }
    }

    private void m3489a(C0714o c0714o, C0721t c0721t, C0682a c0682a) {
        if (!m3490a(c0721t, c0682a) && !m3496b(c0714o, c0721t, c0682a)) {
            c0682a.m3592b();
            c0682a.f2070a = this.f2050d ? c0721t.m3796e() - 1 : 0;
        }
    }

    private boolean m3490a(C0721t c0721t, C0682a c0682a) {
        boolean z = false;
        if (c0721t.m3792a() || this.f2058l == -1) {
            return false;
        }
        if (this.f2058l < 0 || this.f2058l >= c0721t.m3796e()) {
            this.f2058l = -1;
            this.f2059m = Integer.MIN_VALUE;
            return false;
        }
        c0682a.f2070a = this.f2058l;
        if (this.f2060n != null && this.f2060n.m3603a()) {
            c0682a.f2072c = this.f2060n.f2093c;
            if (c0682a.f2072c) {
                c0682a.f2071b = this.f2056j.mo725d() - this.f2060n.f2092b;
                return true;
            }
            c0682a.f2071b = this.f2056j.mo723c() + this.f2060n.f2092b;
            return true;
        } else if (this.f2059m == Integer.MIN_VALUE) {
            View c = mo620c(this.f2058l);
            if (c == null) {
                if (m3472u() > 0) {
                    if ((this.f2058l < m3432d(m3453h(0))) == this.f2057k) {
                        z = true;
                    }
                    c0682a.f2072c = z;
                }
                c0682a.m3592b();
                return true;
            } else if (this.f2056j.mo728e(c) > this.f2056j.mo729f()) {
                c0682a.m3592b();
                return true;
            } else if (this.f2056j.mo720a(c) - this.f2056j.mo723c() < 0) {
                c0682a.f2071b = this.f2056j.mo723c();
                c0682a.f2072c = false;
                return true;
            } else if (this.f2056j.mo725d() - this.f2056j.mo722b(c) < 0) {
                c0682a.f2071b = this.f2056j.mo725d();
                c0682a.f2072c = true;
                return true;
            } else {
                c0682a.f2071b = c0682a.f2072c ? this.f2056j.mo722b(c) + this.f2056j.m4382b() : this.f2056j.mo720a(c);
                return true;
            }
        } else {
            c0682a.f2072c = this.f2057k;
            if (this.f2057k) {
                c0682a.f2071b = this.f2056j.mo725d() - this.f2059m;
                return true;
            }
            c0682a.f2071b = this.f2056j.mo723c() + this.f2059m;
            return true;
        }
    }

    private int m3491b(int i, C0714o c0714o, C0721t c0721t, boolean z) {
        int c = i - this.f2056j.mo723c();
        if (c <= 0) {
            return 0;
        }
        c = -m3527c(c, c0714o, c0721t);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f2056j.mo723c();
        if (i2 <= 0) {
            return c;
        }
        this.f2056j.mo721a(-i2);
        return c - i2;
    }

    private View m3492b(boolean z, boolean z2) {
        return this.f2057k ? m3508a(0, m3472u(), z, z2) : m3508a(m3472u() - 1, -1, z, z2);
    }

    private void m3493b(C0682a c0682a) {
        m3498f(c0682a.f2070a, c0682a.f2071b);
    }

    private void m3494b(C0714o c0714o, int i) {
        int u = m3472u();
        if (i >= 0) {
            int e = this.f2056j.mo727e() - i;
            int i2;
            if (this.f2057k) {
                for (i2 = 0; i2 < u; i2++) {
                    View h = m3453h(i2);
                    if (this.f2056j.mo720a(h) < e || this.f2056j.mo726d(h) < e) {
                        m3487a(c0714o, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = u - 1; i2 >= 0; i2--) {
                View h2 = m3453h(i2);
                if (this.f2056j.mo720a(h2) < e || this.f2056j.mo726d(h2) < e) {
                    m3487a(c0714o, u - 1, i2);
                    return;
                }
            }
        }
    }

    private void m3495b(C0714o c0714o, C0721t c0721t, int i, int i2) {
        if (c0721t.m3793b() && m3472u() != 0 && !c0721t.m3792a() && mo617b()) {
            int i3 = 0;
            int i4 = 0;
            List c = c0714o.m3751c();
            int size = c.size();
            int d = m3432d(m3453h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                C0724w c0724w = (C0724w) c.get(i5);
                if (c0724w.m3847q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((c0724w.m3834d() < d) != this.f2057k ? -1 : 1) == -1) {
                        i7 = this.f2056j.mo728e(c0724w.f2170a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f2056j.mo728e(c0724w.f2170a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f2047a.f2089k = c;
            if (i3 > 0) {
                m3498f(m3432d(m3479K()), i);
                this.f2047a.f2086h = i3;
                this.f2047a.f2081c = 0;
                this.f2047a.m3597a();
                m3506a(c0714o, this.f2047a, c0721t, false);
            }
            if (i4 > 0) {
                mo631a(m3432d(m3480L()), i2);
                this.f2047a.f2086h = i4;
                this.f2047a.f2081c = 0;
                this.f2047a.m3597a();
                m3506a(c0714o, this.f2047a, c0721t, false);
            }
            this.f2047a.f2089k = null;
        }
    }

    private boolean m3496b(C0714o c0714o, C0721t c0721t, C0682a c0682a) {
        boolean z = false;
        if (m3472u() == 0) {
            return false;
        }
        View D = m3355D();
        if (D != null && c0682a.m3591a(D, c0721t)) {
            c0682a.m3590a(D);
            return true;
        } else if (this.f2048b != this.f2050d) {
            return false;
        } else {
            D = c0682a.f2072c ? m3497f(c0714o, c0721t) : m3499g(c0714o, c0721t);
            if (D == null) {
                return false;
            }
            c0682a.m3593b(D);
            if (!c0721t.m3792a() && mo617b()) {
                if (this.f2056j.mo720a(D) >= this.f2056j.mo725d() || this.f2056j.mo722b(D) < this.f2056j.mo723c()) {
                    z = true;
                }
                if (z) {
                    c0682a.f2071b = c0682a.f2072c ? this.f2056j.mo725d() : this.f2056j.mo723c();
                }
            }
            return true;
        }
    }

    private View m3497f(C0714o c0714o, C0721t c0721t) {
        return this.f2057k ? m3500h(c0714o, c0721t) : m3502i(c0714o, c0721t);
    }

    private void m3498f(int i, int i2) {
        this.f2047a.f2081c = i2 - this.f2056j.mo723c();
        this.f2047a.f2082d = i;
        this.f2047a.f2083e = this.f2057k ? 1 : -1;
        this.f2047a.f2084f = -1;
        this.f2047a.f2080b = i2;
        this.f2047a.f2085g = Integer.MIN_VALUE;
    }

    private View m3499g(C0714o c0714o, C0721t c0721t) {
        return this.f2057k ? m3502i(c0714o, c0721t) : m3500h(c0714o, c0721t);
    }

    private View m3500h(C0714o c0714o, C0721t c0721t) {
        return mo635a(c0714o, c0721t, 0, m3472u(), c0721t.m3796e());
    }

    private int m3501i(C0721t c0721t) {
        boolean z = false;
        if (m3472u() == 0) {
            return 0;
        }
        m3543h();
        ax axVar = this.f2056j;
        View a = m3482a(!this.f2051e, true);
        if (!this.f2051e) {
            z = true;
        }
        return bd.m4467a(c0721t, axVar, a, m3492b(z, true), this, this.f2051e, this.f2057k);
    }

    private View m3502i(C0714o c0714o, C0721t c0721t) {
        return mo635a(c0714o, c0721t, m3472u() - 1, -1, c0721t.m3796e());
    }

    private int m3503j(C0721t c0721t) {
        boolean z = false;
        if (m3472u() == 0) {
            return 0;
        }
        m3543h();
        ax axVar = this.f2056j;
        View a = m3482a(!this.f2051e, true);
        if (!this.f2051e) {
            z = true;
        }
        return bd.m4466a(c0721t, axVar, a, m3492b(z, true), this, this.f2051e);
    }

    private int m3504k(C0721t c0721t) {
        boolean z = false;
        if (m3472u() == 0) {
            return 0;
        }
        m3543h();
        ax axVar = this.f2056j;
        View a = m3482a(!this.f2051e, true);
        if (!this.f2051e) {
            z = true;
        }
        return bd.m4468b(c0721t, axVar, a, m3492b(z, true), this, this.f2051e);
    }

    public int mo606a(int i, C0714o c0714o, C0721t c0721t) {
        return this.f2055i == 1 ? 0 : m3527c(i, c0714o, c0721t);
    }

    int m3506a(C0714o c0714o, C0684c c0684c, C0721t c0721t, boolean z) {
        int i = c0684c.f2081c;
        if (c0684c.f2085g != Integer.MIN_VALUE) {
            if (c0684c.f2081c < 0) {
                c0684c.f2085g += c0684c.f2081c;
            }
            m3488a(c0714o, c0684c);
        }
        int i2 = c0684c.f2081c + c0684c.f2086h;
        C0683b c0683b = this.f2053g;
        while (true) {
            if ((!c0684c.f2090l && i2 <= 0) || !c0684c.m3599a(c0721t)) {
                break;
            }
            c0683b.m3594a();
            mo638a(c0714o, c0721t, c0684c, c0683b);
            if (!c0683b.f2076b) {
                c0684c.f2080b += c0683b.f2075a * c0684c.f2084f;
                if (!(c0683b.f2077c && this.f2047a.f2089k == null && c0721t.m3792a())) {
                    c0684c.f2081c -= c0683b.f2075a;
                    i2 -= c0683b.f2075a;
                }
                if (c0684c.f2085g != Integer.MIN_VALUE) {
                    c0684c.f2085g += c0683b.f2075a;
                    if (c0684c.f2081c < 0) {
                        c0684c.f2085g += c0684c.f2081c;
                    }
                    m3488a(c0714o, c0684c);
                }
                if (z && c0683b.f2078d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0684c.f2081c;
    }

    public C0679i mo607a() {
        return new C0679i(-2, -2);
    }

    View m3508a(int i, int i2, boolean z, boolean z2) {
        m3543h();
        int c = this.f2056j.mo723c();
        int d = this.f2056j.mo725d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View h = m3453h(i);
            int a = this.f2056j.mo720a(h);
            int b = this.f2056j.mo722b(h);
            if (a < d && b > c) {
                if (!z) {
                    return h;
                }
                if (a >= c && b <= d) {
                    return h;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = h;
                }
            }
            h = view;
            i += i3;
            view = h;
        }
        return view;
    }

    View mo635a(C0714o c0714o, C0721t c0721t, int i, int i2, int i3) {
        View view = null;
        m3543h();
        int c = this.f2056j.mo723c();
        int d = this.f2056j.mo725d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m3453h(i);
            int d2 = m3432d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((C0679i) h.getLayoutParams()).m3338d()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.f2056j.mo720a(h) < d && this.f2056j.mo722b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
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
        m3478J();
        if (m3472u() == 0) {
            return null;
        }
        int e = m3535e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        m3543h();
        View g = e == -1 ? m3499g(c0714o, c0721t) : m3497f(c0714o, c0721t);
        if (g == null) {
            return null;
        }
        m3543h();
        m3484a(e, (int) (0.33333334f * ((float) this.f2056j.mo729f())), false, c0721t);
        this.f2047a.f2085g = Integer.MIN_VALUE;
        this.f2047a.f2079a = false;
        m3506a(c0714o, this.f2047a, c0721t, true);
        View K = e == -1 ? m3479K() : m3480L();
        return (K == g || !K.isFocusable()) ? null : K;
    }

    public void mo609a(int i, int i2, C0721t c0721t, C0706a c0706a) {
        if (this.f2055i != 0) {
            i = i2;
        }
        if (m3472u() != 0 && i != 0) {
            m3484a(i > 0 ? 1 : -1, Math.abs(i), true, c0721t);
            mo640a(c0721t, this.f2047a, c0706a);
        }
    }

    public void mo610a(int i, C0706a c0706a) {
        int i2;
        boolean z;
        if (this.f2060n == null || !this.f2060n.m3603a()) {
            m3478J();
            boolean z2 = this.f2057k;
            if (this.f2058l == -1) {
                i2 = z2 ? i - 1 : 0;
                z = z2;
            } else {
                i2 = this.f2058l;
                z = z2;
            }
        } else {
            z = this.f2060n.f2093c;
            i2 = this.f2060n.f2091a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.f2054h && i2 >= 0 && i2 < i; i4++) {
            c0706a.mo708b(i2, 0);
            i2 += i3;
        }
    }

    public void mo611a(Parcelable parcelable) {
        if (parcelable instanceof C0686d) {
            this.f2060n = (C0686d) parcelable;
            m3464n();
        }
    }

    void mo637a(C0714o c0714o, C0721t c0721t, C0682a c0682a, int i) {
    }

    void mo638a(C0714o c0714o, C0721t c0721t, C0684c c0684c, C0683b c0683b) {
        View a = c0684c.m3596a(c0714o);
        if (a == null) {
            c0683b.f2076b = true;
            return;
        }
        int f;
        int i;
        int i2;
        int i3;
        C0679i c0679i = (C0679i) a.getLayoutParams();
        if (c0684c.f2089k == null) {
            if (this.f2057k == (c0684c.f2084f == -1)) {
                m3414b(a);
            } else {
                m3415b(a, 0);
            }
        } else {
            if (this.f2057k == (c0684c.f2084f == -1)) {
                m3385a(a);
            } else {
                m3386a(a, 0);
            }
        }
        m3387a(a, 0, 0);
        c0683b.f2075a = this.f2056j.mo728e(a);
        if (this.f2055i == 1) {
            int x;
            if (m3541g()) {
                x = m3475x() - m3353B();
                f = x - this.f2056j.mo730f(a);
            } else {
                f = m3477z();
                x = this.f2056j.mo730f(a) + f;
            }
            if (c0684c.f2084f == -1) {
                i = c0684c.f2080b;
                i2 = c0684c.f2080b - c0683b.f2075a;
                i3 = x;
            } else {
                i2 = c0684c.f2080b;
                i = c0683b.f2075a + c0684c.f2080b;
                i3 = x;
            }
        } else {
            i2 = m3352A();
            i = i2 + this.f2056j.mo730f(a);
            if (c0684c.f2084f == -1) {
                f = c0684c.f2080b - c0683b.f2075a;
                i3 = c0684c.f2080b;
            } else {
                f = c0684c.f2080b;
                i3 = c0684c.f2080b + c0683b.f2075a;
            }
        }
        m3388a(a, f, i2, i3, i);
        if (c0679i.m3338d() || c0679i.m3339e()) {
            c0683b.f2077c = true;
        }
        c0683b.f2078d = a.isFocusable();
    }

    public void mo612a(C0721t c0721t) {
        super.mo612a(c0721t);
        this.f2060n = null;
        this.f2058l = -1;
        this.f2059m = Integer.MIN_VALUE;
        this.f2061o.m3589a();
    }

    void mo640a(C0721t c0721t, C0684c c0684c, C0706a c0706a) {
        int i = c0684c.f2082d;
        if (i >= 0 && i < c0721t.m3796e()) {
            c0706a.mo708b(i, c0684c.f2085g);
        }
    }

    public void mo613a(RecyclerView recyclerView, C0714o c0714o) {
        super.mo613a(recyclerView, c0714o);
        if (this.f2052f) {
            m3423c(c0714o);
            c0714o.m3734a();
        }
    }

    public void mo614a(AccessibilityEvent accessibilityEvent) {
        super.mo614a(accessibilityEvent);
        if (m3472u() > 0) {
            C0386f a = C0357a.m1685a(accessibilityEvent);
            a.m1763b(m3547l());
            a.m1764c(m3548m());
        }
    }

    public void mo615a(String str) {
        if (this.f2060n == null) {
            super.mo615a(str);
        }
    }

    public void mo645a(boolean z) {
        mo615a(null);
        if (this.f2050d != z) {
            this.f2050d = z;
            m3464n();
        }
    }

    public int mo616b(int i, C0714o c0714o, C0721t c0721t) {
        return this.f2055i == 0 ? 0 : m3527c(i, c0714o, c0721t);
    }

    protected int m3523b(C0721t c0721t) {
        return c0721t.m3795d() ? this.f2056j.mo729f() : 0;
    }

    public void m3524b(int i) {
        if (i == 0 || i == 1) {
            mo615a(null);
            if (i != this.f2055i) {
                this.f2055i = i;
                this.f2056j = null;
                m3464n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void m3525b(boolean z) {
        mo615a(null);
        if (z != this.f2049c) {
            this.f2049c = z;
            m3464n();
        }
    }

    public boolean mo617b() {
        return this.f2060n == null && this.f2048b == this.f2050d;
    }

    int m3527c(int i, C0714o c0714o, C0721t c0721t) {
        if (m3472u() == 0 || i == 0) {
            return 0;
        }
        this.f2047a.f2079a = true;
        m3543h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m3484a(i2, abs, true, c0721t);
        int a = this.f2047a.f2085g + m3506a(c0714o, this.f2047a, c0721t, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f2056j.mo721a(-i);
        this.f2047a.f2088j = i;
        return i;
    }

    public int mo618c(C0721t c0721t) {
        return m3501i(c0721t);
    }

    public Parcelable mo619c() {
        if (this.f2060n != null) {
            return new C0686d(this.f2060n);
        }
        Parcelable c0686d = new C0686d();
        if (m3472u() > 0) {
            m3543h();
            boolean z = this.f2048b ^ this.f2057k;
            c0686d.f2093c = z;
            View L;
            if (z) {
                L = m3480L();
                c0686d.f2092b = this.f2056j.mo725d() - this.f2056j.mo722b(L);
                c0686d.f2091a = m3432d(L);
                return c0686d;
            }
            L = m3479K();
            c0686d.f2091a = m3432d(L);
            c0686d.f2092b = this.f2056j.mo720a(L) - this.f2056j.mo723c();
            return c0686d;
        }
        c0686d.m3604b();
        return c0686d;
    }

    public View mo620c(int i) {
        int u = m3472u();
        if (u == 0) {
            return null;
        }
        int d = i - m3432d(m3453h(0));
        if (d >= 0 && d < u) {
            View h = m3453h(d);
            if (m3432d(h) == i) {
                return h;
            }
        }
        return super.mo620c(i);
    }

    public void mo621c(C0714o c0714o, C0721t c0721t) {
        int i = -1;
        if (!(this.f2060n == null && this.f2058l == -1) && c0721t.m3796e() == 0) {
            m3423c(c0714o);
            return;
        }
        int i2;
        int d;
        if (this.f2060n != null && this.f2060n.m3603a()) {
            this.f2058l = this.f2060n.f2091a;
        }
        m3543h();
        this.f2047a.f2079a = false;
        m3478J();
        if (!(this.f2061o.f2073d && this.f2058l == -1 && this.f2060n == null)) {
            this.f2061o.m3589a();
            this.f2061o.f2072c = this.f2057k ^ this.f2050d;
            m3489a(c0714o, c0721t, this.f2061o);
            this.f2061o.f2073d = true;
        }
        int b = m3523b(c0721t);
        if (this.f2047a.f2088j >= 0) {
            i2 = 0;
        } else {
            i2 = b;
            b = 0;
        }
        i2 += this.f2056j.mo723c();
        b += this.f2056j.mo731g();
        if (!(!c0721t.m3792a() || this.f2058l == -1 || this.f2059m == Integer.MIN_VALUE)) {
            View c = mo620c(this.f2058l);
            if (c != null) {
                if (this.f2057k) {
                    d = (this.f2056j.mo725d() - this.f2056j.mo722b(c)) - this.f2059m;
                } else {
                    d = this.f2059m - (this.f2056j.mo720a(c) - this.f2056j.mo723c());
                }
                if (d > 0) {
                    i2 += d;
                } else {
                    b -= d;
                }
            }
        }
        if (this.f2061o.f2072c) {
            if (this.f2057k) {
                i = 1;
            }
        } else if (!this.f2057k) {
            i = 1;
        }
        mo637a(c0714o, c0721t, this.f2061o, i);
        m3374a(c0714o);
        this.f2047a.f2090l = m3545j();
        this.f2047a.f2087i = c0721t.m3792a();
        if (this.f2061o.f2072c) {
            m3493b(this.f2061o);
            this.f2047a.f2086h = i2;
            m3506a(c0714o, this.f2047a, c0721t, false);
            i2 = this.f2047a.f2080b;
            d = this.f2047a.f2082d;
            if (this.f2047a.f2081c > 0) {
                b += this.f2047a.f2081c;
            }
            m3485a(this.f2061o);
            this.f2047a.f2086h = b;
            C0684c c0684c = this.f2047a;
            c0684c.f2082d += this.f2047a.f2083e;
            m3506a(c0714o, this.f2047a, c0721t, false);
            i = this.f2047a.f2080b;
            if (this.f2047a.f2081c > 0) {
                b = this.f2047a.f2081c;
                m3498f(d, i2);
                this.f2047a.f2086h = b;
                m3506a(c0714o, this.f2047a, c0721t, false);
                b = this.f2047a.f2080b;
            } else {
                b = i2;
            }
            i2 = b;
            b = i;
        } else {
            m3485a(this.f2061o);
            this.f2047a.f2086h = b;
            m3506a(c0714o, this.f2047a, c0721t, false);
            b = this.f2047a.f2080b;
            i = this.f2047a.f2082d;
            if (this.f2047a.f2081c > 0) {
                i2 += this.f2047a.f2081c;
            }
            m3493b(this.f2061o);
            this.f2047a.f2086h = i2;
            C0684c c0684c2 = this.f2047a;
            c0684c2.f2082d += this.f2047a.f2083e;
            m3506a(c0714o, this.f2047a, c0721t, false);
            i2 = this.f2047a.f2080b;
            if (this.f2047a.f2081c > 0) {
                d = this.f2047a.f2081c;
                mo631a(i, b);
                this.f2047a.f2086h = d;
                m3506a(c0714o, this.f2047a, c0721t, false);
                b = this.f2047a.f2080b;
            }
        }
        if (m3472u() > 0) {
            int b2;
            if ((this.f2057k ^ this.f2050d) != 0) {
                i = m3481a(b, c0714o, c0721t, true);
                i2 += i;
                b += i;
                b2 = m3491b(i2, c0714o, c0721t, false);
                i2 += b2;
                b += b2;
            } else {
                i = m3491b(i2, c0714o, c0721t, true);
                i2 += i;
                b += i;
                b2 = m3481a(b, c0714o, c0721t, false);
                i2 += b2;
                b += b2;
            }
        }
        m3495b(c0714o, c0721t, i2, b);
        if (c0721t.m3792a()) {
            this.f2061o.m3589a();
        } else {
            this.f2056j.m4380a();
        }
        this.f2048b = this.f2050d;
    }

    public int mo622d(C0721t c0721t) {
        return m3501i(c0721t);
    }

    public void mo623d(int i) {
        this.f2058l = i;
        this.f2059m = Integer.MIN_VALUE;
        if (this.f2060n != null) {
            this.f2060n.m3604b();
        }
        m3464n();
    }

    public boolean mo624d() {
        return this.f2055i == 0;
    }

    int m3535e(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                return (this.f2055i == 1 || !m3541g()) ? -1 : 1;
            case 2:
                return this.f2055i == 1 ? 1 : !m3541g() ? 1 : -1;
            case 17:
                return this.f2055i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f2055i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f2055i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.f2055i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int mo625e(C0721t c0721t) {
        return m3503j(c0721t);
    }

    public boolean mo626e() {
        return this.f2055i == 1;
    }

    public int m3538f() {
        return this.f2055i;
    }

    public int mo627f(C0721t c0721t) {
        return m3503j(c0721t);
    }

    public int mo628g(C0721t c0721t) {
        return m3504k(c0721t);
    }

    protected boolean m3541g() {
        return m3470s() == 1;
    }

    public int mo629h(C0721t c0721t) {
        return m3504k(c0721t);
    }

    void m3543h() {
        if (this.f2047a == null) {
            this.f2047a = m3544i();
        }
        if (this.f2056j == null) {
            this.f2056j = ax.m4377a(this, this.f2055i);
        }
    }

    C0684c m3544i() {
        return new C0684c();
    }

    boolean m3545j() {
        return this.f2056j.mo732h() == 0 && this.f2056j.mo727e() == 0;
    }

    boolean mo630k() {
        return (m3474w() == 1073741824 || m3473v() == 1073741824 || !m3360I()) ? false : true;
    }

    public int m3547l() {
        View a = m3508a(0, m3472u(), false, true);
        return a == null ? -1 : m3432d(a);
    }

    public int m3548m() {
        View a = m3508a(m3472u() - 1, -1, false, true);
        return a == null ? -1 : m3432d(a);
    }
}
