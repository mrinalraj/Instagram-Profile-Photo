package android.support.design.widget;

import android.view.animation.Interpolator;

class C0172r {
    private final C0171e f516a;

    interface C0074c {
        void mo34a(C0172r c0172r);
    }

    interface C0141a {
        void mo112b(C0172r c0172r);

        void mo113c(C0172r c0172r);

        void mo114d(C0172r c0172r);
    }

    static class C0142b implements C0141a {
        C0142b() {
        }

        public void mo112b(C0172r c0172r) {
        }

        public void mo113c(C0172r c0172r) {
        }

        public void mo114d(C0172r c0172r) {
        }
    }

    interface C0170d {
        C0172r mo155a();
    }

    static abstract class C0171e {

        interface C0166b {
            void mo138a();
        }

        interface C0168a {
            void mo139a();

            void mo140b();

            void mo141c();
        }

        C0171e() {
        }

        abstract void mo142a();

        abstract void mo143a(float f, float f2);

        abstract void mo144a(int i, int i2);

        abstract void mo145a(long j);

        abstract void mo146a(C0168a c0168a);

        abstract void mo147a(C0166b c0166b);

        abstract void mo148a(Interpolator interpolator);

        abstract boolean mo149b();

        abstract int mo150c();

        abstract void mo151d();

        abstract float mo152e();

        abstract void mo153f();
    }

    C0172r(C0171e c0171e) {
        this.f516a = c0171e;
    }

    public void m804a() {
        this.f516a.mo142a();
    }

    public void m805a(float f, float f2) {
        this.f516a.mo143a(f, f2);
    }

    public void m806a(int i, int i2) {
        this.f516a.mo144a(i, i2);
    }

    public void m807a(long j) {
        this.f516a.mo145a(j);
    }

    public void m808a(final C0141a c0141a) {
        if (c0141a != null) {
            this.f516a.mo146a(new C0168a(this) {
                final /* synthetic */ C0172r f515b;

                public void mo139a() {
                    c0141a.mo113c(this.f515b);
                }

                public void mo140b() {
                    c0141a.mo112b(this.f515b);
                }

                public void mo141c() {
                    c0141a.mo114d(this.f515b);
                }
            });
        } else {
            this.f516a.mo146a(null);
        }
    }

    public void m809a(final C0074c c0074c) {
        if (c0074c != null) {
            this.f516a.mo147a(new C0166b(this) {
                final /* synthetic */ C0172r f513b;

                public void mo138a() {
                    c0074c.mo34a(this.f513b);
                }
            });
        } else {
            this.f516a.mo147a(null);
        }
    }

    public void m810a(Interpolator interpolator) {
        this.f516a.mo148a(interpolator);
    }

    public boolean m811b() {
        return this.f516a.mo149b();
    }

    public int m812c() {
        return this.f516a.mo150c();
    }

    public void m813d() {
        this.f516a.mo151d();
    }

    public float m814e() {
        return this.f516a.mo152e();
    }

    public void m815f() {
        this.f516a.mo153f();
    }
}
