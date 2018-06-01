package android.support.v7.widget;

import android.support.v4.p018g.C0349j.C0346a;
import android.support.v4.p018g.C0349j.C0347b;
import android.support.v7.widget.RecyclerView.C0724w;
import android.support.v7.widget.aw.C0782a;
import java.util.ArrayList;
import java.util.List;

class C0817f implements C0782a {
    final ArrayList<C0816b> f2735a;
    final ArrayList<C0816b> f2736b;
    final C0694a f2737c;
    Runnable f2738d;
    final boolean f2739e;
    final aw f2740f;
    private C0346a<C0816b> f2741g;
    private int f2742h;

    interface C0694a {
        C0724w mo664a(int i);

        void mo665a(int i, int i2);

        void mo666a(int i, int i2, Object obj);

        void mo667a(C0816b c0816b);

        void mo668b(int i, int i2);

        void mo669b(C0816b c0816b);

        void mo670c(int i, int i2);

        void mo671d(int i, int i2);
    }

    static class C0816b {
        int f2731a;
        int f2732b;
        Object f2733c;
        int f2734d;

        C0816b(int i, int i2, int i3, Object obj) {
            this.f2731a = i;
            this.f2732b = i2;
            this.f2734d = i3;
            this.f2733c = obj;
        }

        String m4675a() {
            switch (this.f2731a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case 8:
                    return "mv";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0816b c0816b = (C0816b) obj;
            return this.f2731a != c0816b.f2731a ? false : (this.f2731a == 8 && Math.abs(this.f2734d - this.f2732b) == 1 && this.f2734d == c0816b.f2732b && this.f2732b == c0816b.f2734d) ? true : this.f2734d != c0816b.f2734d ? false : this.f2732b != c0816b.f2732b ? false : this.f2733c != null ? this.f2733c.equals(c0816b.f2733c) : c0816b.f2733c == null;
        }

        public int hashCode() {
            return (((this.f2731a * 31) + this.f2732b) * 31) + this.f2734d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m4675a() + ",s:" + this.f2732b + "c:" + this.f2734d + ",p:" + this.f2733c + "]";
        }
    }

    C0817f(C0694a c0694a) {
        this(c0694a, false);
    }

    C0817f(C0694a c0694a, boolean z) {
        this.f2741g = new C0347b(30);
        this.f2735a = new ArrayList();
        this.f2736b = new ArrayList();
        this.f2742h = 0;
        this.f2737c = c0694a;
        this.f2739e = z;
        this.f2740f = new aw(this);
    }

