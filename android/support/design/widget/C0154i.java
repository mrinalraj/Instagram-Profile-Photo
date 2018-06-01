package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.widget.C0172r.C0170d;
import android.support.v4.p005c.p006a.C0279a;
import android.view.View;

@TargetApi(21)
class C0154i extends C0151g {
    private InsetDrawable f474q;

    static class C0153a extends GradientDrawable {
        C0153a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    C0154i(aa aaVar, C0110n c0110n, C0170d c0170d) {
        super(aaVar, c0110n, c0170d);
    }

    public float mo116a() {
        return this.n.getElevation();
    }

    void mo117a(float f, float f2) {
        if (VERSION.SDK_INT != 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(j, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(k, animatorSet);
            animatorSet = new AnimatorSet();
            r2 = new Animator[3];
            r2[0] = ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0);
            r2[1] = ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100);
            r2[2] = ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100);
            animatorSet.playSequentially(r2);
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(l, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet.setInterpolator(b);
            stateListAnimator.addState(m, animatorSet);
            this.n.setStateListAnimator(stateListAnimator);
        } else if (this.n.isEnabled()) {
            this.n.setElevation(f);
            if (this.n.isFocused() || this.n.isPressed()) {
                this.n.setTranslationZ(f2);
            } else {
                this.n.setTranslationZ(0.0f);
            }
        } else {
            this.n.setElevation(0.0f);
            this.n.setTranslationZ(0.0f);
        }
        if (this.o.mo96b()) {
            m706g();
        }
    }

    void mo118a(int i) {
        if (this.e instanceof RippleDrawable) {
            ((RippleDrawable) this.e).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo118a(i);
        }
    }

    void mo120a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.d = C0279a.m1431f(m710k());
        C0279a.m1421a(this.d, colorStateList);
        if (mode != null) {
            C0279a.m1424a(this.d, mode);
        }
        if (i2 > 0) {
            this.f = m688a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f, this.d});
        } else {
            this.f = null;
            layerDrawable = this.d;
        }
        this.e = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.g = this.e;
        this.o.mo95a(this.e);
    }

    void mo122a(Rect rect) {
        if (this.o.mo96b()) {
            float a = this.o.mo93a();
            float a2 = mo116a() + this.i;
            int ceil = (int) Math.ceil((double) C0158m.m753b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) C0158m.m750a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void mo124a(int[] iArr) {
    }

    void mo125b() {
    }

    void mo130b(Rect rect) {
        if (this.o.mo96b()) {
            this.f474q = new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom);
            this.o.mo95a(this.f474q);
            return;
        }
        this.o.mo95a(this.e);
    }

    void mo127c() {
        m706g();
    }

    boolean mo128d() {
        return false;
    }

    C0136c mo131j() {
        return new C0137d();
    }

    GradientDrawable mo132l() {
        return new C0153a();
    }
}
