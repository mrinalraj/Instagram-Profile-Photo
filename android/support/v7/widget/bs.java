package android.support.v7.widget;

import android.support.v4.p018g.C0332a;
import android.support.v4.p018g.C0338f;
import android.support.v4.p018g.C0349j.C0346a;
import android.support.v4.p018g.C0349j.C0347b;
import android.support.v7.widget.RecyclerView.C0703e.C0702c;
import android.support.v7.widget.RecyclerView.C0724w;

class bs {
    final C0332a<C0724w, C0800a> f2675a = new C0332a();
    final C0338f<C0724w> f2676b = new C0338f();

    interface C0690b {
        void mo649a(C0724w c0724w);

        void mo650a(C0724w c0724w, C0702c c0702c, C0702c c0702c2);

        void mo651b(C0724w c0724w, C0702c c0702c, C0702c c0702c2);

        void mo652c(C0724w c0724w, C0702c c0702c, C0702c c0702c2);
    }

    static class C0800a {
        static C0346a<C0800a> f2671d = new C0347b(20);
        int f2672a;
        C0702c f2673b;
        C0702c f2674c;

        private C0800a() {
        }

        static C0800a m4594a() {
            C0800a c0800a = (C0800a) f2671d.mo223a();
            return c0800a == null ? new C0800a() : c0800a;
        }

        static void m4595a(C0800a c0800a) {
            c0800a.f2672a = 0;
            c0800a.f2673b = null;
            c0800a.f2674c = null;
            f2671d.mo224a(c0800a);
        }

        static void m4596b() {
            do {
            } while (f2671d.mo223a() != null);
        }
    }

    bs() {
    }

    private C0702c m4597a(C0724w c0724w, int i) {
        C0702c c0702c = null;
        int a = this.f2675a.m1601a((Object) c0724w);
        if (a >= 0) {
            C0800a c0800a = (C0800a) this.f2675a.m1607c(a);
            if (!(c0800a == null || (c0800a.f2672a & i) == 0)) {
                c0800a.f2672a &= i ^ -1;
                if (i == 4) {
                    c0702c = c0800a.f2673b;
                } else if (i == 8) {
                    c0702c = c0800a.f2674c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c0800a.f2672a & 12) == 0) {
                    this.f2675a.m1608d(a);
                    C0800a.m4595a(c0800a);
                }
            }
        }
        return c0702c;
    }

    C0724w m4598a(long j) {
        return (C0724w) this.f2676b.m1639a(j);
    }

    void m4599a() {
        this.f2675a.clear();
        this.f2676b.m1647c();
    }

    void m4600a(long j, C0724w c0724w) {
        this.f2676b.m1645b(j, c0724w);
    }

    void m4601a(C0724w c0724w, C0702c c0702c) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        if (c0800a == null) {
            c0800a = C0800a.m4594a();
            this.f2675a.put(c0724w, c0800a);
        }
        c0800a.f2673b = c0702c;
        c0800a.f2672a |= 4;
    }

    void m4602a(C0690b c0690b) {
        for (int size = this.f2675a.size() - 1; size >= 0; size--) {
            C0724w c0724w = (C0724w) this.f2675a.m1606b(size);
            C0800a c0800a = (C0800a) this.f2675a.m1608d(size);
            if ((c0800a.f2672a & 3) == 3) {
                c0690b.mo649a(c0724w);
            } else if ((c0800a.f2672a & 1) != 0) {
                if (c0800a.f2673b == null) {
                    c0690b.mo649a(c0724w);
                } else {
                    c0690b.mo650a(c0724w, c0800a.f2673b, c0800a.f2674c);
                }
            } else if ((c0800a.f2672a & 14) == 14) {
                c0690b.mo651b(c0724w, c0800a.f2673b, c0800a.f2674c);
            } else if ((c0800a.f2672a & 12) == 12) {
                c0690b.mo652c(c0724w, c0800a.f2673b, c0800a.f2674c);
            } else if ((c0800a.f2672a & 4) != 0) {
                c0690b.mo650a(c0724w, c0800a.f2673b, null);
            } else if ((c0800a.f2672a & 8) != 0) {
                c0690b.mo651b(c0724w, c0800a.f2673b, c0800a.f2674c);
            } else if ((c0800a.f2672a & 2) != 0) {
            }
            C0800a.m4595a(c0800a);
        }
    }

    boolean m4603a(C0724w c0724w) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        return (c0800a == null || (c0800a.f2672a & 1) == 0) ? false : true;
    }

    C0702c m4604b(C0724w c0724w) {
        return m4597a(c0724w, 4);
    }

    void m4605b() {
        C0800a.m4596b();
    }

    void m4606b(C0724w c0724w, C0702c c0702c) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        if (c0800a == null) {
            c0800a = C0800a.m4594a();
            this.f2675a.put(c0724w, c0800a);
        }
        c0800a.f2672a |= 2;
        c0800a.f2673b = c0702c;
    }

    C0702c m4607c(C0724w c0724w) {
        return m4597a(c0724w, 8);
    }

    void m4608c(C0724w c0724w, C0702c c0702c) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        if (c0800a == null) {
            c0800a = C0800a.m4594a();
            this.f2675a.put(c0724w, c0800a);
        }
        c0800a.f2674c = c0702c;
        c0800a.f2672a |= 8;
    }

    boolean m4609d(C0724w c0724w) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        return (c0800a == null || (c0800a.f2672a & 4) == 0) ? false : true;
    }

    void m4610e(C0724w c0724w) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        if (c0800a == null) {
            c0800a = C0800a.m4594a();
            this.f2675a.put(c0724w, c0800a);
        }
        r0.f2672a |= 1;
    }

    void m4611f(C0724w c0724w) {
        C0800a c0800a = (C0800a) this.f2675a.get(c0724w);
        if (c0800a != null) {
            c0800a.f2672a &= -2;
        }
    }

    void m4612g(C0724w c0724w) {
        for (int b = this.f2676b.m1642b() - 1; b >= 0; b--) {
            if (c0724w == this.f2676b.m1646c(b)) {
                this.f2676b.m1641a(b);
                break;
            }
        }
        C0800a c0800a = (C0800a) this.f2675a.remove(c0724w);
        if (c0800a != null) {
            C0800a.m4595a(c0800a);
        }
    }

    public void m4613h(C0724w c0724w) {
        m4611f(c0724w);
    }
}
