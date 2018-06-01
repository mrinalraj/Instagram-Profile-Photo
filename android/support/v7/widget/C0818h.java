package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p008h.C0425s;
import android.support.v7.p021a.C0529a.C0528j;
import android.util.AttributeSet;
import android.view.View;

class C0818h {
    private final View f2743a;
    private final C0827m f2744b;
    private int f2745c = -1;
    private bk f2746d;
    private bk f2747e;
    private bk f2748f;

    C0818h(View view) {
        this.f2743a = view;
        this.f2744b = C0827m.m4729a();
    }

    private boolean m4698b(Drawable drawable) {
        if (this.f2748f == null) {
            this.f2748f = new bk();
        }
        bk bkVar = this.f2748f;
        bkVar.m4510a();
        ColorStateList v = C0425s.m1983v(this.f2743a);
        if (v != null) {
            bkVar.f2624d = true;
            bkVar.f2621a = v;
        }
        Mode w = C0425s.m1984w(this.f2743a);
        if (w != null) {
            bkVar.f2623c = true;
            bkVar.f2622b = w;
        }
        if (!bkVar.f2624d && !bkVar.f2623c) {
            return false;
        }
        C0827m.m4732a(drawable, bkVar, this.f2743a.getDrawableState());
        return true;
    }

    private boolean m4699d() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.f2746d != null : i == 21;
    }

    ColorStateList m4700a() {
        return this.f2747e != null ? this.f2747e.f2621a : null;
    }

    void m4701a(int i) {
        this.f2745c = i;
        m4707b(this.f2744b != null ? this.f2744b.m4752b(this.f2743a.getContext(), i) : null);
        m4708c();
    }

    void m4702a(ColorStateList colorStateList) {
        if (this.f2747e == null) {
            this.f2747e = new bk();
        }
        this.f2747e.f2621a = colorStateList;
        this.f2747e.f2624d = true;
        m4708c();
    }

    void m4703a(Mode mode) {
        if (this.f2747e == null) {
            this.f2747e = new bk();
        }
        this.f2747e.f2622b = mode;
        this.f2747e.f2623c = true;
        m4708c();
    }

    void m4704a(Drawable drawable) {
        this.f2745c = -1;
        m4707b(null);
        m4708c();
    }

    void m4705a(AttributeSet attributeSet, int i) {
        bm a = bm.m4513a(this.f2743a.getContext(), attributeSet, C0528j.ViewBackgroundHelper, i, 0);
        try {
            if (a.m4531g(C0528j.ViewBackgroundHelper_android_background)) {
                this.f2745c = a.m4530g(C0528j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.f2744b.m4752b(this.f2743a.getContext(), this.f2745c);
                if (b != null) {
                    m4707b(b);
                }
            }
            if (a.m4531g(C0528j.ViewBackgroundHelper_backgroundTint)) {
                C0425s.m1945a(this.f2743a, a.m4527e(C0528j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.m4531g(C0528j.ViewBackgroundHelper_backgroundTintMode)) {
                C0425s.m1946a(this.f2743a, al.m4289a(a.m4515a(C0528j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.m4518a();
        } catch (Throwable th) {
            a.m4518a();
        }
    }

    Mode m4706b() {
        return this.f2747e != null ? this.f2747e.f2622b : null;
    }

    void m4707b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2746d == null) {
                this.f2746d = new bk();
            }
            this.f2746d.f2621a = colorStateList;
            this.f2746d.f2624d = true;
        } else {
            this.f2746d = null;
        }
        m4708c();
    }

    void m4708c() {
        Drawable background = this.f2743a.getBackground();
        if (background == null) {
            return;
        }
        if (!m4699d() || !m4698b(background)) {
            if (this.f2747e != null) {
                C0827m.m4732a(background, this.f2747e, this.f2743a.getDrawableState());
            } else if (this.f2746d != null) {
                C0827m.m4732a(background, this.f2746d, this.f2743a.getDrawableState());
            }
        }
    }
}
