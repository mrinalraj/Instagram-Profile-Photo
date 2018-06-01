package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.C0066a.C0058c;
import android.support.design.widget.C0172r.C0170d;
import android.support.v4.p013b.C0190a;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

abstract class C0147h {
    static final Interpolator f446b = C0118a.f402c;
    static final int[] f447j = new int[]{16842919, 16842910};
    static final int[] f448k = new int[]{16842908, 16842910};
    static final int[] f449l = new int[]{16842910};
    static final int[] f450m = new int[0];
    private final Rect f451a = new Rect();
    int f452c = 0;
    Drawable f453d;
    Drawable f454e;
    C0136c f455f;
    Drawable f456g;
    float f457h;
    float f458i;
    final aa f459n;
    final C0110n f460o;
    final C0170d f461p;
    private OnPreDrawListener f462q;

    interface C0107a {
        void mo89a();

        void mo90b();
    }

    class C01521 implements OnPreDrawListener {
        final /* synthetic */ C0147h f473a;

        C01521(C0147h c0147h) {
            this.f473a = c0147h;
        }

        public boolean onPreDraw() {
            this.f473a.mo129e();
            return true;
        }
    }

    C0147h(aa aaVar, C0110n c0110n, C0170d c0170d) {
        this.f459n = aaVar;
        this.f460o = c0110n;
        this.f461p = c0170d;
    }

    private void m686o() {
        if (this.f462q == null) {
            this.f462q = new C01521(this);
        }
    }

    abstract float mo116a();

    C0136c m688a(int i, ColorStateList colorStateList) {
        Context context = this.f459n.getContext();
        C0136c j = mo131j();
        j.m660a(C0190a.m868c(context, C0058c.design_fab_stroke_top_outer_color), C0190a.m868c(context, C0058c.design_fab_stroke_top_inner_color), C0190a.m868c(context, C0058c.design_fab_stroke_end_inner_color), C0190a.m868c(context, C0058c.design_fab_stroke_end_outer_color));
        j.m659a((float) i);
        j.m661a(colorStateList);
        return j;
    }

    final void m689a(float f) {
        if (this.f457h != f) {
            this.f457h = f;
            mo117a(f, this.f458i);
        }
    }

    abstract void mo117a(float f, float f2);

    abstract void mo118a(int i);

    abstract void mo119a(ColorStateList colorStateList);

    abstract void mo120a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void mo121a(Mode mode);

    abstract void mo122a(Rect rect);

    abstract void mo123a(C0107a c0107a, boolean z);

    abstract void mo124a(int[] iArr);

    abstract void mo125b();

    final void m699b(float f) {
        if (this.f458i != f) {
            this.f458i = f;
            mo117a(this.f457h, f);
        }
    }

    void mo130b(Rect rect) {
    }

    abstract void mo126b(C0107a c0107a, boolean z);

    abstract void mo127c();

    boolean mo128d() {
        return false;
    }

    void mo129e() {
    }

    final Drawable m705f() {
        return this.f456g;
    }

    final void m706g() {
        Rect rect = this.f451a;
        mo122a(rect);
        mo130b(rect);
        this.f460o.mo94a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m707h() {
        if (mo128d()) {
            m686o();
            this.f459n.getViewTreeObserver().addOnPreDrawListener(this.f462q);
        }
    }

    void m708i() {
        if (this.f462q != null) {
            this.f459n.getViewTreeObserver().removeOnPreDrawListener(this.f462q);
            this.f462q = null;
        }
    }

    C0136c mo131j() {
        return new C0136c();
    }

    GradientDrawable m710k() {
        GradientDrawable l = mo132l();
        l.setShape(1);
        l.setColor(-1);
        return l;
    }

    GradientDrawable mo132l() {
        return new GradientDrawable();
    }

    boolean m712m() {
        return this.f459n.getVisibility() != 0 ? this.f452c == 2 : this.f452c != 1;
    }

    boolean m713n() {
        return this.f459n.getVisibility() == 0 ? this.f452c == 1 : this.f452c != 2;
    }
}
