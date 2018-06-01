package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.support.design.widget.C0172r.C0171e;
import android.support.design.widget.C0172r.C0171e.C0166b;
import android.support.design.widget.C0172r.C0171e.C0168a;
import android.view.animation.Interpolator;

@TargetApi(12)
class C0177t extends C0171e {
    private final ValueAnimator f533a = new ValueAnimator();

    C0177t() {
    }

    public void mo142a() {
        this.f533a.start();
    }

    public void mo143a(float f, float f2) {
        this.f533a.setFloatValues(new float[]{f, f2});
    }

    public void mo144a(int i, int i2) {
        this.f533a.setIntValues(new int[]{i, i2});
    }

    public void mo145a(long j) {
        this.f533a.setDuration(j);
    }

    public void mo146a(final C0168a c0168a) {
        this.f533a.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ C0177t f532b;

            public void onAnimationCancel(Animator animator) {
                c0168a.mo141c();
            }

            public void onAnimationEnd(Animator animator) {
                c0168a.mo140b();
            }

            public void onAnimationStart(Animator animator) {
                c0168a.mo139a();
            }
        });
    }

    public void mo147a(final C0166b c0166b) {
        this.f533a.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ C0177t f530b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c0166b.mo138a();
            }
        });
    }

    public void mo148a(Interpolator interpolator) {
        this.f533a.setInterpolator(interpolator);
    }

    public boolean mo149b() {
        return this.f533a.isRunning();
    }

    public int mo150c() {
        return ((Integer) this.f533a.getAnimatedValue()).intValue();
    }

    public void mo151d() {
        this.f533a.cancel();
    }

    public float mo152e() {
        return this.f533a.getAnimatedFraction();
    }

    public void mo153f() {
        this.f533a.end();
    }
}
