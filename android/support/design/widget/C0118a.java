package android.support.design.widget;

import android.support.v4.p008h.p020b.C0392a;
import android.support.v4.p008h.p020b.C0393b;
import android.support.v4.p008h.p020b.C0394c;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class C0118a {
    static final Interpolator f400a = new LinearInterpolator();
    static final Interpolator f401b = new C0393b();
    static final Interpolator f402c = new C0392a();
    static final Interpolator f403d = new C0394c();
    static final Interpolator f404e = new DecelerateInterpolator();

    static class C0117a implements AnimationListener {
        C0117a() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static int m629a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
