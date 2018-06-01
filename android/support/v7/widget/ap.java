package android.support.v7.widget;

import android.support.v4.p009e.C0314e;
import android.support.v7.widget.RecyclerView.C0681h;
import android.support.v7.widget.RecyclerView.C0681h.C0706a;
import android.support.v7.widget.RecyclerView.C0714o;
import android.support.v7.widget.RecyclerView.C0724w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class ap implements Runnable {
    static final ThreadLocal<ap> f2456a = new ThreadLocal();
    static Comparator<C0772b> f2457e = new C07701();
    ArrayList<RecyclerView> f2458b = new ArrayList();
    long f2459c;
    long f2460d;
    private ArrayList<C0772b> f2461f = new ArrayList();

    static class C07701 implements Comparator<C0772b> {
        C07701() {
        }

        public int m4306a(C0772b c0772b, C0772b c0772b2) {
            int i = -1;
            if ((c0772b.f2454d == null ? 1 : 0) != (c0772b2.f2454d == null ? 1 : 0)) {
                return c0772b.f2454d == null ? 1 : -1;
            } else {
                if (c0772b.f2451a != c0772b2.f2451a) {
                    if (!c0772b.f2451a) {
                        i = 1;
                    }
                    return i;
                }
                int i2 = c0772b2.f2452b - c0772b.f2452b;
                if (i2 != 0) {
                    return i2;
                }
                i2 = c0772b.f2453c - c0772b2.f2453c;
                return i2 == 0 ? 0 : i2;
            }
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4306a((C0772b) obj, (C0772b) obj2);
        }
    }

    static class C0771a implements C0706a {
        int f2447a;
        int f2448b;
        int[] f2449c;
        int f2450d;

        C0771a() {
        }

        void m4307a() {
            if (this.f2449c != null) {
                Arrays.fill(this.f2449c, -1);
            }
        }

        void m4308a(int i, int i2) {
            this.f2447a = i;
            this.f2448b = i2;
        }

        void m4309a(RecyclerView recyclerView, boolean z) {
            this.f2450d = 0;
            if (this.f2449c != null) {
                Arrays.fill(this.f2449c, -1);
            }
            C0681h c0681h = recyclerView.f215m;
            if (recyclerView.f214l != null && c0681h != null && c0681h.m3466o()) {
                if (z) {
                    if (!recyclerView.f207e.m4695d()) {
                        c0681h.mo610a(recyclerView.f214l.mo839a(), (C0706a) this);
                    }
                } else if (!recyclerView.m300v()) {
                    c0681h.mo609a(this.f2447a, this.f2448b, recyclerView.f189A, (C0706a) this);
                }
                if (this.f2450d > c0681h.f2045v) {
                    c0681h.f2045v = this.f2450d;
                    c0681h.f2046w = z;
                    recyclerView.f206d.m3746b();
                }
            }
        }

        boolean m4310a(int i) {
            if (this.f2449c == null) {
                return false;
            }
            int i2 = this.f2450d * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.f2449c[i3] == i) {
                    return true;
                }
            }
            return false;
        }

        public void mo708b(int i, int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f2450d * 2;
            if (this.f2449c == null) {
                this.f2449c = new int[4];
                Arrays.fill(this.f2449c, -1);
            } else if (i3 >= this.f2449c.length) {
                Object obj = this.f2449c;
                this.f2449c = new int[(i3 * 2)];
                System.arraycopy(obj, 0, this.f2449c, 0, obj.length);
            }
            this.f2449c[i3] = i;
            this.f2449c[i3 + 1] = i2;
            this.f2450d++;
        }
    }

    static class C0772b {
        public boolean f2451a;
        public int f2452b;
        public int f2453c;
        public RecyclerView f2454d;
        public int f2455e;

        C0772b() {
        }

        public void m4312a() {
            this.f2451a = false;
            this.f2452b = 0;
            this.f2453c = 0;
            this.f2454d = null;
            this.f2455e = 0;
        }
    }

    ap() {
    }

    private C0724w m4313a(RecyclerView recyclerView, int i, long j) {
        if (m4317a(recyclerView, i)) {
            return null;
        }
        C0714o c0714o = recyclerView.f206d;
        C0724w a = c0714o.m3731a(i, false, j);
        if (a == null) {
            return a;
        }
        if (a.m3846p()) {
            c0714o.m3742a(a.f2170a);
            return a;
        }
        c0714o.m3741a(a, false);
        return a;
    }

    private void m4314a() {
        int size = this.f2458b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = (RecyclerView) this.f2458b.get(i2);
            recyclerView.f228z.m4309a(recyclerView, false);
            i += recyclerView.f228z.f2450d;
        }
        this.f2461f.ensureCapacity(i);
        int i3 = 0;
        boolean z = false;
        while (i3 < size) {
            recyclerView = (RecyclerView) this.f2458b.get(i3);
            C0771a c0771a = recyclerView.f228z;
            int abs = Math.abs(c0771a.f2447a) + Math.abs(c0771a.f2448b);
            boolean z2 = z;
            for (i = 0; i < c0771a.f2450d * 2; i += 2) {
                C0772b c0772b;
                if (z2 >= this.f2461f.size()) {
                    c0772b = new C0772b();
                    this.f2461f.add(c0772b);
                } else {
                    c0772b = (C0772b) this.f2461f.get(z2);
                }
                int i4 = c0771a.f2449c[i + 1];
                c0772b.f2451a = i4 <= abs;
                c0772b.f2452b = abs;
                c0772b.f2453c = i4;
                c0772b.f2454d = recyclerView;
                c0772b.f2455e = c0771a.f2449c[i];
                z2++;
            }
            i3++;
            z = z2;
        }
        Collections.sort(this.f2461f, f2457e);
    }

    private void m4315a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.f224v && recyclerView.f208f.m4192c() != 0) {
                recyclerView.m255b();
            }
            C0771a c0771a = recyclerView.f228z;
            c0771a.m4309a(recyclerView, true);
            if (c0771a.f2450d != 0) {
                try {
                    C0314e.m1529a("RV Nested Prefetch");
                    recyclerView.f189A.m3791a(recyclerView.f214l);
                    for (int i = 0; i < c0771a.f2450d * 2; i += 2) {
                        m4313a(recyclerView, c0771a.f2449c[i], j);
                    }
                } finally {
                    C0314e.m1528a();
                }
            }
        }
    }

    private void m4316a(C0772b c0772b, long j) {
        C0724w a = m4313a(c0772b.f2454d, c0772b.f2455e, c0772b.f2451a ? Long.MAX_VALUE : j);
        if (a != null && a.f2171b != null) {
            m4315a((RecyclerView) a.f2171b.get(), j);
        }
    }

    static boolean m4317a(RecyclerView recyclerView, int i) {
        int c = recyclerView.f208f.m4192c();
        for (int i2 = 0; i2 < c; i2++) {
            C0724w e = RecyclerView.m227e(recyclerView.f208f.m4195d(i2));
            if (e.f2172c == i && !e.m3844n()) {
                return true;
            }
        }
        return false;
    }

    private void m4318b(long j) {
        int i = 0;
        while (i < this.f2461f.size()) {
            C0772b c0772b = (C0772b) this.f2461f.get(i);
            if (c0772b.f2454d != null) {
                m4316a(c0772b, j);
                c0772b.m4312a();
                i++;
            } else {
                return;
            }
        }
    }

    void m4319a(long j) {
        m4314a();
        m4318b(j);
    }

    public void m4320a(RecyclerView recyclerView) {
        this.f2458b.add(recyclerView);
    }

    void m4321a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2459c == 0) {
            this.f2459c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f228z.m4308a(i, i2);
    }

    public void m4322b(RecyclerView recyclerView) {
        this.f2458b.remove(recyclerView);
    }

    public void run() {
        try {
            C0314e.m1529a("RV Prefetch");
            if (!this.f2458b.isEmpty()) {
                long toNanos = TimeUnit.MILLISECONDS.toNanos(((RecyclerView) this.f2458b.get(0)).getDrawingTime());
                if (toNanos == 0) {
                    this.f2459c = 0;
                    C0314e.m1528a();
                    return;
                }
                m4319a(toNanos + this.f2460d);
                this.f2459c = 0;
                C0314e.m1528a();
            }
        } finally {
            this.f2459c = 0;
            C0314e.m1528a();
        }
    }
}