    private int m4676b(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f2736b.size() - 1; size >= 0; size--) {
            C0816b c0816b = (C0816b) this.f2736b.get(size);
            if (c0816b.f2731a == 8) {
                int i5;
                int i6;
                if (c0816b.f2732b < c0816b.f2734d) {
                    i5 = c0816b.f2732b;
                    i3 = c0816b.f2734d;
                } else {
                    i5 = c0816b.f2734d;
                    i3 = c0816b.f2732b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0816b.f2732b) {
                        if (i2 == 1) {
                            c0816b.f2732b++;
                            c0816b.f2734d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c0816b.f2732b--;
                            c0816b.f2734d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0816b.f2732b) {
                    if (i2 == 1) {
                        c0816b.f2734d++;
                    } else if (i2 == 2) {
                        c0816b.f2734d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c0816b.f2732b++;
                    } else if (i2 == 2) {
                        c0816b.f2732b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0816b.f2732b <= i4) {
                if (c0816b.f2731a == 1) {
                    i4 -= c0816b.f2734d;
                } else if (c0816b.f2731a == 2) {
                    i4 += c0816b.f2734d;
                }
            } else if (i2 == 1) {
                c0816b.f2732b++;
            } else if (i2 == 2) {
                c0816b.f2732b--;
            }
        }
        for (i3 = this.f2736b.size() - 1; i3 >= 0; i3--) {
            c0816b = (C0816b) this.f2736b.get(i3);
            if (c0816b.f2731a == 8) {
                if (c0816b.f2734d == c0816b.f2732b || c0816b.f2734d < 0) {
                    this.f2736b.remove(i3);
                    mo782a(c0816b);
                }
            } else if (c0816b.f2734d <= 0) {
                this.f2736b.remove(i3);
                mo782a(c0816b);
            }
        }
        return i4;
    }

    private void m4677b(C0816b c0816b) {
        m4683g(c0816b);
    }

    private void m4678c(C0816b c0816b) {
        int i = c0816b.f2732b;
        int i2 = c0816b.f2732b + c0816b.f2734d;
        Object obj = -1;
        int i3 = c0816b.f2732b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f2737c.mo664a(i3) != null || m4680d(i3)) {
                if (obj == null) {
                    m4681e(mo781a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m4683g(mo781a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c0816b.f2734d) {
            mo782a(c0816b);
            c0816b = mo781a(2, i, i4, null);
        }
        if (obj == null) {
            m4681e(c0816b);
        } else {
            m4683g(c0816b);
        }
    }

    private void m4679d(C0816b c0816b) {
        int i = c0816b.f2732b;
        int i2 = c0816b.f2732b + c0816b.f2734d;
        int i3 = c0816b.f2732b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f2737c.mo664a(i3) != null || m4680d(i3)) {
                if (obj == null) {
                    m4681e(mo781a(4, i, i4, c0816b.f2733c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m4683g(mo781a(4, i, i4, c0816b.f2733c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0816b.f2734d) {
            Object obj4 = c0816b.f2733c;
            mo782a(c0816b);
            c0816b = mo781a(4, i, i4, obj4);
        }
        if (obj == null) {
            m4681e(c0816b);
        } else {
            m4683g(c0816b);
        }
    }

    private boolean m4680d(int i) {
        int size = this.f2736b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0816b c0816b = (C0816b) this.f2736b.get(i2);
            if (c0816b.f2731a == 8) {
                if (m4684a(c0816b.f2734d, i2 + 1) == i) {
                    return true;
                }
            } else if (c0816b.f2731a == 1) {
                int i3 = c0816b.f2732b + c0816b.f2734d;
                for (int i4 = c0816b.f2732b; i4 < i3; i4++) {
                    if (m4684a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m4681e(C0816b c0816b) {
        if (c0816b.f2731a == 1 || c0816b.f2731a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int b = m4676b(c0816b.f2732b, c0816b.f2731a);
        int i2 = c0816b.f2732b;
        switch (c0816b.f2731a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0816b);
        }
        int i3 = 1;
        int i4 = b;
        b = i2;
        for (i2 = 1; i2 < c0816b.f2734d; i2++) {
            Object obj;
            int b2 = m4676b(c0816b.f2732b + (i * i2), c0816b.f2731a);
            int i5;
            switch (c0816b.f2731a) {
                case 2:
                    if (b2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (b2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C0816b a = mo781a(c0816b.f2731a, i4, i3, c0816b.f2733c);
                m4688a(a, b);
                mo782a(a);
                if (c0816b.f2731a == 4) {
                    b += i3;
                }
                i3 = 1;
                i4 = b2;
            }
        }
        Object obj2 = c0816b.f2733c;
        mo782a(c0816b);
        if (i3 > 0) {
            C0816b a2 = mo781a(c0816b.f2731a, i4, i3, obj2);
            m4688a(a2, b);
            mo782a(a2);
        }
    }

    private void m4682f(C0816b c0816b) {
        m4683g(c0816b);
    }

    private void m4683g(C0816b c0816b) {
        this.f2736b.add(c0816b);
        switch (c0816b.f2731a) {
            case 1:
                this.f2737c.mo670c(c0816b.f2732b, c0816b.f2734d);
                return;
            case 2:
                this.f2737c.mo668b(c0816b.f2732b, c0816b.f2734d);
                return;
            case 4:
                this.f2737c.mo666a(c0816b.f2732b, c0816b.f2734d, c0816b.f2733c);
                return;
            case 8:
                this.f2737c.mo671d(c0816b.f2732b, c0816b.f2734d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0816b);
        }
    }

    int m4684a(int i, int i2) {
        int size = this.f2736b.size();
        int i3 = i;
        while (i2 < size) {
            C0816b c0816b = (C0816b) this.f2736b.get(i2);
            if (c0816b.f2731a == 8) {
                if (c0816b.f2732b == i3) {
                    i3 = c0816b.f2734d;
                } else {
                    if (c0816b.f2732b < i3) {
                        i3--;
                    }
                    if (c0816b.f2734d <= i3) {
                        i3++;
                    }
                }
            } else if (c0816b.f2732b > i3) {
                continue;
            } else if (c0816b.f2731a == 2) {
                if (i3 < c0816b.f2732b + c0816b.f2734d) {
                    return -1;
                }
                i3 -= c0816b.f2734d;
            } else if (c0816b.f2731a == 1) {
                i3 += c0816b.f2734d;
            }
            i2++;
        }
        return i3;
    }

    public C0816b mo781a(int i, int i2, int i3, Object obj) {
        C0816b c0816b = (C0816b) this.f2741g.mo223a();
        if (c0816b == null) {
            return new C0816b(i, i2, i3, obj);
        }
        c0816b.f2731a = i;
        c0816b.f2732b = i2;
        c0816b.f2734d = i3;
        c0816b.f2733c = obj;
        return c0816b;
    }

    void m4686a() {
        m4689a(this.f2735a);
        m4689a(this.f2736b);
        this.f2742h = 0;
    }

    public void mo782a(C0816b c0816b) {
        if (!this.f2739e) {
            c0816b.f2733c = null;
            this.f2741g.mo224a(c0816b);
        }
    }

    void m4688a(C0816b c0816b, int i) {
        this.f2737c.mo667a(c0816b);
        switch (c0816b.f2731a) {
            case 2:
                this.f2737c.mo665a(i, c0816b.f2734d);
                return;
            case 4:
                this.f2737c.mo666a(i, c0816b.f2734d, c0816b.f2733c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void m4689a(List<C0816b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo782a((C0816b) list.get(i));
        }
        list.clear();
    }

    boolean m4690a(int i) {
        return (this.f2742h & i) != 0;
    }

    int m4691b(int i) {
        return m4684a(i, 0);
    }

    void m4692b() {
        this.f2740f.m4373a(this.f2735a);
        int size = this.f2735a.size();
        for (int i = 0; i < size; i++) {
            C0816b c0816b = (C0816b) this.f2735a.get(i);
            switch (c0816b.f2731a) {
                case 1:
                    m4682f(c0816b);
                    break;
                case 2:
                    m4678c(c0816b);
                    break;
                case 4:
                    m4679d(c0816b);
                    break;
                case 8:
                    m4677b(c0816b);
                    break;
            }
            if (this.f2738d != null) {
                this.f2738d.run();
            }
        }
        this.f2735a.clear();
    }

    public int m4693c(int i) {
        int size = this.f2735a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C0816b c0816b = (C0816b) this.f2735a.get(i3);
            switch (c0816b.f2731a) {
                case 1:
                    if (c0816b.f2732b > i2) {
                        break;
                    }
                    i2 += c0816b.f2734d;
                    break;
                case 2:
                    if (c0816b.f2732b <= i2) {
                        if (c0816b.f2732b + c0816b.f2734d <= i2) {
                            i2 -= c0816b.f2734d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (c0816b.f2732b != i2) {
                        if (c0816b.f2732b < i2) {
                            i2--;
                        }
                        if (c0816b.f2734d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c0816b.f2734d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    void m4694c() {
        int size = this.f2736b.size();
        for (int i = 0; i < size; i++) {
            this.f2737c.mo669b((C0816b) this.f2736b.get(i));
        }
        m4689a(this.f2736b);
        this.f2742h = 0;
    }

    boolean m4695d() {
        return this.f2735a.size() > 0;
    }

    void m4696e() {
        m4694c();
        int size = this.f2735a.size();
        for (int i = 0; i < size; i++) {
            C0816b c0816b = (C0816b) this.f2735a.get(i);
            switch (c0816b.f2731a) {
                case 1:
                    this.f2737c.mo669b(c0816b);
                    this.f2737c.mo670c(c0816b.f2732b, c0816b.f2734d);
                    break;
                case 2:
                    this.f2737c.mo669b(c0816b);
                    this.f2737c.mo665a(c0816b.f2732b, c0816b.f2734d);
                    break;
                case 4:
                    this.f2737c.mo669b(c0816b);
                    this.f2737c.mo666a(c0816b.f2732b, c0816b.f2734d, c0816b.f2733c);
                    break;
                case 8:
                    this.f2737c.mo669b(c0816b);
                    this.f2737c.mo671d(c0816b.f2732b, c0816b.f2734d);
                    break;
            }
            if (this.f2738d != null) {
                this.f2738d.run();
            }
        }
        m4689a(this.f2735a);
        this.f2742h = 0;
    }

    boolean m4697f() {
        return (this.f2736b.isEmpty() || this.f2735a.isEmpty()) ? false : true;
    }
}
