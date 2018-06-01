package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p008h.p019a.C0357a;
import android.support.v4.p008h.p019a.C0369b;
import android.support.v4.p008h.p019a.C0369b.C0368k;
import android.support.v4.p008h.p019a.C0386f;
import android.support.v7.widget.RecyclerView.C0679i;
import android.support.v7.widget.RecyclerView.C0681h;
import android.support.v7.widget.RecyclerView.C0681h.C0706a;
import android.support.v7.widget.RecyclerView.C0681h.C0707b;
import android.support.v7.widget.RecyclerView.C0714o;
import android.support.v7.widget.RecyclerView.C0721t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C0681h {
    private final Rect f2280A = new Rect();
    private final C0735a f2281B = new C0735a(this);
    private boolean f2282C = false;
    private boolean f2283D = true;
    private int[] f2284E;
    private final Runnable f2285F = new C07341(this);
    C0742e[] f2286a;
    ax f2287b;
    ax f2288c;
    boolean f2289d = false;
    boolean f2290e = false;
    int f2291f = -1;
    int f2292g = Integer.MIN_VALUE;
    C0739c f2293h = new C0739c();
    private int f2294i = -1;
    private int f2295j;
    private int f2296k;
    private final aq f2297l;
    private BitSet f2298m;
    private int f2299n = 2;
    private boolean f2300o;
    private boolean f2301x;
    private C0741d f2302y;
    private int f2303z;

    class C07341 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f2248a;

        C07341(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2248a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f2248a.m4022f();
        }
    }

    class C0735a {
        int f2249a;
        int f2250b;
        boolean f2251c;
        boolean f2252d;
        boolean f2253e;
        int[] f2254f;
        final /* synthetic */ StaggeredGridLayoutManager f2255g;

        public C0735a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2255g = staggeredGridLayoutManager;
            m3893a();
        }

        void m3893a() {
            this.f2249a = -1;
            this.f2250b = Integer.MIN_VALUE;
            this.f2251c = false;
            this.f2252d = false;
            this.f2253e = false;
            if (this.f2254f != null) {
                Arrays.fill(this.f2254f, -1);
            }
        }

        void m3894a(int i) {
            if (this.f2251c) {
                this.f2250b = this.f2255g.f2287b.mo725d() - i;
            } else {
                this.f2250b = this.f2255g.f2287b.mo723c() + i;
            }
        }

        void m3895a(C0742e[] c0742eArr) {
            int length = c0742eArr.length;
            if (this.f2254f == null || this.f2254f.length < length) {
                this.f2254f = new int[this.f2255g.f2286a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f2254f[i] = c0742eArr[i].m3921a(Integer.MIN_VALUE);
            }
        }

        void m3896b() {
            this.f2250b = this.f2251c ? this.f2255g.f2287b.mo725d() : this.f2255g.f2287b.mo723c();
        }
    }

    public static class C0736b extends C0679i {
        C0742e f2256a;
        boolean f2257b;

        public C0736b(int i, int i2) {
            super(i, i2);
        }

        public C0736b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0736b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0736b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean m3897a() {
            return this.f2257b;
        }

        public final int m3898b() {
            return this.f2256a == null ? -1 : this.f2256a.f2278e;
        }
    }

    static class C0739c {
        int[] f2262a;
        List<C0738a> f2263b;

        static class C0738a implements Parcelable {
            public static final Creator<C0738a> CREATOR = new C07371();
            int f2258a;
            int f2259b;
            int[] f2260c;
            boolean f2261d;

            static class C07371 implements Creator<C0738a> {
                C07371() {
                }

                public C0738a m3899a(Parcel parcel) {
                    return new C0738a(parcel);
                }

                public C0738a[] m3900a(int i) {
                    return new C0738a[i];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m3899a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m3900a(i);
                }
            }

            public C0738a(Parcel parcel) {
                boolean z = true;
                this.f2258a = parcel.readInt();
                this.f2259b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f2261d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f2260c = new int[readInt];
                    parcel.readIntArray(this.f2260c);
                }
            }

            int m3901a(int i) {
                return this.f2260c == null ? 0 : this.f2260c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2258a + ", mGapDir=" + this.f2259b + ", mHasUnwantedGapAfter=" + this.f2261d + ", mGapPerSpan=" + Arrays.toString(this.f2260c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2258a);
                parcel.writeInt(this.f2259b);
                parcel.writeInt(this.f2261d ? 1 : 0);
                if (this.f2260c == null || this.f2260c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f2260c.length);
                parcel.writeIntArray(this.f2260c);
            }
        }

        C0739c() {
        }

        private void m3902c(int i, int i2) {
            if (this.f2263b != null) {
                int i3 = i + i2;
                for (int size = this.f2263b.size() - 1; size >= 0; size--) {
                    C0738a c0738a = (C0738a) this.f2263b.get(size);
                    if (c0738a.f2258a >= i) {
                        if (c0738a.f2258a < i3) {
                            this.f2263b.remove(size);
                        } else {
                            c0738a.f2258a -= i2;
                        }
                    }
                }
            }
        }

        private void m3903d(int i, int i2) {
            if (this.f2263b != null) {
                for (int size = this.f2263b.size() - 1; size >= 0; size--) {
                    C0738a c0738a = (C0738a) this.f2263b.get(size);
                    if (c0738a.f2258a >= i) {
                        c0738a.f2258a += i2;
                    }
                }
            }
        }

        private int m3904g(int i) {
            if (this.f2263b == null) {
                return -1;
            }
            C0738a f = m3916f(i);
            if (f != null) {
                this.f2263b.remove(f);
            }
            int size = this.f2263b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((C0738a) this.f2263b.get(i2)).f2258a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (C0738a) this.f2263b.get(i2);
            this.f2263b.remove(i2);
            return f.f2258a;
        }

        int m3905a(int i) {
            if (this.f2263b != null) {
                for (int size = this.f2263b.size() - 1; size >= 0; size--) {
                    if (((C0738a) this.f2263b.get(size)).f2258a >= i) {
                        this.f2263b.remove(size);
                    }
                }
            }
            return m3911b(i);
        }

        public C0738a m3906a(int i, int i2, int i3, boolean z) {
            if (this.f2263b == null) {
                return null;
            }
            int size = this.f2263b.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0738a c0738a = (C0738a) this.f2263b.get(i4);
                if (c0738a.f2258a >= i2) {
                    return null;
                }
                if (c0738a.f2258a >= i) {
                    if (i3 == 0 || c0738a.f2259b == i3) {
                        return c0738a;
                    }
                    if (z && c0738a.f2261d) {
                        return c0738a;
                    }
                }
            }
            return null;
        }

        void m3907a() {
            if (this.f2262a != null) {
                Arrays.fill(this.f2262a, -1);
            }
            this.f2263b = null;
        }

        void m3908a(int i, int i2) {
            if (this.f2262a != null && i < this.f2262a.length) {
                m3915e(i + i2);
                System.arraycopy(this.f2262a, i + i2, this.f2262a, i, (this.f2262a.length - i) - i2);
                Arrays.fill(this.f2262a, this.f2262a.length - i2, this.f2262a.length, -1);
                m3902c(i, i2);
            }
        }

        void m3909a(int i, C0742e c0742e) {
            m3915e(i);
            this.f2262a[i] = c0742e.f2278e;
        }

        public void m3910a(C0738a c0738a) {
            if (this.f2263b == null) {
                this.f2263b = new ArrayList();
            }
            int size = this.f2263b.size();
            for (int i = 0; i < size; i++) {
                C0738a c0738a2 = (C0738a) this.f2263b.get(i);
                if (c0738a2.f2258a == c0738a.f2258a) {
                    this.f2263b.remove(i);
                }
                if (c0738a2.f2258a >= c0738a.f2258a) {
                    this.f2263b.add(i, c0738a);
                    return;
                }
            }
            this.f2263b.add(c0738a);
        }

        int m3911b(int i) {
            if (this.f2262a == null || i >= this.f2262a.length) {
                return -1;
            }
            int g = m3904g(i);
            if (g == -1) {
                Arrays.fill(this.f2262a, i, this.f2262a.length, -1);
                return this.f2262a.length;
            }
            Arrays.fill(this.f2262a, i, g + 1, -1);
            return g + 1;
        }

        void m3912b(int i, int i2) {
            if (this.f2262a != null && i < this.f2262a.length) {
                m3915e(i + i2);
                System.arraycopy(this.f2262a, i, this.f2262a, i + i2, (this.f2262a.length - i) - i2);
                Arrays.fill(this.f2262a, i, i + i2, -1);
                m3903d(i, i2);
            }
        }

        int m3913c(int i) {
            return (this.f2262a == null || i >= this.f2262a.length) ? -1 : this.f2262a[i];
        }

        int m3914d(int i) {
            int length = this.f2262a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m3915e(int i) {
            if (this.f2262a == null) {
                this.f2262a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f2262a, -1);
            } else if (i >= this.f2262a.length) {
                Object obj = this.f2262a;
                this.f2262a = new int[m3914d(i)];
                System.arraycopy(obj, 0, this.f2262a, 0, obj.length);
                Arrays.fill(this.f2262a, obj.length, this.f2262a.length, -1);
            }
        }

        public C0738a m3916f(int i) {
            if (this.f2263b == null) {
                return null;
            }
            for (int size = this.f2263b.size() - 1; size >= 0; size--) {
                C0738a c0738a = (C0738a) this.f2263b.get(size);
                if (c0738a.f2258a == i) {
                    return c0738a;
                }
            }
            return null;
        }
    }

    public static class C0741d implements Parcelable {
        public static final Creator<C0741d> CREATOR = new C07401();
        int f2264a;
        int f2265b;
        int f2266c;
        int[] f2267d;
        int f2268e;
        int[] f2269f;
        List<C0738a> f2270g;
        boolean f2271h;
        boolean f2272i;
        boolean f2273j;

        static class C07401 implements Creator<C0741d> {
            C07401() {
            }

            public C0741d m3917a(Parcel parcel) {
                return new C0741d(parcel);
            }

            public C0741d[] m3918a(int i) {
                return new C0741d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m3917a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m3918a(i);
            }
        }

        C0741d(Parcel parcel) {
            boolean z = true;
            this.f2264a = parcel.readInt();
            this.f2265b = parcel.readInt();
            this.f2266c = parcel.readInt();
            if (this.f2266c > 0) {
                this.f2267d = new int[this.f2266c];
                parcel.readIntArray(this.f2267d);
            }
            this.f2268e = parcel.readInt();
            if (this.f2268e > 0) {
                this.f2269f = new int[this.f2268e];
                parcel.readIntArray(this.f2269f);
            }
            this.f2271h = parcel.readInt() == 1;
            this.f2272i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2273j = z;
            this.f2270g = parcel.readArrayList(C0738a.class.getClassLoader());
        }

        public C0741d(C0741d c0741d) {
            this.f2266c = c0741d.f2266c;
            this.f2264a = c0741d.f2264a;
            this.f2265b = c0741d.f2265b;
            this.f2267d = c0741d.f2267d;
            this.f2268e = c0741d.f2268e;
            this.f2269f = c0741d.f2269f;
            this.f2271h = c0741d.f2271h;
            this.f2272i = c0741d.f2272i;
            this.f2273j = c0741d.f2273j;
            this.f2270g = c0741d.f2270g;
        }

        void m3919a() {
            this.f2267d = null;
            this.f2266c = 0;
            this.f2268e = 0;
            this.f2269f = null;
            this.f2270g = null;
        }

        void m3920b() {
            this.f2267d = null;
            this.f2266c = 0;
            this.f2264a = -1;
            this.f2265b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.f2264a);
            parcel.writeInt(this.f2265b);
            parcel.writeInt(this.f2266c);
            if (this.f2266c > 0) {
                parcel.writeIntArray(this.f2267d);
            }
            parcel.writeInt(this.f2268e);
            if (this.f2268e > 0) {
                parcel.writeIntArray(this.f2269f);
            }
            parcel.writeInt(this.f2271h ? 1 : 0);
            parcel.writeInt(this.f2272i ? 1 : 0);
            if (!this.f2273j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.f2270g);
        }
    }

    class C0742e {
        ArrayList<View> f2274a = new ArrayList();
        int f2275b = Integer.MIN_VALUE;
        int f2276c = Integer.MIN_VALUE;
        int f2277d = 0;
        final int f2278e;
        final /* synthetic */ StaggeredGridLayoutManager f2279f;

        C0742e(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f2279f = staggeredGridLayoutManager;
            this.f2278e = i;
        }

        int m3921a(int i) {
            if (this.f2275b != Integer.MIN_VALUE) {
                return this.f2275b;
            }
            if (this.f2274a.size() == 0) {
                return i;
            }
            m3923a();
            return this.f2275b;
        }

        public View m3922a(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.f2274a.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.f2274a.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((this.f2279f.m3432d(view2) > i) != this.f2279f.f2289d) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            size = this.f2274a.size() - 1;
            while (size >= 0) {
                view2 = (View) this.f2274a.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                if ((this.f2279f.m3432d(view2) > i ? 1 : null) != (!this.f2279f.f2289d ? 1 : null)) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }

        void m3923a() {
            View view = (View) this.f2274a.get(0);
            C0736b c = m3929c(view);
            this.f2275b = this.f2279f.f2287b.mo720a(view);
            if (c.f2257b) {
                C0738a f = this.f2279f.f2293h.m3916f(c.m3340f());
                if (f != null && f.f2259b == -1) {
                    this.f2275b -= f.m3901a(this.f2278e);
                }
            }
        }

        void m3924a(View view) {
            C0736b c = m3929c(view);
            c.f2256a = this;
            this.f2274a.add(0, view);
            this.f2275b = Integer.MIN_VALUE;
            if (this.f2274a.size() == 1) {
                this.f2276c = Integer.MIN_VALUE;
            }
            if (c.m3338d() || c.m3339e()) {
                this.f2277d += this.f2279f.f2287b.mo728e(view);
            }
        }

        void m3925a(boolean z, int i) {
            int b = z ? m3927b(Integer.MIN_VALUE) : m3921a(Integer.MIN_VALUE);
            m3934e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f2279f.f2287b.mo725d()) {
                    return;
                }
                if (z || b <= this.f2279f.f2287b.mo723c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f2276c = b;
                    this.f2275b = b;
                }
            }
        }

        int m3926b() {
            if (this.f2275b != Integer.MIN_VALUE) {
                return this.f2275b;
            }
            m3923a();
            return this.f2275b;
        }

        int m3927b(int i) {
            if (this.f2276c != Integer.MIN_VALUE) {
                return this.f2276c;
            }
            if (this.f2274a.size() == 0) {
                return i;
            }
            m3930c();
            return this.f2276c;
        }

        void m3928b(View view) {
            C0736b c = m3929c(view);
            c.f2256a = this;
            this.f2274a.add(view);
            this.f2276c = Integer.MIN_VALUE;
            if (this.f2274a.size() == 1) {
                this.f2275b = Integer.MIN_VALUE;
            }
            if (c.m3338d() || c.m3339e()) {
                this.f2277d += this.f2279f.f2287b.mo728e(view);
            }
        }

        C0736b m3929c(View view) {
            return (C0736b) view.getLayoutParams();
        }

        void m3930c() {
            View view = (View) this.f2274a.get(this.f2274a.size() - 1);
            C0736b c = m3929c(view);
            this.f2276c = this.f2279f.f2287b.mo722b(view);
            if (c.f2257b) {
                C0738a f = this.f2279f.f2293h.m3916f(c.m3340f());
                if (f != null && f.f2259b == 1) {
                    this.f2276c = f.m3901a(this.f2278e) + this.f2276c;
                }
            }
        }

        void m3931c(int i) {
            this.f2275b = i;
            this.f2276c = i;
        }

        int m3932d() {
            if (this.f2276c != Integer.MIN_VALUE) {
                return this.f2276c;
            }
            m3930c();
            return this.f2276c;
        }

        void m3933d(int i) {
            if (this.f2275b != Integer.MIN_VALUE) {
                this.f2275b += i;
            }
            if (this.f2276c != Integer.MIN_VALUE) {
                this.f2276c += i;
            }
        }

        void m3934e() {
            this.f2274a.clear();
            m3935f();
            this.f2277d = 0;
        }

        void m3935f() {
            this.f2275b = Integer.MIN_VALUE;
            this.f2276c = Integer.MIN_VALUE;
        }

        void m3936g() {
            int size = this.f2274a.size();
            View view = (View) this.f2274a.remove(size - 1);
            C0736b c = m3929c(view);
            c.f2256a = null;
            if (c.m3338d() || c.m3339e()) {
                this.f2277d -= this.f2279f.f2287b.mo728e(view);
            }
            if (size == 1) {
                this.f2275b = Integer.MIN_VALUE;
            }
            this.f2276c = Integer.MIN_VALUE;
        }

        void m3937h() {
            View view = (View) this.f2274a.remove(0);
            C0736b c = m3929c(view);
            c.f2256a = null;
            if (this.f2274a.size() == 0) {
                this.f2276c = Integer.MIN_VALUE;
            }
            if (c.m3338d() || c.m3339e()) {
                this.f2277d -= this.f2279f.f2287b.mo728e(view);
            }
            this.f2275b = Integer.MIN_VALUE;
        }

        public int m3938i() {
            return this.f2277d;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f2295j = i2;
        m3986a(i);
        if (this.f2299n == 0) {
            z = false;
        }
        m3429c(z);
        this.f2297l = new aq();
        m3939L();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        C0707b a = C0681h.m3345a(context, attributeSet, i, i2);
        m4006b(a.f2112a);
        m3986a(a.f2113b);
        m4001a(a.f2114c);
        if (this.f2299n == 0) {
            z = false;
        }
        m3429c(z);
        this.f2297l = new aq();
        m3939L();
    }

    private void m3939L() {
        this.f2287b = ax.m4377a(this, this.f2295j);
        this.f2288c = ax.m4377a(this, 1 - this.f2295j);
    }

    private void m3940M() {
        boolean z = true;
        if (this.f2295j == 1 || !m4028i()) {
            this.f2290e = this.f2289d;
            return;
        }
        if (this.f2289d) {
            z = false;
        }
        this.f2290e = z;
    }

    private void m3941N() {
        if (this.f2288c.mo732h() != 1073741824) {
            float f = 0.0f;
            int u = m3472u();
            int i = 0;
            while (i < u) {
                float f2;
                View h = m3453h(i);
                float e = (float) this.f2288c.mo728e(h);
                if (e < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((C0736b) h.getLayoutParams()).m3897a() ? (1.0f * e) / ((float) this.f2294i) : e);
                }
                i++;
                f = f2;
            }
            i = this.f2296k;
            int round = Math.round(((float) this.f2294i) * f);
            if (this.f2288c.mo732h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f2288c.mo729f());
            }
            m4019e(round);
            if (this.f2296k != i) {
                for (int i2 = 0; i2 < u; i2++) {
                    View h2 = m3453h(i2);
                    C0736b c0736b = (C0736b) h2.getLayoutParams();
                    if (!c0736b.f2257b) {
                        if (m4028i() && this.f2295j == 1) {
                            h2.offsetLeftAndRight(((-((this.f2294i - 1) - c0736b.f2256a.f2278e)) * this.f2296k) - ((-((this.f2294i - 1) - c0736b.f2256a.f2278e)) * i));
                        } else {
                            int i3 = c0736b.f2256a.f2278e * this.f2296k;
                            round = c0736b.f2256a.f2278e * i;
                            if (this.f2295j == 1) {
                                h2.offsetLeftAndRight(i3 - round);
                            } else {
                                h2.offsetTopAndBottom(i3 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private int m3942a(C0714o c0714o, aq aqVar, C0721t c0721t) {
        int q;
        this.f2298m.set(0, this.f2294i, true);
        int i = this.f2297l.f2470i ? aqVar.f2466e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : aqVar.f2466e == 1 ? aqVar.f2468g + aqVar.f2463b : aqVar.f2467f - aqVar.f2463b;
        m3944a(aqVar.f2466e, i);
        int d = this.f2290e ? this.f2287b.mo725d() : this.f2287b.mo723c();
        Object obj = null;
        while (aqVar.m4324a(c0721t) && (this.f2297l.f2470i || !this.f2298m.isEmpty())) {
            C0742e c0742e;
            int e;
            int e2;
            View a = aqVar.m4323a(c0714o);
            C0736b c0736b = (C0736b) a.getLayoutParams();
            int f = c0736b.m3340f();
            int c = this.f2293h.m3913c(f);
            Object obj2 = c == -1 ? 1 : null;
            if (obj2 != null) {
                C0742e a2 = c0736b.f2257b ? this.f2286a[0] : m3943a(aqVar);
                this.f2293h.m3909a(f, a2);
                c0742e = a2;
            } else {
                c0742e = this.f2286a[c];
            }
            c0736b.f2256a = c0742e;
            if (aqVar.f2466e == 1) {
                m3414b(a);
            } else {
                m3415b(a, 0);
            }
            m3952a(a, c0736b, false);
            if (aqVar.f2466e == 1) {
                q = c0736b.f2257b ? m3970q(d) : c0742e.m3927b(d);
                e = q + this.f2287b.mo728e(a);
                if (obj2 == null || !c0736b.f2257b) {
                    c = q;
                } else {
                    C0738a m = m3965m(q);
                    m.f2259b = -1;
                    m.f2258a = f;
                    this.f2293h.m3910a(m);
                    c = q;
                }
            } else {
                q = c0736b.f2257b ? m3968p(d) : c0742e.m3921a(d);
                c = q - this.f2287b.mo728e(a);
                if (obj2 != null && c0736b.f2257b) {
                    C0738a n = m3966n(q);
                    n.f2259b = 1;
                    n.f2258a = f;
                    this.f2293h.m3910a(n);
                }
                e = q;
            }
            if (c0736b.f2257b && aqVar.f2465d == -1) {
                if (obj2 != null) {
                    this.f2282C = true;
                } else {
                    obj = aqVar.f2466e == 1 ? !m4032l() ? 1 : null : !m4033m() ? 1 : null;
                    if (obj != null) {
                        C0738a f2 = this.f2293h.m3916f(f);
                        if (f2 != null) {
                            f2.f2261d = true;
                        }
                        this.f2282C = true;
                    }
                }
            }
            m3951a(a, c0736b, aqVar);
            if (m4028i() && this.f2295j == 1) {
                q = c0736b.f2257b ? this.f2288c.mo725d() : this.f2288c.mo725d() - (((this.f2294i - 1) - c0742e.f2278e) * this.f2296k);
                e2 = q - this.f2288c.mo728e(a);
                f = q;
            } else {
                q = c0736b.f2257b ? this.f2288c.mo723c() : (c0742e.f2278e * this.f2296k) + this.f2288c.mo723c();
                f = q + this.f2288c.mo728e(a);
                e2 = q;
            }
            if (this.f2295j == 1) {
                m3388a(a, e2, c, f, e);
            } else {
                m3388a(a, c, e2, e, f);
            }
            if (c0736b.f2257b) {
                m3944a(this.f2297l.f2466e, i);
            } else {
                m3949a(c0742e, this.f2297l.f2466e, i);
            }
            m3947a(c0714o, this.f2297l);
            if (this.f2297l.f2469h && a.isFocusable()) {
                if (c0736b.f2257b) {
                    this.f2298m.clear();
                } else {
                    this.f2298m.set(c0742e.f2278e, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m3947a(c0714o, this.f2297l);
        }
        q = this.f2297l.f2466e == -1 ? this.f2287b.mo723c() - m3968p(this.f2287b.mo723c()) : m3970q(this.f2287b.mo725d()) - this.f2287b.mo725d();
        return q > 0 ? Math.min(aqVar.f2463b, q) : 0;
    }

    private C0742e m3943a(aq aqVar) {
        int i;
        int i2;
        C0742e c0742e = null;
        int i3 = -1;
        if (m3973s(aqVar.f2466e)) {
            i = this.f2294i - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f2294i;
            i3 = 1;
        }
        int c;
        int i4;
        C0742e c0742e2;
        int b;
        C0742e c0742e3;
        if (aqVar.f2466e == 1) {
            c = this.f2287b.mo723c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c0742e2 = this.f2286a[i4];
                b = c0742e2.m3927b(c);
                if (b < i) {
                    c0742e3 = c0742e2;
                } else {
                    b = i;
                    c0742e3 = c0742e;
                }
                i4 += i3;
                c0742e = c0742e3;
                i = b;
            }
        } else {
            c = this.f2287b.mo725d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c0742e2 = this.f2286a[i4];
                b = c0742e2.m3921a(c);
                if (b > i) {
                    c0742e3 = c0742e2;
                } else {
                    b = i;
                    c0742e3 = c0742e;
                }
                i4 += i3;
                c0742e = c0742e3;
                i = b;
            }
        }
        return c0742e;
    }

    private void m3944a(int i, int i2) {
        for (int i3 = 0; i3 < this.f2294i; i3++) {
            if (!this.f2286a[i3].f2274a.isEmpty()) {
                m3949a(this.f2286a[i3], i, i2);
            }
        }
    }

    private void m3945a(C0714o c0714o, int i) {
        while (m3472u() > 0) {
            View h = m3453h(0);
            if (this.f2287b.mo722b(h) <= i && this.f2287b.mo724c(h) <= i) {
                C0736b c0736b = (C0736b) h.getLayoutParams();
                if (c0736b.f2257b) {
                    int i2 = 0;
                    while (i2 < this.f2294i) {
                        if (this.f2286a[i2].f2274a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f2294i; i2++) {
                        this.f2286a[i2].m3937h();
                    }
                } else if (c0736b.f2256a.f2274a.size() != 1) {
                    c0736b.f2256a.m3937h();
                } else {
                    return;
                }
                m3392a(h, c0714o);
            } else {
                return;
            }
        }
    }

    private void m3946a(C0714o c0714o, C0721t c0721t, boolean z) {
        C0735a c0735a = this.f2281B;
        if (!(this.f2302y == null && this.f2291f == -1) && c0721t.m3796e() == 0) {
            m3423c(c0714o);
            c0735a.m3893a();
            return;
        }
        boolean z2 = (c0735a.f2253e && this.f2291f == -1 && this.f2302y == null) ? false : true;
        if (z2) {
            c0735a.m3893a();
            if (this.f2302y != null) {
                m3948a(c0735a);
            } else {
                m3940M();
                c0735a.f2251c = this.f2290e;
            }
            m3993a(c0721t, c0735a);
            c0735a.f2253e = true;
        }
        if (this.f2302y == null && this.f2291f == -1 && !(c0735a.f2251c == this.f2300o && m4028i() == this.f2301x)) {
            this.f2293h.m3907a();
            c0735a.f2252d = true;
        }
        if (m3472u() > 0 && (this.f2302y == null || this.f2302y.f2266c < 1)) {
            int i;
            if (c0735a.f2252d) {
                for (i = 0; i < this.f2294i; i++) {
                    this.f2286a[i].m3934e();
                    if (c0735a.f2250b != Integer.MIN_VALUE) {
                        this.f2286a[i].m3931c(c0735a.f2250b);
                    }
                }
            } else if (z2 || this.f2281B.f2254f == null) {
                for (i = 0; i < this.f2294i; i++) {
                    this.f2286a[i].m3925a(this.f2290e, c0735a.f2250b);
                }
                this.f2281B.m3895a(this.f2286a);
            } else {
                for (i = 0; i < this.f2294i; i++) {
                    C0742e c0742e = this.f2286a[i];
                    c0742e.m3934e();
                    c0742e.m3931c(this.f2281B.f2254f[i]);
                }
            }
        }
        m3374a(c0714o);
        this.f2297l.f2462a = false;
        this.f2282C = false;
        m4019e(this.f2288c.mo729f());
        m3956b(c0735a.f2249a, c0721t);
        if (c0735a.f2251c) {
            m3964l(-1);
            m3942a(c0714o, this.f2297l, c0721t);
            m3964l(1);
            this.f2297l.f2464c = c0735a.f2249a + this.f2297l.f2465d;
            m3942a(c0714o, this.f2297l, c0721t);
        } else {
            m3964l(1);
            m3942a(c0714o, this.f2297l, c0721t);
            m3964l(-1);
            this.f2297l.f2464c = c0735a.f2249a + this.f2297l.f2465d;
            m3942a(c0714o, this.f2297l, c0721t);
        }
        m3941N();
        if (m3472u() > 0) {
            if (this.f2290e) {
                m3958b(c0714o, c0721t, true);
                m3960c(c0714o, c0721t, false);
            } else {
                m3960c(c0714o, c0721t, true);
                m3958b(c0714o, c0721t, false);
            }
        }
        if (z && !c0721t.m3792a()) {
            z2 = this.f2299n != 0 && m3472u() > 0 && (this.f2282C || m4024g() != null);
            if (z2) {
                m3406a(this.f2285F);
                if (m4022f()) {
                    z2 = true;
                    if (c0721t.m3792a()) {
                        this.f2281B.m3893a();
                    }
                    this.f2300o = c0735a.f2251c;
                    this.f2301x = m4028i();
                    if (z2) {
                        this.f2281B.m3893a();
                        m3946a(c0714o, c0721t, false);
                    }
                }
            }
        }
        z2 = false;
        if (c0721t.m3792a()) {
            this.f2281B.m3893a();
        }
        this.f2300o = c0735a.f2251c;
        this.f2301x = m4028i();
        if (z2) {
            this.f2281B.m3893a();
            m3946a(c0714o, c0721t, false);
        }
    }

    private void m3947a(C0714o c0714o, aq aqVar) {
        if (aqVar.f2462a && !aqVar.f2470i) {
            if (aqVar.f2463b == 0) {
                if (aqVar.f2466e == -1) {
                    m3957b(c0714o, aqVar.f2468g);
                } else {
                    m3945a(c0714o, aqVar.f2467f);
                }
            } else if (aqVar.f2466e == -1) {
                r0 = aqVar.f2467f - m3967o(aqVar.f2467f);
                m3957b(c0714o, r0 < 0 ? aqVar.f2468g : aqVar.f2468g - Math.min(r0, aqVar.f2463b));
            } else {
                r0 = m3972r(aqVar.f2468g) - aqVar.f2468g;
                m3945a(c0714o, r0 < 0 ? aqVar.f2467f : Math.min(r0, aqVar.f2463b) + aqVar.f2467f);
            }
        }
    }

    private void m3948a(C0735a c0735a) {
        if (this.f2302y.f2266c > 0) {
            if (this.f2302y.f2266c == this.f2294i) {
                for (int i = 0; i < this.f2294i; i++) {
                    this.f2286a[i].m3934e();
                    int i2 = this.f2302y.f2267d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.f2302y.f2272i ? i2 + this.f2287b.mo725d() : i2 + this.f2287b.mo723c();
                    }
                    this.f2286a[i].m3931c(i2);
                }
            } else {
                this.f2302y.m3919a();
                this.f2302y.f2264a = this.f2302y.f2265b;
            }
        }
        this.f2301x = this.f2302y.f2273j;
        m4001a(this.f2302y.f2271h);
        m3940M();
        if (this.f2302y.f2264a != -1) {
            this.f2291f = this.f2302y.f2264a;
            c0735a.f2251c = this.f2302y.f2272i;
        } else {
            c0735a.f2251c = this.f2290e;
        }
        if (this.f2302y.f2268e > 1) {
            this.f2293h.f2262a = this.f2302y.f2269f;
            this.f2293h.f2263b = this.f2302y.f2270g;
        }
    }

    private void m3949a(C0742e c0742e, int i, int i2) {
        int i3 = c0742e.m3938i();
        if (i == -1) {
            if (i3 + c0742e.m3926b() <= i2) {
                this.f2298m.set(c0742e.f2278e, false);
            }
        } else if (c0742e.m3932d() - i3 >= i2) {
            this.f2298m.set(c0742e.f2278e, false);
        }
    }

    private void m3950a(View view, int i, int i2, boolean z) {
        m3416b(view, this.f2280A);
        C0736b c0736b = (C0736b) view.getLayoutParams();
        int b = m3954b(i, c0736b.leftMargin + this.f2280A.left, c0736b.rightMargin + this.f2280A.right);
        int b2 = m3954b(i2, c0736b.topMargin + this.f2280A.top, c0736b.bottomMargin + this.f2280A.bottom);
        if (z ? m3404a(view, b, b2, (C0679i) c0736b) : m3418b(view, b, b2, c0736b)) {
            view.measure(b, b2);
        }
    }

    private void m3951a(View view, C0736b c0736b, aq aqVar) {
        if (aqVar.f2466e == 1) {
            if (c0736b.f2257b) {
                m3969p(view);
            } else {
                c0736b.f2256a.m3928b(view);
            }
        } else if (c0736b.f2257b) {
            m3971q(view);
        } else {
            c0736b.f2256a.m3924a(view);
        }
    }

    private void m3952a(View view, C0736b c0736b, boolean z) {
        if (c0736b.f2257b) {
            if (this.f2295j == 1) {
                m3950a(view, this.f2303z, C0681h.m3344a(m3476y(), m3474w(), 0, c0736b.height, true), z);
            } else {
                m3950a(view, C0681h.m3344a(m3475x(), m3473v(), 0, c0736b.width, true), this.f2303z, z);
            }
        } else if (this.f2295j == 1) {
            m3950a(view, C0681h.m3344a(this.f2296k, m3473v(), 0, c0736b.width, false), C0681h.m3344a(m3476y(), m3474w(), 0, c0736b.height, true), z);
        } else {
            m3950a(view, C0681h.m3344a(m3475x(), m3473v(), 0, c0736b.width, true), C0681h.m3344a(this.f2296k, m3474w(), 0, c0736b.height, false), z);
        }
    }

    private boolean m3953a(C0742e c0742e) {
        boolean z = true;
        if (this.f2290e) {
            if (c0742e.m3932d() < this.f2287b.mo725d()) {
                return !c0742e.m3929c((View) c0742e.f2274a.get(c0742e.f2274a.size() + -1)).f2257b;
            }
        } else if (c0742e.m3926b() > this.f2287b.mo723c()) {
            if (c0742e.m3929c((View) c0742e.f2274a.get(0)).f2257b) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int m3954b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m3955b(C0721t c0721t) {
        boolean z = true;
        if (m3472u() == 0) {
            return 0;
        }
        ax axVar = this.f2287b;
        View b = m4005b(!this.f2283D);
        if (this.f2283D) {
            z = false;
        }
        return bd.m4467a(c0721t, axVar, b, m4015d(z), this, this.f2283D, this.f2290e);
    }

    private void m3956b(int i, C0721t c0721t) {
        int c;
        int i2;
        aq aqVar;
        boolean z = false;
        this.f2297l.f2463b = 0;
        this.f2297l.f2464c = i;
        if (m3469r()) {
            c = c0721t.m3794c();
            if (c != -1) {
                if (this.f2290e == (c < i)) {
                    c = this.f2287b.mo729f();
                    i2 = 0;
                } else {
                    i2 = this.f2287b.mo729f();
                    c = 0;
                }
                if (m3468q()) {
                    this.f2297l.f2468g = c + this.f2287b.mo727e();
                    this.f2297l.f2467f = -i2;
                } else {
                    this.f2297l.f2467f = this.f2287b.mo723c() - i2;
                    this.f2297l.f2468g = c + this.f2287b.mo725d();
                }
                this.f2297l.f2469h = false;
                this.f2297l.f2462a = true;
                aqVar = this.f2297l;
                if (this.f2287b.mo732h() == 0 && this.f2287b.mo727e() == 0) {
                    z = true;
                }
                aqVar.f2470i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m3468q()) {
            this.f2297l.f2468g = c + this.f2287b.mo727e();
            this.f2297l.f2467f = -i2;
        } else {
            this.f2297l.f2467f = this.f2287b.mo723c() - i2;
            this.f2297l.f2468g = c + this.f2287b.mo725d();
        }
        this.f2297l.f2469h = false;
        this.f2297l.f2462a = true;
        aqVar = this.f2297l;
        z = true;
        aqVar.f2470i = z;
    }

    private void m3957b(C0714o c0714o, int i) {
        int u = m3472u() - 1;
        while (u >= 0) {
            View h = m3453h(u);
            if (this.f2287b.mo720a(h) >= i && this.f2287b.mo726d(h) >= i) {
                C0736b c0736b = (C0736b) h.getLayoutParams();
                if (c0736b.f2257b) {
                    int i2 = 0;
                    while (i2 < this.f2294i) {
                        if (this.f2286a[i2].f2274a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (i2 = 0; i2 < this.f2294i; i2++) {
                        this.f2286a[i2].m3936g();
                    }
                } else if (c0736b.f2256a.f2274a.size() != 1) {
                    c0736b.f2256a.m3936g();
                } else {
                    return;
                }
                m3392a(h, c0714o);
                u--;
            } else {
                return;
            }
        }
    }

    private void m3958b(C0714o c0714o, C0721t c0721t, boolean z) {
        int q = m3970q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f2287b.mo725d() - q;
            if (q > 0) {
                q -= -m4010c(-q, c0714o, c0721t);
                if (z && q > 0) {
                    this.f2287b.mo721a(q);
                }
            }
        }
    }

    private void m3959c(int i, int i2, int i3) {
        int i4;
        int i5;
        int J = this.f2290e ? m3978J() : m3979K();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f2293h.m3911b(i5);
        switch (i3) {
            case 1:
                this.f2293h.m3912b(i, i2);
                break;
            case 2:
                this.f2293h.m3908a(i, i2);
                break;
            case 8:
                this.f2293h.m3908a(i, 1);
                this.f2293h.m3912b(i2, 1);
                break;
        }
        if (i4 > J) {
            if (i5 <= (this.f2290e ? m3979K() : m3978J())) {
                m3464n();
            }
        }
    }

    private void m3960c(C0714o c0714o, C0721t c0721t, boolean z) {
        int p = m3968p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f2287b.mo723c();
            if (p > 0) {
                p -= m4010c(p, c0714o, c0721t);
                if (z && p > 0) {
                    this.f2287b.mo721a(-p);
                }
            }
        }
    }

    private boolean m3961c(C0721t c0721t, C0735a c0735a) {
        c0735a.f2249a = this.f2300o ? m3976v(c0721t.m3796e()) : m3975u(c0721t.m3796e());
        c0735a.f2250b = Integer.MIN_VALUE;
        return true;
    }

    private int m3962i(C0721t c0721t) {
        boolean z = true;
        if (m3472u() == 0) {
            return 0;
        }
        ax axVar = this.f2287b;
        View b = m4005b(!this.f2283D);
        if (this.f2283D) {
            z = false;
        }
        return bd.m4466a(c0721t, axVar, b, m4015d(z), this, this.f2283D);
    }

    private int m3963j(C0721t c0721t) {
        boolean z = true;
        if (m3472u() == 0) {
            return 0;
        }
        ax axVar = this.f2287b;
        View b = m4005b(!this.f2283D);
        if (this.f2283D) {
            z = false;
        }
        return bd.m4468b(c0721t, axVar, b, m4015d(z), this, this.f2283D);
    }

    private void m3964l(int i) {
        int i2 = 1;
        this.f2297l.f2466e = i;
        aq aqVar = this.f2297l;
        if (this.f2290e != (i == -1)) {
            i2 = -1;
        }
        aqVar.f2465d = i2;
    }

    private C0738a m3965m(int i) {
        C0738a c0738a = new C0738a();
        c0738a.f2260c = new int[this.f2294i];
        for (int i2 = 0; i2 < this.f2294i; i2++) {
            c0738a.f2260c[i2] = i - this.f2286a[i2].m3927b(i);
        }
        return c0738a;
    }

    private C0738a m3966n(int i) {
        C0738a c0738a = new C0738a();
        c0738a.f2260c = new int[this.f2294i];
        for (int i2 = 0; i2 < this.f2294i; i2++) {
            c0738a.f2260c[i2] = this.f2286a[i2].m3921a(i) - i;
        }
        return c0738a;
    }

    private int m3967o(int i) {
        int a = this.f2286a[0].m3921a(i);
        for (int i2 = 1; i2 < this.f2294i; i2++) {
            int a2 = this.f2286a[i2].m3921a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m3968p(int i) {
        int a = this.f2286a[0].m3921a(i);
        for (int i2 = 1; i2 < this.f2294i; i2++) {
            int a2 = this.f2286a[i2].m3921a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void m3969p(View view) {
        for (int i = this.f2294i - 1; i >= 0; i--) {
            this.f2286a[i].m3928b(view);
        }
    }

    private int m3970q(int i) {
        int b = this.f2286a[0].m3927b(i);
        for (int i2 = 1; i2 < this.f2294i; i2++) {
            int b2 = this.f2286a[i2].m3927b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void m3971q(View view) {
        for (int i = this.f2294i - 1; i >= 0; i--) {
            this.f2286a[i].m3924a(view);
        }
    }

    private int m3972r(int i) {
        int b = this.f2286a[0].m3927b(i);
        for (int i2 = 1; i2 < this.f2294i; i2++) {
            int b2 = this.f2286a[i2].m3927b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean m3973s(int i) {
        if (this.f2295j == 0) {
            return (i == -1) != this.f2290e;
        } else {
            return ((i == -1) == this.f2290e) == m4028i();
        }
    }

    private int m3974t(int i) {
        int i2 = -1;
        if (m3472u() == 0) {
            return this.f2290e ? 1 : -1;
        } else {
            if ((i < m3979K()) == this.f2290e) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int m3975u(int i) {
        int u = m3472u();
        for (int i2 = 0; i2 < u; i2++) {
            int d = m3432d(m3453h(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m3976v(int i) {
        for (int u = m3472u() - 1; u >= 0; u--) {
            int d = m3432d(m3453h(u));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m3977w(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case 1:
                return (this.f2295j == 1 || !m4028i()) ? -1 : 1;
            case 2:
                return this.f2295j == 1 ? 1 : !m4028i() ? 1 : -1;
            case 17:
                return this.f2295j != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f2295j != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f2295j != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.f2295j == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    int m3978J() {
        int u = m3472u();
        return u == 0 ? 0 : m3432d(m3453h(u - 1));
    }

    int m3979K() {
        return m3472u() == 0 ? 0 : m3432d(m3453h(0));
    }

    public int mo606a(int i, C0714o c0714o, C0721t c0721t) {
        return m4010c(i, c0714o, c0721t);
    }

    public int mo632a(C0714o c0714o, C0721t c0721t) {
        return this.f2295j == 0 ? this.f2294i : super.mo632a(c0714o, c0721t);
    }

    public C0679i mo607a() {
        return this.f2295j == 0 ? new C0736b(-2, -1) : new C0736b(-1, -2);
    }

    public C0679i mo633a(Context context, AttributeSet attributeSet) {
        return new C0736b(context, attributeSet);
    }

    public C0679i mo634a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0736b((MarginLayoutParams) layoutParams) : new C0736b(layoutParams);
    }

    public View mo608a(View view, int i, C0714o c0714o, C0721t c0721t) {
        int i2 = 0;
        if (m3472u() == 0) {
            return null;
        }
        View e = m3439e(view);
        if (e == null) {
            return null;
        }
        m3940M();
        int w = m3977w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        C0736b c0736b = (C0736b) e.getLayoutParams();
        boolean z = c0736b.f2257b;
        C0742e c0742e = c0736b.f2256a;
        int J = w == 1 ? m3978J() : m3979K();
        m3956b(J, c0721t);
        m3964l(w);
        this.f2297l.f2464c = this.f2297l.f2465d + J;
        this.f2297l.f2463b = (int) (0.33333334f * ((float) this.f2287b.mo729f()));
        this.f2297l.f2469h = true;
        this.f2297l.f2462a = false;
        m3942a(c0714o, this.f2297l, c0721t);
        this.f2300o = this.f2290e;
        if (!z) {
            a = c0742e.m3922a(J, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m3973s(w)) {
            for (int i3 = this.f2294i - 1; i3 >= 0; i3--) {
                View a2 = this.f2286a[i3].m3922a(J, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f2294i) {
                a = this.f2286a[i2].m3922a(J, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    public void m3986a(int i) {
        mo615a(null);
        if (i != this.f2294i) {
            m4026h();
            this.f2294i = i;
            this.f2298m = new BitSet(this.f2294i);
            this.f2286a = new C0742e[this.f2294i];
            for (int i2 = 0; i2 < this.f2294i; i2++) {
                this.f2286a[i2] = new C0742e(this, i2);
            }
            m3464n();
        }
    }

    public void mo609a(int i, int i2, C0721t c0721t, C0706a c0706a) {
        int i3 = 0;
        if (this.f2295j != 0) {
            i = i2;
        }
        if (m3472u() != 0 && i != 0) {
            m3988a(i, c0721t);
            if (this.f2284E == null || this.f2284E.length < this.f2294i) {
                this.f2284E = new int[this.f2294i];
            }
            for (int i4 = 0; i4 < this.f2294i; i4++) {
                this.f2284E[i4] = this.f2297l.f2465d == -1 ? this.f2297l.f2467f - this.f2286a[i4].m3921a(this.f2297l.f2467f) : this.f2286a[i4].m3927b(this.f2297l.f2468g) - this.f2297l.f2468g;
            }
            Arrays.sort(this.f2284E, 0, this.f2294i);
            while (i3 < this.f2294i && this.f2297l.m4324a(c0721t)) {
                c0706a.mo708b(this.f2297l.f2464c, this.f2284E[i3]);
                aq aqVar = this.f2297l;
                aqVar.f2464c += this.f2297l.f2465d;
                i3++;
            }
        }
    }

    void m3988a(int i, C0721t c0721t) {
        int J;
        int i2;
        if (i > 0) {
            J = m3978J();
            i2 = 1;
        } else {
            i2 = -1;
            J = m3979K();
        }
        this.f2297l.f2462a = true;
        m3956b(J, c0721t);
        m3964l(i2);
        this.f2297l.f2464c = this.f2297l.f2465d + J;
        this.f2297l.f2463b = Math.abs(i);
    }

    public void mo636a(Rect rect, int i, int i2) {
        int B = m3353B() + m3477z();
        int A = m3352A() + m3354C();
        if (this.f2295j == 1) {
            A = C0681h.m3343a(i2, A + rect.height(), m3357F());
            B = C0681h.m3343a(i, B + (this.f2296k * this.f2294i), m3356E());
        } else {
            B = C0681h.m3343a(i, B + rect.width(), m3356E());
            A = C0681h.m3343a(i2, A + (this.f2296k * this.f2294i), m3357F());
        }
        m3440e(B, A);
    }

    public void mo611a(Parcelable parcelable) {
        if (parcelable instanceof C0741d) {
            this.f2302y = (C0741d) parcelable;
            m3464n();
        }
    }

    public void mo639a(C0714o c0714o, C0721t c0721t, View view, C0369b c0369b) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0736b) {
            C0736b c0736b = (C0736b) layoutParams;
            if (this.f2295j == 0) {
                c0369b.m1712b(C0368k.m1701a(c0736b.m3898b(), c0736b.f2257b ? this.f2294i : 1, -1, -1, c0736b.f2257b, false));
                return;
            } else {
                c0369b.m1712b(C0368k.m1701a(-1, -1, c0736b.m3898b(), c0736b.f2257b ? this.f2294i : 1, c0736b.f2257b, false));
                return;
            }
        }
        super.m3391a(view, c0369b);
    }

    public void mo612a(C0721t c0721t) {
        super.mo612a(c0721t);
        this.f2291f = -1;
        this.f2292g = Integer.MIN_VALUE;
        this.f2302y = null;
        this.f2281B.m3893a();
    }

    void m3993a(C0721t c0721t, C0735a c0735a) {
        if (!m4009b(c0721t, c0735a) && !m3961c(c0721t, c0735a)) {
            c0735a.m3896b();
            c0735a.f2249a = 0;
        }
    }

    public void mo641a(RecyclerView recyclerView) {
        this.f2293h.m3907a();
        m3464n();
    }

    public void mo642a(RecyclerView recyclerView, int i, int i2) {
        m3959c(i, i2, 1);
    }

    public void mo643a(RecyclerView recyclerView, int i, int i2, int i3) {
        m3959c(i, i2, 8);
    }

    public void mo644a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m3959c(i, i2, 4);
    }

    public void mo613a(RecyclerView recyclerView, C0714o c0714o) {
        m3406a(this.f2285F);
        for (int i = 0; i < this.f2294i; i++) {
            this.f2286a[i].m3934e();
        }
        recyclerView.requestLayout();
    }

    public void mo614a(AccessibilityEvent accessibilityEvent) {
        super.mo614a(accessibilityEvent);
        if (m3472u() > 0) {
            C0386f a = C0357a.m1685a(accessibilityEvent);
            View b = m4005b(false);
            View d = m4015d(false);
            if (b != null && d != null) {
                int d2 = m3432d(b);
                int d3 = m3432d(d);
                if (d2 < d3) {
                    a.m1763b(d2);
                    a.m1764c(d3);
                    return;
                }
                a.m1763b(d3);
                a.m1764c(d2);
            }
        }
    }

    public void mo615a(String str) {
        if (this.f2302y == null) {
            super.mo615a(str);
        }
    }

    public void m4001a(boolean z) {
        mo615a(null);
        if (!(this.f2302y == null || this.f2302y.f2271h == z)) {
            this.f2302y.f2271h = z;
        }
        this.f2289d = z;
        m3464n();
    }

    public boolean mo646a(C0679i c0679i) {
        return c0679i instanceof C0736b;
    }

    public int mo616b(int i, C0714o c0714o, C0721t c0721t) {
        return m4010c(i, c0714o, c0721t);
    }

    public int mo647b(C0714o c0714o, C0721t c0721t) {
        return this.f2295j == 1 ? this.f2294i : super.mo647b(c0714o, c0721t);
    }

    View m4005b(boolean z) {
        int c = this.f2287b.mo723c();
        int d = this.f2287b.mo725d();
        int u = m3472u();
        View view = null;
        for (int i = 0; i < u; i++) {
            View h = m3453h(i);
            int a = this.f2287b.mo720a(h);
            if (this.f2287b.mo722b(h) > c && a < d) {
                if (a >= c || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void m4006b(int i) {
        if (i == 0 || i == 1) {
            mo615a(null);
            if (i != this.f2295j) {
                this.f2295j = i;
                ax axVar = this.f2287b;
                this.f2287b = this.f2288c;
                this.f2288c = axVar;
                m3464n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void mo648b(RecyclerView recyclerView, int i, int i2) {
        m3959c(i, i2, 2);
    }

    public boolean mo617b() {
        return this.f2302y == null;
    }

    boolean m4009b(C0721t c0721t, C0735a c0735a) {
        boolean z = false;
        if (c0721t.m3792a() || this.f2291f == -1) {
            return false;
        }
        if (this.f2291f < 0 || this.f2291f >= c0721t.m3796e()) {
            this.f2291f = -1;
            this.f2292g = Integer.MIN_VALUE;
            return false;
        } else if (this.f2302y == null || this.f2302y.f2264a == -1 || this.f2302y.f2266c < 1) {
            View c = mo620c(this.f2291f);
            if (c != null) {
                c0735a.f2249a = this.f2290e ? m3978J() : m3979K();
                if (this.f2292g != Integer.MIN_VALUE) {
                    if (c0735a.f2251c) {
                        c0735a.f2250b = (this.f2287b.mo725d() - this.f2292g) - this.f2287b.mo722b(c);
                        return true;
                    }
                    c0735a.f2250b = (this.f2287b.mo723c() + this.f2292g) - this.f2287b.mo720a(c);
                    return true;
                } else if (this.f2287b.mo728e(c) > this.f2287b.mo729f()) {
                    c0735a.f2250b = c0735a.f2251c ? this.f2287b.mo725d() : this.f2287b.mo723c();
                    return true;
                } else {
                    int a = this.f2287b.mo720a(c) - this.f2287b.mo723c();
                    if (a < 0) {
                        c0735a.f2250b = -a;
                        return true;
                    }
                    a = this.f2287b.mo725d() - this.f2287b.mo722b(c);
                    if (a < 0) {
                        c0735a.f2250b = a;
                        return true;
                    }
                    c0735a.f2250b = Integer.MIN_VALUE;
                    return true;
                }
            }
            c0735a.f2249a = this.f2291f;
            if (this.f2292g == Integer.MIN_VALUE) {
                if (m3974t(c0735a.f2249a) == 1) {
                    z = true;
                }
                c0735a.f2251c = z;
                c0735a.m3896b();
            } else {
                c0735a.m3894a(this.f2292g);
            }
            c0735a.f2252d = true;
            return true;
        } else {
            c0735a.f2250b = Integer.MIN_VALUE;
            c0735a.f2249a = this.f2291f;
            return true;
        }
    }

    int m4010c(int i, C0714o c0714o, C0721t c0721t) {
        if (m3472u() == 0 || i == 0) {
            return 0;
        }
        m3988a(i, c0721t);
        int a = m3942a(c0714o, this.f2297l, c0721t);
        if (this.f2297l.f2463b >= a) {
            i = i < 0 ? -a : a;
        }
        this.f2287b.mo721a(-i);
        this.f2300o = this.f2290e;
        this.f2297l.f2463b = 0;
        m3947a(c0714o, this.f2297l);
        return i;
    }

    public int mo618c(C0721t c0721t) {
        return m3955b(c0721t);
    }

    public Parcelable mo619c() {
        if (this.f2302y != null) {
            return new C0741d(this.f2302y);
        }
        C0741d c0741d = new C0741d();
        c0741d.f2271h = this.f2289d;
        c0741d.f2272i = this.f2300o;
        c0741d.f2273j = this.f2301x;
        if (this.f2293h == null || this.f2293h.f2262a == null) {
            c0741d.f2268e = 0;
        } else {
            c0741d.f2269f = this.f2293h.f2262a;
            c0741d.f2268e = c0741d.f2269f.length;
            c0741d.f2270g = this.f2293h.f2263b;
        }
        if (m3472u() > 0) {
            c0741d.f2264a = this.f2300o ? m3978J() : m3979K();
            c0741d.f2265b = m4029j();
            c0741d.f2266c = this.f2294i;
            c0741d.f2267d = new int[this.f2294i];
            for (int i = 0; i < this.f2294i; i++) {
                int b;
                if (this.f2300o) {
                    b = this.f2286a[i].m3927b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f2287b.mo725d();
                    }
                } else {
                    b = this.f2286a[i].m3921a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f2287b.mo723c();
                    }
                }
                c0741d.f2267d[i] = b;
            }
        } else {
            c0741d.f2264a = -1;
            c0741d.f2265b = -1;
            c0741d.f2266c = 0;
        }
        return c0741d;
    }

    public void mo621c(C0714o c0714o, C0721t c0721t) {
        m3946a(c0714o, c0721t, true);
    }

    public int mo622d(C0721t c0721t) {
        return m3955b(c0721t);
    }

    View m4015d(boolean z) {
        int c = this.f2287b.mo723c();
        int d = this.f2287b.mo725d();
        View view = null;
        for (int u = m3472u() - 1; u >= 0; u--) {
            View h = m3453h(u);
            int a = this.f2287b.mo720a(h);
            int b = this.f2287b.mo722b(h);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return h;
                }
                if (view == null) {
                    view = h;
                }
            }
        }
        return view;
    }

    public void mo623d(int i) {
        if (!(this.f2302y == null || this.f2302y.f2264a == i)) {
            this.f2302y.m3920b();
        }
        this.f2291f = i;
        this.f2292g = Integer.MIN_VALUE;
        m3464n();
    }

    public boolean mo624d() {
        return this.f2295j == 0;
    }

    public int mo625e(C0721t c0721t) {
        return m3962i(c0721t);
    }

    void m4019e(int i) {
        this.f2296k = i / this.f2294i;
        this.f2303z = MeasureSpec.makeMeasureSpec(i, this.f2288c.mo732h());
    }

    public boolean mo626e() {
        return this.f2295j == 1;
    }

    public int mo627f(C0721t c0721t) {
        return m3962i(c0721t);
    }

    boolean m4022f() {
        if (m3472u() == 0 || this.f2299n == 0 || !m3467p()) {
            return false;
        }
        int J;
        int K;
        if (this.f2290e) {
            J = m3978J();
            K = m3979K();
        } else {
            J = m3979K();
            K = m3978J();
        }
        if (J == 0 && m4024g() != null) {
            this.f2293h.m3907a();
            m3359H();
            m3464n();
            return true;
        } else if (!this.f2282C) {
            return false;
        } else {
            int i = this.f2290e ? -1 : 1;
            C0738a a = this.f2293h.m3906a(J, K + 1, i, true);
            if (a == null) {
                this.f2282C = false;
                this.f2293h.m3905a(K + 1);
                return false;
            }
            C0738a a2 = this.f2293h.m3906a(J, a.f2258a, i * -1, true);
            if (a2 == null) {
                this.f2293h.m3905a(a.f2258a);
            } else {
                this.f2293h.m3905a(a2.f2258a + 1);
            }
            m3359H();
            m3464n();
            return true;
        }
    }

    public int mo628g(C0721t c0721t) {
        return m3963j(c0721t);
    }

    View m4024g() {
        int i;
        int u = m3472u() - 1;
        BitSet bitSet = new BitSet(this.f2294i);
        bitSet.set(0, this.f2294i, true);
        boolean z = (this.f2295j == 1 && m4028i()) ? true : true;
        if (this.f2290e) {
            i = -1;
        } else {
            i = u + 1;
            u = 0;
        }
        int i2 = u < i ? 1 : -1;
        int i3 = u;
        while (i3 != i) {
            View h = m3453h(i3);
            C0736b c0736b = (C0736b) h.getLayoutParams();
            if (bitSet.get(c0736b.f2256a.f2278e)) {
                if (m3953a(c0736b.f2256a)) {
                    return h;
                }
                bitSet.clear(c0736b.f2256a.f2278e);
            }
            if (!(c0736b.f2257b || i3 + i2 == i)) {
                boolean z2;
                View h2 = m3453h(i3 + i2);
                int b;
                if (this.f2290e) {
                    u = this.f2287b.mo722b(h);
                    b = this.f2287b.mo722b(h2);
                    if (u < b) {
                        return h;
                    }
                    if (u == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    u = this.f2287b.mo720a(h);
                    b = this.f2287b.mo720a(h2);
                    if (u > b) {
                        return h;
                    }
                    if (u == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((c0736b.f2256a.f2278e - ((C0736b) h2.getLayoutParams()).f2256a.f2278e < 0) != (z >= false)) {
                        return h;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public int mo629h(C0721t c0721t) {
        return m3963j(c0721t);
    }

    public void m4026h() {
        this.f2293h.m3907a();
        m3464n();
    }

    public void mo674i(int i) {
        super.mo674i(i);
        for (int i2 = 0; i2 < this.f2294i; i2++) {
            this.f2286a[i2].m3933d(i);
        }
    }

    boolean m4028i() {
        return m3470s() == 1;
    }

    int m4029j() {
        View d = this.f2290e ? m4015d(true) : m4005b(true);
        return d == null ? -1 : m3432d(d);
    }

    public void mo675j(int i) {
        super.mo675j(i);
        for (int i2 = 0; i2 < this.f2294i; i2++) {
            this.f2286a[i2].m3933d(i);
        }
    }

    public void mo676k(int i) {
        if (i == 0) {
            m4022f();
        }
    }

    boolean m4032l() {
        int b = this.f2286a[0].m3927b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2294i; i++) {
            if (this.f2286a[i].m3927b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    boolean m4033m() {
        int a = this.f2286a[0].m3921a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2294i; i++) {
            if (this.f2286a[i].m3921a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }
}
