package android.support.v7.widget;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.p008h.C0119v;
import android.support.v4.p008h.C0425s;
import android.support.v4.p008h.C0433u;
import android.support.v7.widget.RecyclerView.C0724w;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ak extends bf {
    ArrayList<ArrayList<C0724w>> f2418a = new ArrayList();
    ArrayList<ArrayList<C0767b>> f2419b = new ArrayList();
    ArrayList<ArrayList<C0766a>> f2420c = new ArrayList();
    ArrayList<C0724w> f2421d = new ArrayList();
    ArrayList<C0724w> f2422e = new ArrayList();
    ArrayList<C0724w> f2423f = new ArrayList();
    ArrayList<C0724w> f2424g = new ArrayList();
    private ArrayList<C0724w> f2425i = new ArrayList();
    private ArrayList<C0724w> f2426j = new ArrayList();
    private ArrayList<C0767b> f2427k = new ArrayList();
    private ArrayList<C0766a> f2428l = new ArrayList();

    private static class C0760c implements C0119v {
        C0760c() {
        }

        public void mo100a(View view) {
        }

        public void mo101b(View view) {
        }

        public void mo102c(View view) {
        }
    }

    private static class C0766a {
        public C0724w f2406a;
        public C0724w f2407b;
        public int f2408c;
        public int f2409d;
        public int f2410e;
        public int f2411f;

        private C0766a(C0724w c0724w, C0724w c0724w2) {
            this.f2406a = c0724w;
            this.f2407b = c0724w2;
        }

        C0766a(C0724w c0724w, C0724w c0724w2, int i, int i2, int i3, int i4) {
            this(c0724w, c0724w2);
            this.f2408c = i;
            this.f2409d = i2;
            this.f2410e = i3;
            this.f2411f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2406a + ", newHolder=" + this.f2407b + ", fromX=" + this.f2408c + ", fromY=" + this.f2409d + ", toX=" + this.f2410e + ", toY=" + this.f2411f + '}';
        }
    }

    private static class C0767b {
        public C0724w f2412a;
        public int f2413b;
        public int f2414c;
        public int f2415d;
        public int f2416e;

        C0767b(C0724w c0724w, int i, int i2, int i3, int i4) {
            this.f2412a = c0724w;
            this.f2413b = i;
            this.f2414c = i2;
            this.f2415d = i3;
            this.f2416e = i4;
        }
    }

    private void m4270a(List<C0766a> list, C0724w c0724w) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0766a c0766a = (C0766a) list.get(size);
            if (m4271a(c0766a, c0724w) && c0766a.f2406a == null && c0766a.f2407b == null) {
                list.remove(c0766a);
            }
        }
    }

    private boolean m4271a(C0766a c0766a, C0724w c0724w) {
        boolean z = false;
        if (c0766a.f2407b == c0724w) {
            c0766a.f2407b = null;
        } else if (c0766a.f2406a != c0724w) {
            return false;
        } else {
            c0766a.f2406a = null;
            z = true;
        }
        C0425s.m1959c(c0724w.f2170a, 1.0f);
        C0425s.m1942a(c0724w.f2170a, 0.0f);
        C0425s.m1955b(c0724w.f2170a, 0.0f);
        m4245a(c0724w, z);
        return true;
    }

    private void m4272b(C0766a c0766a) {
        if (c0766a.f2406a != null) {
            m4271a(c0766a, c0766a.f2406a);
        }
        if (c0766a.f2407b != null) {
            m4271a(c0766a, c0766a.f2407b);
        }
    }

    private void m4273u(final C0724w c0724w) {
        final C0433u o = C0425s.m1976o(c0724w.f2170a);
        this.f2423f.add(c0724w);
        o.m2015a(m3693g()).m2014a(0.0f).m2016a(new C0760c(this) {
            final /* synthetic */ ak f2390c;

            public void mo100a(View view) {
                this.f2390c.m4261l(c0724w);
            }

            public void mo101b(View view) {
                o.m2016a(null);
                C0425s.m1959c(view, 1.0f);
                this.f2390c.m4258i(c0724w);
                this.f2390c.f2423f.remove(c0724w);
                this.f2390c.m4285c();
            }
        }).m2024c();
    }

    private void m4274v(C0724w c0724w) {
        AnimatorCompatHelper.clearInterpolator(c0724w.f2170a);
        mo706d(c0724w);
    }

    public void mo698a() {
        int i = !this.f2425i.isEmpty() ? 1 : 0;
        int i2 = !this.f2427k.isEmpty() ? 1 : 0;
        int i3 = !this.f2428l.isEmpty() ? 1 : 0;
        int i4 = !this.f2426j.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            final ArrayList arrayList;
            Runnable c07571;
            Iterator it = this.f2425i.iterator();
            while (it.hasNext()) {
                m4273u((C0724w) it.next());
            }
            this.f2425i.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2427k);
                this.f2419b.add(arrayList);
                this.f2427k.clear();
                c07571 = new Runnable(this) {
                    final /* synthetic */ ak f2383b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C0767b c0767b = (C0767b) it.next();
                            this.f2383b.m4282b(c0767b.f2412a, c0767b.f2413b, c0767b.f2414c, c0767b.f2415d, c0767b.f2416e);
                        }
                        arrayList.clear();
                        this.f2383b.f2419b.remove(arrayList);
                    }
                };
                if (i != 0) {
                    C0425s.m1951a(((C0767b) arrayList.get(0)).f2412a.f2170a, c07571, m3693g());
                } else {
                    c07571.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2428l);
                this.f2420c.add(arrayList);
                this.f2428l.clear();
                c07571 = new Runnable(this) {
                    final /* synthetic */ ak f2385b;

                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.f2385b.m4276a((C0766a) it.next());
                        }
                        arrayList.clear();
                        this.f2385b.f2420c.remove(arrayList);
                    }
                };
                if (i != 0) {
                    C0425s.m1951a(((C0766a) arrayList.get(0)).f2406a.f2170a, c07571, m3693g());
                } else {
                    c07571.run();
                }
            }
            if (i4 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2426j);
                this.f2418a.add(arrayList2);
                this.f2426j.clear();
                Runnable c07593 = new Runnable(this) {
                    final /* synthetic */ ak f2387b;

                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            this.f2387b.m4286c((C0724w) it.next());
                        }
                        arrayList2.clear();
                        this.f2387b.f2418a.remove(arrayList2);
                    }
                };
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c07593.run();
                } else {
                    C0425s.m1951a(((C0724w) arrayList2.get(0)).f2170a, c07593, (i != 0 ? m3693g() : 0) + Math.max(i2 != 0 ? m3690e() : 0, i3 != 0 ? m3695h() : 0));
                }
            }
        }
    }

    void m4276a(final C0766a c0766a) {
        View view = null;
        C0724w c0724w = c0766a.f2406a;
        View view2 = c0724w == null ? null : c0724w.f2170a;
        C0724w c0724w2 = c0766a.f2407b;
        if (c0724w2 != null) {
            view = c0724w2.f2170a;
        }
        if (view2 != null) {
            final C0433u a = C0425s.m1976o(view2).m2015a(m3695h());
            this.f2424g.add(c0766a.f2406a);
            a.m2020b((float) (c0766a.f2410e - c0766a.f2408c));
            a.m2023c((float) (c0766a.f2411f - c0766a.f2409d));
            a.m2014a(0.0f).m2016a(new C0760c(this) {
                final /* synthetic */ ak f2401c;

                public void mo100a(View view) {
                    this.f2401c.m4251b(c0766a.f2406a, true);
                }

                public void mo101b(View view) {
                    a.m2016a(null);
                    C0425s.m1959c(view, 1.0f);
                    C0425s.m1942a(view, 0.0f);
                    C0425s.m1955b(view, 0.0f);
                    this.f2401c.m4245a(c0766a.f2406a, true);
                    this.f2401c.f2424g.remove(c0766a.f2406a);
                    this.f2401c.m4285c();
                }
            }).m2024c();
        }
        if (view != null) {
            a = C0425s.m1976o(view);
            this.f2424g.add(c0766a.f2407b);
            a.m2020b(0.0f).m2023c(0.0f).m2015a(m3695h()).m2014a(1.0f).m2016a(new C0760c(this) {
                final /* synthetic */ ak f2405d;

                public void mo100a(View view) {
                    this.f2405d.m4251b(c0766a.f2407b, false);
                }

                public void mo101b(View view) {
                    a.m2016a(null);
                    C0425s.m1959c(view, 1.0f);
                    C0425s.m1942a(view, 0.0f);
                    C0425s.m1955b(view, 0.0f);
                    this.f2405d.m4245a(c0766a.f2407b, false);
                    this.f2405d.f2424g.remove(c0766a.f2407b);
                    this.f2405d.m4285c();
                }
            }).m2024c();
        }
    }

    void m4277a(List<C0724w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0425s.m1976o(((C0724w) list.get(size)).f2170a).m2022b();
        }
    }

    public boolean mo699a(C0724w c0724w) {
        m4274v(c0724w);
        this.f2425i.add(c0724w);
        return true;
    }

    public boolean mo700a(C0724w c0724w, int i, int i2, int i3, int i4) {
        View view = c0724w.f2170a;
        int j = (int) (((float) i) + C0425s.m1971j(c0724w.f2170a));
        int k = (int) (((float) i2) + C0425s.m1972k(c0724w.f2170a));
        m4274v(c0724w);
        int i5 = i3 - j;
        int i6 = i4 - k;
        if (i5 == 0 && i6 == 0) {
            m4259j(c0724w);
            return false;
        }
        if (i5 != 0) {
            C0425s.m1942a(view, (float) (-i5));
        }
        if (i6 != 0) {
            C0425s.m1955b(view, (float) (-i6));
        }
        this.f2427k.add(new C0767b(c0724w, j, k, i3, i4));
        return true;
    }

    public boolean mo701a(C0724w c0724w, C0724w c0724w2, int i, int i2, int i3, int i4) {
        if (c0724w == c0724w2) {
            return mo700a(c0724w, i, i2, i3, i4);
        }
        float j = C0425s.m1971j(c0724w.f2170a);
        float k = C0425s.m1972k(c0724w.f2170a);
        float e = C0425s.m1964e(c0724w.f2170a);
        m4274v(c0724w);
        int i5 = (int) (((float) (i3 - i)) - j);
        int i6 = (int) (((float) (i4 - i2)) - k);
        C0425s.m1942a(c0724w.f2170a, j);
        C0425s.m1955b(c0724w.f2170a, k);
        C0425s.m1959c(c0724w.f2170a, e);
        if (c0724w2 != null) {
            m4274v(c0724w2);
            C0425s.m1942a(c0724w2.f2170a, (float) (-i5));
            C0425s.m1955b(c0724w2.f2170a, (float) (-i6));
            C0425s.m1959c(c0724w2.f2170a, 0.0f);
        }
        this.f2428l.add(new C0766a(c0724w, c0724w2, i, i2, i3, i4));
        return true;
    }

    public boolean mo702a(C0724w c0724w, List<Object> list) {
        return !list.isEmpty() || super.mo702a(c0724w, (List) list);
    }

    void m4282b(C0724w c0724w, int i, int i2, int i3, int i4) {
        View view = c0724w.f2170a;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            C0425s.m1976o(view).m2020b(0.0f);
        }
        if (i6 != 0) {
            C0425s.m1976o(view).m2023c(0.0f);
        }
        final C0433u o = C0425s.m1976o(view);
        this.f2422e.add(c0724w);
        final C0724w c0724w2 = c0724w;
        o.m2015a(m3690e()).m2016a(new C0760c(this) {
            final /* synthetic */ ak f2398e;

            public void mo100a(View view) {
                this.f2398e.m4262m(c0724w2);
            }

            public void mo101b(View view) {
                o.m2016a(null);
                this.f2398e.m4259j(c0724w2);
                this.f2398e.f2422e.remove(c0724w2);
                this.f2398e.m4285c();
            }

            public void mo102c(View view) {
                if (i5 != 0) {
                    C0425s.m1942a(view, 0.0f);
                }
                if (i6 != 0) {
                    C0425s.m1955b(view, 0.0f);
                }
            }
        }).m2024c();
    }

    public boolean mo703b() {
        return (this.f2426j.isEmpty() && this.f2428l.isEmpty() && this.f2427k.isEmpty() && this.f2425i.isEmpty() && this.f2422e.isEmpty() && this.f2423f.isEmpty() && this.f2421d.isEmpty() && this.f2424g.isEmpty() && this.f2419b.isEmpty() && this.f2418a.isEmpty() && this.f2420c.isEmpty()) ? false : true;
    }

    public boolean mo704b(C0724w c0724w) {
        m4274v(c0724w);
        C0425s.m1959c(c0724w.f2170a, 0.0f);
        this.f2426j.add(c0724w);
        return true;
    }

    void m4285c() {
        if (!mo703b()) {
            m3697i();
        }
    }

    void m4286c(final C0724w c0724w) {
        final C0433u o = C0425s.m1976o(c0724w.f2170a);
        this.f2421d.add(c0724w);
        o.m2014a(1.0f).m2015a(m3691f()).m2016a(new C0760c(this) {
            final /* synthetic */ ak f2393c;

            public void mo100a(View view) {
                this.f2393c.m4263n(c0724w);
            }

            public void mo101b(View view) {
                o.m2016a(null);
                this.f2393c.m4260k(c0724w);
                this.f2393c.f2421d.remove(c0724w);
                this.f2393c.m4285c();
            }

            public void mo102c(View view) {
                C0425s.m1959c(view, 1.0f);
            }
        }).m2024c();
    }

    public void mo705d() {
        int size;
        for (size = this.f2427k.size() - 1; size >= 0; size--) {
            C0767b c0767b = (C0767b) this.f2427k.get(size);
            View view = c0767b.f2412a.f2170a;
            C0425s.m1955b(view, 0.0f);
            C0425s.m1942a(view, 0.0f);
            m4259j(c0767b.f2412a);
            this.f2427k.remove(size);
        }
        for (size = this.f2425i.size() - 1; size >= 0; size--) {
            m4258i((C0724w) this.f2425i.get(size));
            this.f2425i.remove(size);
        }
        for (size = this.f2426j.size() - 1; size >= 0; size--) {
            C0724w c0724w = (C0724w) this.f2426j.get(size);
            C0425s.m1959c(c0724w.f2170a, 1.0f);
            m4260k(c0724w);
            this.f2426j.remove(size);
        }
        for (size = this.f2428l.size() - 1; size >= 0; size--) {
            m4272b((C0766a) this.f2428l.get(size));
        }
        this.f2428l.clear();
        if (mo703b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f2419b.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2419b.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0767b c0767b2 = (C0767b) arrayList.get(size3);
                    View view2 = c0767b2.f2412a.f2170a;
                    C0425s.m1955b(view2, 0.0f);
                    C0425s.m1942a(view2, 0.0f);
                    m4259j(c0767b2.f2412a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2419b.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2418a.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2418a.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0724w c0724w2 = (C0724w) arrayList.get(size3);
                    C0425s.m1959c(c0724w2.f2170a, 1.0f);
                    m4260k(c0724w2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2418a.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2420c.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2420c.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m4272b((C0766a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f2420c.remove(arrayList);
                    }
                }
            }
            m4277a(this.f2423f);
            m4277a(this.f2422e);
            m4277a(this.f2421d);
            m4277a(this.f2424g);
            m3697i();
        }
    }

    public void mo706d(C0724w c0724w) {
        int size;
        View view = c0724w.f2170a;
        C0425s.m1976o(view).m2022b();
        for (size = this.f2427k.size() - 1; size >= 0; size--) {
            if (((C0767b) this.f2427k.get(size)).f2412a == c0724w) {
                C0425s.m1955b(view, 0.0f);
                C0425s.m1942a(view, 0.0f);
                m4259j(c0724w);
                this.f2427k.remove(size);
            }
        }
        m4270a(this.f2428l, c0724w);
        if (this.f2425i.remove(c0724w)) {
            C0425s.m1959c(view, 1.0f);
            m4258i(c0724w);
        }
        if (this.f2426j.remove(c0724w)) {
            C0425s.m1959c(view, 1.0f);
            m4260k(c0724w);
        }
        for (size = this.f2420c.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f2420c.get(size);
            m4270a(list, c0724w);
            if (list.isEmpty()) {
                this.f2420c.remove(size);
            }
        }
        for (int size2 = this.f2419b.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2419b.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0767b) arrayList.get(size3)).f2412a == c0724w) {
                    C0425s.m1955b(view, 0.0f);
                    C0425s.m1942a(view, 0.0f);
                    m4259j(c0724w);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2419b.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f2418a.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f2418a.get(size);
            if (arrayList.remove(c0724w)) {
                C0425s.m1959c(view, 1.0f);
                m4260k(c0724w);
                if (arrayList.isEmpty()) {
                    this.f2418a.remove(size);
                }
            }
        }
        if (this.f2423f.remove(c0724w)) {
        }
        if (this.f2421d.remove(c0724w)) {
        }
        if (this.f2424g.remove(c0724w)) {
        }
        if (this.f2422e.remove(c0724w)) {
            m4285c();
        } else {
            m4285c();
        }
    }
}
