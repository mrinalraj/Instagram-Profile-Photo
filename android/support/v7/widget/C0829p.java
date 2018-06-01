package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.C0498f;
import android.support.v7.p021a.C0529a.C0528j;
import android.support.v7.p023c.p024a.C0608b;
import android.util.AttributeSet;
import android.widget.ImageView;

public class C0829p {
    private final ImageView f2778a;
    private bk f2779b;
    private bk f2780c;
    private bk f2781d;

    public C0829p(ImageView imageView) {
        this.f2778a = imageView;
    }

    private boolean m4753a(Drawable drawable) {
        if (this.f2781d == null) {
            this.f2781d = new bk();
        }
        bk bkVar = this.f2781d;
        bkVar.m4510a();
        ColorStateList a = C0498f.m2414a(this.f2778a);
        if (a != null) {
            bkVar.f2624d = true;
            bkVar.f2621a = a;
        }
        Mode b = C0498f.m2417b(this.f2778a);
        if (b != null) {
            bkVar.f2623c = true;
            bkVar.f2622b = b;
        }
        if (!bkVar.f2624d && !bkVar.f2623c) {
            return false;
        }
        C0827m.m4732a(drawable, bkVar, this.f2778a.getDrawableState());
        return true;
    }

    private boolean m4754e() {
        int i = VERSION.SDK_INT;
        return i > 21 ? this.f2779b != null : i == 21;
    }

    public void m4755a(int i) {
        if (i != 0) {
            Drawable b = C0608b.m2863b(this.f2778a.getContext(), i);
            if (b != null) {
                al.m4290a(b);
            }
            this.f2778a.setImageDrawable(b);
        } else {
            this.f2778a.setImageDrawable(null);
        }
        m4762d();
    }

    void m4756a(ColorStateList colorStateList) {
        if (this.f2780c == null) {
            this.f2780c = new bk();
        }
        this.f2780c.f2621a = colorStateList;
        this.f2780c.f2624d = true;
        m4762d();
    }

    void m4757a(Mode mode) {
        if (this.f2780c == null) {
            this.f2780c = new bk();
        }
        this.f2780c.f2622b = mode;
        this.f2780c.f2623c = true;
        m4762d();
    }

    public void m4758a(AttributeSet attributeSet, int i) {
        bm a = bm.m4513a(this.f2778a.getContext(), attributeSet, C0528j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f2778a.getDrawable();
            if (drawable == null) {
                int g = a.m4530g(C0528j.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = C0608b.m2863b(this.f2778a.getContext(), g);
                    if (drawable != null) {
                        this.f2778a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                al.m4290a(drawable);
            }
            if (a.m4531g(C0528j.AppCompatImageView_tint)) {
                C0498f.m2415a(this.f2778a, a.m4527e(C0528j.AppCompatImageView_tint));
            }
            if (a.m4531g(C0528j.AppCompatImageView_tintMode)) {
                C0498f.m2416a(this.f2778a, al.m4289a(a.m4515a(C0528j.AppCompatImageView_tintMode, -1), null));
            }
            a.m4518a();
        } catch (Throwable th) {
            a.m4518a();
        }
    }

    boolean m4759a() {
        return VERSION.SDK_INT < 21 || !(this.f2778a.getBackground() instanceof RippleDrawable);
    }

    ColorStateList m4760b() {
        return this.f2780c != null ? this.f2780c.f2621a : null;
    }

    Mode m4761c() {
        return this.f2780c != null ? this.f2780c.f2622b : null;
    }

    void m4762d() {
        Drawable drawable = this.f2778a.getDrawable();
        if (drawable != null) {
            al.m4290a(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!m4754e() || !m4753a(drawable)) {
            if (this.f2780c != null) {
                C0827m.m4732a(drawable, this.f2780c, this.f2778a.getDrawableState());
            } else if (this.f2779b != null) {
                C0827m.m4732a(drawable, this.f2779b, this.f2778a.getDrawableState());
            }
        }
    }
}
