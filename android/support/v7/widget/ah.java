package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0724w;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ah {
    final C0692b f2379a;
    final C0756a f2380b = new C0756a();
    final List<View> f2381c = new ArrayList();

    interface C0692b {
        int mo653a();

        int mo654a(View view);

        void mo655a(int i);

        void mo656a(View view, int i);

        void mo657a(View view, int i, LayoutParams layoutParams);

        C0724w mo658b(View view);

        View mo659b(int i);

        void mo660b();

        void mo661c(int i);

        void mo662c(View view);

        void mo663d(View view);
    }

    static class C0756a {
        long f2377a = 0;
        C0756a f2378b;

        C0756a() {
        }

        private void m4172b() {
            if (this.f2378b == null) {
                this.f2378b = new C0756a();
            }
        }

        void m4173a() {
            this.f2377a = 0;
            if (this.f2378b != null) {
                this.f2378b.m4173a();
            }
        }

        void m4174a(int i) {
            if (i >= 64) {
                m4172b();
                this.f2378b.m4174a(i - 64);
                return;
            }
            this.f2377a |= 1 << i;
        }

        void m4175a(int i, boolean z) {
            if (i >= 64) {
                m4172b();
                this.f2378b.m4175a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2377a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f2377a = (((j ^ -1) & this.f2377a) << 1) | (this.f2377a & j);
            if (z) {
                m4174a(i);
            } else {
                m4176b(i);
            }
            if (z2 || this.f2378b != null) {
                m4172b();
                this.f2378b.m4175a(0, z2);
            }
        }

        void m4176b(int i) {
            if (i < 64) {
                this.f2377a &= (1 << i) ^ -1;
            } else if (this.f2378b != null) {
                this.f2378b.m4176b(i - 64);
            }
        }

        boolean m4177c(int i) {
            if (i < 64) {
                return (this.f2377a & (1 << i)) != 0;
            } else {
                m4172b();
                return this.f2378b.m4177c(i - 64);
            }
        }

        boolean m4178d(int i) {
            if (i >= 64) {
                m4172b();
                return this.f2378b.m4178d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2377a & j) != 0;
            this.f2377a &= j ^ -1;
            j--;
            this.f2377a = Long.rotateRight((j ^ -1) & this.f2377a, 1) | (this.f2377a & j);
            if (this.f2378b == null) {
                return z;
            }
            if (this.f2378b.m4177c(0)) {
                m4174a(63);
            }
            this.f2378b.m4178d(0);
            return z;
        }

        int m4179e(int i) {
            return this.f2378b == null ? i >= 64 ? Long.bitCount(this.f2377a) : Long.bitCount(this.f2377a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f2377a & ((1 << i) - 1)) : this.f2378b.m4179e(i - 64) + Long.bitCount(this.f2377a);
        }

        public String toString() {
            return this.f2378b == null ? Long.toBinaryString(this.f2377a) : this.f2378b.toString() + "xx" + Long.toBinaryString(this.f2377a);
        }
    }

    ah(C0692b c0692b) {
        this.f2379a = c0692b;
    }

    private int m4180f(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2379a.mo653a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2380b.m4179e(i2));
            if (e == 0) {
                while (this.f2380b.m4177c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void m4181g(View view) {
        this.f2381c.add(view);
        this.f2379a.mo662c(view);
    }

    private boolean m4182h(View view) {
        if (!this.f2381c.remove(view)) {
            return false;
        }
        this.f2379a.mo663d(view);
        return true;
    }

    void m4183a() {
        this.f2380b.m4173a();
        for (int size = this.f2381c.size() - 1; size >= 0; size--) {
            this.f2379a.mo663d((View) this.f2381c.get(size));
            this.f2381c.remove(size);
        }
        this.f2379a.mo660b();
    }

    void m4184a(int i) {
        int f = m4180f(i);
        View b = this.f2379a.mo659b(f);
        if (b != null) {
            if (this.f2380b.m4178d(f)) {
                m4182h(b);
            }
            this.f2379a.mo655a(f);
        }
    }

    void m4185a(View view) {
        int a = this.f2379a.mo654a(view);
        if (a >= 0) {
            if (this.f2380b.m4178d(a)) {
                m4182h(view);
            }
            this.f2379a.mo655a(a);
        }
    }

    void m4186a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.f2379a.mo653a() : m4180f(i);
        this.f2380b.m4175a(a, z);
        if (z) {
            m4181g(view);
        }
        this.f2379a.mo657a(view, a, layoutParams);
    }

    void m4187a(View view, int i, boolean z) {
        int a = i < 0 ? this.f2379a.mo653a() : m4180f(i);
        this.f2380b.m4175a(a, z);
        if (z) {
            m4181g(view);
        }
        this.f2379a.mo656a(view, a);
    }

    void m4188a(View view, boolean z) {
        m4187a(view, -1, z);
    }

    int m4189b() {
        return this.f2379a.mo653a() - this.f2381c.size();
    }

    int m4190b(View view) {
        int a = this.f2379a.mo654a(view);
        return (a == -1 || this.f2380b.m4177c(a)) ? -1 : a - this.f2380b.m4179e(a);
    }

    View m4191b(int i) {
        return this.f2379a.mo659b(m4180f(i));
    }

    int m4192c() {
        return this.f2379a.mo653a();
    }

    View m4193c(int i) {
        int size = this.f2381c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.f2381c.get(i2);
            C0724w b = this.f2379a.mo658b(view);
            if (b.m3834d() == i && !b.m3844n() && !b.m3847q()) {
                return view;
            }
        }
        return null;
    }

    boolean m4194c(View view) {
        return this.f2381c.contains(view);
    }

    View m4195d(int i) {
        return this.f2379a.mo659b(i);
    }

    void m4196d(View view) {
        int a = this.f2379a.mo654a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2380b.m4174a(a);
        m4181g(view);
    }

    void m4197e(int i) {
        int f = m4180f(i);
        this.f2380b.m4178d(f);
        this.f2379a.mo661c(f);
    }

    void m4198e(View view) {
        int a = this.f2379a.mo654a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2380b.m4177c(a)) {
            this.f2380b.m4176b(a);
            m4182h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean m4199f(View view) {
        int a = this.f2379a.mo654a(view);
        if (a == -1) {
            return m4182h(view) ? true : true;
        } else {
            if (!this.f2380b.m4177c(a)) {
                return false;
            }
            this.f2380b.m4178d(a);
            if (m4182h(view)) {
                this.f2379a.mo655a(a);
            } else {
                this.f2379a.mo655a(a);
            }
            return true;
        }
    }

    public String toString() {
        return this.f2380b.toString() + ", hidden list:" + this.f2381c.size();
    }
}
