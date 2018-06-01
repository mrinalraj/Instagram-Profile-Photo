package android.support.v7.view;

import android.support.v4.p008h.C0119v;
import android.support.v4.p008h.C0120w;
import android.support.v4.p008h.C0433u;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class C0622h {
    final ArrayList<C0433u> f1651a = new ArrayList();
    C0119v f1652b;
    private long f1653c = -1;
    private Interpolator f1654d;
    private boolean f1655e;
    private final C0120w f1656f = new C06211(this);

    class C06211 extends C0120w {
        final /* synthetic */ C0622h f1648a;
        private boolean f1649b = false;
        private int f1650c = 0;

        C06211(C0622h c0622h) {
            this.f1648a = c0622h;
        }

        void m2918a() {
            this.f1650c = 0;
            this.f1649b = false;
            this.f1648a.m2927b();
        }

        public void mo100a(View view) {
            if (!this.f1649b) {
                this.f1649b = true;
                if (this.f1648a.f1652b != null) {
                    this.f1648a.f1652b.mo100a(null);
                }
            }
        }

        public void mo101b(View view) {
            int i = this.f1650c + 1;
            this.f1650c = i;
            if (i == this.f1648a.f1651a.size()) {
                if (this.f1648a.f1652b != null) {
                    this.f1648a.f1652b.mo101b(null);
                }
                m2918a();
            }
        }
    }

    public C0622h m2921a(long j) {
        if (!this.f1655e) {
            this.f1653c = j;
        }
        return this;
    }

    public C0622h m2922a(C0433u c0433u) {
        if (!this.f1655e) {
            this.f1651a.add(c0433u);
        }
        return this;
    }

    public C0622h m2923a(C0433u c0433u, C0433u c0433u2) {
        this.f1651a.add(c0433u);
        c0433u2.m2021b(c0433u.m2013a());
        this.f1651a.add(c0433u2);
        return this;
    }

    public C0622h m2924a(C0119v c0119v) {
        if (!this.f1655e) {
            this.f1652b = c0119v;
        }
        return this;
    }

    public C0622h m2925a(Interpolator interpolator) {
        if (!this.f1655e) {
            this.f1654d = interpolator;
        }
        return this;
    }

    public void m2926a() {
        if (!this.f1655e) {
            Iterator it = this.f1651a.iterator();
            while (it.hasNext()) {
                C0433u c0433u = (C0433u) it.next();
                if (this.f1653c >= 0) {
                    c0433u.m2015a(this.f1653c);
                }
                if (this.f1654d != null) {
                    c0433u.m2018a(this.f1654d);
                }
                if (this.f1652b != null) {
                    c0433u.m2016a(this.f1656f);
                }
                c0433u.m2024c();
            }
            this.f1655e = true;
        }
    }

    void m2927b() {
        this.f1655e = false;
    }

    public void m2928c() {
        if (this.f1655e) {
            Iterator it = this.f1651a.iterator();
            while (it.hasNext()) {
                ((C0433u) it.next()).m2022b();
            }
            this.f1655e = false;
        }
    }
}
