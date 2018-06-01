package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.C0066a.C0056a;
import android.support.design.widget.C0118a.C0117a;
import android.support.design.widget.C0147h.C0107a;
import android.support.design.widget.C0172r.C0074c;
import android.support.design.widget.C0172r.C0141a;
import android.support.design.widget.C0172r.C0142b;
import android.support.design.widget.C0172r.C0170d;
import android.support.v4.p005c.p006a.C0279a;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class C0148f extends C0147h {
    C0158m f463a;
    private final C0164p f464q = new C0164p();

    private abstract class C0143d extends C0142b implements C0074c {
        private boolean f439a;
        final /* synthetic */ C0148f f440b;
        private float f441c;
        private float f442d;

        private C0143d(C0148f c0148f) {
            this.f440b = c0148f;
        }

        protected abstract float mo115a();

        public void mo34a(C0172r c0172r) {
            if (!this.f439a) {
                this.f441c = this.f440b.f463a.m756a();
                this.f442d = mo115a();
                this.f439a = true;
            }
            this.f440b.f463a.m760b(this.f441c + ((this.f442d - this.f441c) * c0172r.m814e()));
        }

        public void mo112b(C0172r c0172r) {
            this.f440b.f463a.m760b(this.f442d);
            this.f439a = false;
        }
    }

    private class C0144a extends C0143d {
        final /* synthetic */ C0148f f443a;

        C0144a(C0148f c0148f) {
            this.f443a = c0148f;
            super();
        }

        protected float mo115a() {
            return 0.0f;
        }
    }

    private class C0145b extends C0143d {
        final /* synthetic */ C0148f f444a;

        C0145b(C0148f c0148f) {
            this.f444a = c0148f;
            super();
        }

        protected float mo115a() {
            return this.f444a.h + this.f444a.i;
        }
    }

    private class C0146c extends C0143d {
        final /* synthetic */ C0148f f445a;

        C0146c(C0148f c0148f) {
            this.f445a = c0148f;
            super();
        }

        protected float mo115a() {
            return this.f445a.h;
        }
    }

    C0148f(aa aaVar, C0110n c0110n, C0170d c0170d) {
        super(aaVar, c0110n, c0170d);
        this.f464q.m781a(j, m714a(new C0145b(this)));
        this.f464q.m781a(k, m714a(new C0145b(this)));
        this.f464q.m781a(l, m714a(new C0146c(this)));
        this.f464q.m781a(m, m714a(new C0144a(this)));
    }

    private C0172r m714a(C0143d c0143d) {
        C0172r a = this.p.mo155a();
        a.m810a(b);
        a.m807a(100);
        a.m808a((C0141a) c0143d);
        a.m809a((C0074c) c0143d);
        a.m805a(0.0f, 1.0f);
        return a;
    }

    private static ColorStateList m715b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{k, i, j};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    float mo116a() {
        return this.h;
    }

    void mo117a(float f, float f2) {
        if (this.f463a != null) {
            this.f463a.m758a(f, this.i + f);
            m706g();
        }
    }

    void mo118a(int i) {
        if (this.e != null) {
            C0279a.m1421a(this.e, C0148f.m715b(i));
        }
    }

    void mo119a(ColorStateList colorStateList) {
        if (this.d != null) {
            C0279a.m1421a(this.d, colorStateList);
        }
        if (this.f != null) {
            this.f.m661a(colorStateList);
        }
    }

    void mo120a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.d = C0279a.m1431f(m710k());
        C0279a.m1421a(this.d, colorStateList);
        if (mode != null) {
            C0279a.m1424a(this.d, mode);
        }
        this.e = C0279a.m1431f(m710k());
        C0279a.m1421a(this.e, C0148f.m715b(i));
        if (i2 > 0) {
            this.f = m688a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f, this.d, this.e};
        } else {
            this.f = null;
            drawableArr = new Drawable[]{this.d, this.e};
        }
        this.g = new LayerDrawable(drawableArr);
        this.f463a = new C0158m(this.n.getContext(), this.g, this.o.mo93a(), this.h, this.h + this.i);
        this.f463a.m759a(false);
        this.o.mo95a(this.f463a);
    }

    void mo121a(Mode mode) {
        if (this.d != null) {
            C0279a.m1424a(this.d, mode);
        }
    }

    void mo122a(Rect rect) {
        this.f463a.getPadding(rect);
    }

    void mo123a(final C0107a c0107a, final boolean z) {
        if (!m713n()) {
            this.c = 1;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.n.getContext(), C0056a.design_fab_out);
            loadAnimation.setInterpolator(C0118a.f402c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C0117a(this) {
                final /* synthetic */ C0148f f436c;

                public void onAnimationEnd(Animation animation) {
                    this.f436c.c = 0;
                    this.f436c.n.m583a(z ? 8 : 4, z);
                    if (c0107a != null) {
                        c0107a.mo90b();
                    }
                }
            });
            this.n.startAnimation(loadAnimation);
        }
    }

    void mo124a(int[] iArr) {
        this.f464q.m780a(iArr);
    }

    void mo125b() {
        this.f464q.m779a();
    }

    void mo126b(final C0107a c0107a, boolean z) {
        if (!m712m()) {
            this.c = 2;
            this.n.m583a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.n.getContext(), C0056a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0118a.f403d);
            loadAnimation.setAnimationListener(new C0117a(this) {
                final /* synthetic */ C0148f f438b;

                public void onAnimationEnd(Animation animation) {
                    this.f438b.c = 0;
                    if (c0107a != null) {
                        c0107a.mo89a();
                    }
                }
            });
            this.n.startAnimation(loadAnimation);
        }
    }

    void mo127c() {
    }
}
